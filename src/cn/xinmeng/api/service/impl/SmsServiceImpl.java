package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.SmsDao;
import cn.xinmeng.api.entity.auto.Sms;
import cn.xinmeng.api.entity.auto.example.SmsExample;
import cn.xinmeng.api.enums.SmsStateEnum;
import cn.xinmeng.api.service.ISmsService;
import cn.xinmeng.common.enums.ex.ExBaseEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.HelperPropertie;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：SmsServiceImpl
 * @author jiangyong.tan
 * 描述：短信表
 * @date 2016-01-24 14:39:10
 */
@Service("smsService")
public class SmsServiceImpl implements ISmsService {

    @Resource
	private SmsDao smsDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Sms record){
    	return smsDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return smsDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Sms record){
		return smsDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Sms selectByPrimaryKey(Integer id){
    	return smsDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(SmsExample example){
		return smsDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Sms> selectByExample(SmsExample example){
    	return smsDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Sms> selectByExample(int currentPage, int limit,SmsExample example){
        return smsDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    /**
     *  查询是否有该验证码
     * @author jiangyong.tan
     * @date 2016年2月18日 下午4:58:00
     * @param callphone
     * @param smsCode
     * @return
     */
    public Sms querySmsByPhone(String callphone,String smsCode){
    	if(Utils.isEmpty(callphone) || Utils.isEmpty(smsCode)){
    		return null;
    	}
    	SmsExample example = new SmsExample();
    	SmsExample.Criteria criteria = example.createCriteria();
    	criteria.andReceivePhoneEqualTo(callphone);
    	criteria.andSmsCodeEqualTo(smsCode);
    	criteria.andStateEqualTo(Integer.valueOf(SmsStateEnum.YES_SEND.key()));
    	List<Sms> list = smsDao.selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}
    	return null;
    }
    /**
	 * 校验手机验证码是否有效
	 * @param cellphone
	 * @param smsCode
	 */
	public void verifySmsCode(String cellphone,String smsCode){
		if(Utils.isEmpty(smsCode)){
			//校验：短信验证码
			throw new NullException(LogManager.getLogger(this.getClass()), ExBaseEnum.EX_NULL_SMS_CODE);
		}

		/**
		 * 万能验证码
		 */
		String vCodeAlmighty = HelperPropertie.getValue("sms.verifyCode.almighty");
		// 若输入的是万能验证码，验证有效
		if(smsCode.equals(vCodeAlmighty.trim())){ return; }

		//验证码是否正确
		Sms sms = querySmsByPhone(cellphone, smsCode);


		if(sms == null){
			//校验：短信验证码
			throw new NullException(LogManager.getLogger(this.getClass()), ExBaseEnum.EX_NOTEXIS_SMS_CODE);
		}

		/**
		 * 验证码有效时间
		 * 单位秒
		 */
		int validTime = Integer.valueOf(HelperPropertie.getValue("time.valid.smsCode"));
		if(Utils.surplusTime(sms.getCreateTime(), validTime) <= 0){
			throw new BusinessException(LogManager.getLogger(this.getClass()), ExBaseEnum.EX_ERROR_SMS_CODE);
		}
	}
}