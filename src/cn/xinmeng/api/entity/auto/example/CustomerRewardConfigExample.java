package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CustomerRewardConfigExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CustomerRewardConfigExample() {
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
        
    	public Criteria andVipFeeIsNull() {
            addCriterion("vip_fee is null");
            return (Criteria) this;
        }

        public Criteria andVipFeeIsNotNull() {
            addCriterion("vip_fee is not null");
            return (Criteria) this;
        }

        public Criteria andVipFeeEqualTo(Double value) {
            addCriterion("vip_fee =", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeNotEqualTo(Double value) {
            addCriterion("vip_fee <>", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeGreaterThan(Double value) {
            addCriterion("vip_fee >", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("vip_fee >=", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeLessThan(Double value) {
            addCriterion("vip_fee <", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeLessThanOrEqualTo(Double value) {
            addCriterion("vip_fee <=", value, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeIn(List<Double> values) {
            addCriterion("vip_fee in", values, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeNotIn(List<Double> values) {
            addCriterion("vip_fee not in", values, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeBetween(Double value1, Double value2) {
            addCriterion("vip_fee between", value1, value2, "vip_fee");
            return (Criteria) this;
        }

        public Criteria andVipFeeNotBetween(Double value1, Double value2) {
            addCriterion("vip_fee not between", value1, value2, "vip_fee");
            return (Criteria) this;
        }
        
    	public Criteria andFirstLevelIsNull() {
            addCriterion("first_level is null");
            return (Criteria) this;
        }

        public Criteria andFirstLevelIsNotNull() {
            addCriterion("first_level is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLevelEqualTo(Double value) {
            addCriterion("first_level =", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelNotEqualTo(Double value) {
            addCriterion("first_level <>", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelGreaterThan(Double value) {
            addCriterion("first_level >", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelGreaterThanOrEqualTo(Double value) {
            addCriterion("first_level >=", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelLessThan(Double value) {
            addCriterion("first_level <", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelLessThanOrEqualTo(Double value) {
            addCriterion("first_level <=", value, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelIn(List<Double> values) {
            addCriterion("first_level in", values, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelNotIn(List<Double> values) {
            addCriterion("first_level not in", values, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelBetween(Double value1, Double value2) {
            addCriterion("first_level between", value1, value2, "first_level");
            return (Criteria) this;
        }

        public Criteria andFirstLevelNotBetween(Double value1, Double value2) {
            addCriterion("first_level not between", value1, value2, "first_level");
            return (Criteria) this;
        }
        
    	public Criteria andSecondLevelIsNull() {
            addCriterion("second_level is null");
            return (Criteria) this;
        }

        public Criteria andSecondLevelIsNotNull() {
            addCriterion("second_level is not null");
            return (Criteria) this;
        }

        public Criteria andSecondLevelEqualTo(Double value) {
            addCriterion("second_level =", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelNotEqualTo(Double value) {
            addCriterion("second_level <>", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelGreaterThan(Double value) {
            addCriterion("second_level >", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelGreaterThanOrEqualTo(Double value) {
            addCriterion("second_level >=", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelLessThan(Double value) {
            addCriterion("second_level <", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelLessThanOrEqualTo(Double value) {
            addCriterion("second_level <=", value, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelIn(List<Double> values) {
            addCriterion("second_level in", values, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelNotIn(List<Double> values) {
            addCriterion("second_level not in", values, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelBetween(Double value1, Double value2) {
            addCriterion("second_level between", value1, value2, "second_level");
            return (Criteria) this;
        }

        public Criteria andSecondLevelNotBetween(Double value1, Double value2) {
            addCriterion("second_level not between", value1, value2, "second_level");
            return (Criteria) this;
        }
        
    	public Criteria andThirdLevelIsNull() {
            addCriterion("third_level is null");
            return (Criteria) this;
        }

        public Criteria andThirdLevelIsNotNull() {
            addCriterion("third_level is not null");
            return (Criteria) this;
        }

        public Criteria andThirdLevelEqualTo(Double value) {
            addCriterion("third_level =", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelNotEqualTo(Double value) {
            addCriterion("third_level <>", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelGreaterThan(Double value) {
            addCriterion("third_level >", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelGreaterThanOrEqualTo(Double value) {
            addCriterion("third_level >=", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelLessThan(Double value) {
            addCriterion("third_level <", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelLessThanOrEqualTo(Double value) {
            addCriterion("third_level <=", value, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelIn(List<Double> values) {
            addCriterion("third_level in", values, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelNotIn(List<Double> values) {
            addCriterion("third_level not in", values, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelBetween(Double value1, Double value2) {
            addCriterion("third_level between", value1, value2, "third_level");
            return (Criteria) this;
        }

        public Criteria andThirdLevelNotBetween(Double value1, Double value2) {
            addCriterion("third_level not between", value1, value2, "third_level");
            return (Criteria) this;
        }
        
    	public Criteria andShopIsNull() {
            addCriterion("shop is null");
            return (Criteria) this;
        }

        public Criteria andShopIsNotNull() {
            addCriterion("shop is not null");
            return (Criteria) this;
        }

        public Criteria andShopEqualTo(Double value) {
            addCriterion("shop =", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotEqualTo(Double value) {
            addCriterion("shop <>", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThan(Double value) {
            addCriterion("shop >", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThanOrEqualTo(Double value) {
            addCriterion("shop >=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThan(Double value) {
            addCriterion("shop <", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThanOrEqualTo(Double value) {
            addCriterion("shop <=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopIn(List<Double> values) {
            addCriterion("shop in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotIn(List<Double> values) {
            addCriterion("shop not in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopBetween(Double value1, Double value2) {
            addCriterion("shop between", value1, value2, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotBetween(Double value1, Double value2) {
            addCriterion("shop not between", value1, value2, "shop");
            return (Criteria) this;
        }
        
    	public Criteria andPortalIsNull() {
            addCriterion("portal is null");
            return (Criteria) this;
        }

        public Criteria andPortalIsNotNull() {
            addCriterion("portal is not null");
            return (Criteria) this;
        }

        public Criteria andPortalEqualTo(Double value) {
            addCriterion("portal =", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalNotEqualTo(Double value) {
            addCriterion("portal <>", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalGreaterThan(Double value) {
            addCriterion("portal >", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalGreaterThanOrEqualTo(Double value) {
            addCriterion("portal >=", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalLessThan(Double value) {
            addCriterion("portal <", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalLessThanOrEqualTo(Double value) {
            addCriterion("portal <=", value, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalIn(List<Double> values) {
            addCriterion("portal in", values, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalNotIn(List<Double> values) {
            addCriterion("portal not in", values, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalBetween(Double value1, Double value2) {
            addCriterion("portal between", value1, value2, "portal");
            return (Criteria) this;
        }

        public Criteria andPortalNotBetween(Double value1, Double value2) {
            addCriterion("portal not between", value1, value2, "portal");
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