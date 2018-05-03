package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.Ad;
import cn.xinmeng.api.entity.auto.example.AdExample;
import java.util.List;

/**
 * 接口：IAdService
 * 描述：广告管理
 * @author jiangyong.tan
 * @date 2016-05-24 20:20:05
 */
public interface IAdService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Ad record);
    
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
	public int updateByPrimaryKey(Ad record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Ad selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(AdExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Ad> selectByExample(AdExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Ad> selectByExample(int currentPage, int limit,AdExample example);
}