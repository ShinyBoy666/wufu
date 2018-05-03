package cn.xinmeng.api.constant;

public class RedisConstant {
	
	public static String activity_product_desc = "activity_{0}_{1}_product_{2}_price_{3}"; //活动商品详情：第一个，活动id，第二个，类型id，第三个，商品id，第四个，商品价格id
	public static String address_id = "address_id_{0}";//客户收货地址
	public static String activity_purchase = "activity_{0}_{1}_{2}_{3}_purchase_{4}";//是否参与活动，第一个，活动id，第二个，活动类型，第三个，商品id，第四个，商品价格id，第五个，客户id
	public static String region_id = "region_id_{0}";//区域地址信息，第一个参数，区域主键
	public static String home_page = "home_page_{0}";//首页信息，第一个参数，店铺id
	public static String yun_shop_product_data = "yun_shop_product_data";//默认10条云商城数据（10分钟一次，更新第一页）
	public static String product_detail_info = "product_detail_info_{0}";//商品详情
	public static String product_info = "product_info_{0}";//商品基本信息
	public static String home_page_top_ico = "homepage_topico_{0}";//首页信息,顶部图标，第一个参数，店铺id
	public static String quick_orderid = "quick_orderid_{0}";//优惠买单，第一个参数，订单id
	public static String question_html = "question_html_{0}";//常见问题，第一个参数，id
	public static String report = "report_{0}";//报表中心，第一个参数，店铺id
	
}
