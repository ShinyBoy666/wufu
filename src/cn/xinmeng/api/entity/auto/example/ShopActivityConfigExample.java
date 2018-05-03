package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ShopActivityConfigExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ShopActivityConfigExample() {
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
        
    	public Criteria andCanRandomIsNull() {
            addCriterion("can_random is null");
            return (Criteria) this;
        }

        public Criteria andCanRandomIsNotNull() {
            addCriterion("can_random is not null");
            return (Criteria) this;
        }

        public Criteria andCanRandomEqualTo(Integer value) {
            addCriterion("can_random =", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomNotEqualTo(Integer value) {
            addCriterion("can_random <>", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomGreaterThan(Integer value) {
            addCriterion("can_random >", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_random >=", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomLessThan(Integer value) {
            addCriterion("can_random <", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomLessThanOrEqualTo(Integer value) {
            addCriterion("can_random <=", value, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomIn(List<Integer> values) {
            addCriterion("can_random in", values, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomNotIn(List<Integer> values) {
            addCriterion("can_random not in", values, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomBetween(Integer value1, Integer value2) {
            addCriterion("can_random between", value1, value2, "can_random");
            return (Criteria) this;
        }

        public Criteria andCanRandomNotBetween(Integer value1, Integer value2) {
            addCriterion("can_random not between", value1, value2, "can_random");
            return (Criteria) this;
        }
        
    	public Criteria andMaxMoneyIsNull() {
            addCriterion("max_money is null");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyIsNotNull() {
            addCriterion("max_money is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyEqualTo(Double value) {
            addCriterion("max_money =", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotEqualTo(Double value) {
            addCriterion("max_money <>", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyGreaterThan(Double value) {
            addCriterion("max_money >", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("max_money >=", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyLessThan(Double value) {
            addCriterion("max_money <", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyLessThanOrEqualTo(Double value) {
            addCriterion("max_money <=", value, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyIn(List<Double> values) {
            addCriterion("max_money in", values, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotIn(List<Double> values) {
            addCriterion("max_money not in", values, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyBetween(Double value1, Double value2) {
            addCriterion("max_money between", value1, value2, "max_money");
            return (Criteria) this;
        }

        public Criteria andMaxMoneyNotBetween(Double value1, Double value2) {
            addCriterion("max_money not between", value1, value2, "max_money");
            return (Criteria) this;
        }
        
    	public Criteria andMinMoneyIsNull() {
            addCriterion("min_money is null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyIsNotNull() {
            addCriterion("min_money is not null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyEqualTo(Double value) {
            addCriterion("min_money =", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotEqualTo(Double value) {
            addCriterion("min_money <>", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyGreaterThan(Double value) {
            addCriterion("min_money >", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("min_money >=", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyLessThan(Double value) {
            addCriterion("min_money <", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyLessThanOrEqualTo(Double value) {
            addCriterion("min_money <=", value, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyIn(List<Double> values) {
            addCriterion("min_money in", values, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotIn(List<Double> values) {
            addCriterion("min_money not in", values, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyBetween(Double value1, Double value2) {
            addCriterion("min_money between", value1, value2, "min_money");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotBetween(Double value1, Double value2) {
            addCriterion("min_money not between", value1, value2, "min_money");
            return (Criteria) this;
        }
        
    	public Criteria andCanFullReduceIsNull() {
            addCriterion("can_full_reduce is null");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceIsNotNull() {
            addCriterion("can_full_reduce is not null");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceEqualTo(Integer value) {
            addCriterion("can_full_reduce =", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceNotEqualTo(Integer value) {
            addCriterion("can_full_reduce <>", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceGreaterThan(Integer value) {
            addCriterion("can_full_reduce >", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_full_reduce >=", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceLessThan(Integer value) {
            addCriterion("can_full_reduce <", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceLessThanOrEqualTo(Integer value) {
            addCriterion("can_full_reduce <=", value, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceIn(List<Integer> values) {
            addCriterion("can_full_reduce in", values, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceNotIn(List<Integer> values) {
            addCriterion("can_full_reduce not in", values, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceBetween(Integer value1, Integer value2) {
            addCriterion("can_full_reduce between", value1, value2, "can_full_reduce");
            return (Criteria) this;
        }

        public Criteria andCanFullReduceNotBetween(Integer value1, Integer value2) {
            addCriterion("can_full_reduce not between", value1, value2, "can_full_reduce");
            return (Criteria) this;
        }
        
    	public Criteria andFullMoneyIsNull() {
            addCriterion("full_money is null");
            return (Criteria) this;
        }

        public Criteria andFullMoneyIsNotNull() {
            addCriterion("full_money is not null");
            return (Criteria) this;
        }

        public Criteria andFullMoneyEqualTo(String value) {
            addCriterion("full_money =", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyNotEqualTo(String value) {
            addCriterion("full_money <>", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyGreaterThan(String value) {
            addCriterion("full_money >", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("full_money >=", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyLessThan(String value) {
            addCriterion("full_money <", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyLessThanOrEqualTo(String value) {
            addCriterion("full_money <=", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyIn(List<String> values) {
            addCriterion("full_money in", values, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyNotIn(List<String> values) {
            addCriterion("full_money not in", values, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyBetween(String value1, String value2) {
            addCriterion("full_money between", value1, value2, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyNotBetween(String value1, String value2) {
            addCriterion("full_money not between", value1, value2, "full_money");
            return (Criteria) this;
        }
        
    	public Criteria andFullMoneyLike(String value) {
            addCriterion("full_money like", value, "full_money");
            return (Criteria) this;
        }

        public Criteria andFullMoneyNotLike(String value) {
            addCriterion("full_money not like", value, "full_money");
            return (Criteria) this;
        }
    	public Criteria andReduceMoneyIsNull() {
            addCriterion("reduce_money is null");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyIsNotNull() {
            addCriterion("reduce_money is not null");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyEqualTo(String value) {
            addCriterion("reduce_money =", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotEqualTo(String value) {
            addCriterion("reduce_money <>", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyGreaterThan(String value) {
            addCriterion("reduce_money >", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("reduce_money >=", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyLessThan(String value) {
            addCriterion("reduce_money <", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyLessThanOrEqualTo(String value) {
            addCriterion("reduce_money <=", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyIn(List<String> values) {
            addCriterion("reduce_money in", values, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotIn(List<String> values) {
            addCriterion("reduce_money not in", values, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyBetween(String value1, String value2) {
            addCriterion("reduce_money between", value1, value2, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotBetween(String value1, String value2) {
            addCriterion("reduce_money not between", value1, value2, "reduce_money");
            return (Criteria) this;
        }
        
    	public Criteria andReduceMoneyLike(String value) {
            addCriterion("reduce_money like", value, "reduce_money");
            return (Criteria) this;
        }

        public Criteria andReduceMoneyNotLike(String value) {
            addCriterion("reduce_money not like", value, "reduce_money");
            return (Criteria) this;
        }
    	public Criteria andCanSaleIsNull() {
            addCriterion("can_sale is null");
            return (Criteria) this;
        }

        public Criteria andCanSaleIsNotNull() {
            addCriterion("can_sale is not null");
            return (Criteria) this;
        }

        public Criteria andCanSaleEqualTo(Integer value) {
            addCriterion("can_sale =", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotEqualTo(Integer value) {
            addCriterion("can_sale <>", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleGreaterThan(Integer value) {
            addCriterion("can_sale >", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_sale >=", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleLessThan(Integer value) {
            addCriterion("can_sale <", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleLessThanOrEqualTo(Integer value) {
            addCriterion("can_sale <=", value, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleIn(List<Integer> values) {
            addCriterion("can_sale in", values, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotIn(List<Integer> values) {
            addCriterion("can_sale not in", values, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleBetween(Integer value1, Integer value2) {
            addCriterion("can_sale between", value1, value2, "can_sale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("can_sale not between", value1, value2, "can_sale");
            return (Criteria) this;
        }
        
    	public Criteria andSaleIsNull() {
            addCriterion("sale is null");
            return (Criteria) this;
        }

        public Criteria andSaleIsNotNull() {
            addCriterion("sale is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEqualTo(Double value) {
            addCriterion("sale =", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotEqualTo(Double value) {
            addCriterion("sale <>", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleGreaterThan(Double value) {
            addCriterion("sale >", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleGreaterThanOrEqualTo(Double value) {
            addCriterion("sale >=", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleLessThan(Double value) {
            addCriterion("sale <", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleLessThanOrEqualTo(Double value) {
            addCriterion("sale <=", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleIn(List<Double> values) {
            addCriterion("sale in", values, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotIn(List<Double> values) {
            addCriterion("sale not in", values, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleBetween(Double value1, Double value2) {
            addCriterion("sale between", value1, value2, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotBetween(Double value1, Double value2) {
            addCriterion("sale not between", value1, value2, "sale");
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