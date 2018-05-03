package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductCommentImageDao;
import cn.xinmeng.api.entity.auto.ProductCommentImage;
import cn.xinmeng.api.entity.auto.example.ProductCommentImageExample;
import cn.xinmeng.api.service.IProductCommentImageService;

/**
 * 业务层：ProductCommentImageServiceImpl
 * @author jiangyong.tan
 * 描述：商品评论图片表
 * @date 2016-01-24 14:39:04
 */
@Service("productCommentImageService")
public class ProductCommentImageServiceImpl implements IProductCommentImageService {

    @Resource
	private ProductCommentImageDao productCommentImageDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductCommentImage record){
    	return productCommentImageDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productCommentImageDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductCommentImage record){
		return productCommentImageDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductCommentImage selectByPrimaryKey(Integer id){
    	return productCommentImageDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductCommentImageExample example){
		return productCommentImageDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductCommentImage> selectByExample(ProductCommentImageExample example){
    	return productCommentImageDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductCommentImage> selectByExample(int currentPage, int limit,ProductCommentImageExample example){
        return productCommentImageDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}