package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ProductQuantityRecordExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ProductQuantityRecordExample() {
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
    	public Criteria andChangeTypeIsNull() {
            addCriterion("change_type is null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIsNotNull() {
            addCriterion("change_type is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTypeEqualTo(Integer value) {
            addCriterion("change_type =", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotEqualTo(Integer value) {
            addCriterion("change_type <>", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThan(Integer value) {
            addCriterion("change_type >", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_type >=", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThan(Integer value) {
            addCriterion("change_type <", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("change_type <=", value, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeIn(List<Integer> values) {
            addCriterion("change_type in", values, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotIn(List<Integer> values) {
            addCriterion("change_type not in", values, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeBetween(Integer value1, Integer value2) {
            addCriterion("change_type between", value1, value2, "change_type");
            return (Criteria) this;
        }

        public Criteria andChangeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("change_type not between", value1, value2, "change_type");
            return (Criteria) this;
        }
        
    	public Criteria andOldActualQuantityIsNull() {
            addCriterion("old_actual_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityIsNotNull() {
            addCriterion("old_actual_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityEqualTo(Integer value) {
            addCriterion("old_actual_quantity =", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityNotEqualTo(Integer value) {
            addCriterion("old_actual_quantity <>", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityGreaterThan(Integer value) {
            addCriterion("old_actual_quantity >", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_actual_quantity >=", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityLessThan(Integer value) {
            addCriterion("old_actual_quantity <", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("old_actual_quantity <=", value, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityIn(List<Integer> values) {
            addCriterion("old_actual_quantity in", values, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityNotIn(List<Integer> values) {
            addCriterion("old_actual_quantity not in", values, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityBetween(Integer value1, Integer value2) {
            addCriterion("old_actual_quantity between", value1, value2, "old_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andOldActualQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("old_actual_quantity not between", value1, value2, "old_actual_quantity");
            return (Criteria) this;
        }
        
    	public Criteria andChangeActualQuantityIsNull() {
            addCriterion("change_actual_quantity is null");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityIsNotNull() {
            addCriterion("change_actual_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityEqualTo(Integer value) {
            addCriterion("change_actual_quantity =", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityNotEqualTo(Integer value) {
            addCriterion("change_actual_quantity <>", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityGreaterThan(Integer value) {
            addCriterion("change_actual_quantity >", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("change_actual_quantity >=", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityLessThan(Integer value) {
            addCriterion("change_actual_quantity <", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("change_actual_quantity <=", value, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityIn(List<Integer> values) {
            addCriterion("change_actual_quantity in", values, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityNotIn(List<Integer> values) {
            addCriterion("change_actual_quantity not in", values, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityBetween(Integer value1, Integer value2) {
            addCriterion("change_actual_quantity between", value1, value2, "change_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andChangeActualQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("change_actual_quantity not between", value1, value2, "change_actual_quantity");
            return (Criteria) this;
        }
        
    	public Criteria andNowActualQuantityIsNull() {
            addCriterion("now_actual_quantity is null");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityIsNotNull() {
            addCriterion("now_actual_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityEqualTo(Integer value) {
            addCriterion("now_actual_quantity =", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityNotEqualTo(Integer value) {
            addCriterion("now_actual_quantity <>", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityGreaterThan(Integer value) {
            addCriterion("now_actual_quantity >", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_actual_quantity >=", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityLessThan(Integer value) {
            addCriterion("now_actual_quantity <", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("now_actual_quantity <=", value, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityIn(List<Integer> values) {
            addCriterion("now_actual_quantity in", values, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityNotIn(List<Integer> values) {
            addCriterion("now_actual_quantity not in", values, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityBetween(Integer value1, Integer value2) {
            addCriterion("now_actual_quantity between", value1, value2, "now_actual_quantity");
            return (Criteria) this;
        }

        public Criteria andNowActualQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("now_actual_quantity not between", value1, value2, "now_actual_quantity");
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