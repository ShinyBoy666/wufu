package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.SystemErrorLog;
import cn.xinmeng.api.entity.auto.example.SystemErrorLogExample;
import java.util.List;

/**
 * 接口：ISystemErrorLogService
 * 描述：系统异常日志表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:29
 */
public interface ISystemErrorLogService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemErrorLog record);
    
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
	public int updateByPrimaryKey(SystemErrorLog record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemErrorLog selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemErrorLogExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(SystemErrorLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemErrorLog> selectByExample(int currentPage, int limit,SystemErrorLogExample example);
}