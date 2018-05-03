package cn.xinmeng.api.service;

import java.util.List;
import java.util.Map;

import cn.xinmeng.api.entity.auto.IcoSetting;
import cn.xinmeng.api.entity.auto.example.IcoSettingExample;
import cn.xinmeng.web.shop.entity.vo.IcoSettingVo;

/**
 * 接口：IIcoSettingService
 * 描述：图标配置表
 * @author jiangyong.tan
 * @date 2016-05-21 13:35:11
 */
public interface IIcoSettingService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(IcoSetting record);
    
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
	public int updateByPrimaryKey(IcoSetting record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public IcoSetting selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(IcoSettingExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<IcoSetting> selectByExample(IcoSettingExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<IcoSetting> selectByExample(int currentPage, int limit,IcoSettingExample example);
    
    /**
     * 查询首页图标
     * @return
     */
    public Map<String,String> selectHomePageByExample(Integer shopId);
    
    /**
     * 查询首页菜单
     * @return
     */
    public List<IcoSettingVo> queryHomePageMenu(Integer shopId);
}