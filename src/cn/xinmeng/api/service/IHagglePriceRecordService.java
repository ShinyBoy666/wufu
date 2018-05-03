package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.HagglePriceRecord;
import cn.xinmeng.api.entity.auto.example.HagglePriceRecordExample;
import java.util.List;

/**
 * 接口：IHagglePriceRecordService
 * 描述：砍价活动价格记录表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:07
 */
public interface IHagglePriceRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HagglePriceRecord record);
    
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
	public int updateByPrimaryKey(HagglePriceRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HagglePriceRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HagglePriceRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(HagglePriceRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HagglePriceRecord> selectByExample(int currentPage, int limit,HagglePriceRecordExample example);
}