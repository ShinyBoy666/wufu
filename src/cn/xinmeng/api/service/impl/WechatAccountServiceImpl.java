package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.WechatAccountDao;
import cn.xinmeng.api.entity.auto.WechatAccount;
import cn.xinmeng.api.entity.auto.example.WechatAccountExample;
import cn.xinmeng.api.service.IWechatAccountService;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：WechatAccountServiceImpl
 * 描述：客户微信信息表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:10
 */
@Service("wechatAccountService")
public class WechatAccountServiceImpl implements IWechatAccountService {

    @Resource
	private WechatAccountDao wechatAccountDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(WechatAccount record){
    	return wechatAccountDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return wechatAccountDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(WechatAccount record){
		return wechatAccountDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public WechatAccount selectByPrimaryKey(Integer id){
    	return wechatAccountDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(WechatAccountExample example){
		return wechatAccountDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(WechatAccountExample example){
    	return wechatAccountDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<WechatAccount> selectByExample(int currentPage, int limit,WechatAccountExample example){
        return wechatAccountDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

	@Override
	public int insertOrUpdate(WechatAccount wechatAccount) {
		WechatAccountExample example = new WechatAccountExample();
		WechatAccountExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(wechatAccount.getOpenid());
		
		String updateUser = "api";
		Date now = new Date();
		wechatAccount.setUpdateTime(now);
		wechatAccount.setUpdateUser(updateUser);
		int i = wechatAccountDao.updateByExampleSelective(wechatAccount, example);
		if(i > 0){
			return i;
		}
		
		if(wechatAccount.getNickname() == null){
			wechatAccount.setNickname("");
		}
		if(wechatAccount.getHeardImage() == null){
			wechatAccount.setHeardImage("");
		}
		if(wechatAccount.getSex() == null){
			wechatAccount.setSex(0);
		}
		wechatAccount.setCreateTime(now);
		wechatAccount.setCreateUser(updateUser);
		try {
			return wechatAccountDao.insert(wechatAccount);
		} catch (Exception e) {
			LogManager.error(this.getClass(), "保存微信账户信息错误", e);
			wechatAccount.setNickname("");
			return wechatAccountDao.insert(wechatAccount);
		}
	}
    /**
     * 根据openid获取微信账户信息
     * @param openId
     * @return
     */
    public WechatAccount getWechatAccount(String openId){
    	if(Utils.isEmpty(openId)){
    		return null;
    	}
    	WechatAccountExample example = new WechatAccountExample();
    	WechatAccountExample.Criteria criteria = example.createCriteria();
    	criteria.andOpenidEqualTo(openId);
    	List<WechatAccount> list = wechatAccountDao.selectByExample(example);
    	if(!Utils.isEmpty(list)){
    		return list.get(0);
    	}
    	return null;
    }

	@Override
	public List<WechatAccount> getWechatAccount(List<String> openIds) {
		WechatAccountExample example = new WechatAccountExample();
    	WechatAccountExample.Criteria criteria = example.createCriteria();
    	criteria.andOpenidIn(openIds);
    	return wechatAccountDao.selectByExample(example);
	}
}