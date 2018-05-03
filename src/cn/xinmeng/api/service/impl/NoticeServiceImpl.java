package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.NoticeDao;
import cn.xinmeng.api.dao.ex.ExNoticeDao;
import cn.xinmeng.api.entity.auto.Notice;
import cn.xinmeng.api.entity.auto.example.NoticeExample;
import cn.xinmeng.api.service.INoticeService;

/**
 * 业务层：NoticeServiceImpl
 * @author jiangyong.tan
 * 描述：消息表
 * @date 2016-01-24 14:39:09
 */
@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {

    @Resource
	private NoticeDao noticeDao;
    @Resource
    private ExNoticeDao exNoticeDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Notice record){
    	return noticeDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return noticeDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Notice record){
		return noticeDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Notice selectByPrimaryKey(Integer id){
    	return noticeDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(NoticeExample example){
		return noticeDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Notice> selectByExample(NoticeExample example){
    	return noticeDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Notice> selectByExample(int currentPage, int limit,NoticeExample example){
        return noticeDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	/**
	 * 查询消息列表
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public List<Notice> searchNoticeList(int currentPage, int limit,@Param("customerId") Integer customerId,@Param("shopId") Integer shopId){
		return exNoticeDao.searchNoticeList(new RowBounds(currentPage, limit),customerId, shopId);
	}

	
	/**
	 * 查询消息数量
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public Integer searchNoticeCount(@Param("customerId") Integer customerId,@Param("shopId") Integer shopId){
		return exNoticeDao.searchNoticeCount(customerId, shopId);
	}

	/**
	 * 消息阅读次数
	 * @param id
	 * @return
	 */
	public Integer readNotice(Integer id){
		return exNoticeDao.readNotice(id);
	}

	@Override
	public Integer searchNoticeReadCount(Integer customerId, Integer shopId) {
		return exNoticeDao.searchNoticeReadCount(customerId, shopId);
	}
}