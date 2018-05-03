package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import cn.xinmeng.api.service.IShopActivityConfigService;
import cn.xinmeng.api.dao.auto.ShopActivityConfigDao;
import cn.xinmeng.api.entity.auto.ShopActivityConfig;
import cn.xinmeng.api.entity.auto.example.ShopActivityConfigExample;
import cn.xinmeng.common.util.Utils;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ShopActivityConfigServiceImpl
 * 描述：店铺优惠买单活动配置
 * @author jiangyong.tan
 * @date 2016-06-21 17:37:13
 */
@Service("shopActivityConfigService")
public class ShopActivityConfigServiceImpl implements IShopActivityConfigService {

    @Resource
	private ShopActivityConfigDao shopActivityConfigDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopActivityConfig record){
    	return shopActivityConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopActivityConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopActivityConfig record){
		return shopActivityConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopActivityConfig selectByPrimaryKey(Integer id){
    	return shopActivityConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopActivityConfigExample example){
		return shopActivityConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopActivityConfig> selectByExample(ShopActivityConfigExample example){
    	return shopActivityConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopActivityConfig> selectByExample(int currentPage, int limit,ShopActivityConfigExample example){
        return shopActivityConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public ShopActivityConfig queryByShopId(Integer shopId) {
		ShopActivityConfigExample example = new ShopActivityConfigExample();
		ShopActivityConfigExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		List<ShopActivityConfig> list = shopActivityConfigDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean insertOrUpdate(ShopActivityConfig record) {
		ShopActivityConfigExample example = new ShopActivityConfigExample();
		ShopActivityConfigExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(record.getShopId());
		
		String createUser = "api";
		Date now = new Date();
		record.setUpdateTime(now);
		record.setUpdateUser(createUser);
		if(shopActivityConfigDao.updateByExampleSelective(record, example) > 0){
			return true;
		}
		record.setCreateTime(now);
		record.setCreateUser(createUser);
		if(shopActivityConfigDao.insert(record) > 0){
			return true;
		}
		return false;
	}
    
}