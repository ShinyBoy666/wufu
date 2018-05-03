package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：闪购活动表
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:00
 */
public class FlashPurchaseActivity implements IEntity{

    private static final long serialVersionUID = 360630109117018849L;

    private Integer id; //主键
    private Integer shopId; //店铺编号
    private String title; //活动标题
    private String description; //活动描述
    private String imageUrl; //活动图片
    private java.util.Date showTime; //展示时间
    private java.util.Date beginTime; //开始时间
    private java.util.Date endTime; //结束时间
    private Integer sort; //排序
    private Integer maxBuy; //每人限购数量0表示不限购
    private Integer state; //1、无效2、有效
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
	
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
	
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
	
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return Utils.getImageUrl(this.imageUrl);
    }
	
    public void setShowTime(java.util.Date showTime) {
        this.showTime = showTime;
    }
    
    public java.util.Date getShowTime() {
        return this.showTime;
    }
	
    public void setBeginTime(java.util.Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public java.util.Date getBeginTime() {
        return this.beginTime;
    }
	
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    
    public java.util.Date getEndTime() {
        return this.endTime;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
	
    public void setMaxBuy(Integer maxBuy) {
        this.maxBuy = maxBuy;
    }
    
    public Integer getMaxBuy() {
        return this.maxBuy;
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