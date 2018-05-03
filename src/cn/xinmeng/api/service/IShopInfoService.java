package cn.xinmeng.api.service;

import java.util.List;
import java.util.Map;

import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.ShopInfoExample;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.shop.S1036RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ShopInfoVo;

/**
 * 接口：IShopInfoService
 * 描述：门店信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:12
 */
public interface IShopInfoService {

	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int add(ShopInfo record);

	/**
	 * 按主键删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id);

	/**
	 * 按主键修改（全新替换每一个字段数据）
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(ShopInfo record);

	/**
	 * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
	 * @param record
	 * @param example
	 * @return
	 */
	public int updateSelectiveByPrimaryKey(ShopInfo record);

	/**
	 * 按主键查询
	 * @param id
	 * @return
	 */
	public ShopInfo selectByPrimaryKey(Integer id);

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopInfoExample example);

	/**
	 * 按条件查询
	 * @param example
	 * @return
	 */
	public List<ShopInfo> selectByExample(ShopInfoExample example);

	/**
	 * 按条件查询（分页）
	 * @param currentPage
	 * @param limit
	 * @param example
	 * @return
	 */
	public List<ShopInfo> selectByExample(int currentPage, int limit,ShopInfoExample example);

	/**
	 * 查询店铺名称
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午11:34:00
	 * @param shopIds
	 * @return
	 */
	public Map<Integer,String> searchShopNameByShopIds(List<Integer> shopIds);


	/**
	 * 查询店铺(id,对象，ioc)
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午11:34:00
	 * @param shopIds
	 * @return
	 */
	public Map<Integer,ShopInfo> searchShopInfoByShopIds(List<Integer> shopIds,String fieldList);

	/**
	 * 
	 * <p class="detail"> 附近店铺列表 </p>
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月23日 下午6:40:24
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @param sortType 排序类型
	 * @param distance 距离
	 * @return
	 */
	public PageInfoEntity<ShopInfoVo> selectShopInfoVoList(S1036RequestEntity entity);

	/**
	 *  查询自定义属性
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:06:44
	 * @param shopId
	 * @param fieldList
	 * @return
	 */
	public ShopInfo queryShopInfoById(Integer shopId,String fieldList);

	/**
	 * 查询店铺名称
	 * @param shopId
	 * @return
	 */
	public String queryShopNameByShopId(Integer shopId);

	/**
	 * 根据店铺名称查询店铺编号
	 */
	public List<Integer> queryShopIdsByShopName(String shopName);

	/**
	 * 店铺有效性验证
	 * @param loginShopId
	 * @param sourceShopId
	 * @return
	 */
	public boolean shopEffection(Integer loginShopId,Integer sourceShopId);
}