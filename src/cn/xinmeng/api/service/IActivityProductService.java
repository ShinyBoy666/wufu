package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.ActivityProduct;
import cn.xinmeng.api.entity.auto.biz.ActvityProductInfoBiz;
import cn.xinmeng.api.entity.auto.example.ActivityProductExample;

/**
 * 接口：IActivityProductService
 * 描述：活动商品表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:04
 */
public interface IActivityProductService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ActivityProduct record);
    
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
	public int updateByPrimaryKey(ActivityProduct record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ActivityProduct selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ActivityProductExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ActivityProduct> selectByExample(ActivityProductExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ActivityProduct> selectByExample(int currentPage, int limit,ActivityProductExample example);
    
    /**
     * 查询活动详情信息
     * @param activityId
     * @param activityType
     * @param productId
     * @param productPriceId
     * @return
     */
    public ActvityProductInfoBiz getActvityProductInfoBiz(Integer activityId,Integer activityType,Integer productId,Integer productPriceId);
    
    /**
     * 修改活动商品信息
     * @param biz
     * @return
     */
    public int updateActivityProduct(ActvityProductInfoBiz biz);
    
    /**
     * redis同步到mysql
     */
    public void redisSyncMysqlActivityProduct();
    
    /**
     * 按条件查询
     * @param activityId
     * @param activityType
     * @return
     */
    public List<ActivityProduct> selectByExample(Integer activityId,Integer activityType);
}