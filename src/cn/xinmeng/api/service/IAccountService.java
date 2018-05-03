package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.OrderProductProfit;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.ScoreConsumTypeEnum;


public interface IAccountService {
	
	/**
	 *  账户扣款，均分到店铺账户
	 * @param orderId
	 * @param changeAmount
	 * @param fullPayment
	 */
	public Double accountDeductToShop(String orderId,Double changeAmount,boolean fullPayment,Integer onlinePayType);
	
	/**
	 * 
	 * <p class="detail"> 账户扣款</p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月1日 下午2:34:27
	 * @param customerId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void completeAccountDeduct(Integer customerId,Double changeAmount,ConsumTypeEnum consumTypeEnum,String orderId);

	/**
	 * 店铺扣减
	 * @param shopId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void shopCompleteAccountDeduct(Integer shopId, Double changeAmount,ConsumTypeEnum consumTypeEnum, String orderId);
	
	/**
	 * 
	 * <p class="detail"> 客户账户充值 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:37:17
	 * @param customerId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void accountRecharge(Integer customerId,Double changeAmount,ConsumTypeEnum consumTypeEnum,String orderId);
	
	/**
	 * 给推荐用户，推荐店铺，货款店铺加金额
	 * @param listProfit
	 */
	public void orderProductProfit(List<OrderProductProfit> listProfit);
	
	/**
	 * 账户充值
	 * @param shopId
	 * @param changeAmount
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void shopRecharge(Integer shopId,Double changeAmount,ConsumTypeEnum consumTypeEnum,String orderId);
	
	/**
	 * 增加客户积分
	 * @param customerId
	 * @param score
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void addScore(Integer customerId,Integer score,ScoreConsumTypeEnum consumTypeEnum,String orderId);
	
	/**
	 * 减少客户积分
	 * @param customerId
	 * @param score
	 * @param consumTypeEnum
	 * @param orderId
	 */
	public void subScore(Integer customerId,Integer score,ScoreConsumTypeEnum consumTypeEnum,String orderId);
}
