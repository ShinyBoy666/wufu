package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：商品点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:23
 */
public class ProductClickLog implements IEntity{

    private static final long serialVersionUID = 254510286465083751L;

    private Integer id; //主键
    private String pageName; //页面名称
    private Integer productId; //商品编号
    private String productName; //商品名称
    private String imei; //IMEI
    private Integer fromType; //1、安卓2、IOS3、WAP
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getPageName() {
        return this.pageName;
    }
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductName() {
        return this.productName;
    }
	
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public String getImei() {
        return this.imei;
    }
	
    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }
    
    public Integer getFromType() {
        return this.fromType;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}