package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：图标配置表
 * @author jiangyong.tan
 * @date 2016-11-21 16:13:37
 */
public class IcoSetting implements IEntity{

    private static final long serialVersionUID = 104119265804772120L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private Integer page; //所属页面:1=首页，2=底部导航
    private String icoName; //图标名称page=1时：联系商家=contactShop，领取优惠券=coupon，收藏商品=collection，附近店铺=near
    private String url; //图标资源位置
    private Integer icoIndex; //图标位置
    private String linkUrl; //链接地址
    private Integer state; //1=无效，2=有效
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
	
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getPage() {
        return this.page;
    }
	
    public void setIcoName(String icoName) {
        this.icoName = icoName;
    }
    
    public String getIcoName() {
        return this.icoName;
    }
	
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return Utils.getImageUrl(this.url);
    }
	
    public void setIcoIndex(Integer icoIndex) {
        this.icoIndex = icoIndex;
    }
    
    public Integer getIcoIndex() {
        return this.icoIndex;
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
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