package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.AmountRecordMonthDao;
import cn.xinmeng.api.entity.auto.AmountRecordMonth;
import cn.xinmeng.api.entity.auto.example.AmountRecordMonthExample;
import cn.xinmeng.api.service.IAmountRecordMonthService;

/**
 * 业务层：AmountRecordMonthServiceImpl
 * 描述：客户账户金额记录表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:08
 */
@Service("amountRecordMonthService")
public class AmountRecordMonthServiceImpl implements IAmountRecordMonthService {

    @Resource
	private AmountRecordMonthDao amountRecordMonthDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(AmountRecordMonth record){
    	return amountRecordMonthDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return amountRecordMonthDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(AmountRecordMonth record){
		return amountRecordMonthDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public AmountRecordMonth selectByPrimaryKey(Integer id){
    	return amountRecordMonthDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(AmountRecordMonthExample example){
		return amountRecordMonthDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(AmountRecordMonthExample example){
    	return amountRecordMonthDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<AmountRecordMonth> selectByExample(int currentPage, int limit,AmountRecordMonthExample example){
        return amountRecordMonthDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}