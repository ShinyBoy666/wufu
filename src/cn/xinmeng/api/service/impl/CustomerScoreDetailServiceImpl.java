package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerScoreDetailDao;
import cn.xinmeng.api.entity.auto.CustomerScoreDetail;
import cn.xinmeng.api.entity.auto.example.CustomerScoreDetailExample;
import cn.xinmeng.api.service.ICustomerScoreDetailService;

/**
 * 业务层：CustomerScoreDetailServiceImpl
 * @author jiangyong.tan
 * 描述：积分帐户流水表
 * @date 2016-01-24 14:38:51
 */
@Service("customerScoreDetailService")
public class CustomerScoreDetailServiceImpl implements ICustomerScoreDetailService {

    @Resource
	private CustomerScoreDetailDao customerScoreDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerScoreDetail record){
    	return customerScoreDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerScoreDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerScoreDetail record){
		return customerScoreDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerScoreDetail selectByPrimaryKey(Integer id){
    	return customerScoreDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerScoreDetailExample example){
		return customerScoreDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(CustomerScoreDetailExample example){
    	return customerScoreDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CustomerScoreDetail> selectByExample(int currentPage, int limit,CustomerScoreDetailExample example){
        return customerScoreDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}