package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.NoticeReaderDao;
import cn.xinmeng.api.entity.auto.NoticeReader;
import cn.xinmeng.api.entity.auto.example.NoticeReaderExample;
import cn.xinmeng.api.service.INoticeReaderService;

/**
 * 业务层：NoticeReaderServiceImpl
 * 描述：消息用户读取记录表
 * @author jiangyong.tan
 * @date 2016-04-07 11:08:02
 */
@Service("noticeReaderService")
public class NoticeReaderServiceImpl implements INoticeReaderService {

    @Resource
	private NoticeReaderDao noticeReaderDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(NoticeReader record){
    	return noticeReaderDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return noticeReaderDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(NoticeReader record){
		return noticeReaderDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public NoticeReader selectByPrimaryKey(Integer id){
    	return noticeReaderDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(NoticeReaderExample example){
		return noticeReaderDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(NoticeReaderExample example){
    	return noticeReaderDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(int currentPage, int limit,NoticeReaderExample example){
        return noticeReaderDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}