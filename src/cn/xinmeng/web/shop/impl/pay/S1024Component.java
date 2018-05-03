package cn.xinmeng.web.shop.impl.pay;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.entity.auto.example.CustomerAmountDetailExample;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.service.ICustomerAmountDetailService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.pay.S1024RequestEntity;
import cn.xinmeng.web.shop.entity.pay.S1024ResponseEntity;

/**
 * 账户明细
 * @param 
 * @ClassName: S1024Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.pay.S1024Component")
public class S1024Component extends BaseService {

	@Resource
	private ICustomerAmountDetailService customerAmountDetailService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1024RequestEntity entity = parseRequertParam(data, S1024RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}

		//返回分页数据
		PageInfoEntity<S1024ResponseEntity> resPage = new PageInfoEntity<S1024ResponseEntity>();
		//返回支付明细列表
		List<S1024ResponseEntity> result = new ArrayList<S1024ResponseEntity>();
		
		//查询支付流水明细
		CustomerAmountDetailExample example = new CustomerAmountDetailExample();
		example.setOrderByClause(" id desc ");
		CustomerAmountDetailExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(entity.getCustomerId());
		criteria.andAccountTypeEqualTo(Integer.valueOf(AccountTypeEnum.USER.key()));
		if(!Utils.isEmpty(entity.getPaymentType())){
			criteria.andPaymentTypeEqualTo(entity.getPaymentType());
		}
		if(!Utils.isEmpty(entity.getBeginTime()) && !Utils.isEmpty(entity.getEndTime())){
			criteria.andCreateTimeBetween(entity.getBeginTime(), DateUtil.strToDayEndDate(DateUtil.formatDate(entity.getEndTime(), "yyyy-MM-dd")));
		}

		
		int totalCount = customerAmountDetailService.countByExample(example);
		
		if(totalCount > 0){
			//查询支付流水明细
			List<CustomerAmountDetail> list = customerAmountDetailService.selectByExample(entity.getCurrentPage(), entity.getLimit(), example);
			
			if(list != null && list.size() > 0){
				for (CustomerAmountDetail customerAmountDetail : list) {
					S1024ResponseEntity responseEntity = new S1024ResponseEntity();
					CloneUtils.cloneEntity(customerAmountDetail, responseEntity);
					result.add(responseEntity);
				}
			}
		}
		resPage.setList(result);
		resPage.setCurrentPage(entity.getCurrentPage());
		resPage.setLimit(entity.getLimit());
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}
	
	
}
