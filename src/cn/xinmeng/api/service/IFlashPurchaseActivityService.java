package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.FlashPurchaseActivity;
import cn.xinmeng.api.entity.auto.example.FlashPurchaseActivityExample;

/**
 * 接口：IFlashPurchaseActivityService
 * 描述：闪购活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:06
 */
public interface IFlashPurchaseActivityService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(FlashPurchaseActivity record);
    
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
	public int updateByPrimaryKey(FlashPurchaseActivity record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public FlashPurchaseActivity selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(FlashPurchaseActivityExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<FlashPurchaseActivity> selectByExample(FlashPurchaseActivityExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<FlashPurchaseActivity> selectByExample(int currentPage, int limit,FlashPurchaseActivityExample example);
    
    /**
     * 展示店铺活动
     * @param shopId
     * @return
     */
    public List<FlashPurchaseActivity> selectAllShowFlashPurchaseActivity(Integer shopId);
}