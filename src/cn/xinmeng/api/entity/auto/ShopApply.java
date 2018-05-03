package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：s_shop_apply
 * @author jiangyong.tan
 * @date 2016-12-20 15:34:35
 */
public class ShopApply implements IEntity{

    private static final long serialVersionUID = 279348717734087663L;

    private Integer id; //主键
    private String linkman; //联系人
    private String telephone; //联系电话
    private String remark; //备注
    private Integer state; //1、申请中2、申请成功3、申请拒绝
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    
    public String getLinkman() {
        return this.linkman;
    }
	
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getTelephone() {
        return this.telephone;
    }
	
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return this.remark;
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