package cn.xinmeng.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.FlashPurchaseActivityDao;
import cn.xinmeng.api.entity.auto.FlashPurchaseActivity;
import cn.xinmeng.api.entity.auto.example.FlashPurchaseActivityExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IFlashPurchaseActivityService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：FlashPurchaseActivityServiceImpl
 * 描述：闪购活动表
 * @author jiangyong.tan
 * @date 2016-05-03 15:04:06
 */
@Service("flashPurchaseActivityService")
public class FlashPurchaseActivityServiceImpl implements IFlashPurchaseActivityService {

    @Resource
	private FlashPurchaseActivityDao flashPurchaseActivityDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(FlashPurchaseActivity record){
    	return flashPurchaseActivityDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return flashPurchaseActivityDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(FlashPurchaseActivity record){
		return flashPurchaseActivityDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public FlashPurchaseActivity selectByPrimaryKey(Integer id){
    	return flashPurchaseActivityDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(FlashPurchaseActivityExample example){
		return flashPurchaseActivityDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<FlashPurchaseActivity> selectByExample(FlashPurchaseActivityExample example){
    	return flashPurchaseActivityDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<FlashPurchaseActivity> selectByExample(int currentPage, int limit,FlashPurchaseActivityExample example){
        return flashPurchaseActivityDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
    /**
     * 展示店铺活动
     * @param shopId
     * @return
     */
    public List<FlashPurchaseActivity> selectAllShowFlashPurchaseActivity(Integer shopId){
    	Date curr = new Date();
    	FlashPurchaseActivityExample example = new FlashPurchaseActivityExample();
    	FlashPurchaseActivityExample.Criteria criteria = example.createCriteria();
    	if(!Utils.isEmpty(shopId)){
        	criteria.andShopIdEqualTo(shopId);
    	}
    	criteria.andShowTimeLessThan(curr);
    	criteria.andEndTimeGreaterThan(curr);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	return flashPurchaseActivityDao.selectByExample(example);
    }
}