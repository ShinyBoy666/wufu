package cn.xinmeng.web.base.entity;


@SuppressWarnings("serial")
public class PageSearchEntity extends RequestBaseEntity{

	private int currentPage;//当前页
	private int limit;//每页显示条数
	
	public int getCurrentPage() {
		if(currentPage <= 0){
			return 1;
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimit() {
		if(limit <= 0){
			return 10;
		}
		if(limit > 50){
			return 50;
		}
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
