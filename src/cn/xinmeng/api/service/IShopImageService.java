package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.ShopImage;
import cn.xinmeng.api.entity.auto.example.ShopImageExample;
import cn.xinmeng.api.enums.ShopImageTypeEnum;

/**
 * 接口：IShopImageService
 * 描述：门店图片表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:12
 */
public interface IShopImageService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopImage record);
    
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
	public int updateByPrimaryKey(ShopImage record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopImage selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ShopImageExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(ShopImageExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(int currentPage, int limit,ShopImageExample example);
    
    /**
     * 查询店铺其中一张图片
     * @param shopId
     * @return
     */
    public String queryShopInfoImage(Integer shopId,ShopImageTypeEnum imageType);
    
    /**
     * 添加封面图，形象图
     * @param coverImageUrl
     * @param personalImageUrl
     * @return
     */
    public int addImageUrl(Integer shopId,String coverImageUrl,String personalImageUrl);
}