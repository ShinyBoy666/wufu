package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.HomepageSetting;
import cn.xinmeng.api.entity.auto.example.HomepageSettingExample;
import cn.xinmeng.web.shop.entity.vo.HomepageSettingParentVo;

/**
 * 接口：IHomepageSettingService
 * 描述：主页配置表
 * @author jiangyong.tan
 * @date 2016-03-08 14:00:36
 */
public interface IHomepageSettingService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageSetting record);
    
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
	public int updateByPrimaryKey(HomepageSetting record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageSetting selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HomepageSettingExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(HomepageSettingExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<HomepageSetting> selectByExample(int currentPage, int limit,HomepageSettingExample example);
    
    /**
     * 首页配置信息
     * @param shopId
     * @return
     */
    public List<HomepageSettingParentVo> getHomepageList(Integer shopId);
}