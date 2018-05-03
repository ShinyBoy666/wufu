package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ProductCommentReplyDao;
import cn.xinmeng.api.entity.auto.ProductCommentReply;
import cn.xinmeng.api.entity.auto.example.ProductCommentReplyExample;
import cn.xinmeng.api.service.IProductCommentReplyService;

/**
 * 业务层：ProductCommentReplyServiceImpl
 * @author jiangyong.tan
 * 描述：评论回复表
 * @date 2016-01-24 14:39:04
 */
@Service("productCommentReplyService")
public class ProductCommentReplyServiceImpl implements IProductCommentReplyService {

    @Resource
	private ProductCommentReplyDao productCommentReplyDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ProductCommentReply record){
    	return productCommentReplyDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return productCommentReplyDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductCommentReply record){
		return productCommentReplyDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductCommentReply selectByPrimaryKey(Integer id){
    	return productCommentReplyDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ProductCommentReplyExample example){
		return productCommentReplyDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(ProductCommentReplyExample example){
    	return productCommentReplyDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(int currentPage, int limit,ProductCommentReplyExample example){
        return productCommentReplyDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}