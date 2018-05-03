package cn.xinmeng.common.util;

import java.math.BigDecimal;
import java.math.MathContext;


public final class UtilMoney {

	public static void main(String[] args) {
		double a = 0.0012; 
		double b = 0.0011;
		System.out.println(compareTo(a,b));
	}

	/**
	 *  数据大小比较（返回1，a大，返回-1，则b大，0，则两个相对）
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午1:47:28
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compareTo(Double a,Double b){
		BigDecimal data1 = new BigDecimal(a); 
		BigDecimal data2 = new BigDecimal(b); 
		return data1.compareTo(data2);
	}

	/**
	 * 加法 return double
	 * @param a 加数
	 * @param b 被加数
	 * @return
	 */
	public static double addToDouble(double a,double b) {
		/**
		 *  a + b
		 */
		return addToDecimal(a, b).doubleValue();
	}

	/**
	 * 加法 return BigDecimal
	 * @param a 加数
	 * @param b 被加数
	 * @return
	 */
	public static BigDecimal addToDecimal(double a,double b) {
		/**
		 *  a + b
		 */
		return new BigDecimal(a,MathContext.DECIMAL32).add(new BigDecimal(b,MathContext.DECIMAL32));
	}


	/**
	 * 减法 return BigDecimal
	 * @param a 减数
	 * @param b 被减数
	 * @return
	 */
	public static BigDecimal subtractToDecimal(double a,double b) {
		/**
		 *  a - b
		 */
		return new BigDecimal(a,MathContext.DECIMAL32).subtract(new BigDecimal(b,MathContext.DECIMAL32));
	}

	/**
	 * 减法 return Double
	 * @param a 减数
	 * @param b 被减数
	 * @return
	 */
	public static double subtractToDouble(double a,double b) {
		/**
		 *  a - b
		 */
		return subtractToDecimal(a,b).doubleValue();
	}

	/**
	 * 乘法计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal multiplyToDecimal(Number a,Number b){
		if(a == null){
			a = 0.0D;
		}
		if(b == null){
			b = 0.0D;
		}
		/**
		 * a * b
		 */
		return new BigDecimal(a.doubleValue(),MathContext.DECIMAL32).multiply(new BigDecimal(b.doubleValue(),MathContext.DECIMAL32));
	}


	/**
	 * 乘法计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static double multiplyToDouble(double a,double b){
		/**
		 * a * b
		 */
		return multiplyToDecimal(a,b).doubleValue();
	}


	/**
	 * 除法计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal divideToDecimal(Number a,Number b){
		if(a == null){
			a = 0.0D;
		}
		if(Utils.isEmpty(b)){
			return BigDecimal.ZERO;
		}

		/**
		 * a / b
		 */
		return new BigDecimal(a.doubleValue(),MathContext.DECIMAL32).divide(new BigDecimal(b.doubleValue(),MathContext.DECIMAL32),MathContext.DECIMAL32);
	}

	/**
	 * 除法计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static double divideToDouble(double a,double b){
		/**
		 * a * b
		 */
		return divideToDecimal(a,b).doubleValue();
	}

	/**
	 * 
	 * <p class="detail"> 四舍五入保留指定位数的小数 </p>
	 * @author <a href="mailto:niukun@taojinzi.com ">牛坤</a> 2015年10月14日 下午2:01:52
	 * @param d
	 * @param decimal 
	 * @return
	 */
	public static Double roundToDouble(Double d,Integer decimal) {
		if(Utils.isEmpty(d) || decimal == null){
			return d;
		}
		BigDecimal b = new BigDecimal(d); 
		return b.setScale(decimal, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 
	 * <p class="detail"> 进1 </p>
	 * @author <a href="mailto:niukun@taojinzi.com ">牛坤</a> 2015年12月8日 上午10:57:16
	 * @param d
	 * @param decimal
	 * @return
	 */
	public static Double roundUpToDouble(Double d,Integer decimal) {
		if(d ==null || decimal == null){
			return d;
		}
		BigDecimal b = new BigDecimal(d); 
		return b.setScale(decimal, BigDecimal.ROUND_UP).doubleValue();
	}
	
	/**
	 *  查询优惠金额
	 * @author jiangyong.tan
	 * @date 2016年3月2日 下午2:19:28
	 * @param totalAmount
	 * @param postage
	 * @param discountAmount
	 * @param couponPayment
	 * @param paidAccountPayment
	 * @return
	 */
	public static Double getNoPayment(double totalAmount,double postage,double discountAmount,double couponPayment,double paidAccountPayment){
		Double totalPayAmount = UtilMoney.addToDouble(totalAmount, postage);
		Double youhuiAmount = UtilMoney.addToDouble(discountAmount, couponPayment);
		Double paidTotalAmount = UtilMoney.addToDouble(youhuiAmount, paidAccountPayment);
		return UtilMoney.subtractToDouble(totalPayAmount, paidTotalAmount);
	}
	
	/**
	 * 把空转成0
	 * @param a
	 * @return
	 */
	public static Double doubleToZero(Double a){
		if(Utils.isEmpty(a)){
			return 0.00;
		}
		return a;
	}
	/**
	 * 把空转成0
	 * @param a
	 * @return
	 */
	public static Integer integerToZero(Integer a){
		if(Utils.isEmpty(a)){
			return 0;
		}
		return a;
	}
	
	/**
	 * 返回可提现金额
	 * @param cashAmount
	 * @param freezeAmount
	 * @param enchashmentAmount
	 * @return
	 */
	public static double getWithdrawAmount(Double cashAmount,Double freezeAmount) {
		double cash = UtilMoney.doubleToZero(cashAmount);
		double freeze = UtilMoney.doubleToZero(freezeAmount);
		double ss = UtilMoney.subtractToDouble(cash, freeze);
		if(ss <= 0){
			return 0;
		}
		return ss;
	}
	
}
