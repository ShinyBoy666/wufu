package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ProductInfoExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ProductInfoExample() {
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
        
    	public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }
        
    	public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }
    	public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "product_name");
            return (Criteria) this;
        }
        
    	public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "product_name");
            return (Criteria) this;
        }
    	public Criteria andMetaKeywordsIsNull() {
            addCriterion("meta_keywords is null");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsIsNotNull() {
            addCriterion("meta_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsEqualTo(String value) {
            addCriterion("meta_keywords =", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsNotEqualTo(String value) {
            addCriterion("meta_keywords <>", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsGreaterThan(String value) {
            addCriterion("meta_keywords >", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("meta_keywords >=", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsLessThan(String value) {
            addCriterion("meta_keywords <", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsLessThanOrEqualTo(String value) {
            addCriterion("meta_keywords <=", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsIn(List<String> values) {
            addCriterion("meta_keywords in", values, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsNotIn(List<String> values) {
            addCriterion("meta_keywords not in", values, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsBetween(String value1, String value2) {
            addCriterion("meta_keywords between", value1, value2, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsNotBetween(String value1, String value2) {
            addCriterion("meta_keywords not between", value1, value2, "meta_keywords");
            return (Criteria) this;
        }
        
    	public Criteria andMetaKeywordsLike(String value) {
            addCriterion("meta_keywords like", value, "meta_keywords");
            return (Criteria) this;
        }

        public Criteria andMetaKeywordsNotLike(String value) {
            addCriterion("meta_keywords not like", value, "meta_keywords");
            return (Criteria) this;
        }
    	public Criteria andProductIntroductionIsNull() {
            addCriterion("product_introduction is null");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionIsNotNull() {
            addCriterion("product_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionEqualTo(String value) {
            addCriterion("product_introduction =", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotEqualTo(String value) {
            addCriterion("product_introduction <>", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionGreaterThan(String value) {
            addCriterion("product_introduction >", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("product_introduction >=", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionLessThan(String value) {
            addCriterion("product_introduction <", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionLessThanOrEqualTo(String value) {
            addCriterion("product_introduction <=", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionIn(List<String> values) {
            addCriterion("product_introduction in", values, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotIn(List<String> values) {
            addCriterion("product_introduction not in", values, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionBetween(String value1, String value2) {
            addCriterion("product_introduction between", value1, value2, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotBetween(String value1, String value2) {
            addCriterion("product_introduction not between", value1, value2, "product_introduction");
            return (Criteria) this;
        }
        
    	public Criteria andProductIntroductionLike(String value) {
            addCriterion("product_introduction like", value, "product_introduction");
            return (Criteria) this;
        }

        public Criteria andProductIntroductionNotLike(String value) {
            addCriterion("product_introduction not like", value, "product_introduction");
            return (Criteria) this;
        }
    	public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "category_id");
            return (Criteria) this;
        }
        
    	public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(Double value) {
            addCriterion("market_price =", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(Double value) {
            addCriterion("market_price <>", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(Double value) {
            addCriterion("market_price >", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("market_price >=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(Double value) {
            addCriterion("market_price <", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(Double value) {
            addCriterion("market_price <=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<Double> values) {
            addCriterion("market_price in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<Double> values) {
            addCriterion("market_price not in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(Double value1, Double value2) {
            addCriterion("market_price between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(Double value1, Double value2) {
            addCriterion("market_price not between", value1, value2, "market_price");
            return (Criteria) this;
        }
        
    	public Criteria andRetailPriceIsNull() {
            addCriterion("retail_price is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(Double value) {
            addCriterion("retail_price =", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(Double value) {
            addCriterion("retail_price <>", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(Double value) {
            addCriterion("retail_price >", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("retail_price >=", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(Double value) {
            addCriterion("retail_price <", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(Double value) {
            addCriterion("retail_price <=", value, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<Double> values) {
            addCriterion("retail_price in", values, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<Double> values) {
            addCriterion("retail_price not in", values, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(Double value1, Double value2) {
            addCriterion("retail_price between", value1, value2, "retail_price");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(Double value1, Double value2) {
            addCriterion("retail_price not between", value1, value2, "retail_price");
            return (Criteria) this;
        }
        
    	public Criteria andVipPriceIsNull() {
            addCriterion("vip_price is null");
            return (Criteria) this;
        }

        public Criteria andVipPriceIsNotNull() {
            addCriterion("vip_price is not null");
            return (Criteria) this;
        }

        public Criteria andVipPriceEqualTo(Double value) {
            addCriterion("vip_price =", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotEqualTo(Double value) {
            addCriterion("vip_price <>", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceGreaterThan(Double value) {
            addCriterion("vip_price >", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("vip_price >=", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceLessThan(Double value) {
            addCriterion("vip_price <", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceLessThanOrEqualTo(Double value) {
            addCriterion("vip_price <=", value, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceIn(List<Double> values) {
            addCriterion("vip_price in", values, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotIn(List<Double> values) {
            addCriterion("vip_price not in", values, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceBetween(Double value1, Double value2) {
            addCriterion("vip_price between", value1, value2, "vip_price");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotBetween(Double value1, Double value2) {
            addCriterion("vip_price not between", value1, value2, "vip_price");
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
        
    	public Criteria andIsRealynameIsNull() {
            addCriterion("is_realyname is null");
            return (Criteria) this;
        }

        public Criteria andIsRealynameIsNotNull() {
            addCriterion("is_realyname is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealynameEqualTo(Integer value) {
            addCriterion("is_realyname =", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameNotEqualTo(Integer value) {
            addCriterion("is_realyname <>", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameGreaterThan(Integer value) {
            addCriterion("is_realyname >", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_realyname >=", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameLessThan(Integer value) {
            addCriterion("is_realyname <", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameLessThanOrEqualTo(Integer value) {
            addCriterion("is_realyname <=", value, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameIn(List<Integer> values) {
            addCriterion("is_realyname in", values, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameNotIn(List<Integer> values) {
            addCriterion("is_realyname not in", values, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameBetween(Integer value1, Integer value2) {
            addCriterion("is_realyname between", value1, value2, "is_realyname");
            return (Criteria) this;
        }

        public Criteria andIsRealynameNotBetween(Integer value1, Integer value2) {
            addCriterion("is_realyname not between", value1, value2, "is_realyname");
            return (Criteria) this;
        }
        
    	public Criteria andIsHaveSkuIsNull() {
            addCriterion("is_have_sku is null");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuIsNotNull() {
            addCriterion("is_have_sku is not null");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuEqualTo(Integer value) {
            addCriterion("is_have_sku =", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuNotEqualTo(Integer value) {
            addCriterion("is_have_sku <>", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuGreaterThan(Integer value) {
            addCriterion("is_have_sku >", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_have_sku >=", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuLessThan(Integer value) {
            addCriterion("is_have_sku <", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuLessThanOrEqualTo(Integer value) {
            addCriterion("is_have_sku <=", value, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuIn(List<Integer> values) {
            addCriterion("is_have_sku in", values, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuNotIn(List<Integer> values) {
            addCriterion("is_have_sku not in", values, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuBetween(Integer value1, Integer value2) {
            addCriterion("is_have_sku between", value1, value2, "is_have_sku");
            return (Criteria) this;
        }

        public Criteria andIsHaveSkuNotBetween(Integer value1, Integer value2) {
            addCriterion("is_have_sku not between", value1, value2, "is_have_sku");
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
        
    	public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Integer value) {
            addCriterion("is_new =", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Integer value) {
            addCriterion("is_new <>", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Integer value) {
            addCriterion("is_new >", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_new >=", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Integer value) {
            addCriterion("is_new <", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Integer value) {
            addCriterion("is_new <=", value, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Integer> values) {
            addCriterion("is_new in", values, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Integer> values) {
            addCriterion("is_new not in", values, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Integer value1, Integer value2) {
            addCriterion("is_new between", value1, value2, "is_new");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Integer value1, Integer value2) {
            addCriterion("is_new not between", value1, value2, "is_new");
            return (Criteria) this;
        }
        
    	public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }
        
    	public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
        
    	public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "image_url");
            return (Criteria) this;
        }
        
    	public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "image_url");
            return (Criteria) this;
        }
    	public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Integer value) {
            addCriterion("view_count =", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Integer value) {
            addCriterion("view_count <>", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Integer value) {
            addCriterion("view_count >", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_count >=", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Integer value) {
            addCriterion("view_count <", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("view_count <=", value, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Integer> values) {
            addCriterion("view_count in", values, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Integer> values) {
            addCriterion("view_count not in", values, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Integer value1, Integer value2) {
            addCriterion("view_count between", value1, value2, "view_count");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("view_count not between", value1, value2, "view_count");
            return (Criteria) this;
        }
        
    	public Criteria andBuyVirtualCountIsNull() {
            addCriterion("buy_virtual_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountIsNotNull() {
            addCriterion("buy_virtual_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountEqualTo(Integer value) {
            addCriterion("buy_virtual_count =", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountNotEqualTo(Integer value) {
            addCriterion("buy_virtual_count <>", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountGreaterThan(Integer value) {
            addCriterion("buy_virtual_count >", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_virtual_count >=", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountLessThan(Integer value) {
            addCriterion("buy_virtual_count <", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_virtual_count <=", value, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountIn(List<Integer> values) {
            addCriterion("buy_virtual_count in", values, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountNotIn(List<Integer> values) {
            addCriterion("buy_virtual_count not in", values, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_virtual_count between", value1, value2, "buy_virtual_count");
            return (Criteria) this;
        }

        public Criteria andBuyVirtualCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_virtual_count not between", value1, value2, "buy_virtual_count");
            return (Criteria) this;
        }
        
    	public Criteria andBuyCountIsNull() {
            addCriterion("buy_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("buy_count =", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("buy_count <>", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("buy_count >", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_count >=", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("buy_count <", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_count <=", value, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("buy_count in", values, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("buy_count not in", values, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_count between", value1, value2, "buy_count");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_count not between", value1, value2, "buy_count");
            return (Criteria) this;
        }
        
    	public Criteria andPraiseCountIsNull() {
            addCriterion("praise_count is null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIsNotNull() {
            addCriterion("praise_count is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountEqualTo(Integer value) {
            addCriterion("praise_count =", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotEqualTo(Integer value) {
            addCriterion("praise_count <>", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThan(Integer value) {
            addCriterion("praise_count >", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_count >=", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThan(Integer value) {
            addCriterion("praise_count <", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThanOrEqualTo(Integer value) {
            addCriterion("praise_count <=", value, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIn(List<Integer> values) {
            addCriterion("praise_count in", values, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotIn(List<Integer> values) {
            addCriterion("praise_count not in", values, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountBetween(Integer value1, Integer value2) {
            addCriterion("praise_count between", value1, value2, "praise_count");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_count not between", value1, value2, "praise_count");
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