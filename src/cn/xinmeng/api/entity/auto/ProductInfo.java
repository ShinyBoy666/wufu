package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：商品基础信息表
 * @author jiangyong.tan
 * @date 2016-10-24 18:06:53
 */
public class ProductInfo implements IEntity{

    private static final long serialVersionUID = 559661521332020368L;

    private Integer id; //主键
    private Integer productId; //商品编号
    private Integer shopId; //店铺编号
    private String unit; //单位
    private String productName; //产品名称
    private String metaKeywords; //商品SEO关键字
    private String productIntroduction; //商品简介
    private Integer categoryId; //商品类别
    private Double marketPrice; //市场上的价格，只是用来显示，界面用横线画掉。
    private Double retailPrice; //普通商品的售卖价格
    private Double vipPrice; //会员价
    private Integer isDelivery; //1、不需要2、需要
    private Integer isRealyname; //是否实名制1、不需要2、需要
    private Integer isHaveSku; //是否有SKU1、否2、是
    private Integer state; //1：无效、2：有效、3：上架、4：下架
    private Integer isNew; //新品1、否2、是
    private Integer hot; //热销1、否2、是
    private Integer sort; //权重（排序）数组越大越靠前
    private String imageUrl; //默认图片地址
    private Integer viewCount; //浏览量
    private Integer buyVirtualCount; //虚拟购买量
    private Integer buyCount; //实际购买量
    private Integer praiseCount; //点赞次数
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
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Integer getShopId() {
        return this.shopId;
    }
	
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getUnit() {
        return this.unit;
    }
	
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductName() {
        return this.productName;
    }
	
    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }
    
    public String getMetaKeywords() {
        return this.metaKeywords;
    }
	
    public void setProductIntroduction(String productIntroduction) {
        this.productIntroduction = productIntroduction;
    }
    
    public String getProductIntroduction() {
        return this.productIntroduction;
    }
	
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public Integer getCategoryId() {
        return this.categoryId;
    }
	
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }
    
    public Double getMarketPrice() {
        return this.marketPrice;
    }
	
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }
    
    public Double getRetailPrice() {
        return this.retailPrice;
    }
	
    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }
    
    public Double getVipPrice() {
        return this.vipPrice;
    }
	
    public void setIsDelivery(Integer isDelivery) {
        this.isDelivery = isDelivery;
    }
    
    public Integer getIsDelivery() {
        return this.isDelivery;
    }
	
    public void setIsRealyname(Integer isRealyname) {
        this.isRealyname = isRealyname;
    }
    
    public Integer getIsRealyname() {
        return this.isRealyname;
    }
	
    public void setIsHaveSku(Integer isHaveSku) {
        this.isHaveSku = isHaveSku;
    }
    
    public Integer getIsHaveSku() {
        return this.isHaveSku;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    
    public Integer getIsNew() {
        return this.isNew;
    }
	
    public void setHot(Integer hot) {
        this.hot = hot;
    }
    
    public Integer getHot() {
        return this.hot;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    
    public Integer getViewCount() {
        return this.viewCount;
    }
	
    public void setBuyVirtualCount(Integer buyVirtualCount) {
        this.buyVirtualCount = buyVirtualCount;
    }
    
    public Integer getBuyVirtualCount() {
        return this.buyVirtualCount;
    }
	
    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }
    
    public Integer getBuyCount() {
        return this.buyCount;
    }
	
    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
    
    public Integer getPraiseCount() {
        return this.praiseCount;
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