package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class HagglePriceRecordExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public HagglePriceRecordExample() {
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
        
    	public Criteria andHaggleIdIsNull() {
            addCriterion("haggle_id is null");
            return (Criteria) this;
        }

        public Criteria andHaggleIdIsNotNull() {
            addCriterion("haggle_id is not null");
            return (Criteria) this;
        }

        public Criteria andHaggleIdEqualTo(Integer value) {
            addCriterion("haggle_id =", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdNotEqualTo(Integer value) {
            addCriterion("haggle_id <>", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdGreaterThan(Integer value) {
            addCriterion("haggle_id >", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("haggle_id >=", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdLessThan(Integer value) {
            addCriterion("haggle_id <", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdLessThanOrEqualTo(Integer value) {
            addCriterion("haggle_id <=", value, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdIn(List<Integer> values) {
            addCriterion("haggle_id in", values, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdNotIn(List<Integer> values) {
            addCriterion("haggle_id not in", values, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdBetween(Integer value1, Integer value2) {
            addCriterion("haggle_id between", value1, value2, "haggle_id");
            return (Criteria) this;
        }

        public Criteria andHaggleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("haggle_id not between", value1, value2, "haggle_id");
            return (Criteria) this;
        }
        
    	public Criteria andFromCustomerIdIsNull() {
            addCriterion("from_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdIsNotNull() {
            addCriterion("from_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdEqualTo(Integer value) {
            addCriterion("from_customer_id =", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdNotEqualTo(Integer value) {
            addCriterion("from_customer_id <>", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdGreaterThan(Integer value) {
            addCriterion("from_customer_id >", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_customer_id >=", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdLessThan(Integer value) {
            addCriterion("from_customer_id <", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_customer_id <=", value, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdIn(List<Integer> values) {
            addCriterion("from_customer_id in", values, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdNotIn(List<Integer> values) {
            addCriterion("from_customer_id not in", values, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("from_customer_id between", value1, value2, "from_customer_id");
            return (Criteria) this;
        }

        public Criteria andFromCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_customer_id not between", value1, value2, "from_customer_id");
            return (Criteria) this;
        }
        
    	public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(Double value) {
            addCriterion("current_price =", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(Double value) {
            addCriterion("current_price <>", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(Double value) {
            addCriterion("current_price >", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("current_price >=", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(Double value) {
            addCriterion("current_price <", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(Double value) {
            addCriterion("current_price <=", value, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<Double> values) {
            addCriterion("current_price in", values, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<Double> values) {
            addCriterion("current_price not in", values, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(Double value1, Double value2) {
            addCriterion("current_price between", value1, value2, "current_price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(Double value1, Double value2) {
            addCriterion("current_price not between", value1, value2, "current_price");
            return (Criteria) this;
        }
        
    	public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
            return (Criteria) this;
        }
        
    	public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "order_id");
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