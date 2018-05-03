package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ButtonClickLog;
import cn.xinmeng.api.entity.auto.example.ButtonClickLogExample;
import java.util.List;

/**
 * 接口：IButtonClickLogService
 * 描述：按钮点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:19
 */
public interface IButtonClickLogService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ButtonClickLog record);
    
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
	public int updateByPrimaryKey(ButtonClickLog record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ButtonClickLog selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ButtonClickLogExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(ButtonClickLogExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(int currentPage, int limit,ButtonClickLogExample example);
}