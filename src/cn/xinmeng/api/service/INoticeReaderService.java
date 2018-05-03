package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.NoticeReader;
import cn.xinmeng.api.entity.auto.example.NoticeReaderExample;
import java.util.List;

/**
 * 接口：INoticeReaderService
 * 描述：消息用户读取记录表
 * @author jiangyong.tan
 * @date 2016-04-07 11:08:02
 */
public interface INoticeReaderService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(NoticeReader record);
    
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
	public int updateByPrimaryKey(NoticeReader record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public NoticeReader selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(NoticeReaderExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(NoticeReaderExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<NoticeReader> selectByExample(int currentPage, int limit,NoticeReaderExample example);
}