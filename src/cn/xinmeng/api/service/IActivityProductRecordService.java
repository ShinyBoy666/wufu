package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ActivityProductRecord;
import cn.xinmeng.api.entity.auto.example.ActivityProductRecordExample;
import java.util.List;

/**
 * 接口：IActivityProductRecordService
 * 描述：活动商品数量流水表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:04
 */
public interface IActivityProductRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ActivityProductRecord record);
    
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
	public int updateByPrimaryKey(ActivityProductRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ActivityProductRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ActivityProductRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ActivityProductRecord> selectByExample(ActivityProductRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ActivityProductRecord> selectByExample(int currentPage, int limit,ActivityProductRecordExample example);
}