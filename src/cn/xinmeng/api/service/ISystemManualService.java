package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.SystemManual;
import cn.xinmeng.api.entity.auto.example.SystemManualExample;
import java.util.List;

/**
 * 接口：ISystemManualService
 * 描述：系统操作手册
 * @author jiangyong.tan
 * @date 2016-04-21 15:36:59
 */
public interface ISystemManualService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(SystemManual record);
    
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
	public int updateByPrimaryKey(SystemManual record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public SystemManual selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SystemManualExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(SystemManualExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<SystemManual> selectByExample(int currentPage, int limit,SystemManualExample example);
    
    /**
     * 查询内容id
     * @param id
     * @return
     */
    public String queryContentById(Integer id);
}