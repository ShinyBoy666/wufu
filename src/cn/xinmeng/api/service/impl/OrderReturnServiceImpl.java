package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderReturnDao;
import cn.xinmeng.api.entity.auto.OrderReturn;
import cn.xinmeng.api.entity.auto.example.OrderReturnExample;
import cn.xinmeng.api.service.IOrderReturnService;

/**
 * 业务层：OrderReturnServiceImpl
 * @author jiangyong.tan
 * 描述：订单退换货信息
 * @date 2016-01-24 14:39:01
 */
@Service("orderReturnService")
public class OrderReturnServiceImpl implements IOrderReturnService {

    @Resource
	private OrderReturnDao orderReturnDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderReturn record){
    	return orderReturnDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return orderReturnDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderReturn record){
		return orderReturnDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderReturn selectByPrimaryKey(Integer id){
    	return orderReturnDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderReturnExample example){
		return orderReturnDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderReturn> selectByExample(OrderReturnExample example){
    	return orderReturnDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<OrderReturn> selectByExample(int currentPage, int limit,OrderReturnExample example){
        return orderReturnDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}