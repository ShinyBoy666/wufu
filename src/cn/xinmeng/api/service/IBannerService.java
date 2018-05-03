package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.Banner;
import cn.xinmeng.api.entity.auto.example.BannerExample;
import cn.xinmeng.web.shop.entity.vo.BannerVo;

import java.util.List;

/**
 * 接口：IBannerService
 * @author jiangyong.tan
 * 描述：轮播图表
 * @date 2016-01-24 14:38:55
 */
public interface IBannerService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Banner record);
    
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
	public int updateByPrimaryKey(Banner record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Banner selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(BannerExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Banner> selectByExample(BannerExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Banner> selectByExample(int currentPage, int limit,BannerExample example);
    
    /**
     * 轮播图
     * @param shopId
     * @param showArea
     * @return
     */
    public List<BannerVo> selectBannerVo(Integer shopId,Integer showArea);
}