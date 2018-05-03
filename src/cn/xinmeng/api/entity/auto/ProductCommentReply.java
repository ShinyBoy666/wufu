package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：评论回复表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:25
 */
public class ProductCommentReply implements IEntity{

    private static final long serialVersionUID = 599178178165077230L;

    private Integer id; //主键
    private Integer commontId; //评论主表ID
    private Integer replyId; //评论回复表ID
    private Integer replyType; //回复类型1：客户、2：客服3：店主
    private String replyContent; //回复内容
    private String replyUser; //回复用户
    private java.util.Date replyTime; //回复时间
    private Integer state; //状态0：无效1：有效

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setCommontId(Integer commontId) {
        this.commontId = commontId;
    }
    
    public Integer getCommontId() {
        return this.commontId;
    }
	
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }
    
    public Integer getReplyId() {
        return this.replyId;
    }
	
    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }
    
    public Integer getReplyType() {
        return this.replyType;
    }
	
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    
    public String getReplyContent() {
        return this.replyContent;
    }
	
    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }
    
    public String getReplyUser() {
        return this.replyUser;
    }
	
    public void setReplyTime(java.util.Date replyTime) {
        this.replyTime = replyTime;
    }
    
    public java.util.Date getReplyTime() {
        return this.replyTime;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
}