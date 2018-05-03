package cn.xinmeng.api.enums;

import java.text.MessageFormat;

import cn.xinmeng.common.enums.IEnum;

/**
 * 
 * <p class="detail">充值状态 </p>
 * 
 * @param 
 * @ClassName: RechargeStateEnum 
 * @version V1.0  @date 2016年3月10日 上午10:29:54 
 * @author <a href="mailto:kk20151112@163.com ">nk</a>
 * @return 
 *
 */
public enum RechargeStateEnum implements IEnum{
	STATE_VALID("1","有效"),
	STATE_SUCCESS("2","成功"), 
	STATE_FAILURED("3","失效"),
	STATE_EXCEPTION("4","异常"),
	;
	private RechargeStateEnum(String key,String value){
		this.key = key;
		this.value = value;
	}
	private String key;
	private String value;
	@Override
	public String value() {
		return this.value;
	}

	@Override
	public String key() {
		return this.key;
	}

	@Override
	public IEnum parseValue(Object... params) {
		return setValue(MessageFormat.format(value, params));
	}

	@Override
	public IEnum setValue(String value) {
		this.value = value;
		return this;
	}
	/**
	 * 校验是否存在
	 * @param value
	 * @return
	 */
	public static boolean exist(String value){
		boolean exist = false;
		for (RechargeStateEnum payGateway : RechargeStateEnum.values()) {
			if(payGateway.key().equals(value)){
				exist = true; 
				break;
			}
		}
		return exist;
	}
	
	public static void main(String[] args) {
		System.out.println(RechargeStateEnum.exist("1"));
	}
}
