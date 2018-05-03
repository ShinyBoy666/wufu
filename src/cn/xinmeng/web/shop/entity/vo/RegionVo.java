package cn.xinmeng.web.shop.entity.vo;

import java.io.Serializable;

public class RegionVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8970584881592302351L;
	
	private Integer id; //
    private String regionName; //
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
    
}
