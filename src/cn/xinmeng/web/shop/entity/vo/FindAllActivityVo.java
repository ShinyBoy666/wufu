package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;
import java.util.List;

public class FindAllActivityVo implements Serializable{

	private static final long serialVersionUID = 8176314142211178854L;

    private Integer showPlace; //显示位置
    private List<FindActivityVo> list;
    
    //set get 
    
	public Integer getShowPlace() {
		return showPlace;
	}
	public void setShowPlace(Integer showPlace) {
		this.showPlace = showPlace;
	}
	public List<FindActivityVo> getList() {
		return list;
	}
	public void setList(List<FindActivityVo> list) {
		this.list = list;
	}
}
