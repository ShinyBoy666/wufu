package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：商品评论图片表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:23
 */
public class ProductCommentImage implements IEntity{

    private static final long serialVersionUID = 777366419485651008L;

    private Integer id; //主键
    private Integer commontId; //商品评论编号
    private String imageUrl; //图片地址
    private Integer state; //状态0：无效1：有效
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
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
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
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