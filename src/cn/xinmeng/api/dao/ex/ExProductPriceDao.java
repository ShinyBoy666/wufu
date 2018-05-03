package cn.xinmeng.api.dao.ex;

import org.apache.ibatis.annotations.Param;



/**
 * 商品价格信息
 * @param 
 * @ClassName: ExProductPriceDao 
 * @version V1.0  
 * @date 2016年2月24日 上午11:57:22 
 * @author jiangyong.tan
 * @return 
 *
 */
public interface ExProductPriceDao {
	
	/**
	 *  商品减库存
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午11:58:42
	 * @param num
	 * @param id
	 * @return
	 */
	public Integer updateSubtractActualQuantity(@Param("num") Integer num,@Param("id") Integer id);
	
	/**
	 *  商品加库存
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午11:58:53
	 * @param num
	 * @param id
	 * @return
	 */
	public Integer updateAddActualQuantity(@Param("num") Integer num,@Param("id") Integer id);
}