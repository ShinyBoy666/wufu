package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IAgentApplyService;
import cn.xinmeng.api.dao.auto.AgentApplyDao;
import cn.xinmeng.api.entity.auto.AgentApply;
import cn.xinmeng.api.entity.auto.example.AgentApplyExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：AgentApplyServiceImpl
 * 描述：代理商申请
 * @author jiangyong.tan
 * @date 2016-05-18 17:04:42
 */
@Service("agentApplyService")
public class AgentApplyServiceImpl implements IAgentApplyService {

    @Resource
	private AgentApplyDao agentApplyDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(AgentApply record){
    	return agentApplyDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return agentApplyDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(AgentApply record){
		return agentApplyDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public AgentApply selectByPrimaryKey(Integer id){
    	return agentApplyDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(AgentApplyExample example){
		return agentApplyDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<AgentApply> selectByExample(AgentApplyExample example){
    	return agentApplyDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<AgentApply> selectByExample(int currentPage, int limit,AgentApplyExample example){
        return agentApplyDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}