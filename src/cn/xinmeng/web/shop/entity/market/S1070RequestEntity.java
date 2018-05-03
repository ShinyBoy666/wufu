package cn.xinmeng.web.shop.entity.market;

import cn.xinmeng.web.base.entity.RequestBaseEntity;

/**
 * 秒杀商品列表
 * @param 
 * @ClassName: S1070RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1070RequestEntity extends RequestBaseEntity {
	
	private static final long serialVersionUID = 4164900864783271653L;

	private Integer activityType;
	private Integer activityId;

	//set get

	
	public Integer getActivityType() {
		return activityType;
	}
	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
}
