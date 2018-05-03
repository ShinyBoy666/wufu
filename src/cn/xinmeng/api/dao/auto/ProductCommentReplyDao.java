package cn.xinmeng.api.dao.auto;

import cn.xinmeng.api.entity.auto.ProductCommentReply;
import cn.xinmeng.api.entity.auto.example.ProductCommentReplyExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Param;

/**
 * dao：ProductCommentReplyDao
 * 描述：评论回复表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:15
 */
public interface ProductCommentReplyDao {

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(ProductCommentReplyExample example);
    
    /**
     * 按条件删除
     * @param example
     * @return
     */
    public int deleteByExample(ProductCommentReplyExample example);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
    
    /**
     * 添加数据（单个）
     * @param record
     * @return
     */
    public int insert(ProductCommentReply record);
    
    /**
     * 添加数据（多个）
     * @param record
     * @return
     */
    public int insertBatch(List<ProductCommentReply> listRecord);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(ProductCommentReplyExample example);
    
    /**
     * 按条件查询（分页）
     * @param rowBounds
     * @param example
     * @return
     */
    public List<ProductCommentReply> selectByExample(RowBounds rowBounds,ProductCommentReplyExample example);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ProductCommentReply selectByPrimaryKey(Integer id);
    
    /**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(@Param("record") ProductCommentReply record, @Param("example") ProductCommentReplyExample example);
	
	/**
     * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(@Param("record") ProductCommentReply record, @Param("example") ProductCommentReplyExample example);
    
	/**
     * 按主键修改（修改有值的，实体属性有值，则修改数据库相应的字段）
     * @param record
     * @param example
     * @return
     */
    public int updateSelectiveByPrimaryKey(ProductCommentReply record);
    
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ProductCommentReply record);
}