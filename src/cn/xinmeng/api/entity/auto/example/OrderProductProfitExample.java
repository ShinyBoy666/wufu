package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class OrderProductProfitExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public OrderProductProfitExample() {
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
    	public Criteria andOrderProductIdIsNull() {
            addCriterion("order_product_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIsNotNull() {
            addCriterion("order_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdEqualTo(Integer value) {
            addCriterion("order_product_id =", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotEqualTo(Integer value) {
            addCriterion("order_product_id <>", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThan(Integer value) {
            addCriterion("order_product_id >", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_product_id >=", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThan(Integer value) {
            addCriterion("order_product_id <", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_product_id <=", value, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIn(List<Integer> values) {
            addCriterion("order_product_id in", values, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotIn(List<Integer> values) {
            addCriterion("order_product_id not in", values, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdBetween(Integer value1, Integer value2) {
            addCriterion("order_product_id between", value1, value2, "order_product_id");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_product_id not between", value1, value2, "order_product_id");
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
        
    	public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customer_id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customer_id");
            return (Criteria) this;
        }
        
    	public Criteria andCustomerAwardIsNull() {
            addCriterion("customer_award is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardIsNotNull() {
            addCriterion("customer_award is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardEqualTo(Double value) {
            addCriterion("customer_award =", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardNotEqualTo(Double value) {
            addCriterion("customer_award <>", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardGreaterThan(Double value) {
            addCriterion("customer_award >", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardGreaterThanOrEqualTo(Double value) {
            addCriterion("customer_award >=", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardLessThan(Double value) {
            addCriterion("customer_award <", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardLessThanOrEqualTo(Double value) {
            addCriterion("customer_award <=", value, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardIn(List<Double> values) {
            addCriterion("customer_award in", values, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardNotIn(List<Double> values) {
            addCriterion("customer_award not in", values, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardBetween(Double value1, Double value2) {
            addCriterion("customer_award between", value1, value2, "customer_award");
            return (Criteria) this;
        }

        public Criteria andCustomerAwardNotBetween(Double value1, Double value2) {
            addCriterion("customer_award not between", value1, value2, "customer_award");
            return (Criteria) this;
        }
        
    	public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "account_type");
            return (Criteria) this;
        }
        
    	public Criteria andProfitLevelIsNull() {
            addCriterion("profit_level is null");
            return (Criteria) this;
        }

        public Criteria andProfitLevelIsNotNull() {
            addCriterion("profit_level is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLevelEqualTo(Integer value) {
            addCriterion("profit_level =", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelNotEqualTo(Integer value) {
            addCriterion("profit_level <>", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelGreaterThan(Integer value) {
            addCriterion("profit_level >", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("profit_level >=", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelLessThan(Integer value) {
            addCriterion("profit_level <", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelLessThanOrEqualTo(Integer value) {
            addCriterion("profit_level <=", value, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelIn(List<Integer> values) {
            addCriterion("profit_level in", values, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelNotIn(List<Integer> values) {
            addCriterion("profit_level not in", values, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelBetween(Integer value1, Integer value2) {
            addCriterion("profit_level between", value1, value2, "profit_level");
            return (Criteria) this;
        }

        public Criteria andProfitLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("profit_level not between", value1, value2, "profit_level");
            return (Criteria) this;
        }
        
    	public Criteria andHandleStateIsNull() {
            addCriterion("handle_state is null");
            return (Criteria) this;
        }

        public Criteria andHandleStateIsNotNull() {
            addCriterion("handle_state is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStateEqualTo(Integer value) {
            addCriterion("handle_state =", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateNotEqualTo(Integer value) {
            addCriterion("handle_state <>", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateGreaterThan(Integer value) {
            addCriterion("handle_state >", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("handle_state >=", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateLessThan(Integer value) {
            addCriterion("handle_state <", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateLessThanOrEqualTo(Integer value) {
            addCriterion("handle_state <=", value, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateIn(List<Integer> values) {
            addCriterion("handle_state in", values, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateNotIn(List<Integer> values) {
            addCriterion("handle_state not in", values, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateBetween(Integer value1, Integer value2) {
            addCriterion("handle_state between", value1, value2, "handle_state");
            return (Criteria) this;
        }

        public Criteria andHandleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("handle_state not between", value1, value2, "handle_state");
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
        
    	public Criteria andProfitTimeIsNull() {
            addCriterion("profit_time is null");
            return (Criteria) this;
        }

        public Criteria andProfitTimeIsNotNull() {
            addCriterion("profit_time is not null");
            return (Criteria) this;
        }

        public Criteria andProfitTimeEqualTo(java.util.Date value) {
            addCriterion("profit_time =", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeNotEqualTo(java.util.Date value) {
            addCriterion("profit_time <>", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeGreaterThan(java.util.Date value) {
            addCriterion("profit_time >", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("profit_time >=", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeLessThan(java.util.Date value) {
            addCriterion("profit_time <", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("profit_time <=", value, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeIn(List<java.util.Date> values) {
            addCriterion("profit_time in", values, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeNotIn(List<java.util.Date> values) {
            addCriterion("profit_time not in", values, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("profit_time between", value1, value2, "profit_time");
            return (Criteria) this;
        }

        public Criteria andProfitTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("profit_time not between", value1, value2, "profit_time");
            return (Criteria) this;
        }
        
    	public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(java.util.Date value) {
            addCriterion("cancel_time =", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(java.util.Date value) {
            addCriterion("cancel_time <>", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(java.util.Date value) {
            addCriterion("cancel_time >", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("cancel_time >=", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(java.util.Date value) {
            addCriterion("cancel_time <", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("cancel_time <=", value, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<java.util.Date> values) {
            addCriterion("cancel_time in", values, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<java.util.Date> values) {
            addCriterion("cancel_time not in", values, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancel_time");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancel_time");
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