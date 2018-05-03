package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IShopApplyService;
import cn.xinmeng.api.dao.auto.ShopApplyDao;
import cn.xinmeng.api.entity.auto.ShopApply;
import cn.xinmeng.api.entity.auto.example.ShopApplyExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ShopApplyServiceImpl
 * 描述：s_shop_apply
 * @author jiangyong.tan
 * @date 2016-12-20 15:34:35
 */
@Service("shopApplyService")
public class ShopApplyServiceImpl implements IShopApplyService {

    @Resource
	private ShopApplyDao shopApplyDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopApply record){
    	return shopApplyDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopApplyDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopApply record){
		return shopApplyDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopApply selectByPrimaryKey(Integer id){
    	return shopApplyDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopApplyExample example){
		return shopApplyDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(ShopApplyExample example){
    	return shopApplyDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(int currentPage, int limit,ShopApplyExample example){
        return shopApplyDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}