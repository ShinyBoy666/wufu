package cn.xinmeng.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.BannerDao;
import cn.xinmeng.api.entity.auto.Banner;
import cn.xinmeng.api.entity.auto.example.BannerExample;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IBannerService;
import cn.xinmeng.common.util.CloneUtils;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.shop.entity.vo.BannerVo;

/**
 * 业务层：BannerServiceImpl
 * @author jiangyong.tan
 * 描述：轮播图表
 * @date 2016-01-24 14:38:55
 */
@Service("bannerService")
public class BannerServiceImpl implements IBannerService {

    @Resource
	private BannerDao bannerDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(Banner record){
    	return bannerDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return bannerDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(Banner record){
		return bannerDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Banner selectByPrimaryKey(Integer id){
    	return bannerDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(BannerExample example){
		return bannerDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<Banner> selectByExample(BannerExample example){
    	return bannerDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param pageNo
     * @param pageSize
     * @param example
     * @return
     */
    public List<Banner> selectByExample(int currentPage, int limit,BannerExample example){
        return bannerDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    /**
     * 轮播图
     * @param shopId
     * @param showArea
     * @return
     */
    public List<BannerVo> selectBannerVo(Integer shopId,Integer showArea){
    	Date now = new Date();
		List<BannerVo> result = new ArrayList<BannerVo>();//返回集合
		
		BannerExample example = new BannerExample();
		BannerExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("sort desc,id desc");
		criteria.andShopIdEqualTo(0);
		criteria.andShowAreaEqualTo(1);
		criteria.andBeginTimeLessThanOrEqualTo(now);
		criteria.andEndTimeGreaterThanOrEqualTo(now);
		criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
		List<Banner> list = selectByExample(example);
		if(!Utils.isEmpty(list)){
			for (Banner banner : list) {
				BannerVo bannerVo = new BannerVo();
				//复制属性
				CloneUtils.copyEntity(banner, bannerVo);
				bannerVo.setImageUrl(Utils.getImageUrl(bannerVo.getImageUrl(),"?640_320"));
				result.add(bannerVo);
			}
		}
		return result;
    }
    
}