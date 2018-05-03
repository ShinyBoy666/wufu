package cn.xinmeng.api.service;

import java.util.List;

import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.entity.auto.example.WechatAccountExample;

/**
 * 接口：IWechatAccountService
 * 描述：客户微信信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
public interface IWechatAccountService {
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(WechatAccount record);
    
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
	public int updateByPrimaryKey(WechatAccount record);
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public WechatAccount selectByPrimaryKey(Integer id);
    
    /**
	 * 查询总条数
	 * @param example
	 * @return
	 */
    public int countByExample(WechatAccountExample example);
    
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(WechatAccountExample example);
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(int currentPage, int limit,WechatAccountExample example);
    
    /**
     * 添加或修改微信信息
     * @param wechatAccount
     * @return
     */
    public int insertOrUpdate(WechatAccount wechatAccount);
    
    /**
     * 根据openid获取微信账户信息
     * @param openId
     * @return
     */
    public WechatAccount getWechatAccount(String openId);
    
    /**
     * 根据openId集合获取微信账户信息
     * @param openIds
     * @return
     */
    public List<WechatAccount> getWechatAccount(List<String> openIds);
}