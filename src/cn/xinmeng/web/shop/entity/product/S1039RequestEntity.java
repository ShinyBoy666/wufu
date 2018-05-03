package cn.xinmeng.web.shop.entity.product;


import cn.xinmeng.web.base.entity.RequestBaseEntity;

public class S1039RequestEntity extends RequestBaseEntity{

	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月25日 上午10:28:42
	 */ 
	private static final long serialVersionUID = 6344460073423053942L;
	
	private Integer level; //所属级别
	private Integer pid; //父级id level=1时 为0
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
