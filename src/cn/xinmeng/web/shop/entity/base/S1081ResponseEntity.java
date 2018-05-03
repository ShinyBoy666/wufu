package cn.xinmeng.web.shop.entity.base;

import cn.xinmeng.api.enums.PaymentGatewayEnum;
import cn.xinmeng.web.base.entity.ResponseBaseEntity;

/**
 * 购物车列表 
 * @param 
 * @ClassName: S1011ResponseEntity 
 * @version V1.0  
 * @date 2016年2月18日 下午2:17:21 
 * @author jiangyong.tan
 * @return 
 *
 */
public class S1081ResponseEntity extends ResponseBaseEntity {

	private static final long serialVersionUID = 5563411612415114290L;

    private Integer enchashmentType; //1：支付宝2：微信3：银联
    private Double amount; //提现金额
    private String remark; //备注
    private Integer state; //1、审核中、2、审核通过 3、审核拒绝、4、打款失败 5、打款完成
    private java.util.Date createTime; //创建时间
    
    //set get
    
    /**
     * 1：支付宝2：微信3：银联
     * @return
     */
	public String getEnchashmentTypeValue() {
		return PaymentGatewayEnum.keyToValue(enchashmentType+"");
	}
	
	/**
	 * 提现状态
	 * @return
	 */
	public String getStateValue() {
//		AUDIT("1","审核中"),
//		AUDIT_PASS("2","审核通过"),
//		AUDIT_REJECT("3","审核拒绝"),
//		FAILURE_TO_PLAY("4","打款失败"),
//		COMPLETION_OF_THE_PLAY("5","打款完成"),
//		return EnchashmentStateEnum.keyToValue(state+"");
		if(state == null){
			return "审核中";
		}else if(state == 1){
			return "审核中";
		}else if(state == 2){
			return "审核成功";
		}else if(state == 3){
			return "审核失败";
		}else if(state == 4){
			return "提现失败";
		}else if(state == 5){
			return "提现成功";
		}
		return "审核中";
	}
    
	public Integer getEnchashmentType() {
		return enchashmentType;
	}
	public void setEnchashmentType(Integer enchashmentType) {
		this.enchashmentType = enchashmentType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
}
