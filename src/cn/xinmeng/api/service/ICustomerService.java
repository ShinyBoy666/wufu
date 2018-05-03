package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Customer;
import cn.xinmeng.api.entity.auto.example.CustomerExample;

/**
 * 接口：ICustomerService
 * @author jiangyong.tan
 * 描述：客户基本信息表
 * @date 2016-01-24 14:38:49
 */
public interface ICustomerService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Customer record);
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id);
	
	/**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Customer record);
	
	/**
	 * 按主键修改（全新替换每一个不为空的字段数据）
	 * @param record
	 * @return
	 */
	public int updateSelectiveByPrimaryKey(Customer record);
	
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Customer selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(CustomerExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Customer> selectByExample(CustomerExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Customer> selectByExample(int currentPage, int limit,CustomerExample example);
    
    /**
	 * 根据手机号码，查询客户信息
	 * @author jiangyong.tan
	 * @param cellphone
	 * @return
	 */
	public Customer queryCustomerByCellphone(String cellphone,Integer state,Integer shopId);
	/**
	 * 根据token，查询客户信息
	 * @author jiangyong.tan
	 * 2015年11月16日 下午11:05:54
	 * @param cellphone
	 * @return
	 */
	public Customer queryCustomerByToken(String token);
	
	/**
	 * 根据登录名，判断用户是否存在
	 *  描述 
	 * @author jiangyong.tan
	 * @date 2015年11月18日 上午9:20:09
	 * @param loginName
	 * @return
	 */
	public boolean existsUser(String loginName,Integer shopId);
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
	public Customer registerUser(String cellphone,String password,int shopId,String inviteCode,String imei,String openId);
	
	/**
	 *  更新token
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午6:09:13
	 * @param customerId
	 * @param oldToken
	 * @return
	 */
	public String updateToken(Integer customerId,String oldToken);
	
	/**
	 * 修改密码
	 * @author jiangyong.tan
	 * @date 2016年2月18日 下午6:18:19
	 * @param customerId
	 * @param newPassword
	 * @return
	 */
	public boolean passwordReset(Integer customerId,String newPassword);
	
	/**
	 *  查询用户现金账户
	 * @author jiangyong.tan
	 * @date 2016年2月25日 上午11:49:39
	 * @param customerId
	 * @return
	 */
	public Double queryCustomerCashAmount(Integer customerId);
	
	/**
	 *  查询自定义属性
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:04:19
	 * @param customerId
	 * @param fieldList
	 * @return
	 */
	public Customer queryCustomerById(Integer customerId,String fieldList);
	
	/**
	 * 查询客户名称
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:39:23
	 * @param customerId
	 * @return
	 */
	public String queryCustomerNameById(Integer customerId);
	
	/**
	 * 是否是会员
	 * @author jiangyong.tan
	 * @date 2016年3月1日 下午2:27:54
	 * @param customerId
	 * @return
	 */
	public boolean isMember(Integer customerId);

	/**
	 * 是否是会员
	 * @author jiangyong.tan
	 * @date 2016年3月1日 下午2:27:54
	 * @param customer
	 * @return
	 */
	public boolean isMember(Customer customer);
	
	/**
	 * 解除openId的绑定关系
	 * @param openId
	 * @return
	 */
	public Integer reSetOpenId(String openId);
	
	/**
	 *  根据openId查询自定义属性
	 * @author jiangyong.tan
	 * @date 2016年2月25日 下午3:04:19
	 * @param openId
	 * @param fieldList
	 * @return
	 */
	public Customer queryCustomerByOpenId(String openId,String fieldList);
	
	/**
	 * 查询用户头像
	 * @param customerId
	 * @return
	 */
	public String queryHeadSculpture(Integer customerId);
	
	/**
	 * 修改团队人数
	 * @param customerIds
	 * @return
	 */
	public Integer updateTeamNumber(List<Integer> customerIds);
}