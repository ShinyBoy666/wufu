package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

import cn.xinmeng.common.util.Utils;

public class CategoryVo implements Serializable{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月24日 上午9:56:27
	 */ 
	private static final long serialVersionUID = -1181820449710650507L;

	private Integer id; //主键
    private String categoryName; //类别名称
    private String categoryDescription; //类别描述
    private String ico; //图片
    private Integer level; //所属级别
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getIco() {
		return Utils.getImageUrl(ico);
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
