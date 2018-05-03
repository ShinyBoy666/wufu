package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

public class FindInformationVo implements Serializable{

	private static final long serialVersionUID = 8176314142211178854L;


    private Integer id; //主键
    private String title; //活动标题
    private String headSculpture; //用户头像
    private Integer minSalary; //薪水最小值
    private Integer maxSalary; //薪水最大值
    private String contactName; //联系人姓名
    private String contactPosition; //联系人职位
    
    //set get 
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	public Integer getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}
	public Integer getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPosition() {
		return contactPosition;
	}
	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}
}
