package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IAdService;
import cn.xinmeng.api.dao.auto.AdDao;
import cn.xinmeng.api.entity.auto.Ad;
import cn.xinmeng.api.entity.auto.example.AdExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：AdServiceImpl
 * 描述：广告管理
 * @author jiangyong.tan
 * @date 2016-05-24 20:20:05
 */
@Service("adService")
public class AdServiceImpl implements IAdService {

    @Resource
	private AdDao adDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Ad record){
    	return adDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return adDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Ad record){
		return adDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Ad selectByPrimaryKey(Integer id){
    	return adDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(AdExample example){
		return adDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Ad> selectByExample(AdExample example){
    	return adDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<Ad> selectByExample(int currentPage, int limit,AdExample example){
        return adDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}