package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.Notice;
import cn.xinmeng.api.service.INoticeService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.customer.S1052ResponseEntity;

/**
 * 查询消息
 * @param 
 * @ClassName: S1052Component 
 * @version V1.0  
 * @date 2016年2月18日 下午3:20:02 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1052Component")
public class S1052Component extends BaseService {
	
	@Resource
	private INoticeService noticeService;
	
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		PageSearchEntity entity = parseRequertParam(data, PageSearchEntity.class);
		
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
//		}else if(Utils.isEmpty(entity.getCustomerId())){
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		PageInfoEntity<S1052ResponseEntity> page = new PageInfoEntity<S1052ResponseEntity>(entity.getCurrentPage(),entity.getLimit());
		Integer totalCount = noticeService.searchNoticeCount(entity.getCustomerId(), entity.getShopId());
		List<S1052ResponseEntity> listRes = new ArrayList<S1052ResponseEntity>();
		if(totalCount > 0){
			List<Notice> list = noticeService.searchNoticeList(entity.getCurrentPage(), entity.getLimit(), entity.getCustomerId(), entity.getShopId());
			for (Notice notice : list) {
				S1052ResponseEntity res = new S1052ResponseEntity();
				CloneUtils.copyEntity(notice, res);
				if(res.getLinkType() == 1){//1、详细2、外网
					String httpLocal = HelperPropertie.getValue("local.url");
					res.setLinkUrl(httpLocal+"App/Notice?id="+res.getId()+"&c="+entity.getCustomerId()+"&flag="+("wap".equals(request.getSource())));
				}
				res.setCoverImg(Utils.getImageUrl(res.getCoverImg(),"?640_320"));
				listRes.add(res);
			}
		}
		page.setList(listRes);
		page.setTotalRecord(totalCount);
		return getAppResponseEntity(page);
	}
	
	
}
