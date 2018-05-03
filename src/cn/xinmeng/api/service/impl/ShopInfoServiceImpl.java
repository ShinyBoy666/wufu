package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ShopInfoDao;
import cn.xinmeng.api.dao.ex.ExShopInfoDao;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.ShopInfoExample;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExShopEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.shop.S1036RequestEntity;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;
import cn.xinmeng.web.shop.entity.vo.ShopInfoVo;

/**
 * 业务层：ShopInfoServiceImpl
 * 描述：门店信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:12
 */
@Service("shopInfoService")
public class ShopInfoServiceImpl implements IShopInfoService {

    @Resource
	private ShopInfoDao shopInfoDao;
    @Resource
    private ExShopInfoDao exShopInfoDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopInfo record){
    	return shopInfoDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopInfoDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopInfo record){
		return shopInfoDao.updateByPrimaryKey(record);
	}
	
   /**
    * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
    * @param record
    * @param example
    * @return
    */
   public int updateSelectiveByPrimaryKey(ShopInfo record){
	   return shopInfoDao.updateSelectiveByPrimaryKey(record);
   }
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopInfo selectByPrimaryKey(Integer id){
    	return shopInfoDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopInfoExample example){
		return shopInfoDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopInfo> selectByExample(ShopInfoExample example){
    	return shopInfoDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopInfo> selectByExample(int currentPage, int limit,ShopInfoExample example){
        return shopInfoDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 查询店铺名称
     * @author jiangyong.tan
     * @date 2016年2月23日 上午11:34:00
     * @param shopIds
     * @return
     */
    public Map<Integer,String> searchShopNameByShopIds(List<Integer> shopIds){
    	ShopInfoExample example = new ShopInfoExample();
    	example.setFieldList("id,shop_name");
    	ShopInfoExample.Criteria criteria = example.createCriteria();
    	criteria.andIdIn(shopIds);
    	List<ShopInfo> list = shopInfoDao.selectByExample(example);
    	Map<Integer,String> resMap = new HashMap<Integer, String>();
    	if(list.size() > 0){
        	for (ShopInfo shopInfo : list) {
    			resMap.put(shopInfo.getId(),shopInfo.getShopName());
    		}
    	}
    	return resMap;
    }


    /**
     * 查询店铺(id,对象，ioc)
     * @author jiangyong.tan
     * @date 2016年2月23日 上午11:34:00
     * @param shopIds
     * @return
     */
    public Map<Integer,ShopInfo> searchShopInfoByShopIds(List<Integer> shopIds,String fieldList){
    	ShopInfoExample example = new ShopInfoExample();
    	if(!Utils.isEmpty(fieldList)){
        	example.setFieldList(fieldList);
    	}
    	ShopInfoExample.Criteria criteria = example.createCriteria();
    	criteria.andIdIn(shopIds);
    	List<ShopInfo> list = shopInfoDao.selectByExample(example);
    	Map<Integer,ShopInfo> resMap = new HashMap<Integer, ShopInfo>();
    	if(list.size() > 0){
        	for (ShopInfo shopInfo : list) {
    			resMap.put(shopInfo.getId(),shopInfo);
    		}
    	}
    	return resMap;
    }
    
    
	@Override
	public PageInfoEntity<ShopInfoVo> selectShopInfoVoList(S1036RequestEntity entity) {
		PageInfoEntity<ShopInfoVo> pageInfoEntity = new PageInfoEntity<ShopInfoVo>(entity.getCurrentPage(), entity.getLimit());
		int count = exShopInfoDao.selectShopInfoVoListCount(entity);
		if(count > 0){
			List<ShopInfoVo> list = exShopInfoDao.selectShopInfoVoList(new RowBounds(entity.getCurrentPage(), entity.getLimit()),entity);
			if(!Utils.isEmpty(list)){
				for (ShopInfoVo shopInfoVo : list) {
					shopInfoVo.setLogo(Utils.getImageUrl(shopInfoVo.getLogo(),"?300_300"));
					if(!Utils.isEmpty(shopInfoVo.getProductInfoList())){
						for (ProductInfoVo productInfoVo : shopInfoVo.getProductInfoList()) {
							productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?300_300"));
						}
					}
				}
			}
			pageInfoEntity.setList(list);
		}else {
			pageInfoEntity.setList(new ArrayList<ShopInfoVo>());
		}
		pageInfoEntity.setTotalRecord(count);
		return pageInfoEntity;
	}
	
	/**
	 *  查询自定义属性
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:06:44
	 * @param shopId
	 * @param fieldList
	 * @return
	 */
	public ShopInfo queryShopInfoById(Integer shopId,String fieldList){
    	ShopInfoExample example = new ShopInfoExample();
    	example.setFieldList(fieldList);
    	ShopInfoExample.Criteria criteria = example.createCriteria();
    	criteria.andIdEqualTo(shopId);
    	List<ShopInfo> list = shopInfoDao.selectByExample(example);
    	if(list.size() > 0){
        	return list.get(0);
    	}
    	return null;
    }

	/**
	 * 查询店铺名称
	 * @param shopId
	 * @return
	 */
	public String queryShopNameByShopId(Integer shopId){
    	ShopInfoExample example = new ShopInfoExample();
    	example.setFieldList("shop_name");
    	ShopInfoExample.Criteria criteria = example.createCriteria();
    	criteria.andIdEqualTo(shopId);
    	List<ShopInfo> list = shopInfoDao.selectByExample(example);
    	if(list.size() > 0){
        	return list.get(0).getShopName();
    	}
    	return "";
	}

	@Override
	public List<Integer> queryShopIdsByShopName(String shopName) {
		List<Integer> shopIds = new ArrayList<Integer>();
		if(!Utils.isEmpty(shopName)){
			ShopInfoExample example = new ShopInfoExample();
	    	example.setFieldList(" id ");
	    	ShopInfoExample.Criteria criteria = example.createCriteria();
	    	criteria.andShopNameLike("%"+shopName+"%");
	    	List<ShopInfo> list = shopInfoDao.selectByExample(example);
	    	if(!Utils.isEmpty(list)){
	    		for (ShopInfo shopInfo : list) {
					shopIds.add(shopInfo.getId());
				}
	    	}
		}
    	return shopIds;
	}
	
	/**
	 * 店铺有效性验证
	 * @param loginShopId
	 * @param sourceShopId
	 * @return
	 */
	public boolean shopEffection(Integer loginShopId,Integer sourceShopId){
		if(Utils.isEmpty(loginShopId) && Utils.isEmpty(loginShopId)){
			return false;
		}
		Date curr = new Date();
		if(!Utils.isEmpty(loginShopId)){
			ShopInfo shopInfo = queryShopInfoById(loginShopId, "id,state,open_time,end_time");
			if(Utils.isEmpty(shopInfo)){
				//店铺不存在
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
			}else if(shopInfo.getState() == 1){
				//店铺无效
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DISABLE);
			}else if(shopInfo.getState() == 3){
				//店铺删除
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DELETE);
			}else if(shopInfo.getState() == 4){
				//店铺有效期已过
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
			}else if(DateUtil.compareDate(curr, shopInfo.getEndTime())){
				//店铺有效期已过
				throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
			}
			
			//
			if(!Utils.isEmpty(sourceShopId) && loginShopId != sourceShopId){
				shopInfo = queryShopInfoById(sourceShopId, "id,state,open_time,end_time");
				if(Utils.isEmpty(shopInfo)){
					//店铺不存在
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
				}else if(shopInfo.getState() == 1){
					//店铺无效
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DISABLE);
				}else if(shopInfo.getState() == 3){
					//店铺删除
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DELETE);
				}else if(shopInfo.getState() == 4){
					//店铺有效期已过
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
				}else if(DateUtil.compareDate(curr, shopInfo.getEndTime())){
					//店铺有效期已过
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
				}
			}
		}else{
			if(!Utils.isEmpty(sourceShopId)){
				ShopInfo shopInfo = queryShopInfoById(sourceShopId, "id,state,open_time,end_time");
				if(Utils.isEmpty(shopInfo)){
					//店铺不存在
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_NOTEXISTS_SHOP);
				}else if(shopInfo.getState() == 1){
					//店铺无效
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DISABLE);
				}else if(shopInfo.getState() == 3){
					//店铺删除
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_DELETE);
				}else if(shopInfo.getState() == 4){
					//店铺有效期已过
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
				}else if(DateUtil.compareDate(curr, shopInfo.getEndTime())){
					//店铺有效期已过
					throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopEnum.EX_OVERDUE);
				}
			}
		}
		return false;
	}
}