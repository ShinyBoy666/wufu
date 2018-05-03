package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：消息用户读取记录表
 * @author jiangyong.tan
 * @date 2016-04-07 11:08:02
 */
public class NoticeReader implements IEntity{

    private static final long serialVersionUID = 437739352381297811L;

    private Integer id; //主键
    private Integer noticeId; //消息编号
    private Integer customerId; //用户编号
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }
    
    public Integer getNoticeId() {
        return this.noticeId;
    }
	
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getCustomerId() {
        return this.customerId;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
	
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
}