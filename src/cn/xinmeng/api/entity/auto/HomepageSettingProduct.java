package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：主页配置商品表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:13
 */
public class HomepageSettingProduct implements IEntity{

    private static final long serialVersionUID = 433464937662760892L;

    private Integer id; //主键
    private Integer modulId; //模块编号
    private Integer productId; //商品编号
    private Integer sort; //排序

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setModulId(Integer modulId) {
        this.modulId = modulId;
    }
    
    public Integer getModulId() {
        return this.modulId;
    }
	
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
	
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public Integer getSort() {
        return this.sort;
    }
}