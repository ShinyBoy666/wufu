package cn.xinmeng.web.shop.entity.customer;

import cn.xinmeng.api.entity.auto.CustomerFeedback;

/**
 * 客户反馈新增
 * @param 
 * @ClassName: S1027RequestEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午4:14:56 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1027RequestEntity extends CustomerFeedback {
	
	private static final long serialVersionUID = 4164900864783271653L;
	
	private String replyContent;	//客户反馈
	

	//set get


	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}
