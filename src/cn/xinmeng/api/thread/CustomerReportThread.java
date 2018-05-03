package cn.xinmeng.api.thread;

import java.util.ArrayList;
import java.util.List;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 团队人数
 * @author Administrator
 *
 */
public class CustomerReportThread implements Runnable{


	private ICustomerService customerService;
	private Integer recommendCustomerId;
	
	public CustomerReportThread(
			ICustomerService customerService,Integer recommendCustomerId){
		this.customerService = customerService;
		this.recommendCustomerId = recommendCustomerId;
	}
	
	
	@Override
	public void run() {
		try {
			List<Integer> ids = new ArrayList<Integer>();
			if(customerService != null && !Utils.isEmpty(recommendCustomerId)){
				int i = recommendCustomerId;
				while (i > 0) {
					ids.add(i);
					Customer customer = customerService.selectByPrimaryKey(i);
					if(customer != null && !Utils.isEmpty(customer.getRecommendCustomerId())){
						i = customer.getRecommendCustomerId();
					}else {
						i = 0;
					}
				}
				if(ids.size() > 0){
					customerService.updateTeamNumber(ids);
				}
			}
			LogManager.info(this.getClass(),"线程【CustomerReportThread】,ids:"+FastJsonUtils.bean2JsonAll(ids));
		} catch (Exception ex) {
			LogManager.error(this.getClass(),"线程【CustomerReportThread】异常，recommendCustomerId:"+recommendCustomerId,ex);
		}
	}

}
