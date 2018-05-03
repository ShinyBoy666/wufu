package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IMutualFundPoolDetailService;
import cn.xinmeng.api.dao.auto.MutualFundPoolDetailDao;
import cn.xinmeng.api.entity.auto.MutualFundPoolDetail;
import cn.xinmeng.api.entity.auto.example.MutualFundPoolDetailExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：MutualFundPoolDetailServiceImpl
 * 描述：互助基金池账户金额流水表
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:07
 */
@Service("mutualFundPoolDetailService")
public class MutualFundPoolDetailServiceImpl implements IMutualFundPoolDetailService {

    @Resource
	private MutualFundPoolDetailDao mutualFundPoolDetailDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(MutualFundPoolDetail record){
    	return mutualFundPoolDetailDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return mutualFundPoolDetailDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(MutualFundPoolDetail record){
		return mutualFundPoolDetailDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public MutualFundPoolDetail selectByPrimaryKey(Integer id){
    	return mutualFundPoolDetailDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(MutualFundPoolDetailExample example){
		return mutualFundPoolDetailDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(MutualFundPoolDetailExample example){
    	return mutualFundPoolDetailDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<MutualFundPoolDetail> selectByExample(int currentPage, int limit,MutualFundPoolDetailExample example){
        return mutualFundPoolDetailDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}