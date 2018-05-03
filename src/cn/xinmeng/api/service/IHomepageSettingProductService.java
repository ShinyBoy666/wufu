package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.HomepageSettingProduct;
import cn.xinmeng.api.entity.auto.example.HomepageSettingProductExample;
import java.util.List;

/**
 * 接口：IHomepageSettingProductService
 * @author jiangyong.tan
 * 描述：主页配置商品表
 * @date 2016-01-24 14:38:57
 */
public interface IHomepageSettingProductService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(HomepageSettingProduct record);
    
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
	public int updateByPrimaryKey(HomepageSettingProduct record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public HomepageSettingProduct selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(HomepageSettingProductExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<HomepageSettingProduct> selectByExample(HomepageSettingProductExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<HomepageSettingProduct> selectByExample(int currentPage, int limit,HomepageSettingProductExample example);
    
    public Integer selectProductIdByModulId(Integer modulId);
}