package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.HaggleRecord;
import cn.xinmeng.api.entity.auto.example.HaggleRecordExample;
import java.util.List;

/**
 * 接口：IHaggleRecordService
 * 描述：砍价活动记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:08
 */
public interface IHaggleRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HaggleRecord record);
    
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
	public int updateByPrimaryKey(HaggleRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HaggleRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HaggleRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(HaggleRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HaggleRecord> selectByExample(int currentPage, int limit,HaggleRecordExample example);
}