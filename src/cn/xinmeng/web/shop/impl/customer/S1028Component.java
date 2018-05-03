package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.Enchashment;
import cn.xinmeng.api.entity.auto.example.EnchashmentExample;
import cn.xinmeng.api.service.ICustomerRewardConfigService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IEnchashmentService;
import cn.xinmeng.api.service.ISystemConfigService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1028ResponseEntity;

/**
 * 我的钱包信息
 * @param 
 * @ClassName: S1028Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1028Component")
public class S1028Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	@Resource
	private IEnchashmentService enchashmentService;
	@Resource
	private ISystemConfigService systemConfigService;
	@Resource
	private ICustomerRewardConfigService customerRewardConfigService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		RequestBaseEntity entity = parseRequertParam(data, RequestBaseEntity.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		Customer customer = customerService.selectByPrimaryKey(entity.getCustomerId());
		if(customer == null){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_CUSTOMER_NOT_EXISTS);
		}
		S1028ResponseEntity responseEntity = new S1028ResponseEntity();
		responseEntity.setCashAmount(customer.getCashAmount());//账户余额
		//查询提现中金额
		responseEntity.setCashing(getCashing(entity.getCustomerId()));
		if(customerService.isMember(entity.getCustomerId())){
			responseEntity.setAccountDeduct(true);
			responseEntity.setCusotmerWithdrawals(true);
		}else{
			responseEntity.setAccountDeduct(true);
			responseEntity.setCusotmerWithdrawals(systemConfigService.notNumberWithdrawals());
		}
		responseEntity.setVipAmount(customerRewardConfigService.queryVipAmount(request.getLoginShopId()));
		return getAppResponseEntity(responseEntity);
	}
	
	/**
	 * 
	 * <p class="detail"> 查询提现中金额 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月29日 下午2:27:00
	 * @param customerId
	 * @return
	 */
	private Double getCashing(Integer customerId){
		Double cashing = 0.0d;
		EnchashmentExample example = new EnchashmentExample();
		example.setFieldList("sum(amount) as amount");
		EnchashmentExample.Criteria criteria = example.createCriteria();
		criteria.andAccountTypeEqualTo(1);
		criteria.andCustomerIdEqualTo(customerId);
		List<Integer> states = new ArrayList<Integer>();
		//0、未处理1、审核中、2、审核通过 3、审核拒绝、4、打款失败 5、打款完成
		states.add(0);
		states.add(1);
		states.add(2);
		criteria.andStateIn(states);
		List<Enchashment> list = enchashmentService.selectByExample(example);
		if(!Utils.isEmpty(list) && !Utils.isEmpty(list.get(0))){
			return list.get(0).getAmount();
		}
		return cashing;
	}
}
