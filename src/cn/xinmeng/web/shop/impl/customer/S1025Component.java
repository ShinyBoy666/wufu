package cn.xinmeng.web.shop.impl.customer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.common.enums.ex.ExBaseEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.common.util.http.HttpClient;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1025RequestEntity;

/**
 * 上传头像
 * @param 
 * @ClassName: S1025Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1025Component")
public class S1025Component extends BaseService {
	
	@Resource
	private ICustomerService customerService;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1025RequestEntity entity = parseRequertParam(data, S1025RequestEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getBase64String())){
			throw new BusinessException(LogManager.getLogger(getClass()),ExBaseEnum.EX_NULL_UPLOAD_IMAGE);
		}
		try {
			if(Utils.isEmpty(entity.getImgType())){
				//后台要求，类型写死传0
				entity.setImgType("0");
			}
			String url = HelperPropertie.getValue("image.upload.url");//上传文件地址
			HttpClient httpClient= HttpClient.getInstance();
			String res = httpClient.doPost(url, beanToJSON(entity));
			Map<String,String> mapResult = parseRequertParam(res, Map.class);
			String result = mapResult == null ?"":mapResult.get("Base64UploadImageResult");
			if(Utils.isEmpty(result)){
				throw new BusinessException(LogManager.getLogger(getClass()),ExBaseEnum.EX_ERROR_UPLOAD_IMAGE);
			}else {
				if(!"1".equals(entity.getImgType())){
					Customer customer = new Customer();
					customer.setId(entity.getCustomerId());
					customer.setHeadSculpture(result);
					customerService.updateSelectiveByPrimaryKey(customer);
				}
				//读取文件地址
				String imageReadUrl = HelperPropertie.getValue("image.read.url");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("imageUrl",imageReadUrl + result);
				return getAppResponseEntity(map);
			}
		} catch (Exception e) {
			throw new BusinessException(LogManager.getLogger(getClass()),ExBaseEnum.EX_ERROR_UPLOAD_IMAGE,e);
		}
	}
	
	
}
