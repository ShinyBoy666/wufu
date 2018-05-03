package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.Collection;
import cn.xinmeng.api.entity.auto.example.CollectionExample;
import java.util.List;

/**
 * 接口：ICollectionService
 * @author jiangyong.tan
 * 描述：客户收藏表
 * @date 2016-01-24 14:38:48
 */
public interface ICollectionService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Collection record);
    
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
	public int updateByPrimaryKey(Collection record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Collection selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CollectionExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Collection> selectByExample(CollectionExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Collection> selectByExample(int currentPage, int limit,CollectionExample example);
    
    /**
     * 添加或删除
     * @param record
     * @return
     */
    public boolean insertOrDelete(Collection record);
    
    /**
     * 
     * <p class="detail"> 根据客户id和收藏类型查询收藏对象id集合 </p>
     * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月13日 下午4:05:38
     * @param customerId
     * @param objectType 收藏类型为null查询所有
     * @return
     */
    public List<String> selectObjectIdsByCustomerId(Integer customerId,Integer objectType);
}