package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.SystemLog;
import cn.xinmeng.api.entity.auto.example.SystemLogExample;
import java.util.List;

/**
 * 接口：ISystemLogService
 * 描述：系统操作日志表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:30
 */
public interface ISystemLogService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemLog record);
    
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
	public int updateByPrimaryKey(SystemLog record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemLog selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemLogExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemLog> selectByExample(SystemLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemLog> selectByExample(int currentPage, int limit,SystemLogExample example);
}