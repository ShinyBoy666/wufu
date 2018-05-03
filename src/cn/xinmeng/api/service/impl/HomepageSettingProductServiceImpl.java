package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.HomepageSettingProductDao;
import cn.xinmeng.api.entity.auto.HomepageSettingProduct;
import cn.xinmeng.api.entity.auto.example.HomepageSettingProductExample;
import cn.xinmeng.api.service.IHomepageSettingProductService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：HomepageSettingProductServiceImpl
 * @author jiangyong.tan
 * 描述：主页配置商品表
 * @date 2016-01-24 14:38:57
 */
@Service("homepageSettingProductService")
public class HomepageSettingProductServiceImpl implements IHomepageSettingProductService {

    @Resource
	private HomepageSettingProductDao homepageSettingProductDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageSettingProduct record){
    	return homepageSettingProductDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return homepageSettingProductDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(HomepageSettingProduct record){
		return homepageSettingProductDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageSettingProduct selectByPrimaryKey(Integer id){
    	return homepageSettingProductDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(HomepageSettingProductExample example){
		return homepageSettingProductDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageSettingProduct> selectByExample(HomepageSettingProductExample example){
    	return homepageSettingProductDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<HomepageSettingProduct> selectByExample(int currentPage, int limit,HomepageSettingProductExample example){
        return homepageSettingProductDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public Integer selectProductIdByModulId(Integer modulId) {
		HomepageSettingProductExample example = new HomepageSettingProductExample();
		HomepageSettingProductExample.Criteria criteria = example.createCriteria();
		criteria.andModulIdEqualTo(modulId);
		example.setOrderByClause(" sort desc,id desc");
		example.setFieldList("product_id");
		List<HomepageSettingProduct> list = homepageSettingProductDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0).getProductId();
		}
		return null;
	}
    
}