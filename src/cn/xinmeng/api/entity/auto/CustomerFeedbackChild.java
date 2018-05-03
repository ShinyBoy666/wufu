package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户意见反馈子表
 * @author jiangyong.tan
 * @date 2016-03-21 11:03:55
 */
public class CustomerFeedbackChild implements IEntity{

    private static final long serialVersionUID = 384929407054725432L;

    private Integer id; //主键
    private Integer feedbackId; //意见反馈主表Id
    private Integer feedbackChildId; //回复Id
    private String replyContent; //回复内容
    private Integer replyType; //回复人类型1客户2客服
    private java.util.Date createTime; //创建时间
    private String updateUser; //修改人
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }
    
    public Integer getFeedbackId() {
        return this.feedbackId;
    }
	
    public void setFeedbackChildId(Integer feedbackChildId) {
        this.feedbackChildId = feedbackChildId;
    }
    
    public Integer getFeedbackChildId() {
        return this.feedbackChildId;
    }
	
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    
    public String getReplyContent() {
        return this.replyContent;
    }
	
    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }
    
    public Integer getReplyType() {
        return this.replyType;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
}