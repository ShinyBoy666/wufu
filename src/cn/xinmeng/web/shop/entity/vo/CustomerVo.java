package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.Date;

import cn.xinmeng.common.util.Utils;

public class CustomerVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月29日 上午11:26:13
	 */ 
	private static final long serialVersionUID = 951911479335640460L;
    
	private Integer id; //主键
    private String cellphone; //手机号码
    private String nickname; //用户昵称
    private String customerCategory; //用户类型1、普通用户2、付费用户
    private String headSculpture; //用户头像
    private Integer sex; //0、未知1、男2、女
    private Date openTime; //付费会员开始时间
    private Date endTime; //付费会员到期时间
    private Date createTime; //创建时间
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getHeadSculpture() {
		return Utils.getImageUrl(headSculpture);
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
