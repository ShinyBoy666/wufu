package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CollectionDao;
import cn.xinmeng.api.entity.auto.Collection;
import cn.xinmeng.api.entity.auto.example.CollectionExample;
import cn.xinmeng.api.service.ICollectionService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CollectionServiceImpl
 * @author jiangyong.tan
 * 描述：客户收藏表
 * @date 2016-01-24 14:38:48
 */
@Service("collectionService")
public class CollectionServiceImpl implements ICollectionService {

    @Resource
	private CollectionDao collectionDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Collection record){
    	return collectionDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return collectionDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Collection record){
		return collectionDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Collection selectByPrimaryKey(Integer id){
    	return collectionDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CollectionExample example){
		return collectionDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Collection> selectByExample(CollectionExample example){
    	return collectionDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Collection> selectByExample(int currentPage, int limit,CollectionExample example){
        return collectionDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public boolean insertOrDelete(Collection record) {
		CollectionExample example = new CollectionExample();
    	CollectionExample.Criteria criteria = example.createCriteria();
    	criteria.andCustomerIdEqualTo(record.getCustomerId());
    	criteria.andShopIdEqualTo(record.getShopId());
    	criteria.andObjectIdEqualTo(record.getObjectId());
    	criteria.andObjectTypeEqualTo(record.getObjectType());
    	//删除 收藏关系
    	if(collectionDao.deleteByExample(example) > 0){
    		return false;
    	}
    	record.setId(null);
    	record.setCreateTime(new Date());
    	//添加收藏关系
    	if(collectionDao.insert(record) > 0){
    		return true;
    	}
		return false;
	}

	@Override
	public List<String> selectObjectIdsByCustomerId(Integer customerId,
			Integer objectType) {
		List<String> result = new ArrayList<String>();
		if(!Utils.isEmpty(customerId)){
			CollectionExample example = new CollectionExample();
			CollectionExample.Criteria criteria = example.createCriteria();
			criteria.andCustomerIdEqualTo(customerId);
			if(!Utils.isEmpty(objectType)){
				criteria.andObjectTypeEqualTo(objectType);
			}
			List<Collection> list = collectionDao.selectByExample(example);
			if(!Utils.isEmpty(list)){
				for (Collection collection : list) {
					result.add(collection.getObjectId());
				}
			}
		}
		return result;
	}
    
}