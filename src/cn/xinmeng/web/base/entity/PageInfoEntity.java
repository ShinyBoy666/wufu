package cn.xinmeng.web.base.entity;

import java.io.Serializable;
import java.util.List;


public class PageInfoEntity<T> implements Serializable{
	/** 
	 * <p class="detail"> 这里写描述 </p>
	 * @Fields serialVersionUID 
	 * @author <a href="mailto:kk20151112@163.com ">nk</a> 2016年2月26日 下午5:21:53
	 */ 
	private static final long serialVersionUID = -1787161632045831553L;
	
	private int currentPage;//当前页
	private int limit;//每页显示条数
	private int totalPage;//总页数
	private List<T> list;
	private int totalRecord;//总条数
	
	public PageInfoEntity(){
	}
	
	public PageInfoEntity(int currentPage,int limit){
		this.limit = limit;
		this.currentPage = currentPage;
	}
	
//	public PageInfoEntity(List<T> list){
//		if ((list instanceof Page)) {
//		      Page<T> page = (Page<T>)list;
//		      this.currentPage = page.getPageNum();
//		      this.limit = page.getPageSize();
//		      this.totalPage = page.getPages();
//		      this.list = page;
//	    }
//	}
//	
//	/**
//	 *  设置分页非数据信息
//	 * @author jiangyong.tan
//	 * @date 2016年2月26日 下午6:01:08
//	 * @param list
//	 */
//	@SuppressWarnings("all")
//	public PageInfoEntity(List list,boolean listFlag){
//		if ((list instanceof Page)) {
//		      Page page = (Page)list;
//		      this.currentPage = page.getPageNum();
//		      this.limit = page.getPageSize();
//		      this.totalPage = page.getPages();
//		      if(listFlag){
//			      this.list = page;
//		      }
//	    }
//	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		int recordNum  = this.getTotalRecord();
		int limitNum  = this.getLimit();
		int shang= recordNum / limitNum;
		this.totalPage = (recordNum % limitNum) > 0 ? shang + 1:shang;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
