package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.QuickOrderDao;
import cn.xinmeng.api.dao.ex.ExOrderDao;
import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.biz.OrderTotalBiz;
import cn.xinmeng.api.entity.auto.example.QuickOrderExample;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：QuickOrderServiceImpl
 * 描述：优惠买单订单表
 * @author jiangyong.tan
 * @date 2016-06-17 19:55:01
 */
@Service("quickOrderService")
public class QuickOrderServiceImpl implements IQuickOrderService {

    @Resource
	private QuickOrderDao quickOrderDao;
    @Resource
    private ExOrderDao exOrderDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(QuickOrder record){
    	String createUser = "api";
    	Date now = new Date();
    	record.setCreateTime(now);
    	record.setCreateUser(createUser);
    	record.setUpdateTime(now);
    	record.setUpdateUser(createUser);
    	return quickOrderDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return quickOrderDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(QuickOrder record){
		return quickOrderDao.updateByPrimaryKey(record);
	}

	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
	public int updateSelectiveByPrimaryKey(QuickOrder record){
		return quickOrderDao.updateSelectiveByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public QuickOrder selectByPrimaryKey(Integer id){
    	return quickOrderDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(QuickOrderExample example){
		return quickOrderDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<QuickOrder> selectByExample(QuickOrderExample example){
    	return quickOrderDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<QuickOrder> selectByExample(int currentPage, int limit,QuickOrderExample example){
        return quickOrderDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public QuickOrder queryByOrderId(String orderId) {
		QuickOrderExample example = new QuickOrderExample();
		QuickOrderExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<QuickOrder> list = quickOrderDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

    /**
     * 查询订单数量
     * @param date
     * @return
     */
    public Integer queryOrderCount(Date date,Integer shopId){
    	QuickOrderExample example = new QuickOrderExample();
		QuickOrderExample.Criteria criteria = example.createCriteria();
		if(!Utils.isEmpty(date)){
			criteria.andCreateTimeGreaterThan(date);
		}
		criteria.andShopIdEqualTo(shopId);
		criteria.andPayStateEqualTo(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
		return quickOrderDao.countByExample(example);
    }
    
	/**
	 * 查询优惠买单统计
	 * @param shopId
	 * @param payTime
	 * @return
	 */
	public OrderTotalBiz queryQuickOrderTotal(Integer shopId, Date payTime){
		return exOrderDao.queryQuickOrderTotal(shopId, payTime);
	}
}