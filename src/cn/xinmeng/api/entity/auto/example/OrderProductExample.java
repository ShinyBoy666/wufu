package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class OrderProductExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public OrderProductExample() {
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
        
    	public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (Criteria) this;
        }
        
    	public Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
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
        
    	public Criteria andProfitFirstIsNull() {
            addCriterion("profit_first is null");
            return (Criteria) this;
        }

        public Criteria andProfitFirstIsNotNull() {
            addCriterion("profit_first is not null");
            return (Criteria) this;
        }

        public Criteria andProfitFirstEqualTo(Double value) {
            addCriterion("profit_first =", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstNotEqualTo(Double value) {
            addCriterion("profit_first <>", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstGreaterThan(Double value) {
            addCriterion("profit_first >", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstGreaterThanOrEqualTo(Double value) {
            addCriterion("profit_first >=", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstLessThan(Double value) {
            addCriterion("profit_first <", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstLessThanOrEqualTo(Double value) {
            addCriterion("profit_first <=", value, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstIn(List<Double> values) {
            addCriterion("profit_first in", values, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstNotIn(List<Double> values) {
            addCriterion("profit_first not in", values, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstBetween(Double value1, Double value2) {
            addCriterion("profit_first between", value1, value2, "profit_first");
            return (Criteria) this;
        }

        public Criteria andProfitFirstNotBetween(Double value1, Double value2) {
            addCriterion("profit_first not between", value1, value2, "profit_first");
            return (Criteria) this;
        }
        
    	public Criteria andProfitSecondIsNull() {
            addCriterion("profit_second is null");
            return (Criteria) this;
        }

        public Criteria andProfitSecondIsNotNull() {
            addCriterion("profit_second is not null");
            return (Criteria) this;
        }

        public Criteria andProfitSecondEqualTo(Double value) {
            addCriterion("profit_second =", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondNotEqualTo(Double value) {
            addCriterion("profit_second <>", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondGreaterThan(Double value) {
            addCriterion("profit_second >", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondGreaterThanOrEqualTo(Double value) {
            addCriterion("profit_second >=", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondLessThan(Double value) {
            addCriterion("profit_second <", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondLessThanOrEqualTo(Double value) {
            addCriterion("profit_second <=", value, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondIn(List<Double> values) {
            addCriterion("profit_second in", values, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondNotIn(List<Double> values) {
            addCriterion("profit_second not in", values, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondBetween(Double value1, Double value2) {
            addCriterion("profit_second between", value1, value2, "profit_second");
            return (Criteria) this;
        }

        public Criteria andProfitSecondNotBetween(Double value1, Double value2) {
            addCriterion("profit_second not between", value1, value2, "profit_second");
            return (Criteria) this;
        }
        
    	public Criteria andProfitThirdIsNull() {
            addCriterion("profit_third is null");
            return (Criteria) this;
        }

        public Criteria andProfitThirdIsNotNull() {
            addCriterion("profit_third is not null");
            return (Criteria) this;
        }

        public Criteria andProfitThirdEqualTo(Double value) {
            addCriterion("profit_third =", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdNotEqualTo(Double value) {
            addCriterion("profit_third <>", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdGreaterThan(Double value) {
            addCriterion("profit_third >", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdGreaterThanOrEqualTo(Double value) {
            addCriterion("profit_third >=", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdLessThan(Double value) {
            addCriterion("profit_third <", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdLessThanOrEqualTo(Double value) {
            addCriterion("profit_third <=", value, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdIn(List<Double> values) {
            addCriterion("profit_third in", values, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdNotIn(List<Double> values) {
            addCriterion("profit_third not in", values, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdBetween(Double value1, Double value2) {
            addCriterion("profit_third between", value1, value2, "profit_third");
            return (Criteria) this;
        }

        public Criteria andProfitThirdNotBetween(Double value1, Double value2) {
            addCriterion("profit_third not between", value1, value2, "profit_third");
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
        
    	public Criteria andProductDiscountMoneyIsNull() {
            addCriterion("product_discount_money is null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyIsNotNull() {
            addCriterion("product_discount_money is not null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyEqualTo(Double value) {
            addCriterion("product_discount_money =", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyNotEqualTo(Double value) {
            addCriterion("product_discount_money <>", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyGreaterThan(Double value) {
            addCriterion("product_discount_money >", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("product_discount_money >=", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyLessThan(Double value) {
            addCriterion("product_discount_money <", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyLessThanOrEqualTo(Double value) {
            addCriterion("product_discount_money <=", value, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyIn(List<Double> values) {
            addCriterion("product_discount_money in", values, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyNotIn(List<Double> values) {
            addCriterion("product_discount_money not in", values, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyBetween(Double value1, Double value2) {
            addCriterion("product_discount_money between", value1, value2, "product_discount_money");
            return (Criteria) this;
        }

        public Criteria andProductDiscountMoneyNotBetween(Double value1, Double value2) {
            addCriterion("product_discount_money not between", value1, value2, "product_discount_money");
            return (Criteria) this;
        }
        
    	public Criteria andProductPayMoneyIsNull() {
            addCriterion("product_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyIsNotNull() {
            addCriterion("product_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyEqualTo(Double value) {
            addCriterion("product_pay_money =", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyNotEqualTo(Double value) {
            addCriterion("product_pay_money <>", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyGreaterThan(Double value) {
            addCriterion("product_pay_money >", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("product_pay_money >=", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyLessThan(Double value) {
            addCriterion("product_pay_money <", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyLessThanOrEqualTo(Double value) {
            addCriterion("product_pay_money <=", value, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyIn(List<Double> values) {
            addCriterion("product_pay_money in", values, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyNotIn(List<Double> values) {
            addCriterion("product_pay_money not in", values, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyBetween(Double value1, Double value2) {
            addCriterion("product_pay_money between", value1, value2, "product_pay_money");
            return (Criteria) this;
        }

        public Criteria andProductPayMoneyNotBetween(Double value1, Double value2) {
            addCriterion("product_pay_money not between", value1, value2, "product_pay_money");
            return (Criteria) this;
        }
        
    	public Criteria andProductStateIsNull() {
            addCriterion("product_state is null");
            return (Criteria) this;
        }

        public Criteria andProductStateIsNotNull() {
            addCriterion("product_state is not null");
            return (Criteria) this;
        }

        public Criteria andProductStateEqualTo(Integer value) {
            addCriterion("product_state =", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateNotEqualTo(Integer value) {
            addCriterion("product_state <>", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThan(Integer value) {
            addCriterion("product_state >", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_state >=", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThan(Integer value) {
            addCriterion("product_state <", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateLessThanOrEqualTo(Integer value) {
            addCriterion("product_state <=", value, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateIn(List<Integer> values) {
            addCriterion("product_state in", values, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateNotIn(List<Integer> values) {
            addCriterion("product_state not in", values, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateBetween(Integer value1, Integer value2) {
            addCriterion("product_state between", value1, value2, "product_state");
            return (Criteria) this;
        }

        public Criteria andProductStateNotBetween(Integer value1, Integer value2) {
            addCriterion("product_state not between", value1, value2, "product_state");
            return (Criteria) this;
        }
        
    	public Criteria andIsDeliveryIsNull() {
            addCriterion("is_delivery is null");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryIsNotNull() {
            addCriterion("is_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryEqualTo(Integer value) {
            addCriterion("is_delivery =", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryNotEqualTo(Integer value) {
            addCriterion("is_delivery <>", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryGreaterThan(Integer value) {
            addCriterion("is_delivery >", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delivery >=", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryLessThan(Integer value) {
            addCriterion("is_delivery <", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryLessThanOrEqualTo(Integer value) {
            addCriterion("is_delivery <=", value, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryIn(List<Integer> values) {
            addCriterion("is_delivery in", values, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryNotIn(List<Integer> values) {
            addCriterion("is_delivery not in", values, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryBetween(Integer value1, Integer value2) {
            addCriterion("is_delivery between", value1, value2, "is_delivery");
            return (Criteria) this;
        }

        public Criteria andIsDeliveryNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delivery not between", value1, value2, "is_delivery");
            return (Criteria) this;
        }
        
    	public Criteria andIsCommentIsNull() {
            addCriterion("is_comment is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNotNull() {
            addCriterion("is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentEqualTo(Integer value) {
            addCriterion("is_comment =", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotEqualTo(Integer value) {
            addCriterion("is_comment <>", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThan(Integer value) {
            addCriterion("is_comment >", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_comment >=", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThan(Integer value) {
            addCriterion("is_comment <", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThanOrEqualTo(Integer value) {
            addCriterion("is_comment <=", value, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentIn(List<Integer> values) {
            addCriterion("is_comment in", values, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotIn(List<Integer> values) {
            addCriterion("is_comment not in", values, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentBetween(Integer value1, Integer value2) {
            addCriterion("is_comment between", value1, value2, "is_comment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_comment not between", value1, value2, "is_comment");
            return (Criteria) this;
        }
        
    	public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(java.util.Date value) {
            addCriterion("delivery_time =", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(java.util.Date value) {
            addCriterion("delivery_time <>", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(java.util.Date value) {
            addCriterion("delivery_time >", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("delivery_time >=", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(java.util.Date value) {
            addCriterion("delivery_time <", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("delivery_time <=", value, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<java.util.Date> values) {
            addCriterion("delivery_time in", values, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<java.util.Date> values) {
            addCriterion("delivery_time not in", values, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("delivery_time between", value1, value2, "delivery_time");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("delivery_time not between", value1, value2, "delivery_time");
            return (Criteria) this;
        }
        
    	public Criteria andActivityProductIdIsNull() {
            addCriterion("activity_product_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdIsNotNull() {
            addCriterion("activity_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdEqualTo(Integer value) {
            addCriterion("activity_product_id =", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdNotEqualTo(Integer value) {
            addCriterion("activity_product_id <>", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdGreaterThan(Integer value) {
            addCriterion("activity_product_id >", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_product_id >=", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdLessThan(Integer value) {
            addCriterion("activity_product_id <", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_product_id <=", value, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdIn(List<Integer> values) {
            addCriterion("activity_product_id in", values, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdNotIn(List<Integer> values) {
            addCriterion("activity_product_id not in", values, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_product_id between", value1, value2, "activity_product_id");
            return (Criteria) this;
        }

        public Criteria andActivityProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_product_id not between", value1, value2, "activity_product_id");
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