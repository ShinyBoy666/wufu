package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.GetuiMessage;
import cn.xinmeng.api.entity.auto.example.GetuiMessageExample;
import java.util.List;

/**
 * 接口：IGetuiMessageService
 * 描述：推送消息表
 * @author jiangyong.tan
 * @date 2016-06-17 19:55:06
 */
public interface IGetuiMessageService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(GetuiMessage record);
    
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
	public int updateByPrimaryKey(GetuiMessage record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public GetuiMessage selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(GetuiMessageExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<GetuiMessage> selectByExample(GetuiMessageExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<GetuiMessage> selectByExample(int currentPage, int limit,GetuiMessageExample example);
}