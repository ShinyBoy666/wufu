package cn.xinmeng.web.shop.impl.quickorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.api.entity.auto.ShopInfo;
import cn.xinmeng.api.entity.auto.example.QuickOrderExample;
import cn.xinmeng.api.enums.PaymentStateEnum;
import cn.xinmeng.api.service.IQuickOrderService;
import cn.xinmeng.api.service.IShopInfoService;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.service.BaseService;
import cn.xinmeng.web.shop.entity.quickorder.S1084RequestEntity;
import cn.xinmeng.web.shop.entity.quickorder.S1084ResponseEntity;

/**
 * 优惠买单，订单列表
 * @param 
 * @ClassName: S1084Component 
 * @version V1.0  
 * @date 2016年2月18日 下午1:33:18 
 * @author jiangyong.tan
 * @return 
 *
 */
@Component ("cn.xinmeng.web.shop.impl.quickorder.S1084Component")
public class S1084Component extends BaseService {

	@Resource
	private IQuickOrderService quickOrderService;
	@Resource
	private IShopInfoService shopInfoService;

	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		S1084RequestEntity entity = parseRequertParam(data, S1084RequestEntity.class);
		
		/**
		 * 非空验证
		 */
		if(entity ==  null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
//		}else if(Utils.isEmpty(entity.getOpenId())){
//			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}

		//返回分页数据
		PageInfoEntity<S1084ResponseEntity> resPage = new PageInfoEntity<S1084ResponseEntity>();
		//返回列表数据
		List<S1084ResponseEntity> resList = new ArrayList<S1084ResponseEntity>();
		Integer totalCount = 0;
		if(!Utils.isEmpty(entity.getOpenId())){
			//查询我的订单（除待支付的）
			QuickOrderExample quickOrderExample = new QuickOrderExample();
			QuickOrderExample.Criteria quickOrderCriteria = quickOrderExample.createCriteria();
			quickOrderExample.setOrderByClause(" id desc ");
			quickOrderCriteria.andOpenIdEqualTo(entity.getOpenId());
			if(!Utils.isEmpty(entity.getShopId())){
				quickOrderCriteria.andShopIdEqualTo(entity.getShopId());
			}
			quickOrderCriteria.andPayStateEqualTo(Integer.valueOf(PaymentStateEnum.STATE_PAY_SUCCESS.key()));
			totalCount = quickOrderService.countByExample(quickOrderExample);
			Map<Integer,ShopInfo> map = new HashMap<Integer,ShopInfo>();
			if(totalCount > 0){
				List<QuickOrder> list = quickOrderService.selectByExample(entity.getCurrentPage(),entity.getLimit(),quickOrderExample);
				for (QuickOrder quickOrder : list) {
					S1084ResponseEntity res = new S1084ResponseEntity();
					CloneUtils.copyEntity(quickOrder, res);
					if(map.containsKey(quickOrder.getShopId())){
						ShopInfo shopInfo = map.get(quickOrder.getShopId());
						res.setShopName(shopInfo.getShopName());
						res.setShopLogo(shopInfo.getShopLogo());
					}else{
						ShopInfo shopInfo = shopInfoService.queryShopInfoById(quickOrder.getShopId(),"shop_logo,shop_name");
						if(!Utils.isEmpty(shopInfo)){
							res.setShopName(shopInfo.getShopName());
							res.setShopLogo(shopInfo.getShopLogo());
							map.put(quickOrder.getShopId(), shopInfo);
						}
					}
					resList.add(res);
				}
			}
		}
		resPage.setList(resList);
		resPage.setCurrentPage(entity.getCurrentPage());
		resPage.setLimit(entity.getLimit());
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}

	
}
