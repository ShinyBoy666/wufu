package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IMutualFundPoolService;
import cn.xinmeng.api.dao.auto.MutualFundPoolDao;
import cn.xinmeng.api.entity.auto.MutualFundPool;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：MutualFundPoolServiceImpl
 * 描述：互助基金池
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:06
 */
@Service("mutualFundPoolService")
public class MutualFundPoolServiceImpl implements IMutualFundPoolService {

    @Resource
	private MutualFundPoolDao mutualFundPoolDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(MutualFundPool record){
    	return mutualFundPoolDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return mutualFundPoolDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(MutualFundPool record){
		return mutualFundPoolDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPool selectByPrimaryKey(Integer id){
    	return mutualFundPoolDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(MutualFundPoolExample example){
		return mutualFundPoolDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(MutualFundPoolExample example){
    	return mutualFundPoolDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<MutualFundPool> selectByExample(int currentPage, int limit,MutualFundPoolExample example){
        return mutualFundPoolDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}