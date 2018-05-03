package cn.xinmeng.web.shop.impl.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.enums.ex.ExProductEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.RequestBaseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.vo.ProductInfoVo;

/**
 * 根据模块id查询商品信息
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.product.S1055Component")
public class S1055Component extends BaseService {
	
	@Resource
	private IProductInfoService prodInfoService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
			
		RequestBaseEntity requestEntity = parseRequertParam(data, RequestBaseEntity.class);
		/**
		 * 非空验证
		 */
		if(requestEntity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if (Utils.isEmpty(requestEntity.getId())) {
			throw new NullException(LogManager.getLogger(this.getClass()),ExProductEnum.EX_NULL_MODUL_ID);
		}
		List<ProductInfoVo> productInfoVos = prodInfoService.selectProductInfoVoByModulId(requestEntity.getId());
		if(productInfoVos == null){
			productInfoVos = new ArrayList<ProductInfoVo>();
		}else{
			for (ProductInfoVo productInfoVo : productInfoVos) {
				productInfoVo.setImageUrl(Utils.getImageUrl(productInfoVo.getImageUrl(),"?400_400"));
			}
		}
		return getAppResponseEntity(productInfoVos);
	}
	
}
