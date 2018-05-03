package cn.xinmeng.api.entity.auto;
import cn.xinmeng.common.entity.IEntity;

/**
 * 描述：搜索关键字表
 * @author jiangyong.tan
 * @date 2016-03-21 11:04:31
 */
public class SearchKeyword implements IEntity{

    private static final long serialVersionUID = 826754628250261826L;

    private Integer id; //主键
    private String keyword; //关键字
    private Integer customerCount; //搜索次数
    private String keywordQp; //关键字全拼
    private String keywordJp; //关键字简拼
    private Integer state; //状态1、无效，2、有效
    private java.util.Date createTime; //创建时间

	
	// set get
	
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }
	
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String getKeyword() {
        return this.keyword;
    }
	
    public void setCustomerCount(Integer customerCount) {
        this.customerCount = customerCount;
    }
    
    public Integer getCustomerCount() {
        return this.customerCount;
    }
	
    public void setKeywordQp(String keywordQp) {
        this.keywordQp = keywordQp;
    }
    
    public String getKeywordQp() {
        return this.keywordQp;
    }
	
    public void setKeywordJp(String keywordJp) {
        this.keywordJp = keywordJp;
    }
    
    public String getKeywordJp() {
        return this.keywordJp;
    }
	
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return this.state;
    }
	
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    public java.util.Date getCreateTime() {
        return this.createTime;
    }
}