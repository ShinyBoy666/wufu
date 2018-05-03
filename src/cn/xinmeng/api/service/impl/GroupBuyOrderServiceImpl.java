package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IGroupBuyOrderService;
import cn.xinmeng.api.dao.auto.GroupBuyOrderDao;
import cn.xinmeng.api.entity.auto.GroupBuyOrder;
import cn.xinmeng.api.entity.auto.example.GroupBuyOrderExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：GroupBuyOrderServiceImpl
 * 描述：团购订单表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
@Service("groupBuyOrderService")
public class GroupBuyOrderServiceImpl implements IGroupBuyOrderService {

    @Resource
	private GroupBuyOrderDao groupBuyOrderDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GroupBuyOrder record){
    	return groupBuyOrderDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return groupBuyOrderDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GroupBuyOrder record){
		return groupBuyOrderDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GroupBuyOrder selectByPrimaryKey(Integer id){
    	return groupBuyOrderDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(GroupBuyOrderExample example){
		return groupBuyOrderDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GroupBuyOrder> selectByExample(GroupBuyOrderExample example){
    	return groupBuyOrderDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GroupBuyOrder> selectByExample(int currentPage, int limit,GroupBuyOrderExample example){
        return groupBuyOrderDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}