package cn.xinmeng.web.shop.entity.address;



/**
 * 常用地址 邮费
 * @param 
 * @ClassName: S1015ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午1:58:26 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1056ResponseEntity extends S1015ResponseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3842133822021838541L;

	private double postage;		//邮费
	private double postageFree;		//满多少免邮费
	
	
	public double getPostage() {
		return postage;
	}
	public void setPostage(double postage) {
		this.postage = postage;
	}
	public double getPostageFree() {
		return postageFree;
	}
	public void setPostageFree(double postageFree) {
		this.postageFree = postageFree;
	}
	
}
