package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：客户推荐奖励配置
 * @author jiangyong.tan
 * @date 2016-10-26 10:28:16
 */
public class CustomerRewardConfig implements IEntity{

    private static final long serialVersionUID = 718801125058035211L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Double vipFee; //会员费
    private Double firstLevel; //第一级
    private Double secondLevel; //第二级
    private Double thirdLevel; //第三级
    private Double shop; //店铺分利
    private Double portal; //平台分利
    private Integer state; //状态0、无效1、有效
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setVipFee(Double vipFee) {
        this.vipFee = vipFee;
    }
    
    public Double getVipFee() {
        return this.vipFee;
    }
	
    public void setFirstLevel(Double firstLevel) {
        this.firstLevel = firstLevel;
    }
    
    public Double getFirstLevel() {
        return this.firstLevel;
    }
	
    public void setSecondLevel(Double secondLevel) {
        this.secondLevel = secondLevel;
    }
    
    public Double getSecondLevel() {
        return this.secondLevel;
    }
	
    public void setThirdLevel(Double thirdLevel) {
        this.thirdLevel = thirdLevel;
    }
    
    public Double getThirdLevel() {
        return this.thirdLevel;
    }
	
    public void setShop(Double shop) {
        this.shop = shop;
    }
    
    public Double getShop() {
        return this.shop;
    }
	
    public void setPortal(Double portal) {
        this.portal = portal;
    }
    
    public Double getPortal() {
        return this.portal;
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