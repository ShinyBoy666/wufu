package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CustomerDao;
import cn.xinmeng.api.dao.ex.ExAccountDao;
import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.CustomerDetail;
import cn.xinmeng.api.entity.auto.example.CustomerExample;
import cn.xinmeng.api.enums.CustomerCategoryEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICouponService;
import cn.xinmeng.api.service.ICustomerDetailService;
import cn.xinmeng.api.service.ICustomerService;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CustomerServiceImpl
 * @author jiangyong.tan
 * 描述：客户基本信息表
 * @date 2016-01-24 14:38:49
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Resource
	private CustomerDao customerDao;
	@Resource
	private ISmsService smsService;
	@Resource
	private ICustomerDetailService customerDetailService;
	@Resource
	private ICouponService couponService;
	@Resource
	private ExAccountDao exAccountDao;
	@Resource
	private TaskExecutor customerReportThreadPool;

	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
	public int add(Customer record){
		return customerDao.insert(record);
	}

	/**
	 * 按主键删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return customerDao.deleteByPrimaryKey(id);
	}

	/**
	 * 按主键修改（全新替换每一个字段数据）
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(Customer record){
		return customerDao.updateByPrimaryKey(record);
	}

	/**
	 * 按主键修改（全新替换每一个不为空的字段数据）
	 * @param record
	 * @return
	 */
	public int updateSelectiveByPrimaryKey(Customer record){
		record.setHeadSculpture(Utils.replaceImageUrl(record.getHeadSculpture()));
		return customerDao.updateSelectiveByPrimaryKey(record);
	}
	
	/**
	 * 按主键查询
	 * @param id
	 * @return
	 */
	public Customer selectByPrimaryKey(Integer id){
		return customerDao.selectByPrimaryKey(id);
	}

	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CustomerExample example){
		return customerDao.countByExample(example);
	}

	/**
	 * 按条件查询
	 * @param example
	 * @return
	 */
	public List<Customer> selectByExample(CustomerExample example){
		return customerDao.selectByExample(example);
	}

	/**
	 * 按条件查询（分页）
	 * @param pageNo
	 * @param pageSize
	 * @param example
	 * @return
	 */
	public List<Customer> selectByExample(int currentPage, int limit,CustomerExample example){
		return customerDao.selectByExample(new RowBounds(currentPage, limit),example);
	}
	/**
	 * 根据手机号码，查询客户信息
	 * @author jiangyong.tan
	 * @param cellphone
	 * @return
	 */
	public Customer queryCustomerByCellphone(String cellphone,Integer state,Integer shopId){
		if(Utils.isEmpty(cellphone)){
			return null;
		}
		CustomerExample customerExample = new CustomerExample();
		CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		customerCriteria.andCellphoneEqualTo(cellphone);
		customerCriteria.andShopIdEqualTo(shopId);
		if(!Utils.isEmpty(state)){
			customerCriteria.andStateEqualTo(state);
		}
		List<Customer> listCustomer = customerDao.selectByExample(customerExample);
		if(listCustomer != null && listCustomer.size() > 0){
			return listCustomer.get(0);
		}
		return null;
	}
	/**
	 * 根据token，查询客户信息
	 * @author jiangyong.tan
	 * 2015年11月16日 下午11:05:54
	 * @param cellphone
	 * @return
	 */
	public Customer queryCustomerByToken(String token){
		if(Utils.isEmpty(token)){
			return null;
		}
		CustomerExample customerExample = new CustomerExample();
		CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		customerCriteria.andTokenEqualTo(token);
		customerCriteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<Customer> listCustomer = customerDao.selectByExample(customerExample);
		if(listCustomer != null && listCustomer.size() > 0){
			return listCustomer.get(0);
		}
		return null;
	}
	
	/**
	 * 根据邀请码，查询客户信息
	 * @author jiangyong.tan
	 * 2015年11月16日 下午11:05:54
	 * @param inviteCode
	 * @return
	 */
	public Customer queryCustomerByInviteCode(String inviteCode){
		if(Utils.isEmpty(inviteCode)){
			return null;
		}
		CustomerExample customerExample = new CustomerExample();
		CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		customerCriteria.andRecommendCodeEqualTo(inviteCode);
		customerCriteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<Customer> listCustomer = customerDao.selectByExample(customerExample);
		if(listCustomer != null && listCustomer.size() > 0){
			return listCustomer.get(0);
		}
		return null;
	}
	
	/**
	 * 根据登录名，判断用户是否存在
	 *  描述 
	 * @author jiangyong.tan
	 * @date 2015年11月18日 上午9:20:09
	 * @param loginName
	 * @return
	 */
	public boolean existsUser(String loginName,Integer shopId){
		if(Utils.isEmpty(loginName)){
			return false;
		}
		CustomerExample customerExample = new CustomerExample();
		CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		customerCriteria.andCellphoneEqualTo(loginName);
		customerCriteria.andShopIdEqualTo(shopId);
		if(customerDao.countByExample(customerExample) > 0){
			return true;
		}
		return false;

	}

	/**
	 * 客户注册
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午5:13:03
	 * @param cellphone
	 * @param password
	 * @param shopId
	 * @param inviteCode
	 * @return
	 */
	public Customer registerUser(String cellphone,String password,int shopId,String inviteCode,String imei,String openId){
		Date now = new Date();
		Customer customer = new Customer();
		
		/**
		 * 生成默认头像
		 */
//		int i = Utils.random(1, 44);// 第一步 生成 1-44随机数
		customer.setCellphone(cellphone);
		customer.setPassword(password);
		customer.setNickname(Utils.getNickname());
		customer.setToken(Utils.UUID());//注册生成token
		customer.setShopId(shopId);
		customer.setRecommendCode(Utils.inviteCode(6));//设置：生成邀请码
		customer.setState(Integer.valueOf(StateEnum.EFFECTION.key()));//有效状态
		customer.setCustomerCategory(CustomerCategoryEnum.NOT_FEEPAY.key());
		customer.setHeadSculpture(Utils.getHeadScolpture());
		if(!Utils.isEmpty(inviteCode)){
			Customer inviteCustomer = queryCustomerByInviteCode(inviteCode);
			if(inviteCustomer != null){
				customer.setRecommendCustomerId(inviteCustomer.getId());
			}
		}
		if(!Utils.isEmpty(openId)){
			//解除原先openId的绑定关系
			reSetOpenId(openId);
			
			customer.setOpenId(openId);
		}
		customer.setCreateTime(now);
		customer.setCreateUser(Utils.createUser);
		customer.setUpdateTime(now);
		customerDao.insert(customer);

		/**
		 * 注册客户详细信息
		 */
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomerId(customer.getId());
//		customerDetail.setDeviceType(deviceType);  TODO //1、未知2、苹果3、安卓4、WAP
//		customerDetail.setRegisterVersion(registerVersion); //注册版本
		customerDetail.setLastLoginTime(now);
		customerDetail.setCreateTime(now);
		customerDetail.setCreateUser(Utils.createUser);
		customerDetail.setUpdateTime(now);
		customerDetail.setUpdateUser(Utils.createUser);
		customerDetailService.add(customerDetail);
		
		//送优惠券 
		couponService.addCouponList(customer.getId(), customer.getShopId(), 1, 1, null);//20.00
		couponService.addCouponList(customer.getId(), customer.getShopId(), 2, 1, null);//10.00
		return customer;
	}
	
	/**
	 *  更新token
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午6:09:13
	 * @param customerId
	 * @param oldToken
	 * @return
	 */
	public String updateToken(Integer customerId,String oldToken) {
//		if(Utils.isEmpty(customerId)){
//			// 校验：客户编号
//			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
//		}
//		Customer customer = new Customer();
//		customer.setId(customerId);
//		customer.setToken(Utils.UUID());
//		
//		//更新token
//		if(customerDao.updateSelectiveByPrimaryKey(customer) > 0){
//			//更新成功，将token 放到redis中  且删除旧的token
//			IHJedisString redisString = HJRedisUtil.JedisString();
//			int expireTime = 0;
//			if(Utils.isEmpty(HelperPropertie.getValue("token.expireTime"))){
//				expireTime = 60*60;
//			}else{
//				expireTime = Integer.parseInt(HelperPropertie.getValue("token.expireTime"));
//			}
//			redisString.set(HelperPropertie.getValue("token.prefix")+customer.getToken(), expireTime, customerId+"");
//			if(!Utils.isEmpty(oldToken)){
//				redisString.del(HelperPropertie.getValue("token.prefix")+oldToken);
//			}
//			return customer.getToken();
//		}
		return oldToken;
	}
	

	/**
	 * 修改密码
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午6:18:19
	 * @param customerId
	 * @param newPassword
	 * @return
	 */
	public boolean passwordReset(Integer customerId,String newPassword){
		if(Utils.isEmpty(customerId) || Utils.isEmpty(newPassword)){
			return false;
		}
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setPassword(newPassword);
		if(customerDao.updateSelectiveByPrimaryKey(customer) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 *  查询用户现金账户
	 * @author jiangyong.tan
	 * @date 2016年2月25日 上午11:49:39
	 * @param customerId
	 * @return
	 */
	public Double queryCustomerCashAmount(Integer customerId){
		CustomerExample example = new CustomerExample();
		example.setFieldList("cash_amount");
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(customerId);
		List<Customer> list = customerDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0).getCashAmount();
		}
		return 0.00;
	}
	
	/**
	 *  查询自定义属性
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:04:19
	 * @param customerId
	 * @param fieldList
	 * @return
	 */
	public Customer queryCustomerById(Integer customerId,String fieldList){
		CustomerExample example = new CustomerExample();
		example.setFieldList(fieldList);
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(customerId);
		List<Customer> list = customerDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 查询客户名称
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:39:23
	 * @param customerId
	 * @return
	 */
	public String queryCustomerNameById(Integer customerId){
		Customer customer = queryCustomerById(customerId, "nickname");
		if(customer != null){
			return customer.getNickname();
		}
		return null;
	}
	
	
	/**
	 * 是否是会员
	 * @author jiangyong.tan
	 * @date 2016年3月1日 下午2:27:54
	 * @param customerId
	 * @return
	 */
	public boolean isMember(Integer customerId){
		Date currDate = new Date();
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerCategoryEqualTo(CustomerCategoryEnum.FEEPAY.key());
		criteria.andIdEqualTo(customerId);
		criteria.andOpenTimeLessThanOrEqualTo(currDate);
		criteria.andEndTimeGreaterThanOrEqualTo(currDate);
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		int count = customerDao.countByExample(example);
		if(count > 0){
			return true;
		}
		return false;
	}

	/**
	 * 是否是会员
	 * @author jiangyong.tan
	 * @date 2016年3月1日 下午2:27:54
	 * @param customer
	 * @return
	 */
	public boolean isMember(Customer customer){
		if(Utils.isEmpty(customer)){
			return false;
		}
		Date now = new Date();
		if(CustomerCategoryEnum.FEEPAY.key().equals(customer.getCustomerCategory())
				&& DateUtil.compareDate(now, customer.getOpenTime()) && DateUtil.compareDate(customer.getEndTime(), now)){
			return true;
		}
		return false;
	}

	@Override
	public Integer reSetOpenId(String openId) {
		Customer record = new Customer();
		record.setOpenId("");
		
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		
		return customerDao.updateByExampleSelective(record, example);
	}

	@Override
	public Customer queryCustomerByOpenId(String openId, String fieldList) {
		CustomerExample example = new CustomerExample();
		if(!Utils.isEmpty(fieldList)){
			example.setFieldList(fieldList);
		}
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andOpenIdEqualTo(openId);
		List<Customer> list = customerDao.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查询用户头像
	 * @param customerId
	 * @return
	 */
	public String queryHeadSculpture(Integer customerId){
		if(Utils.isEmpty(customerId)){
			return null;
		}
		Customer customer = queryCustomerById(customerId, "Head_Sculpture");
		if(!Utils.isEmpty(customer)){
			return customer.getHeadSculpture();
		}
		return null;
	}
	
	@Override
	public Integer updateTeamNumber(List<Integer> customerIds) {
		return exAccountDao.updateTeamNumber(customerIds);
	}
}