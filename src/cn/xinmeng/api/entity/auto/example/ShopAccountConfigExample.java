package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ShopAccountConfigExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ShopAccountConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() {
        return orderByClause;
    }
    
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    public boolean isDistinct() {
        return distinct;
    }
    
    public String getFieldList() {
		return fieldList;
	}

	public void setFieldList(String fieldList) {
		this.fieldList = fieldList;
	}

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }
        
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }
        

    	public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
    	public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shop_id");
            return (Criteria) this;
        }
        
    	public Criteria andWechatpayAppIdIsNull() {
            addCriterion("wechatpay_app_id is null");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdIsNotNull() {
            addCriterion("wechatpay_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdEqualTo(String value) {
            addCriterion("wechatpay_app_id =", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdNotEqualTo(String value) {
            addCriterion("wechatpay_app_id <>", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdGreaterThan(String value) {
            addCriterion("wechatpay_app_id >", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("wechatpay_app_id >=", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdLessThan(String value) {
            addCriterion("wechatpay_app_id <", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdLessThanOrEqualTo(String value) {
            addCriterion("wechatpay_app_id <=", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdIn(List<String> values) {
            addCriterion("wechatpay_app_id in", values, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdNotIn(List<String> values) {
            addCriterion("wechatpay_app_id not in", values, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdBetween(String value1, String value2) {
            addCriterion("wechatpay_app_id between", value1, value2, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdNotBetween(String value1, String value2) {
            addCriterion("wechatpay_app_id not between", value1, value2, "wechatpay_app_id");
            return (Criteria) this;
        }
        
    	public Criteria andWechatpayAppIdLike(String value) {
            addCriterion("wechatpay_app_id like", value, "wechatpay_app_id");
            return (Criteria) this;
        }

        public Criteria andWechatpayAppIdNotLike(String value) {
            addCriterion("wechatpay_app_id not like", value, "wechatpay_app_id");
            return (Criteria) this;
        }
    	public Criteria andWechatpaySignTypeIsNull() {
            addCriterion("wechatpay_sign_type is null");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeIsNotNull() {
            addCriterion("wechatpay_sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeEqualTo(String value) {
            addCriterion("wechatpay_sign_type =", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeNotEqualTo(String value) {
            addCriterion("wechatpay_sign_type <>", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeGreaterThan(String value) {
            addCriterion("wechatpay_sign_type >", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("wechatpay_sign_type >=", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeLessThan(String value) {
            addCriterion("wechatpay_sign_type <", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeLessThanOrEqualTo(String value) {
            addCriterion("wechatpay_sign_type <=", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeIn(List<String> values) {
            addCriterion("wechatpay_sign_type in", values, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeNotIn(List<String> values) {
            addCriterion("wechatpay_sign_type not in", values, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeBetween(String value1, String value2) {
            addCriterion("wechatpay_sign_type between", value1, value2, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeNotBetween(String value1, String value2) {
            addCriterion("wechatpay_sign_type not between", value1, value2, "wechatpay_sign_type");
            return (Criteria) this;
        }
        
    	public Criteria andWechatpaySignTypeLike(String value) {
            addCriterion("wechatpay_sign_type like", value, "wechatpay_sign_type");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignTypeNotLike(String value) {
            addCriterion("wechatpay_sign_type not like", value, "wechatpay_sign_type");
            return (Criteria) this;
        }
    	public Criteria andWechatpaySignIsNull() {
            addCriterion("wechatpay_sign is null");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignIsNotNull() {
            addCriterion("wechatpay_sign is not null");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignEqualTo(String value) {
            addCriterion("wechatpay_sign =", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignNotEqualTo(String value) {
            addCriterion("wechatpay_sign <>", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignGreaterThan(String value) {
            addCriterion("wechatpay_sign >", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignGreaterThanOrEqualTo(String value) {
            addCriterion("wechatpay_sign >=", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignLessThan(String value) {
            addCriterion("wechatpay_sign <", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignLessThanOrEqualTo(String value) {
            addCriterion("wechatpay_sign <=", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignIn(List<String> values) {
            addCriterion("wechatpay_sign in", values, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignNotIn(List<String> values) {
            addCriterion("wechatpay_sign not in", values, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignBetween(String value1, String value2) {
            addCriterion("wechatpay_sign between", value1, value2, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignNotBetween(String value1, String value2) {
            addCriterion("wechatpay_sign not between", value1, value2, "wechatpay_sign");
            return (Criteria) this;
        }
        
    	public Criteria andWechatpaySignLike(String value) {
            addCriterion("wechatpay_sign like", value, "wechatpay_sign");
            return (Criteria) this;
        }

        public Criteria andWechatpaySignNotLike(String value) {
            addCriterion("wechatpay_sign not like", value, "wechatpay_sign");
            return (Criteria) this;
        }
    	public Criteria andAlipayPidIsNull() {
            addCriterion("alipay_pid is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPidIsNotNull() {
            addCriterion("alipay_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPidEqualTo(String value) {
            addCriterion("alipay_pid =", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidNotEqualTo(String value) {
            addCriterion("alipay_pid <>", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidGreaterThan(String value) {
            addCriterion("alipay_pid >", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_pid >=", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidLessThan(String value) {
            addCriterion("alipay_pid <", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidLessThanOrEqualTo(String value) {
            addCriterion("alipay_pid <=", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidIn(List<String> values) {
            addCriterion("alipay_pid in", values, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidNotIn(List<String> values) {
            addCriterion("alipay_pid not in", values, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidBetween(String value1, String value2) {
            addCriterion("alipay_pid between", value1, value2, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidNotBetween(String value1, String value2) {
            addCriterion("alipay_pid not between", value1, value2, "alipay_pid");
            return (Criteria) this;
        }
        
    	public Criteria andAlipayPidLike(String value) {
            addCriterion("alipay_pid like", value, "alipay_pid");
            return (Criteria) this;
        }

        public Criteria andAlipayPidNotLike(String value) {
            addCriterion("alipay_pid not like", value, "alipay_pid");
            return (Criteria) this;
        }
    	public Criteria andAlipayKeyIsNull() {
            addCriterion("alipay_key is null");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyIsNotNull() {
            addCriterion("alipay_key is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyEqualTo(String value) {
            addCriterion("alipay_key =", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyNotEqualTo(String value) {
            addCriterion("alipay_key <>", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyGreaterThan(String value) {
            addCriterion("alipay_key >", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_key >=", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyLessThan(String value) {
            addCriterion("alipay_key <", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyLessThanOrEqualTo(String value) {
            addCriterion("alipay_key <=", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyIn(List<String> values) {
            addCriterion("alipay_key in", values, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyNotIn(List<String> values) {
            addCriterion("alipay_key not in", values, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyBetween(String value1, String value2) {
            addCriterion("alipay_key between", value1, value2, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyNotBetween(String value1, String value2) {
            addCriterion("alipay_key not between", value1, value2, "alipay_key");
            return (Criteria) this;
        }
        
    	public Criteria andAlipayKeyLike(String value) {
            addCriterion("alipay_key like", value, "alipay_key");
            return (Criteria) this;
        }

        public Criteria andAlipayKeyNotLike(String value) {
            addCriterion("alipay_key not like", value, "alipay_key");
            return (Criteria) this;
        }
    	public Criteria andAlipayAccountIsNull() {
            addCriterion("alipay_account is null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIsNotNull() {
            addCriterion("alipay_account is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountEqualTo(String value) {
            addCriterion("alipay_account =", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotEqualTo(String value) {
            addCriterion("alipay_account <>", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThan(String value) {
            addCriterion("alipay_account >", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_account >=", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThan(String value) {
            addCriterion("alipay_account <", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            addCriterion("alipay_account <=", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountIn(List<String> values) {
            addCriterion("alipay_account in", values, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotIn(List<String> values) {
            addCriterion("alipay_account not in", values, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountBetween(String value1, String value2) {
            addCriterion("alipay_account between", value1, value2, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotBetween(String value1, String value2) {
            addCriterion("alipay_account not between", value1, value2, "alipay_account");
            return (Criteria) this;
        }
        
    	public Criteria andAlipayAccountLike(String value) {
            addCriterion("alipay_account like", value, "alipay_account");
            return (Criteria) this;
        }

        public Criteria andAlipayAccountNotLike(String value) {
            addCriterion("alipay_account not like", value, "alipay_account");
            return (Criteria) this;
        }
    	public Criteria andGetuiAccountIsNull() {
            addCriterion("getui_account is null");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountIsNotNull() {
            addCriterion("getui_account is not null");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountEqualTo(String value) {
            addCriterion("getui_account =", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountNotEqualTo(String value) {
            addCriterion("getui_account <>", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountGreaterThan(String value) {
            addCriterion("getui_account >", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountGreaterThanOrEqualTo(String value) {
            addCriterion("getui_account >=", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountLessThan(String value) {
            addCriterion("getui_account <", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountLessThanOrEqualTo(String value) {
            addCriterion("getui_account <=", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountIn(List<String> values) {
            addCriterion("getui_account in", values, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountNotIn(List<String> values) {
            addCriterion("getui_account not in", values, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountBetween(String value1, String value2) {
            addCriterion("getui_account between", value1, value2, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountNotBetween(String value1, String value2) {
            addCriterion("getui_account not between", value1, value2, "getui_account");
            return (Criteria) this;
        }
        
    	public Criteria andGetuiAccountLike(String value) {
            addCriterion("getui_account like", value, "getui_account");
            return (Criteria) this;
        }

        public Criteria andGetuiAccountNotLike(String value) {
            addCriterion("getui_account not like", value, "getui_account");
            return (Criteria) this;
        }
    	public Criteria andGetuiPasswordIsNull() {
            addCriterion("getui_password is null");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordIsNotNull() {
            addCriterion("getui_password is not null");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordEqualTo(String value) {
            addCriterion("getui_password =", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordNotEqualTo(String value) {
            addCriterion("getui_password <>", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordGreaterThan(String value) {
            addCriterion("getui_password >", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("getui_password >=", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordLessThan(String value) {
            addCriterion("getui_password <", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordLessThanOrEqualTo(String value) {
            addCriterion("getui_password <=", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordIn(List<String> values) {
            addCriterion("getui_password in", values, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordNotIn(List<String> values) {
            addCriterion("getui_password not in", values, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordBetween(String value1, String value2) {
            addCriterion("getui_password between", value1, value2, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordNotBetween(String value1, String value2) {
            addCriterion("getui_password not between", value1, value2, "getui_password");
            return (Criteria) this;
        }
        
    	public Criteria andGetuiPasswordLike(String value) {
            addCriterion("getui_password like", value, "getui_password");
            return (Criteria) this;
        }

        public Criteria andGetuiPasswordNotLike(String value) {
            addCriterion("getui_password not like", value, "getui_password");
            return (Criteria) this;
        }
    	public Criteria andShareAccountIsNull() {
            addCriterion("share_account is null");
            return (Criteria) this;
        }

        public Criteria andShareAccountIsNotNull() {
            addCriterion("share_account is not null");
            return (Criteria) this;
        }

        public Criteria andShareAccountEqualTo(String value) {
            addCriterion("share_account =", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotEqualTo(String value) {
            addCriterion("share_account <>", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountGreaterThan(String value) {
            addCriterion("share_account >", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountGreaterThanOrEqualTo(String value) {
            addCriterion("share_account >=", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountLessThan(String value) {
            addCriterion("share_account <", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountLessThanOrEqualTo(String value) {
            addCriterion("share_account <=", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountIn(List<String> values) {
            addCriterion("share_account in", values, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotIn(List<String> values) {
            addCriterion("share_account not in", values, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountBetween(String value1, String value2) {
            addCriterion("share_account between", value1, value2, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotBetween(String value1, String value2) {
            addCriterion("share_account not between", value1, value2, "share_account");
            return (Criteria) this;
        }
        
    	public Criteria andShareAccountLike(String value) {
            addCriterion("share_account like", value, "share_account");
            return (Criteria) this;
        }

        public Criteria andShareAccountNotLike(String value) {
            addCriterion("share_account not like", value, "share_account");
            return (Criteria) this;
        }
    	public Criteria andSharePasswordIsNull() {
            addCriterion("share_password is null");
            return (Criteria) this;
        }

        public Criteria andSharePasswordIsNotNull() {
            addCriterion("share_password is not null");
            return (Criteria) this;
        }

        public Criteria andSharePasswordEqualTo(String value) {
            addCriterion("share_password =", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotEqualTo(String value) {
            addCriterion("share_password <>", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordGreaterThan(String value) {
            addCriterion("share_password >", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("share_password >=", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordLessThan(String value) {
            addCriterion("share_password <", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordLessThanOrEqualTo(String value) {
            addCriterion("share_password <=", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordIn(List<String> values) {
            addCriterion("share_password in", values, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotIn(List<String> values) {
            addCriterion("share_password not in", values, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordBetween(String value1, String value2) {
            addCriterion("share_password between", value1, value2, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotBetween(String value1, String value2) {
            addCriterion("share_password not between", value1, value2, "share_password");
            return (Criteria) this;
        }
        
    	public Criteria andSharePasswordLike(String value) {
            addCriterion("share_password like", value, "share_password");
            return (Criteria) this;
        }

        public Criteria andSharePasswordNotLike(String value) {
            addCriterion("share_password not like", value, "share_password");
            return (Criteria) this;
        }
    	public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
        
    	public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(java.util.Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(java.util.Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(java.util.Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(java.util.Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<java.util.Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<java.util.Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }
        
    	public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "create_user");
            return (Criteria) this;
        }
        
    	public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "create_user");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "create_user");
            return (Criteria) this;
        }
    	public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(java.util.Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(java.util.Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(java.util.Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(java.util.Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<java.util.Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<java.util.Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }
        
    	public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "update_user");
            return (Criteria) this;
        }
        
    	public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "update_user");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "update_user");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}