package cn.xinmeng.api.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.xinmeng.api.dao.auto.ShopImageDao;
import cn.xinmeng.api.entity.auto.ShopImage;
import cn.xinmeng.api.entity.auto.example.ShopImageExample;
import cn.xinmeng.api.enums.ShopImageTypeEnum;
import cn.xinmeng.api.enums.StateEnum;
import cn.xinmeng.api.service.IShopImageService;
import cn.xinmeng.common.util.Utils;

/**
 * 业务层：ShopImageServiceImpl
 * 描述：门店图片表
 * @author jiangyong.tan
 * @date 2016-02-21 21:35:12
 */
@Service("shopImageService")
public class ShopImageServiceImpl implements IShopImageService {

    @Resource
	private ShopImageDao shopImageDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ShopImage record){
    	return shopImageDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return shopImageDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ShopImage record){
		return shopImageDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ShopImage selectByPrimaryKey(Integer id){
    	return shopImageDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ShopImageExample example){
		return shopImageDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(ShopImageExample example){
    	return shopImageDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ShopImage> selectByExample(int currentPage, int limit,ShopImageExample example){
        return shopImageDao.selectByExample(new RowBounds(currentPage, limit),example);
    }

    
    /**
     * 查询店铺其中一张图片
     * @param shopId
     * @return
     */
    public String queryShopInfoImage(Integer shopId,ShopImageTypeEnum imageType){
    	ShopImageExample example = new ShopImageExample();
    	example.setFieldList("image_url");
    	example.setOrderByClause("create_time desc,id desc");
    	ShopImageExample.Criteria criteria = example.createCriteria();
    	criteria.andShopIdEqualTo(shopId);
    	if(!Utils.isEmpty(imageType)){
        	criteria.andImageTypeEqualTo(Integer.valueOf(imageType.key()));
    	}
    	criteria.andStateEqualTo(Integer.valueOf(StateEnum.EFFECTION.key()));
    	List<ShopImage> list = shopImageDao.selectByExample(example);
    	if(list != null && list.size() > 0){
    		return list.get(0).getImageUrl();
    	}
    	return "";
    }
    

    /**
     * 添加封面图，形象图
     * @param coverImageUrl
     * @param personalImageUrl
     * @return
     */
    public int addImageUrl(Integer shopId,String coverImageUrl,String personalImageUrl){
    	ShopImageExample example = new ShopImageExample();
    	ShopImageExample.Criteria criteria = example.createCriteria();
    	criteria.andImageTypeIn(Arrays.asList(new Integer[]{2,3}));//2-店铺封面，3-老板形象
    	criteria.andShopIdEqualTo(shopId);
    	shopImageDao.deleteByExample(example);
    	
    	if(!Utils.isEmpty(coverImageUrl)){
    		ShopImage shopImage = new ShopImage();
    		shopImage.setImageType(2);
    		shopImage.setImageUrl(coverImageUrl);
    		shopImage.setState(Integer.valueOf(StateEnum.EFFECTION.key()));
    		shopImage.setShopId(shopId);
    		shopImageDao.insert(shopImage);
    	}

    	if(!Utils.isEmpty(personalImageUrl)){
    		ShopImage shopImage = new ShopImage();
    		shopImage.setImageType(3);
    		shopImage.setImageUrl(personalImageUrl);
    		shopImage.setState(Integer.valueOf(StateEnum.EFFECTION.key()));
    		shopImage.setShopId(shopId);
    		shopImageDao.insert(shopImage);
    	}
    	return 2;
    }
    
}