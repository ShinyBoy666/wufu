package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderRemindDao;
import cn.xinmeng.api.entity.auto.OrderRemind;
import cn.xinmeng.api.entity.auto.example.OrderRemindExample;
import cn.xinmeng.api.service.IOrderRemindService;

/**
 * 业务层：OrderRemindServiceImpl
 * 描述：订单提醒表
 * @author jiangyong.tan
 * @date 2016-04-12 14:42:29
 */
@Service("orderRemindService")
public class OrderRemindServiceImpl implements IOrderRemindService {

    @Resource
	private OrderRemindDao orderRemindDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderRemind record){
    	return orderRemindDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return orderRemindDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderRemind record){
		return orderRemindDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderRemind selectByPrimaryKey(Integer id){
    	return orderRemindDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderRemindExample example){
		return orderRemindDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderRemind> selectByExample(OrderRemindExample example){
    	return orderRemindDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<OrderRemind> selectByExample(int currentPage, int limit,OrderRemindExample example){
        return orderRemindDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}