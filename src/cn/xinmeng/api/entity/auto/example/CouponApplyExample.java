package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CouponApplyExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CouponApplyExample() {
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
        
    	public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "coupon_name");
            return (Criteria) this;
        }
        
    	public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "coupon_name");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "coupon_name");
            return (Criteria) this;
        }
    	public Criteria andCouponDescIsNull() {
            addCriterion("coupon_desc is null");
            return (Criteria) this;
        }

        public Criteria andCouponDescIsNotNull() {
            addCriterion("coupon_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCouponDescEqualTo(String value) {
            addCriterion("coupon_desc =", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotEqualTo(String value) {
            addCriterion("coupon_desc <>", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThan(String value) {
            addCriterion("coupon_desc >", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_desc >=", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThan(String value) {
            addCriterion("coupon_desc <", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThanOrEqualTo(String value) {
            addCriterion("coupon_desc <=", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescIn(List<String> values) {
            addCriterion("coupon_desc in", values, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotIn(List<String> values) {
            addCriterion("coupon_desc not in", values, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescBetween(String value1, String value2) {
            addCriterion("coupon_desc between", value1, value2, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotBetween(String value1, String value2) {
            addCriterion("coupon_desc not between", value1, value2, "coupon_desc");
            return (Criteria) this;
        }
        
    	public Criteria andCouponDescLike(String value) {
            addCriterion("coupon_desc like", value, "coupon_desc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotLike(String value) {
            addCriterion("coupon_desc not like", value, "coupon_desc");
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
        
    	public Criteria andFirstIdIsNull() {
            addCriterion("first_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstIdIsNotNull() {
            addCriterion("first_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIdEqualTo(Integer value) {
            addCriterion("first_id =", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotEqualTo(Integer value) {
            addCriterion("first_id <>", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThan(Integer value) {
            addCriterion("first_id >", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_id >=", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThan(Integer value) {
            addCriterion("first_id <", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThanOrEqualTo(Integer value) {
            addCriterion("first_id <=", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdIn(List<Integer> values) {
            addCriterion("first_id in", values, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotIn(List<Integer> values) {
            addCriterion("first_id not in", values, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdBetween(Integer value1, Integer value2) {
            addCriterion("first_id between", value1, value2, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotBetween(Integer value1, Integer value2) {
            addCriterion("first_id not between", value1, value2, "first_id");
            return (Criteria) this;
        }
        
    	public Criteria andSecondIdIsNull() {
            addCriterion("second_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondIdIsNotNull() {
            addCriterion("second_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondIdEqualTo(Integer value) {
            addCriterion("second_id =", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotEqualTo(Integer value) {
            addCriterion("second_id <>", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThan(Integer value) {
            addCriterion("second_id >", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_id >=", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThan(Integer value) {
            addCriterion("second_id <", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThanOrEqualTo(Integer value) {
            addCriterion("second_id <=", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdIn(List<Integer> values) {
            addCriterion("second_id in", values, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotIn(List<Integer> values) {
            addCriterion("second_id not in", values, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdBetween(Integer value1, Integer value2) {
            addCriterion("second_id between", value1, value2, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotBetween(Integer value1, Integer value2) {
            addCriterion("second_id not between", value1, value2, "second_id");
            return (Criteria) this;
        }
        
    	public Criteria andThridIdIsNull() {
            addCriterion("thrid_id is null");
            return (Criteria) this;
        }

        public Criteria andThridIdIsNotNull() {
            addCriterion("thrid_id is not null");
            return (Criteria) this;
        }

        public Criteria andThridIdEqualTo(Integer value) {
            addCriterion("thrid_id =", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdNotEqualTo(Integer value) {
            addCriterion("thrid_id <>", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdGreaterThan(Integer value) {
            addCriterion("thrid_id >", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("thrid_id >=", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdLessThan(Integer value) {
            addCriterion("thrid_id <", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdLessThanOrEqualTo(Integer value) {
            addCriterion("thrid_id <=", value, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdIn(List<Integer> values) {
            addCriterion("thrid_id in", values, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdNotIn(List<Integer> values) {
            addCriterion("thrid_id not in", values, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdBetween(Integer value1, Integer value2) {
            addCriterion("thrid_id between", value1, value2, "thrid_id");
            return (Criteria) this;
        }

        public Criteria andThridIdNotBetween(Integer value1, Integer value2) {
            addCriterion("thrid_id not between", value1, value2, "thrid_id");
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
        
    	public Criteria andCouponNumberIsNull() {
            addCriterion("coupon_number is null");
            return (Criteria) this;
        }

        public Criteria andCouponNumberIsNotNull() {
            addCriterion("coupon_number is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNumberEqualTo(Integer value) {
            addCriterion("coupon_number =", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberNotEqualTo(Integer value) {
            addCriterion("coupon_number <>", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberGreaterThan(Integer value) {
            addCriterion("coupon_number >", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_number >=", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberLessThan(Integer value) {
            addCriterion("coupon_number <", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_number <=", value, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberIn(List<Integer> values) {
            addCriterion("coupon_number in", values, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberNotIn(List<Integer> values) {
            addCriterion("coupon_number not in", values, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberBetween(Integer value1, Integer value2) {
            addCriterion("coupon_number between", value1, value2, "coupon_number");
            return (Criteria) this;
        }

        public Criteria andCouponNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_number not between", value1, value2, "coupon_number");
            return (Criteria) this;
        }
        
    	public Criteria andCouponReceiveNumberIsNull() {
            addCriterion("coupon_receive_number is null");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberIsNotNull() {
            addCriterion("coupon_receive_number is not null");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberEqualTo(Integer value) {
            addCriterion("coupon_receive_number =", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberNotEqualTo(Integer value) {
            addCriterion("coupon_receive_number <>", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberGreaterThan(Integer value) {
            addCriterion("coupon_receive_number >", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_receive_number >=", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberLessThan(Integer value) {
            addCriterion("coupon_receive_number <", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_receive_number <=", value, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberIn(List<Integer> values) {
            addCriterion("coupon_receive_number in", values, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberNotIn(List<Integer> values) {
            addCriterion("coupon_receive_number not in", values, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberBetween(Integer value1, Integer value2) {
            addCriterion("coupon_receive_number between", value1, value2, "coupon_receive_number");
            return (Criteria) this;
        }

        public Criteria andCouponReceiveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_receive_number not between", value1, value2, "coupon_receive_number");
            return (Criteria) this;
        }
        
    	public Criteria andMaxGetNumberIsNull() {
            addCriterion("max_get_number is null");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberIsNotNull() {
            addCriterion("max_get_number is not null");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberEqualTo(Integer value) {
            addCriterion("max_get_number =", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberNotEqualTo(Integer value) {
            addCriterion("max_get_number <>", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberGreaterThan(Integer value) {
            addCriterion("max_get_number >", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_get_number >=", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberLessThan(Integer value) {
            addCriterion("max_get_number <", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberLessThanOrEqualTo(Integer value) {
            addCriterion("max_get_number <=", value, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberIn(List<Integer> values) {
            addCriterion("max_get_number in", values, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberNotIn(List<Integer> values) {
            addCriterion("max_get_number not in", values, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberBetween(Integer value1, Integer value2) {
            addCriterion("max_get_number between", value1, value2, "max_get_number");
            return (Criteria) this;
        }

        public Criteria andMaxGetNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("max_get_number not between", value1, value2, "max_get_number");
            return (Criteria) this;
        }
        
    	public Criteria andMaxUseNumberIsNull() {
            addCriterion("max_use_number is null");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberIsNotNull() {
            addCriterion("max_use_number is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberEqualTo(Integer value) {
            addCriterion("max_use_number =", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberNotEqualTo(Integer value) {
            addCriterion("max_use_number <>", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberGreaterThan(Integer value) {
            addCriterion("max_use_number >", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_use_number >=", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberLessThan(Integer value) {
            addCriterion("max_use_number <", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberLessThanOrEqualTo(Integer value) {
            addCriterion("max_use_number <=", value, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberIn(List<Integer> values) {
            addCriterion("max_use_number in", values, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberNotIn(List<Integer> values) {
            addCriterion("max_use_number not in", values, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberBetween(Integer value1, Integer value2) {
            addCriterion("max_use_number between", value1, value2, "max_use_number");
            return (Criteria) this;
        }

        public Criteria andMaxUseNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("max_use_number not between", value1, value2, "max_use_number");
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
        
    	public Criteria andCanUseDayIsNull() {
            addCriterion("can_use_day is null");
            return (Criteria) this;
        }

        public Criteria andCanUseDayIsNotNull() {
            addCriterion("can_use_day is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseDayEqualTo(String value) {
            addCriterion("can_use_day =", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayNotEqualTo(String value) {
            addCriterion("can_use_day <>", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayGreaterThan(String value) {
            addCriterion("can_use_day >", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayGreaterThanOrEqualTo(String value) {
            addCriterion("can_use_day >=", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayLessThan(String value) {
            addCriterion("can_use_day <", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayLessThanOrEqualTo(String value) {
            addCriterion("can_use_day <=", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayIn(List<String> values) {
            addCriterion("can_use_day in", values, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayNotIn(List<String> values) {
            addCriterion("can_use_day not in", values, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayBetween(String value1, String value2) {
            addCriterion("can_use_day between", value1, value2, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayNotBetween(String value1, String value2) {
            addCriterion("can_use_day not between", value1, value2, "can_use_day");
            return (Criteria) this;
        }
        
    	public Criteria andCanUseDayLike(String value) {
            addCriterion("can_use_day like", value, "can_use_day");
            return (Criteria) this;
        }

        public Criteria andCanUseDayNotLike(String value) {
            addCriterion("can_use_day not like", value, "can_use_day");
            return (Criteria) this;
        }
    	public Criteria andCanUseHourIsNull() {
            addCriterion("can_use_hour is null");
            return (Criteria) this;
        }

        public Criteria andCanUseHourIsNotNull() {
            addCriterion("can_use_hour is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseHourEqualTo(String value) {
            addCriterion("can_use_hour =", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourNotEqualTo(String value) {
            addCriterion("can_use_hour <>", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourGreaterThan(String value) {
            addCriterion("can_use_hour >", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourGreaterThanOrEqualTo(String value) {
            addCriterion("can_use_hour >=", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourLessThan(String value) {
            addCriterion("can_use_hour <", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourLessThanOrEqualTo(String value) {
            addCriterion("can_use_hour <=", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourIn(List<String> values) {
            addCriterion("can_use_hour in", values, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourNotIn(List<String> values) {
            addCriterion("can_use_hour not in", values, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourBetween(String value1, String value2) {
            addCriterion("can_use_hour between", value1, value2, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourNotBetween(String value1, String value2) {
            addCriterion("can_use_hour not between", value1, value2, "can_use_hour");
            return (Criteria) this;
        }
        
    	public Criteria andCanUseHourLike(String value) {
            addCriterion("can_use_hour like", value, "can_use_hour");
            return (Criteria) this;
        }

        public Criteria andCanUseHourNotLike(String value) {
            addCriterion("can_use_hour not like", value, "can_use_hour");
            return (Criteria) this;
        }
    	public Criteria andExpiresModelIsNull() {
            addCriterion("expires_model is null");
            return (Criteria) this;
        }

        public Criteria andExpiresModelIsNotNull() {
            addCriterion("expires_model is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresModelEqualTo(Integer value) {
            addCriterion("expires_model =", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelNotEqualTo(Integer value) {
            addCriterion("expires_model <>", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelGreaterThan(Integer value) {
            addCriterion("expires_model >", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("expires_model >=", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelLessThan(Integer value) {
            addCriterion("expires_model <", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelLessThanOrEqualTo(Integer value) {
            addCriterion("expires_model <=", value, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelIn(List<Integer> values) {
            addCriterion("expires_model in", values, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelNotIn(List<Integer> values) {
            addCriterion("expires_model not in", values, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelBetween(Integer value1, Integer value2) {
            addCriterion("expires_model between", value1, value2, "expires_model");
            return (Criteria) this;
        }

        public Criteria andExpiresModelNotBetween(Integer value1, Integer value2) {
            addCriterion("expires_model not between", value1, value2, "expires_model");
            return (Criteria) this;
        }
        
    	public Criteria andExpiresDaysIsNull() {
            addCriterion("expires_days is null");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysIsNotNull() {
            addCriterion("expires_days is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysEqualTo(Integer value) {
            addCriterion("expires_days =", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysNotEqualTo(Integer value) {
            addCriterion("expires_days <>", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysGreaterThan(Integer value) {
            addCriterion("expires_days >", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("expires_days >=", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysLessThan(Integer value) {
            addCriterion("expires_days <", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysLessThanOrEqualTo(Integer value) {
            addCriterion("expires_days <=", value, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysIn(List<Integer> values) {
            addCriterion("expires_days in", values, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysNotIn(List<Integer> values) {
            addCriterion("expires_days not in", values, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysBetween(Integer value1, Integer value2) {
            addCriterion("expires_days between", value1, value2, "expires_days");
            return (Criteria) this;
        }

        public Criteria andExpiresDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("expires_days not between", value1, value2, "expires_days");
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
        
    	public Criteria andIsCreateIsNull() {
            addCriterion("is_create is null");
            return (Criteria) this;
        }

        public Criteria andIsCreateIsNotNull() {
            addCriterion("is_create is not null");
            return (Criteria) this;
        }

        public Criteria andIsCreateEqualTo(Integer value) {
            addCriterion("is_create =", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateNotEqualTo(Integer value) {
            addCriterion("is_create <>", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateGreaterThan(Integer value) {
            addCriterion("is_create >", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_create >=", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateLessThan(Integer value) {
            addCriterion("is_create <", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateLessThanOrEqualTo(Integer value) {
            addCriterion("is_create <=", value, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateIn(List<Integer> values) {
            addCriterion("is_create in", values, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateNotIn(List<Integer> values) {
            addCriterion("is_create not in", values, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateBetween(Integer value1, Integer value2) {
            addCriterion("is_create between", value1, value2, "is_create");
            return (Criteria) this;
        }

        public Criteria andIsCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("is_create not between", value1, value2, "is_create");
            return (Criteria) this;
        }
        
    	public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
        
    	public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
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