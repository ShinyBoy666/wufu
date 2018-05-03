package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CouponExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CouponExample() {
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
        
    	public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "coupon_type");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "coupon_type");
            return (Criteria) this;
        }
        
    	public Criteria andCouponApplyIdIsNull() {
            addCriterion("coupon_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdIsNotNull() {
            addCriterion("coupon_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdEqualTo(Integer value) {
            addCriterion("coupon_apply_id =", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdNotEqualTo(Integer value) {
            addCriterion("coupon_apply_id <>", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdGreaterThan(Integer value) {
            addCriterion("coupon_apply_id >", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_apply_id >=", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdLessThan(Integer value) {
            addCriterion("coupon_apply_id <", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_apply_id <=", value, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdIn(List<Integer> values) {
            addCriterion("coupon_apply_id in", values, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdNotIn(List<Integer> values) {
            addCriterion("coupon_apply_id not in", values, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_apply_id between", value1, value2, "coupon_apply_id");
            return (Criteria) this;
        }

        public Criteria andCouponApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_apply_id not between", value1, value2, "coupon_apply_id");
            return (Criteria) this;
        }
        
    	public Criteria andCouponCodeIsNull() {
            addCriterion("coupon_code is null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIsNotNull() {
            addCriterion("coupon_code is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCodeEqualTo(String value) {
            addCriterion("coupon_code =", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotEqualTo(String value) {
            addCriterion("coupon_code <>", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThan(String value) {
            addCriterion("coupon_code >", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_code >=", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThan(String value) {
            addCriterion("coupon_code <", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_code <=", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeIn(List<String> values) {
            addCriterion("coupon_code in", values, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotIn(List<String> values) {
            addCriterion("coupon_code not in", values, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeBetween(String value1, String value2) {
            addCriterion("coupon_code between", value1, value2, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotBetween(String value1, String value2) {
            addCriterion("coupon_code not between", value1, value2, "coupon_code");
            return (Criteria) this;
        }
        
    	public Criteria andCouponCodeLike(String value) {
            addCriterion("coupon_code like", value, "coupon_code");
            return (Criteria) this;
        }

        public Criteria andCouponCodeNotLike(String value) {
            addCriterion("coupon_code not like", value, "coupon_code");
            return (Criteria) this;
        }
    	public Criteria andCouponMoneyIsNull() {
            addCriterion("coupon_money is null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIsNotNull() {
            addCriterion("coupon_money is not null");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyEqualTo(Double value) {
            addCriterion("coupon_money =", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotEqualTo(Double value) {
            addCriterion("coupon_money <>", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThan(Double value) {
            addCriterion("coupon_money >", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("coupon_money >=", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThan(Double value) {
            addCriterion("coupon_money <", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyLessThanOrEqualTo(Double value) {
            addCriterion("coupon_money <=", value, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyIn(List<Double> values) {
            addCriterion("coupon_money in", values, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotIn(List<Double> values) {
            addCriterion("coupon_money not in", values, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyBetween(Double value1, Double value2) {
            addCriterion("coupon_money between", value1, value2, "coupon_money");
            return (Criteria) this;
        }

        public Criteria andCouponMoneyNotBetween(Double value1, Double value2) {
            addCriterion("coupon_money not between", value1, value2, "coupon_money");
            return (Criteria) this;
        }
        
    	public Criteria andOrderMoneyIsNull() {
            addCriterion("order_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNotNull() {
            addCriterion("order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyEqualTo(Double value) {
            addCriterion("order_money =", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(Double value) {
            addCriterion("order_money <>", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(Double value) {
            addCriterion("order_money >", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("order_money >=", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(Double value) {
            addCriterion("order_money <", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(Double value) {
            addCriterion("order_money <=", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<Double> values) {
            addCriterion("order_money in", values, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<Double> values) {
            addCriterion("order_money not in", values, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(Double value1, Double value2) {
            addCriterion("order_money between", value1, value2, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(Double value1, Double value2) {
            addCriterion("order_money not between", value1, value2, "order_money");
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
        
    	public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(java.util.Date value) {
            addCriterion("add_time =", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(java.util.Date value) {
            addCriterion("add_time <>", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(java.util.Date value) {
            addCriterion("add_time >", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("add_time >=", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(java.util.Date value) {
            addCriterion("add_time <", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("add_time <=", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<java.util.Date> values) {
            addCriterion("add_time in", values, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<java.util.Date> values) {
            addCriterion("add_time not in", values, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("add_time between", value1, value2, "add_time");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("add_time not between", value1, value2, "add_time");
            return (Criteria) this;
        }
        
    	public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(java.util.Date value) {
            addCriterion("use_time =", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(java.util.Date value) {
            addCriterion("use_time <>", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(java.util.Date value) {
            addCriterion("use_time >", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("use_time >=", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(java.util.Date value) {
            addCriterion("use_time <", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("use_time <=", value, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<java.util.Date> values) {
            addCriterion("use_time in", values, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<java.util.Date> values) {
            addCriterion("use_time not in", values, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("use_time between", value1, value2, "use_time");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("use_time not between", value1, value2, "use_time");
            return (Criteria) this;
        }
        
    	public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(java.util.Date value) {
            addCriterion("begin_time =", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(java.util.Date value) {
            addCriterion("begin_time <>", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(java.util.Date value) {
            addCriterion("begin_time >", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_time >=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(java.util.Date value) {
            addCriterion("begin_time <", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_time <=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<java.util.Date> values) {
            addCriterion("begin_time in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<java.util.Date> values) {
            addCriterion("begin_time not in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_time between", value1, value2, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_time not between", value1, value2, "begin_time");
            return (Criteria) this;
        }
        
    	public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(java.util.Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(java.util.Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(java.util.Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(java.util.Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<java.util.Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<java.util.Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
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