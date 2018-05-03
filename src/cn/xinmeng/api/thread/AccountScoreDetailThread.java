package cn.xinmeng.api.thread;

import java.util.List;

import cn.xinmeng.api.entity.auto.CustomerScoreDetail;
import cn.xinmeng.api.service.ICustomerScoreDetailService;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 积分流水记录
 * @author Administrator
 *
 */
public class AccountScoreDetailThread implements Runnable{


	private ICustomerScoreDetailService customerScoreDetailService;
	List<CustomerScoreDetail> list;
	
	public AccountScoreDetailThread(
			ICustomerScoreDetailService customerScoreDetailService,
			List<CustomerScoreDetail> list){
		this.customerScoreDetailService = customerScoreDetailService;
		this.list = list;
	}
	
	
	@Override
	public void run() {
		try {
			if(customerScoreDetailService != null && !Utils.isEmpty(list)){
				for (CustomerScoreDetail customerScoreDetail : list) {
					customerScoreDetailService.add(customerScoreDetail);
				}
			}
		} catch (Exception ex) {
			LogManager.error(this.getClass(),"线程【AccountScoreDetailThread】异常，list:"+FastJsonUtils.bean2Json(list),ex);
			
		}
	}

}
