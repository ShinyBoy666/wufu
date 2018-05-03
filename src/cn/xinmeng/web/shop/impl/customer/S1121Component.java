package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import cn.xinmeng.api.service.ICustomerAccountService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1121RequestEntity;

/**
 * 贡献积分查询
 * @author Administrator
 *
 */
@Component("cn.xinmeng.web.shop.impl.customer.S1121Component")
public class S1121Component extends BaseService{
	
	@Resource
	private ICustomerService customerService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request, String data) {
		// TODO Auto-generated method stub
		S1121RequestEntity entity = parseRequertParam(data, S1121RequestEntity.class);
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("contribution_amount desc,id");
		example.setFieldList("id,nickname,head_sculpture,contribution_amount");
		//1-贡献,2-积分,3-现金
		if (entity.getState()==1) {
			
		}else if (entity.getState()==2) {
			
		}else if (entity.getState()==3) {
			
		}
		
		
		
		
		
		List<S1121RequestEntity> resList = new ArrayList<S1121RequestEntity>();
		
		List<Customer> list = customerService.selectByExample(1, 4, example);
		if(!Utils.isEmpty(list)){
			for (Customer customer : list) {
				S1121RequestEntity res = new S1121RequestEntity();
				CloneUtils.copyEntity(customer, res);
				resList.add(res);
			}
		}
		
		return getAppResponseEntity(resList);
	}

}
