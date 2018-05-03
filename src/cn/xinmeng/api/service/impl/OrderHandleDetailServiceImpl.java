package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderHandleDetailDao;
import cn.xinmeng.api.entity.auto.OrderHandleDetail;
import cn.xinmeng.api.entity.auto.example.OrderHandleDetailExample;
import cn.xinmeng.api.service.IOrderHandleDetailService;

/**
 * 业务层：OrderHandleDetailServiceImpl
 * @author jiangyong.tan
 * 描述：订单处理记录表
 * @date 2016-01-24 14:39:00
 */
@Service("orderHandleDetailService")
public class OrderHandleDetailServiceImpl implements IOrderHandleDetailService {

    @Resource
	private OrderHandleDetailDao orderHandleDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(OrderHandleDetail record){
    	return orderHandleDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return orderHandleDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(OrderHandleDetail record){
		return orderHandleDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public OrderHandleDetail selectByPrimaryKey(Integer id){
    	return orderHandleDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderHandleDetailExample example){
		return orderHandleDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(OrderHandleDetailExample example){
    	return orderHandleDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<OrderHandleDetail> selectByExample(int currentPage, int limit,OrderHandleDetailExample example){
        return orderHandleDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}