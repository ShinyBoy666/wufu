package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IGuidePageCustomerService;
import cn.xinmeng.api.dao.auto.GuidePageCustomerDao;
import cn.xinmeng.api.entity.auto.GuidePageCustomer;
import cn.xinmeng.api.entity.auto.example.GuidePageCustomerExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：GuidePageCustomerServiceImpl
 * 描述：用户引导记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:21
 */
@Service("guidePageCustomerService")
public class GuidePageCustomerServiceImpl implements IGuidePageCustomerService {

    @Resource
	private GuidePageCustomerDao guidePageCustomerDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GuidePageCustomer record){
    	return guidePageCustomerDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return guidePageCustomerDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GuidePageCustomer record){
		return guidePageCustomerDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GuidePageCustomer selectByPrimaryKey(Integer id){
    	return guidePageCustomerDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(GuidePageCustomerExample example){
		return guidePageCustomerDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GuidePageCustomer> selectByExample(GuidePageCustomerExample example){
    	return guidePageCustomerDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GuidePageCustomer> selectByExample(int currentPage, int limit,GuidePageCustomerExample example){
        return guidePageCustomerDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}