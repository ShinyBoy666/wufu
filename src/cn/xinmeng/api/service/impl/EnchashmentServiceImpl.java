package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.EnchashmentDao;
import cn.xinmeng.api.entity.auto.Enchashment;
import cn.xinmeng.api.entity.auto.example.EnchashmentExample;
import cn.xinmeng.api.enums.AccountTypeEnum;
import cn.xinmeng.api.enums.ConsumTypeEnum;
import cn.xinmeng.api.enums.EnchashmentStateEnum;
import cn.xinmeng.api.service.IAccountService;
import cn.xinmeng.api.service.IEnchashmentService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.shop.entity.base.S1081ResponseEntity;

/**
 * 业务层：EnchashmentServiceImpl
 * @author jiangyong.tan
 * 描述：客户提现记录表
 * @date 2016-01-24 14:38:52
 */
@Service("enchashmentService")
public class EnchashmentServiceImpl implements IEnchashmentService {

    @Resource
	private EnchashmentDao enchashmentDao;
	
    @Resource
    private IAccountService accountService;
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Enchashment record){
    	//账户扣款
    	if(record.getAccountType() == 1){
    		//用户提现
        	accountService.completeAccountDeduct(record.getCustomerId(), record.getAmount(), ConsumTypeEnum.TYPE_51, null);
    	}else if(record.getAccountType() == 2){
    		//店铺提现
    		accountService.shopCompleteAccountDeduct(record.getCustomerId(), record.getAmount(), ConsumTypeEnum.TYPE_51, null);
    	}else if(record.getAccountType() == 3){
    		//代理商提现
    	}
    	Date now = new Date();
    	record.setId(null);
    	record.setCreateTime(now);
    	record.setUpdateTime(now);
    	record.setState(Integer.valueOf(EnchashmentStateEnum.AUDIT.key())); // 审核中
    	record.setCreateUser("api");
    	record.setUpdateUser("api");
    	return enchashmentDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return enchashmentDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Enchashment record){
		return enchashmentDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Enchashment selectByPrimaryKey(Integer id){
    	return enchashmentDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(EnchashmentExample example){
		return enchashmentDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Enchashment> selectByExample(EnchashmentExample example){
    	return enchashmentDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Enchashment> selectByExample(int currentPage, int limit,EnchashmentExample example){
        return enchashmentDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public PageInfoEntity<S1081ResponseEntity> selectByExample(int currentPage, int limit,Integer customerId,AccountTypeEnum accountTypeEnum){
    	PageInfoEntity<S1081ResponseEntity> page = new PageInfoEntity<S1081ResponseEntity>();
    	List<S1081ResponseEntity> resList = new ArrayList<S1081ResponseEntity>();
    	
		EnchashmentExample example = new EnchashmentExample();
		example.setOrderByClause("id desc");
		EnchashmentExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andAccountTypeEqualTo(Integer.valueOf(accountTypeEnum.key()));
		Integer totalCount = enchashmentDao.countByExample(example);
		if(totalCount > 0){
			List<Enchashment> list = enchashmentDao.selectByExample(new RowBounds(currentPage, limit),example);
			for (Enchashment enchashment : list) {
				S1081ResponseEntity entity = new S1081ResponseEntity();
				CloneUtils.copyEntity(enchashment, entity);
				resList.add(entity);
			}
		}
		page.setCurrentPage(currentPage);
		page.setLimit(limit);
		page.setList(resList);
		page.setTotalRecord(totalCount);
		return page;
    }
    

    /**
     * 查询店铺审核中金额
     * @param shopId
     * @return
     */
    public Double queryEnchashment(Integer shopId,AccountTypeEnum accountTypeEnum){
    	EnchashmentExample example = new EnchashmentExample();
    	example.setFieldList("sum(amount) as amount");
		EnchashmentExample.Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(shopId);
		criteria.andStateEqualTo(1);//审核中
		criteria.andAccountTypeEqualTo(Integer.valueOf(accountTypeEnum.key()));
		List<Enchashment> list = enchashmentDao.selectByExample(example);
		if(!Utils.isEmpty(list) && !Utils.isEmpty(list.get(0))){
			return list.get(0).getAmount();
		}
    	return 0.00;
    }
}