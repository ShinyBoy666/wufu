package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IGroupBuyService;
import cn.xinmeng.api.dao.auto.GroupBuyDao;
import cn.xinmeng.api.entity.auto.GroupBuy;
import cn.xinmeng.api.entity.auto.example.GroupBuyExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：GroupBuyServiceImpl
 * 描述：团购活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:06
 */
@Service("groupBuyService")
public class GroupBuyServiceImpl implements IGroupBuyService {

    @Resource
	private GroupBuyDao groupBuyDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GroupBuy record){
    	return groupBuyDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return groupBuyDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GroupBuy record){
		return groupBuyDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GroupBuy selectByPrimaryKey(Integer id){
    	return groupBuyDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(GroupBuyExample example){
		return groupBuyDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(GroupBuyExample example){
    	return groupBuyDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GroupBuy> selectByExample(int currentPage, int limit,GroupBuyExample example){
        return groupBuyDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}