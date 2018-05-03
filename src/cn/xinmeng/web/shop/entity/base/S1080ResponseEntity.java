package cn.xinmeng.web.shop.entity.base;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 购物车列表 
 * @param 
 * @ClassName: S1011ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1080ResponseEntity extends ResponseBaseEntity {

	private static final long serialVersionUID = 5563411612415114290L;

    private Integer id; //编号
    private String adTitle; //标题
    private String imageUrl; //图片地址
    private String linkUrl; //链接地址
    private Integer holdTime; //持续时间
    private Integer runInterval; //间隔
    
    //set get
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdTitle() {
		return adTitle;
	}
	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getHoldTime() {
		return holdTime;
	}
	public void setHoldTime(Integer holdTime) {
		this.holdTime = holdTime;
	}
	public Integer getRunInterval() {
		return runInterval;
	}
	public void setRunInterval(Integer runInterval) {
		this.runInterval = runInterval;
	}
}
