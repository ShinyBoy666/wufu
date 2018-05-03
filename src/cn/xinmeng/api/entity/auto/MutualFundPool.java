package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：互助基金池
 * @author jiangyong.tan
 * @date 2017-03-09 12:21:06
 */
public class MutualFundPool implements IEntity{

    private static final long serialVersionUID = 250532528220890209L;

    private Integer id; //主键
    private Double amount; //基金池金额
    private java.util.Date createTime; //创建时间
    private String createUser; //创建者

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
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