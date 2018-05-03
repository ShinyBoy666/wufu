package cn.xinmeng.api.service;

import cn.xinmeng.api.entity.auto.QuickOrder;
import cn.xinmeng.web.shop.entity.customer.S1067RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1021RequestEntity;
import cn.xinmeng.web.shop.entity.order.S1022RequestEntity;
import cn.xinmeng.web.shop.entity.order.vo.PayOrderBiz;
import cn.xinmeng.web.shop.entity.quickorder.S1093RequestEntity;

/**
 * 订单提交
 * @param 
 * @ClassName: IOrderSubimtService 
 * @version V1.0  
 * @date 2016年2月24日 上午11:33:27 
 * @author jiangyong.tan
 * @return 
 *
 */
public interface IOrderSubimtService {

    /**
     * 提交订单，主方法
     * @author jiangyong.tan
     * @date 2016年2月24日 上午11:29:43
     * @param entity
     * @return
     */
    public PayOrderBiz submitOrderMain(S1021RequestEntity entity,Integer sourceShopId,Integer loginShopId);
    

    /**
     * 立即购买（快速下单）提交订单，主方法
     * @author jiangyong.tan
     * @date 2016年2月24日 上午11:29:43
     * @param entity
     * @return
     */
    public PayOrderBiz fastSubmitOrderMain(S1022RequestEntity entity,Integer sourceShopId,Integer loginShopId);
    

    /**
     * 会员充值
     * @author jiangyong.tan
     * @date 2016年2月24日 上午11:29:43
     * @param entity
     * @return
     */
    public PayOrderBiz vipSubmitOrder(S1067RequestEntity entity,Integer sourceShopId,Integer loginShopId);
    
    /**
     * 优惠买单创建订单
     */
    public QuickOrder quickOrderSumbit(S1093RequestEntity entity);
}
