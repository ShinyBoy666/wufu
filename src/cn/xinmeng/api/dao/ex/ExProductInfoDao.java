package cn.xinmeng.api.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.xinmeng.web.shop.entity.product.S1006RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 
 * <p class="detail">商品 </p>
 * 
 * @param 
 * @ClassName: ExProductInfoDao 
 * @version V1.0  @date 2016年2月22日 下午4:10:33 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
public interface ExProductInfoDao {
	
	/**
	 * 
	 * <p class="detail"> 根据modulId查询商品集合 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午4:11:26
	 * @param modulId
	 * @return
	 */
	public List<ProductInfoVo> selectProductInfoVoByModulId(@Param("modulId")Integer modulId);
	
	/**
	 * 
	 * <p class="detail"> 根据店铺id查询商品 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午7:15:54
	 * @param shopId
	 * @return
	 */
	public List<ProductInfoVo> selectProductInfosByShopId(@Param("shopId")Integer shopId);
	
	/**
	 * 
	 * <p class="detail"> 商品列表 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午7:15:54
	 * @param rowBounds
	 * @param entity
	 * @return
	 */
	public int selectProductInfoListCount(@Param("entity")S1006RequestEntity entity);
	public List<ProductInfoVo> selectProductInfoList(RowBounds rowBounds,@Param("entity")S1006RequestEntity entity);
	
	/**
	 *  修改商品实际购买量
	 * @author jiangyong.tan
	 * @date 2016年2月24日 上午11:58:53
	 * @param num
	 * @param id
	 * @return
	 */
	public Integer updateBuyNum(@Param("num") Integer num,@Param("productId") Integer productId,@Param("type") Integer type);
	
	

	/**
	 * 云商城列表
	 * @param entity
	 * @return
	 */
	public int selectHotProductInfoListCount(@Param("entity")S1006RequestEntity entity);
	
	/**
	 * 云商城数量
	 * @param rowBounds
	 * @param entity
	 * @return
	 */
	public List<ProductInfoVo> selectHotProductInfoList(RowBounds rowBounds,@Param("entity")S1006RequestEntity entity);
	
}