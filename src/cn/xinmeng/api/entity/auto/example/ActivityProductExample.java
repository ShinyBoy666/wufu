package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ActivityProductExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ActivityProductExample() {
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
        
    	public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activity_id");
            return (Criteria) this;
        }
        
    	public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }
        
    	public Criteria andActivityTypeIsNull() {
            addCriterion("activity_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("activity_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(Integer value) {
            addCriterion("activity_type =", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(Integer value) {
            addCriterion("activity_type <>", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(Integer value) {
            addCriterion("activity_type >", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_type >=", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(Integer value) {
            addCriterion("activity_type <", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("activity_type <=", value, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<Integer> values) {
            addCriterion("activity_type in", values, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<Integer> values) {
            addCriterion("activity_type not in", values, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(Integer value1, Integer value2) {
            addCriterion("activity_type between", value1, value2, "activity_type");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_type not between", value1, value2, "activity_type");
            return (Criteria) this;
        }
        
    	public Criteria andProductPriceIdIsNull() {
            addCriterion("product_price_id is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdIsNotNull() {
            addCriterion("product_price_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdEqualTo(Integer value) {
            addCriterion("product_price_id =", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdNotEqualTo(Integer value) {
            addCriterion("product_price_id <>", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdGreaterThan(Integer value) {
            addCriterion("product_price_id >", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_price_id >=", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdLessThan(Integer value) {
            addCriterion("product_price_id <", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_price_id <=", value, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdIn(List<Integer> values) {
            addCriterion("product_price_id in", values, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdNotIn(List<Integer> values) {
            addCriterion("product_price_id not in", values, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdBetween(Integer value1, Integer value2) {
            addCriterion("product_price_id between", value1, value2, "product_price_id");
            return (Criteria) this;
        }

        public Criteria andProductPriceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_price_id not between", value1, value2, "product_price_id");
            return (Criteria) this;
        }
        
    	public Criteria andProductActivityPriceIsNull() {
            addCriterion("product_activity_price is null");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceIsNotNull() {
            addCriterion("product_activity_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceEqualTo(Double value) {
            addCriterion("product_activity_price =", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotEqualTo(Double value) {
            addCriterion("product_activity_price <>", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceGreaterThan(Double value) {
            addCriterion("product_activity_price >", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("product_activity_price >=", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceLessThan(Double value) {
            addCriterion("product_activity_price <", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceLessThanOrEqualTo(Double value) {
            addCriterion("product_activity_price <=", value, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceIn(List<Double> values) {
            addCriterion("product_activity_price in", values, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotIn(List<Double> values) {
            addCriterion("product_activity_price not in", values, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceBetween(Double value1, Double value2) {
            addCriterion("product_activity_price between", value1, value2, "product_activity_price");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotBetween(Double value1, Double value2) {
            addCriterion("product_activity_price not between", value1, value2, "product_activity_price");
            return (Criteria) this;
        }
        
    	public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Double value) {
            addCriterion("product_price =", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Double value) {
            addCriterion("product_price <>", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Double value) {
            addCriterion("product_price >", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("product_price >=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Double value) {
            addCriterion("product_price <", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Double value) {
            addCriterion("product_price <=", value, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Double> values) {
            addCriterion("product_price in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Double> values) {
            addCriterion("product_price not in", values, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Double value1, Double value2) {
            addCriterion("product_price between", value1, value2, "product_price");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Double value1, Double value2) {
            addCriterion("product_price not between", value1, value2, "product_price");
            return (Criteria) this;
        }
        
    	public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(Integer value) {
            addCriterion("product_number =", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(Integer value) {
            addCriterion("product_number <>", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(Integer value) {
            addCriterion("product_number >", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_number >=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(Integer value) {
            addCriterion("product_number <", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(Integer value) {
            addCriterion("product_number <=", value, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<Integer> values) {
            addCriterion("product_number in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<Integer> values) {
            addCriterion("product_number not in", values, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(Integer value1, Integer value2) {
            addCriterion("product_number between", value1, value2, "product_number");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("product_number not between", value1, value2, "product_number");
            return (Criteria) this;
        }
        
    	public Criteria andSoldNumberIsNull() {
            addCriterion("sold_number is null");
            return (Criteria) this;
        }

        public Criteria andSoldNumberIsNotNull() {
            addCriterion("sold_number is not null");
            return (Criteria) this;
        }

        public Criteria andSoldNumberEqualTo(Integer value) {
            addCriterion("sold_number =", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberNotEqualTo(Integer value) {
            addCriterion("sold_number <>", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberGreaterThan(Integer value) {
            addCriterion("sold_number >", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sold_number >=", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberLessThan(Integer value) {
            addCriterion("sold_number <", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sold_number <=", value, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberIn(List<Integer> values) {
            addCriterion("sold_number in", values, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberNotIn(List<Integer> values) {
            addCriterion("sold_number not in", values, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberBetween(Integer value1, Integer value2) {
            addCriterion("sold_number between", value1, value2, "sold_number");
            return (Criteria) this;
        }

        public Criteria andSoldNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sold_number not between", value1, value2, "sold_number");
            return (Criteria) this;
        }
        
    	public Criteria andMaxBuyIsNull() {
            addCriterion("max_buy is null");
            return (Criteria) this;
        }

        public Criteria andMaxBuyIsNotNull() {
            addCriterion("max_buy is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBuyEqualTo(Integer value) {
            addCriterion("max_buy =", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyNotEqualTo(Integer value) {
            addCriterion("max_buy <>", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyGreaterThan(Integer value) {
            addCriterion("max_buy >", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_buy >=", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyLessThan(Integer value) {
            addCriterion("max_buy <", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyLessThanOrEqualTo(Integer value) {
            addCriterion("max_buy <=", value, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyIn(List<Integer> values) {
            addCriterion("max_buy in", values, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyNotIn(List<Integer> values) {
            addCriterion("max_buy not in", values, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyBetween(Integer value1, Integer value2) {
            addCriterion("max_buy between", value1, value2, "max_buy");
            return (Criteria) this;
        }

        public Criteria andMaxBuyNotBetween(Integer value1, Integer value2) {
            addCriterion("max_buy not between", value1, value2, "max_buy");
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