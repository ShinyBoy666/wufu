package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerVipRecordDao;
import cn.xinmeng.api.entity.auto.CustomerVipRecord;
import cn.xinmeng.api.entity.auto.example.CustomerVipRecordExample;
import cn.xinmeng.api.service.ICustomerVipRecordService;

/**
 * 业务层：CustomerVipRecordServiceImpl
 * 描述：会员开通记录表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
@Service("customerVipRecordService")
public class CustomerVipRecordServiceImpl implements ICustomerVipRecordService {

    @Resource
	private CustomerVipRecordDao customerVipRecordDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CustomerVipRecord record){
    	return customerVipRecordDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return customerVipRecordDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CustomerVipRecord record){
		return customerVipRecordDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CustomerVipRecord selectByPrimaryKey(Integer id){
    	return customerVipRecordDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerVipRecordExample example){
		return customerVipRecordDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(CustomerVipRecordExample example){
    	return customerVipRecordDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CustomerVipRecord> selectByExample(int currentPage, int limit,CustomerVipRecordExample example){
        return customerVipRecordDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}