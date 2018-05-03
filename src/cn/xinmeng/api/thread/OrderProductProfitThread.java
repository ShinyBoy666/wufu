package cn.xinmeng.api.thread;

import java.util.Date;

import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.ISystemErrorLogService;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 订单分利
 * @param 
 * @ClassName: AccountAmountDetailThread 
 * @version V1.0  
 * @date 2016年2月25日 下午3:13:10 
 * @author jiangyong.tan
 * @return 
 *
 */
//public class OrderProductProfitThread implements Runnable{
//
//	ISystemErrorLogService systemErrorLogService;
//	IOrderProductProfitService orderProductProfitService;
//	Integer customerId;
//	String parentOrderId;
//	
//	public OrderProductProfitThread(
//			IOrderProductProfitService orderProductProfitService,
//			ISystemErrorLogService systemErrorLogService,
//			String parentOrderId,Integer customerId){
//		this.orderProductProfitService = orderProductProfitService;
//		this.systemErrorLogService = systemErrorLogService;
//		this.customerId = customerId;
//		this.parentOrderId = parentOrderId;
//	}
//	
//	
//	@Override
//	public void run() {
//		try {
//			if(orderProductProfitService != null){
//				orderProductProfitService.merchandiseDistribution(parentOrderId);
//			}
//		} catch (Exception ex) {
//			String params = "customerId:"+customerId+"  parentOrderId:"+parentOrderId;
//			LogManager.errorProfit("线程【OrderProductProfitThread】异常，"+params,ex);
//			SystemErrorLog log = new SystemErrorLog();
//			log.setActionType(1);
//			log.setCreateTime(new Date());
//			log.setCreateUser("api");
//			log.setDescription("线程【OrderProductProfitThread】异常");
//			String errorInfo = Utils.exceptionConvertStr(ex);
//			if(errorInfo != null && errorInfo.length() > 2000){
//				errorInfo = errorInfo.substring(0, 2000);
//			}
//			log.setErrorInformation(errorInfo);
//			log.setInformed(1);
//			log.setIp("");
//			log.setPlatform(2);
//			log.setPri(10);
//			log.setRunCommand(params);
//			systemErrorLogService.add(log);
//		}
//	}
//
//}
