package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IAgentService;
import cn.xinmeng.api.dao.auto.AgentDao;
import cn.xinmeng.api.entity.auto.Agent;
import cn.xinmeng.api.entity.auto.example.AgentExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：AgentServiceImpl
 * 描述：代理商信息
 * @author jiangyong.tan
 * @date 2016-05-21 13:34:44
 */
@Service("agentService")
public class AgentServiceImpl implements IAgentService {

    @Resource
	private AgentDao agentDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Agent record){
    	return agentDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return agentDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Agent record){
		return agentDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Agent selectByPrimaryKey(Integer id){
    	return agentDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(AgentExample example){
		return agentDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Agent> selectByExample(AgentExample example){
    	return agentDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Agent> selectByExample(int currentPage, int limit,AgentExample example){
        return agentDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}