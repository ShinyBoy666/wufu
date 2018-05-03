package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.OrderProductDao;
import cn.xinmeng.api.dao.ex.ExProductInfoDao;
import cn.xinmeng.api.entity.auto.OrderProduct;
import cn.xinmeng.api.entity.auto.ProductInfo;
import cn.xinmeng.api.entity.auto.example.OrderProductExample;
import cn.xinmeng.api.entity.auto.example.ProductInfoExample;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.IOrderProductProfitService;
import cn.xinmeng.api.service.IOrderProductService;
import cn.xinmeng.api.service.IOrderService;
import cn.xinmeng.api.service.IProductImageService;
import cn.xinmeng.api.service.IProductInfoService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.order.vo.OrderProductVO;

/**
 * 业务层：OrderProductServiceImpl
 * @author jiangyong.tan
 * 描述：订单商品表
 * @date 2016-01-24 14:39:01
 */
@Service("orderProductService")
public class OrderProductServiceImpl implements IOrderProductService {

	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private IOrderService orderService;
	@Resource
	private IProductInfoService productInfoService;
	@Resource
	private ICustomerService customerService;
	@Resource
	private IOrderProductProfitService orderProductProfitService;
	@Resource
	private IProductImageService productImageService;
	@Resource
	private ExProductInfoDao exProductInfoDao;

	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int add(OrderProduct record){
		return orderProductDao.insert(record);
	}

	/**
	 * 添加数据
	 * @param list
	 * @return
	 */
	public int addAll(List<OrderProduct> list){
		return orderProductDao.insertBatch(list);
	}

	/**
	 * 按主键删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return orderProductDao.deleteByPrimaryKey(id);
	}

	/**
	 * 按主键修改（全新替换每一个字段数据）
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(OrderProduct record){
		return orderProductDao.updateByPrimaryKey(record);
	}


	/**
	 * 按条件修改（修改有值的，实体属性有值，则修改数据库相应的字段）
	 * @param record
	 * @return
	 */
	public int updateByExampleSelective(OrderProduct record,OrderProductExample example){
		return orderProductDao.updateByExampleSelective(record, example);
	}

	/**
	 * 按主键查询
	 * @param id
	 * @return
	 */
	public OrderProduct selectByPrimaryKey(Integer id){
		return orderProductDao.selectByPrimaryKey(id);
	}

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(OrderProductExample example){
		return orderProductDao.countByExample(example);
	}

	/**
	 * 按条件查询
	 * @param example
	 * @return
	 */
	public List<OrderProduct> selectByExample(OrderProductExample example){
		return orderProductDao.selectByExample(example);
	}

	/**
	 * 按条件查询（分页）
	 * @param pageNo
	 * @param pageSize
	 * @param example
	 * @return
	 */
	public List<OrderProduct> selectByExample(int currentPage, int limit,OrderProductExample example){
		return orderProductDao.selectByExample(new RowBounds(currentPage, limit),example);
	}

	/**
	 * 根据订单，查询订单产品信息
	 * @param orderId
	 * @return
	 */
	public List<OrderProduct> queryOrderProductByOrderId(String orderId){
		List<OrderProduct> list = new ArrayList<OrderProduct>();
		if(Utils.isEmpty(orderId)){
			return list;
		}
		OrderProductExample orderProductExample = new OrderProductExample();
		OrderProductExample.Criteria orderProductCriteria = orderProductExample.createCriteria();
		orderProductCriteria.andOrderIdEqualTo(orderId);
		return orderProductDao.selectByExample(orderProductExample);
	}

	/**
	 *  查询订单商品
	 * @author jiangyong.tan
	 * @date 2016年2月29日 下午4:51:52
	 * @param orderId
	 * @return
	 */
	public List<OrderProductVO> queryOrderProductVoByOrderId(String orderId){
		OrderProductExample orderProductExample = new OrderProductExample();
		OrderProductExample.Criteria orderProductCriteria = orderProductExample.createCriteria();
		orderProductCriteria.andOrderIdEqualTo(orderId);
		List<OrderProductVO> list = new ArrayList<OrderProductVO>();
		
		List<OrderProduct> listOrderProduct = orderProductDao.selectByExample(orderProductExample);
		if(!Utils.isEmpty(listOrderProduct)){
			for (OrderProduct orderProduct : listOrderProduct) {
				OrderProductVO vo = new OrderProductVO();
				CloneUtils.cloneEntity(orderProduct, vo);

				ProductInfoExample productInfoExample = new ProductInfoExample();
				productInfoExample.setFieldList("image_url,product_name");

				ProductInfoExample.Criteria productInfoCriteria = productInfoExample.createCriteria();
				productInfoCriteria.andProductIdEqualTo(orderProduct.getProductId());
				List<ProductInfo> listProductInfo = productInfoService.selectByExample(productInfoExample);
				if(listProductInfo == null || listProductInfo.size() == 0){
					continue;
				}
				ProductInfo productInfo = listProductInfo.get(0);
				vo.setImageUrl(productInfo.getImageUrl());
				vo.setProductName(productInfo.getProductName());
				
				List<String> imageUrl = productImageService.queryProductImage(orderProduct.getProductPriceId());
				if(!Utils.isEmpty(imageUrl)){
					vo.setImageUrl(imageUrl.get(0));
				}
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * 获取订单id
	 * @param orderId
	 * @return
	 */
	public Integer getOrderProductId(String orderId){
		OrderProductExample example = new OrderProductExample();
		example.setFieldList("id");
		OrderProductExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrderProduct> list = selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0).getId();
		}
		return 0;
	}
	

	/**
	 * 获取商品信息
	 * @param orderId
	 * @return
	 */
	public OrderProduct getOrderProduct(String orderId,String fieldList){
		OrderProductExample example = new OrderProductExample();
		if(!Utils.isEmpty(fieldList)){
			example.setFieldList(fieldList);
		}
		OrderProductExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrderProduct> list = orderProductDao.selectByExample(new RowBounds(1, 1),example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	
}