package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.CommonAddressDao;
import cn.xinmeng.api.entity.auto.CommonAddress;
import cn.xinmeng.api.entity.auto.example.CommonAddressExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.ICommonAddressService;
import cn.xinmeng.api.service.IRedisService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：CommonAddressServiceImpl
 * @author jiangyong.tan
 * 描述：客户常用地址表
 * @date 2016-01-24 14:38:49
 */
@Service("commonAddressService")
public class CommonAddressServiceImpl implements ICommonAddressService {

    @Resource
	private CommonAddressDao commonAddressDao;
    @Resource
    private IRedisService redisService;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(CommonAddress record){
    	record.setIsDefault(Utils.isDefaultAddress(record.getIsDefault(), true));
    	//如果是默认地址，则需要把其他设置为非默认
		commonAddressDao.insert(record);
    	if(StateEnum.EFFECTION.key().equals(record.getIsDefault()+"")){
        	setNotDefaultAddress(record.getId(), record.getCustomerId());
    	}
    	return record.getId();
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return commonAddressDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(CommonAddress record){
		redisService.delCommonAddress(record.getId());
		return commonAddressDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public CommonAddress selectByPrimaryKey(Integer id){
    	return commonAddressDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(CommonAddressExample example){
		return commonAddressDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(CommonAddressExample example){
    	return commonAddressDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<CommonAddress> selectByExample(int currentPage, int limit,CommonAddressExample example){
        return commonAddressDao.selectByExample(new RowBounds(currentPage, limit),example);
    }


    /**
     * 修改地址信息
     */
	public Integer updateCommonAddress(CommonAddress commonAddress) {
		commonAddress.setIsDefault(Utils.isDefaultAddress(commonAddress.getIsDefault(), true));
		commonAddress.setUpdateTime(new Date());
		if(Utils.isEmpty(commonAddress.getUpdateUser())){
			commonAddress.setUpdateUser(Utils.createUser);
		}
		if(StateEnum.EFFECTION.key().equals(commonAddress.getIsDefault()+"")){
        	setNotDefaultAddress(commonAddress.getId(), commonAddress.getCustomerId());
    	}
		int row = commonAddressDao.updateSelectiveByPrimaryKey(commonAddress);
		redisService.delCommonAddress(commonAddress.getId());
		return row;
	}
	
	public Integer updateDefault(Integer id, Integer customerId) {
		//组装修改条件
		setNotDefaultAddress(id, customerId);
		//目标地址改为默认地址
		CommonAddress address = new CommonAddress();
		address.setIsDefault(Integer.parseInt(StateEnum.EFFECTION.key()));
		address.setId(id);
		return commonAddressDao.updateSelectiveByPrimaryKey(address);
	}
	
	/**
	 * 客户下地址置成非默认（除notId地址外）
	 * @param notId
	 * @param customerId
	 * @return
	 */
	public boolean setNotDefaultAddress(Integer notId,Integer customerId){
		if(Utils.isEmpty(customerId)){
			return false;
		}

		CommonAddress address = new CommonAddress();
		address.setIsDefault(Integer.parseInt(StateEnum.NOT_EFFECTION.key()));
		
		CommonAddressExample commonAddressExample = new CommonAddressExample();
		CommonAddressExample.Criteria commonAddressCriteria = commonAddressExample.createCriteria();
		commonAddressCriteria.andCustomerIdEqualTo(customerId);
		if(!Utils.isEmpty(notId)){
			commonAddressCriteria.andIdNotEqualTo(notId);
		}
		commonAddressDao.updateByExampleSelective(address, commonAddressExample);
		return true;
	}

	/**
	 * 查询默认地址（没有默认地址，返回其中一个地址）
	 * @param customerId
	 * @return
	 */
	public CommonAddress queryDefaultAddress(Integer customerId){
		if(Utils.isEmpty(customerId)){
			return null;
		}
		CommonAddressExample example = new CommonAddressExample();
		CommonAddressExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andIsDefaultEqualTo(Integer.parseInt(StateEnum.EFFECTION.key()));
		List<CommonAddress> list = commonAddressDao.selectByExample(example);
		if(!Utils.isEmpty(list)){
			return list.get(0);
		}

		CommonAddressExample commonAddressExample = new CommonAddressExample();
		commonAddressExample.setOrderByClause("create_time desc,id desc");
		CommonAddressExample.Criteria commonAddressCriteria = commonAddressExample.createCriteria();
		commonAddressCriteria.andCustomerIdEqualTo(customerId);
		List<CommonAddress> listC = commonAddressDao.selectByExample(new RowBounds(1,1), commonAddressExample);
		if(!Utils.isEmpty(listC)){
			return listC.get(0);
		}
		return null;
	}
}