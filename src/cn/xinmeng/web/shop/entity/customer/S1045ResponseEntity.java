package cn.xinmeng.web.shop.entity.customer;

import java.util.List;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.vo.CustomerVo;

public class S1045ResponseEntity extends ResponseBaseEntity{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月29日 上午11:25:03
	 */ 
	private static final long serialVersionUID = 9104730642726395102L;
	
	private String url;//二维码地址
	
	private String remark;//

    private String headSculpture; //用户头像
	
	private List<CustomerVo> list;//最近推荐的好友
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CustomerVo> getList() {
		return list;
	}

	public void setList(List<CustomerVo> list) {
		this.list = list;
	}

	public String getHeadSculpture() {
		return headSculpture;
	}

	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}
	
}
