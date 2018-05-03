package cn.xinmeng.web.shop.impl.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.AgentApply;
import cn.xinmeng.api.enums.AgentApplyEnum;
import cn.xinmeng.api.service.IAgentApplyService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.enums.ex.ExShopApplyEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 代理商入住申请
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.base.S1077Component")
public class S1077Component extends BaseService {

	@Resource
	private IAgentApplyService agentApplyService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		AgentApply entity = parseRequertParam(data,AgentApply.class);
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getEnterpriseName())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopApplyEnum.EX_NULL_ENTERPRISE_NAME);
		}else if(Utils.isEmpty(entity.getTelephone())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopApplyEnum.EX_NULL_TELEPHONE);
		}else if(Utils.isEmpty(entity.getEmail())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopApplyEnum.EX_NULL_EMAIL);
		}else if(Utils.isEmpty(entity.getAgentType())){
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExShopApplyEnum.EX_NULL_AGENT_TYPE);
		}
		entity.setCreateUser("api");
		entity.setState(Integer.valueOf(AgentApplyEnum.APPLY_ING.key()));
		agentApplyService.add(entity);
		return getAppResponseEntity(true);
	}
}
