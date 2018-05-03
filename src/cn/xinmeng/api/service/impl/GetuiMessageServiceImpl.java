package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IGetuiMessageService;
import cn.xinmeng.api.dao.auto.GetuiMessageDao;
import cn.xinmeng.api.entity.auto.GetuiMessage;
import cn.xinmeng.api.entity.auto.example.GetuiMessageExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：GetuiMessageServiceImpl
 * 描述：推送消息表
 * @author jiangyong.tan
 * @date 2016-06-17 19:55:06
 */
@Service("getuiMessageService")
public class GetuiMessageServiceImpl implements IGetuiMessageService {

    @Resource
	private GetuiMessageDao getuiMessageDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GetuiMessage record){
    	return getuiMessageDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return getuiMessageDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(GetuiMessage record){
		return getuiMessageDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GetuiMessage selectByPrimaryKey(Integer id){
    	return getuiMessageDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(GetuiMessageExample example){
		return getuiMessageDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GetuiMessage> selectByExample(GetuiMessageExample example){
    	return getuiMessageDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GetuiMessage> selectByExample(int currentPage, int limit,GetuiMessageExample example){
        return getuiMessageDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}