package cn.xinmeng.web.shop.entity.market;

import java.util.List;

import cn.xinmeng.web.base.entity.ResponseBaseEntity;
import cn.xinmeng.web.shop.entity.vo.BannerVo;

/**
 * 秒杀商品列表（wap用）
 * @param 
 * @ClassName: S1075ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1075ResponseEntity extends ResponseBaseEntity{
	private static final long serialVersionUID = 1L;
	
	private List<BannerVo> bannerList;
	private String title; //活动标题
	private Integer activityState;//活动时间：1=还未开始，2=正在进行，3=已经结束
	private long activityTime;//活动时间：当活动状态=1时表示距离开始时间，2时表示距离结束时间，3时可以返回0
    private List<S1070ResponseEntity> list;//商品时间
    
    // set get 

	public List<S1070ResponseEntity> getList() {
		return list;
	}
	public void setList(List<S1070ResponseEntity> list) {
		this.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getActivityState() {
		return activityState;
	}
	public void setActivityState(Integer activityState) {
		this.activityState = activityState;
	}
	public long getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(long activityTime) {
		this.activityTime = activityTime;
	}
	public List<BannerVo> getBannerList() {
		return bannerList;
	}
	public void setBannerList(List<BannerVo> bannerList) {
		this.bannerList = bannerList;
	}
}
