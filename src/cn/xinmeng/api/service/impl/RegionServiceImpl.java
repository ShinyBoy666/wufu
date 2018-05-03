package cn.xinmeng.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.RegionDao;
import cn.xinmeng.api.entity.auto.Region;
import cn.xinmeng.api.entity.auto.example.RegionExample;
import cn.xinmeng.api.service.IRegionService;

/**
 * 业务层：RegionServiceImpl
 * @author jiangyong.tan
 * 描述：行政信息表
 * @date 2016-01-24 14:39:09
 */
@Service("regionService")
public class RegionServiceImpl implements IRegionService {

    @Resource
	private RegionDao regionDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Region record){
    	return regionDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return regionDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Region record){
		return regionDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Region selectByPrimaryKey(Integer id){
    	return regionDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(RegionExample example){
		return regionDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Region> selectByExample(RegionExample example){
    	return regionDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Region> selectByExample(int currentPage, int limit,RegionExample example){
        return regionDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

}