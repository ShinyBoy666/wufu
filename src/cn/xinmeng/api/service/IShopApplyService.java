package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.ShopApply;
import cn.xinmeng.api.entity.auto.example.ShopApplyExample;
import java.util.List;

/**
 * 接口：IShopApplyService
 * 描述：s_shop_apply
 * @author jiangyong.tan
 * @date 2016-12-20 15:34:35
 */
public interface IShopApplyService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopApply record);
    
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
	public int updateByPrimaryKey(ShopApply record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopApply selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopApplyExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(ShopApplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopApply> selectByExample(int currentPage, int limit,ShopApplyExample example);
}