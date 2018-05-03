package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductCommentDao;
import cn.xinmeng.api.entity.auto.ProductComment;
import cn.xinmeng.api.entity.auto.example.ProductCommentExample;
import cn.xinmeng.api.service.IProductCommentService;

/**
 * 业务层：ProductCommentServiceImpl
 * @author jiangyong.tan
 * 描述：商品评论表
 * @date 2016-01-24 14:39:04
 */
@Service("productCommentService")
public class ProductCommentServiceImpl implements IProductCommentService {

    @Resource
	private ProductCommentDao productCommentDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductComment record){
    	return productCommentDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productCommentDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductComment record){
		return productCommentDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductComment selectByPrimaryKey(Integer id){
    	return productCommentDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductCommentExample example){
		return productCommentDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductComment> selectByExample(ProductCommentExample example){
    	return productCommentDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductComment> selectByExample(int currentPage, int limit,ProductCommentExample example){
        return productCommentDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}