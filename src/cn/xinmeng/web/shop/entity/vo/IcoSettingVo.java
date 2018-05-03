package cn.xinmeng.web.shop.entity.vo;
import cn.xinmeng.common.entity.IEntity;
import cn.xinmeng.common.util.Utils;

/**
 * 描述：图标配置表
 * @author jiangyong.tan
 * @date 2016-11-21 16:13:37
 */
public class IcoSettingVo implements IEntity{

    private static final long serialVersionUID = 104119265804772120L;
    
    public IcoSettingVo(){}
    public IcoSettingVo(String icoName,String url,String linkUrl){
    	this.icoName = icoName;
    	this.url = url;
    	this.linkUrl = linkUrl;
    }
    
    private String icoName; //图标名称
    private String url; //图标资源位置
    private String linkUrl; //链接地址

	// set get
	
    public void setIcoName(String icoName) {
        this.icoName = icoName;
    }
    
    public String getIcoName() {
        return this.icoName;
    }
	
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return Utils.getImageUrl(this.url);
    }
	
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
	
}