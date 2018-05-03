package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xinmeng.api.service.IShopPostageConfigService;
import cn.xinmeng.api.dao.auto.ShopPostageConfigDao;
import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.ShopPostageConfig;
import cn.xinmeng.api.entity.auto.example.ShopPostageConfigExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.common.util.UtilMoney;
import cn.xinmeng.common.util.Utils;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ShopPostageConfigServiceImpl
 * 描述：店铺邮费配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:28
 */
@Service("shopPostageConfigService")
public class ShopPostageConfigServiceImpl implements IShopPostageConfigService {

    @Resource
	private ShopPostageConfigDao shopPostageConfigDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopPostageConfig record){
    	return shopPostageConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopPostageConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopPostageConfig record){
		return shopPostageConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopPostageConfig selectByPrimaryKey(Integer id){
    	return shopPostageConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopPostageConfigExample example){
		return shopPostageConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(ShopPostageConfigExample example){
    	return shopPostageConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopPostageConfig> selectByExample(int currentPage, int limit,ShopPostageConfigExample example){
        return shopPostageConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public double queryPostage(Integer shopId, CommonAddress commonAddress,
			Double amount) {
		ShopPostageConfig shopPostageConfig = queryPostage(shopId, commonAddress);
		if(shopPostageConfig != null){
			if(Utils.isEmpty(amount) || UtilMoney.compareTo(shopPostageConfig.getPostageFree(), amount) > 0){
				return shopPostageConfig.getPostage();
			}
		}
		return 0;
	}

	@Override
	public ShopPostageConfig queryPostage(Integer shopId,
			CommonAddress commonAddress) {
		if(!Utils.isEmpty(shopId)){
			ShopPostageConfigExample example = new ShopPostageConfigExample();
//			example.setOrderByClause("district_id desc,city_id desc,province_id desc,id desc");
			example.setOrderByClause("city_id desc,province_id desc,id desc");
			ShopPostageConfigExample.Criteria criteria = example.createCriteria();
			criteria.andStateEqualTo(Integer.parseInt(StateEnum.EFFECTION.key()));
			criteria.andShopIdEqualTo(shopId);
			List<Integer> province = new ArrayList<Integer>();
			province.add(-1);
			if(commonAddress != null){
//				if(!Utils.isEmpty(commonAddress.getDistrictId())){
//					List<Integer> district = new ArrayList<Integer>();
//					district.add(-1);
//					district.add(commonAddress.getDistrictId());
//					criteria.andDistrictIdIn(district);
//				}
				if(!Utils.isEmpty(commonAddress.getCityId())){
					List<Integer> city = new ArrayList<Integer>();
					city.add(-1);
					city.add(commonAddress.getCityId());
					criteria.andCityIdIn(city);
				}
				
				if(!Utils.isEmpty(commonAddress.getProvinceId())){
					province.add(commonAddress.getProvinceId());
				}
			}
			criteria.andProvinceIdIn(province);
			
			List<ShopPostageConfig> list = shopPostageConfigDao.selectByExample(example);
			if(!Utils.isEmpty(list)){
				return list.get(0);
			}
		}
		return null;
	}

}