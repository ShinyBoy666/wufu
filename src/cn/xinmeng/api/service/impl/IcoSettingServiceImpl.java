package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.IcoSettingDao;
import cn.xinmeng.api.entity.auto.IcoSetting;
import cn.xinmeng.api.entity.auto.example.IcoSettingExample;
import cn.xinmeng.api.enums.IcoTypeEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IIcoSettingService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.vo.IcoSettingVo;

/**
 * 业务层：IcoSettingServiceImpl
 * 描述：图标配置表
 * @author jiangyong.tan
 * @date 2016-05-21 13:35:11
 */
@Service("icoSettingService")
public class IcoSettingServiceImpl implements IIcoSettingService {

    @Resource
	private IcoSettingDao icoSettingDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(IcoSetting record){
    	return icoSettingDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return icoSettingDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(IcoSetting record){
		return icoSettingDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public IcoSetting selectByPrimaryKey(Integer id){
    	return icoSettingDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(IcoSettingExample example){
		return icoSettingDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<IcoSetting> selectByExample(IcoSettingExample example){
    	return icoSettingDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<IcoSetting> selectByExample(int currentPage, int limit,IcoSettingExample example){
        return icoSettingDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 查询首页图标
     * @return
     */
    public Map<String,String> selectHomePageByExample(Integer shopId){
    	Map<String,String> map =new HashMap<String, String>();
    	IcoSettingExample example = new IcoSettingExample();
    	IcoSettingExample.Criteria criteria = example.createCriteria();
    	criteria.andPageEqualTo(Integer.valueOf(IcoTypeEnum.HOME_PAGE.key()));
    	criteria.andShopIdEqualTo(shopId);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	List<IcoSetting> list = icoSettingDao.selectByExample(example);
    	if(!Utils.isEmpty(list)){
    		for (IcoSetting icoSetting : list) {
    			map.put(icoSetting.getIcoName(), icoSetting.getUrl());
			}
    	}
    	return map;
    }

	@Override
	public List<IcoSettingVo> queryHomePageMenu(Integer shopId) {
		List<IcoSettingVo> resList = new ArrayList<IcoSettingVo>();
		IcoSettingExample example = new IcoSettingExample();
		example.setOrderByClause("ico_index,id");
    	IcoSettingExample.Criteria criteria = example.createCriteria();
    	criteria.andPageEqualTo(Integer.valueOf(IcoTypeEnum.HOME_PAGE.key()));
    	criteria.andShopIdEqualTo(shopId);
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	List<IcoSetting> list = icoSettingDao.selectByExample(example);
    	if(!Utils.isEmpty(list)){
    		for (IcoSetting icoSetting : list) {
    			IcoSettingVo result = new IcoSettingVo();
    			CloneUtils.copyEntity(icoSetting, result);
    			resList.add(result);
			}
    	}
		return resList;
	}
}