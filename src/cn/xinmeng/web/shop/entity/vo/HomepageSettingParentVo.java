package cn.xinmeng.web.shop.entity.vo;

import java.util.List;

public class HomepageSettingParentVo extends HomepageSettingVo{

	
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月22日 下午3:34:40
	 */ 
	private static final long serialVersionUID = -4619523491748689718L;
	
    private List<HomepageSettingVo> list;//子模块集合
    
    private Integer showType;//展现形式 1、1张图片 2、2张图片 3、3张图片 4、4张图片 5、5张图片 6、横排图片 7、竖排图片  8、秒杀

	public List<HomepageSettingVo> getList() {
		return list;
	}

	public void setList(List<HomepageSettingVo> list) {
		this.list = list;
	}
	
	public Integer getShowType() {
		return showType;
	}
	
	public void setShowType(Integer showType) {
		this.showType = showType;
	}
}
