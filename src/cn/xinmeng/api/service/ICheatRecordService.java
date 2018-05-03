package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.CheatRecord;
import cn.xinmeng.api.entity.auto.example.CheatRecordExample;
import java.util.List;

/**
 * 接口：ICheatRecordService
 * 描述：优惠买单作弊记录表
 * @author jiangyong.tan
 * @date 2016-08-16 10:49:55
 */
public interface ICheatRecordService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CheatRecord record);
    
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
	public int updateByPrimaryKey(CheatRecord record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CheatRecord selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CheatRecordExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(CheatRecordExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<CheatRecord> selectByExample(int currentPage, int limit,CheatRecordExample example);
}