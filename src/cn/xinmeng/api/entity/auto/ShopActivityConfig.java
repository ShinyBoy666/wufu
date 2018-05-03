package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：店铺优惠买单活动配置
 * @author jiangyong.tan
 * @date 2016-06-21 17:37:13
 */
public class ShopActivityConfig implements IEntity{

    private static final long serialVersionUID = 295283583567516960L;

    private Integer id; //编号
    private Integer shopId; //店铺编号
    private Integer canRandom; //是否支持随机立减1、是2、否
    private Double maxMoney; //随机最高金额
    private Double minMoney; //随机最低金额
    private Integer canFullReduce; //是否支持满立减1、是2、否
    private String fullMoney; //满多少金额
    private String reduceMoney; //减多少金额
    private Integer canSale; //是否支持买单打折1、是2、否
    private Double sale; //折扣
    private java.util.Date createTime; //创建时间
    private String createUser; //创建人
    private java.util.Date updateTime; //修改时间
    private String updateUser; //修改人

	
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
	
    public void setCanRandom(Integer canRandom) {
        this.canRandom = canRandom;
    }
    
    public Integer getCanRandom() {
        return this.canRandom;
    }
	
    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }
    
    public Double getMaxMoney() {
        return this.maxMoney;
    }
	
    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }
    
    public Double getMinMoney() {
        return this.minMoney;
    }
	
    public void setCanFullReduce(Integer canFullReduce) {
        this.canFullReduce = canFullReduce;
    }
    
    public Integer getCanFullReduce() {
        return this.canFullReduce;
    }
	
    public void setFullMoney(String fullMoney) {
        this.fullMoney = fullMoney;
    }
    
    public String getFullMoney() {
        return this.fullMoney;
    }
	
    public void setReduceMoney(String reduceMoney) {
        this.reduceMoney = reduceMoney;
    }
    
    public String getReduceMoney() {
        return this.reduceMoney;
    }
	
    public void setCanSale(Integer canSale) {
        this.canSale = canSale;
    }
    
    public Integer getCanSale() {
        return this.canSale;
    }
	
    public void setSale(Double sale) {
        this.sale = sale;
    }
    
    public Double getSale() {
        return this.sale;
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
	
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
	
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
}