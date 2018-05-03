package cn.xinmeng.api.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 账户
 * @param 
 * @ClassName: ExAccountDao 
 * @version V1.0  
 * @date 2016年2月25日 下午2:19:04 
 * @author jiangyong.tan
 * @return 
 *
 */
public interface ExAccountDao {
	
	/**
	 * 
	 * <p class="detail"> 客户账户充值  </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:19:47
	 * @param customerId
	 * @param amount
	 * @return
	 */
	public Integer custAccountAdd(@Param("customerId") Integer customerId,@Param("amount") Double amount);
	
	/**
	 * 
	 * <p class="detail"> 客户账户扣款</p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:19:47
	 * @param customerId
	 * @param amount
	 * @return
	 */
	public Integer custAccountSub(@Param("customerId") Integer customerId,@Param("amount") Double amount);
	
	/**
	 * 
	 * <p class="detail"> 店主账户充值 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:19:57
	 * @param shopId
	 * @param amount
	 * @return
	 */
	public Integer shopAccountAdd(@Param("shopId") Integer shopId,@Param("amount") Double amount);
	
	/**
	 * 
	 * <p class="detail"> 店主账户扣款 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月10日 上午11:19:57
	 * @param shopId
	 * @param amount
	 * @return
	 */
	public Integer shopAccountSub(@Param("shopId") Integer shopId,@Param("amount") Double amount);
	
	/**
	 * 增加客户积分
	 * @param customerId
	 * @param score
	 * @return
	 */
	public Integer addScore(@Param("customerId") Integer customerId,@Param("score") Integer score);
	
	/**
	 * 减少客户积分
	 * @param customerId
	 * @param score
	 * @return
	 */
	public Integer subScore(@Param("customerId") Integer customerId,@Param("score") Integer score);
	
	/**
	 * 
	 * <p class="detail"> 修改团队人数</p>
	 *  2016年3月10日 上午11:19:57
	 * @param customerIds
	 * @return
	 */
	public Integer updateTeamNumber(@Param("customerIds") List<Integer> customerIds);
}
