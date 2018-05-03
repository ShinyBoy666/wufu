package cn.xinmeng.web.shop.entity.product;

import java.util.List;

import cn.xinmeng.web.shop.entity.vo.CategoryVo;

public class S1050ResponseEntity extends CategoryVo{

	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年3月14日 下午3:51:13
	 */ 
	private static final long serialVersionUID = 6777577874577656671L;

	private List<CategoryVo> list;//下级分类集合

	public List<CategoryVo> getList() {
		return list;
	}

	public void setList(List<CategoryVo> list) {
		this.list = list;
	}
	
}
