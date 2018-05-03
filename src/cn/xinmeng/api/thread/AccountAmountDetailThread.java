package cn.xinmeng.api.thread;

import java.util.List;

import cn.xinmeng.api.entity.auto.CustomerAmountDetail;
import cn.xinmeng.api.service.ICustomerAmountDetailService;
import cn.xinmeng.common.util.FastJsonUtils;
import cn.xinmeng.common.util.LogManager;

/**
 * 资金流水记录
 * @param 
 * @ClassName: AccountAmountDetailThread 
 * @version V1.0  
 * @date 2016年2月25日 下午3:13:10 
 * @author jiangyong.tan
 * @return 
 *
 */
public class AccountAmountDetailThread implements Runnable{


	private ICustomerAmountDetailService customerAmountDetailService;
	List<CustomerAmountDetail> list;
	
	public AccountAmountDetailThread(
			ICustomerAmountDetailService customerAmountDetailService,
			List<CustomerAmountDetail> list){
		this.customerAmountDetailService = customerAmountDetailService;
		this.list = list;
	}
	
	
	@Override
	public void run() {
		try {
			if(customerAmountDetailService != null && (list != null && list.size() > 0)){
				for (CustomerAmountDetail customerAmountDetail : list) {
					customerAmountDetailService.add(customerAmountDetail);
				}
			}
		} catch (Exception ex) {
			LogManager.error(this.getClass(),"线程【AccountAmountDetailThread】异常，list:"+FastJsonUtils.bean2Json(list),ex);
			
		}
	}

}
