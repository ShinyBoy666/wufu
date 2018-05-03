package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.vo.CustomerVo;

/**
 * 
 * <p class="detail">邀请好友列表</p>
 * 
 * @param 
 * @ClassName: S1046Component 
 * @version V1.0  @date 2016年2月29日 上午11:20:05 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1046Component")
public class S1046Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		PageSearchEntity entity = parseRequertParam(data, PageSearchEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		PageInfoEntity<CustomerVo> pageInfoEntity = new PageInfoEntity<CustomerVo>(entity.getCurrentPage(),entity.getLimit());
		
		List<CustomerVo> list = new ArrayList<CustomerVo>();
		//查询最近推荐的好友
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andRecommendCustomerIdEqualTo(entity.getCustomerId());
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		int count = customerService.countByExample(example);
		if(count > 0){
			example.setOrderByClause("id desc");
			List<Customer> customers = customerService.selectByExample(entity.getCurrentPage(), entity.getLimit(), example);
			if(!Utils.isEmpty(customers)){
				for (Customer customer : customers) {
					CustomerVo customerVo = new CustomerVo();
					CloneUtils.cloneEntity(customer, customerVo);
					customerVo.setHeadSculpture(Utils.getImageUrl(customerVo.getHeadSculpture(),"?300_300"));
					list.add(customerVo);
				}
			}
		}
		pageInfoEntity.setTotalRecord(count);
		pageInfoEntity.setList(list);
		return getAppResponseEntity(pageInfoEntity);
	}
	
	
}
