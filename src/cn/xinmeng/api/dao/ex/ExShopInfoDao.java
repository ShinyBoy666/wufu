package cn.xinmeng.api.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.xinmeng.web.shop.entity.shop.S1036RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ShopInfoVo;


public interface ExShopInfoDao {
	
	/**
	 * 
	 * <p class="detail"> 附件店铺列表</p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午6:40:24
	 * @param rowBounds
	 * @param entity
	 * @return
	 */
	public int selectShopInfoVoListCount(@Param("entity")S1036RequestEntity entity);
	public List<ShopInfoVo> selectShopInfoVoList(RowBounds rowBounds,@Param("entity")S1036RequestEntity entity);
	
	/**
	 * 
	 * <p class="detail"> 根据店铺id查询logo </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午7:11:59
	 * @param shopId
	 * @return
	 */
	public String selectLogoByShopId(@Param("shopId")Integer shopId);
	
	/**
	 * 
	 * <p class="detail"> 根据店铺id查询经营种类名称 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午7:15:54
	 * @param shopId
	 * @return
	 */
	public List<String> selectCategoryNamesByShopId(@Param("shopId")Integer shopId);
	
}
