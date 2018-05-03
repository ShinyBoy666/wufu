package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.Sms;
import cn.xinmeng.api.entity.auto.example.SmsExample;

/**
 * 接口：ISmsService
 * @author jiangyong.tan
 * 描述：短信表
 * @date 2016-01-24 14:39:10
 */
public interface ISmsService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Sms record);
    
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
	public int updateByPrimaryKey(Sms record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Sms selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(SmsExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Sms> selectByExample(SmsExample example);
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Sms> selectByExample(int currentPage, int limit,SmsExample example);
    
    /**
     *  查询是否有该验证码
     * @author jiangyong.tan
     * @date 2016年2月18日 下午4:58:00
     * @param callphone
     * @param smsCode
     * @return
     */
    public Sms querySmsByPhone(String callphone,String smsCode);
    

    /**
	 * 校验手机验证码是否有效
	 * @param cellphone
	 * @param smsCode
	 */
	public void verifySmsCode(String cellphone,String smsCode);
}