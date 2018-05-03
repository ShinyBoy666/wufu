package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Notice;
import cn.xinmeng.api.entity.auto.example.NoticeExample;

/**
 * 接口：INoticeService
 * @author jiangyong.tan
 * 描述：消息表
 * @date 2016-01-24 14:39:09
 */
public interface INoticeService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Notice record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Notice record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Notice selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(NoticeExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Notice> selectByExample(NoticeExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Notice> selectByExample(int currentPage, int limit,NoticeExample example);

	/**
	 * 查询消息列表
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public List<Notice> searchNoticeList(int currentPage, int limit,Integer customerId,Integer shopId);

	
	/**
	 * 查询消息数量
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public Integer searchNoticeCount(Integer customerId,Integer shopId);

	/**
	 * 消息阅读次数
	 * @param id
	 * @return
	 */
	public Integer readNotice(Integer id);
	
	/**
	 * 查询消息已读数量
	 * @param customerId
	 * @param shopId
	 * @return
	 */
	public Integer searchNoticeReadCount(Integer customerId,Integer shopId);
}