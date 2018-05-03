package cn.xinmeng.web.shop.impl.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.service.IWechatAccountService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.EmojiFilter;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 更新微信信息
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1082Component")
public class S1082Component extends BaseService {
	
	@Resource
	private IWechatAccountService wechatAccountService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		WechatAccount entity = parseRequertParam(data,WechatAccount.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getOpenid())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_OPEN_ID);
		}
		//过滤emoji 表情符
		entity.setNickname(EmojiFilter.filterEmoji(entity.getNickname()));
		if(wechatAccountService.insertOrUpdate(entity) > 0){
			return getAppResponseEntity(true);
		}
		return getAppResponseEntity(false);
	}
	
	
}
