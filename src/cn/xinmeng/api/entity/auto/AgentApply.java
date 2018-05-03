package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：代理商申请
 * @author jiangyong.tan
 * @date 2016-05-18 17:04:42
 */
public class AgentApply implements IEntity{

    private static final long serialVersionUID = 756951135154912113L;

    private Integer id; //主键
    private String enterpriseName; //企业名称
    private String linkman; //联系人
    private String telephone; //联系电话
    private String email; //邮箱
    private Integer agentType; //代理级别
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
	
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    public String getEnterpriseName() {
        return this.enterpriseName;
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
	
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
	
    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }
    
    public Integer getAgentType() {
        return this.agentType;
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