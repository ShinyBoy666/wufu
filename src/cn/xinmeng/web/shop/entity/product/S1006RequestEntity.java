package cn.xinmeng.web.shop.entity.product;


import cn.xinmeng.web.base.entity.PageSearchEntity;

public class S1006RequestEntity extends PageSearchEntity{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月24日 上午10:04:07
	 */ 
	private static final long serialVersionUID = -3337036354101207272L;
	
	private Integer categoryId; //分类id
	private Integer level; //分类所属等级
	private Integer sortType;//排序类型：0-销量由高到低；1-销量由低到高；2-价格由高到低；3-价格由低到高 
	private String keyword;//关键词
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSortType() {
		return sortType;
	}
	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
