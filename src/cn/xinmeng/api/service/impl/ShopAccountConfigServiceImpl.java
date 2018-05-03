package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IShopAccountConfigService;
import cn.xinmeng.api.dao.auto.ShopAccountConfigDao;
import cn.xinmeng.api.entity.auto.ShopAccountConfig;
import cn.xinmeng.api.entity.auto.example.ShopAccountConfigExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ShopAccountConfigServiceImpl
 * 描述：店铺账户配置表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:25
 */
@Service("shopAccountConfigService")
public class ShopAccountConfigServiceImpl implements IShopAccountConfigService {

    @Resource
	private ShopAccountConfigDao shopAccountConfigDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopAccountConfig record){
    	return shopAccountConfigDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopAccountConfigDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopAccountConfig record){
		return shopAccountConfigDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopAccountConfig selectByPrimaryKey(Integer id){
    	return shopAccountConfigDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopAccountConfigExample example){
		return shopAccountConfigDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(ShopAccountConfigExample example){
    	return shopAccountConfigDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopAccountConfig> selectByExample(int currentPage, int limit,ShopAccountConfigExample example){
        return shopAccountConfigDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}