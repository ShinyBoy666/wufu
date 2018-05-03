package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CustomerExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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
        
    	public Criteria andRecommendCodeIsNull() {
            addCriterion("recommend_code is null");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeIsNotNull() {
            addCriterion("recommend_code is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeEqualTo(String value) {
            addCriterion("recommend_code =", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotEqualTo(String value) {
            addCriterion("recommend_code <>", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeGreaterThan(String value) {
            addCriterion("recommend_code >", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_code >=", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLessThan(String value) {
            addCriterion("recommend_code <", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLessThanOrEqualTo(String value) {
            addCriterion("recommend_code <=", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeIn(List<String> values) {
            addCriterion("recommend_code in", values, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotIn(List<String> values) {
            addCriterion("recommend_code not in", values, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeBetween(String value1, String value2) {
            addCriterion("recommend_code between", value1, value2, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotBetween(String value1, String value2) {
            addCriterion("recommend_code not between", value1, value2, "recommend_code");
            return (Criteria) this;
        }
        
    	public Criteria andRecommendCodeLike(String value) {
            addCriterion("recommend_code like", value, "recommend_code");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotLike(String value) {
            addCriterion("recommend_code not like", value, "recommend_code");
            return (Criteria) this;
        }
    	public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }
        
    	public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }
    	public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }
        
    	public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }
    	public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "province_id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "province_id");
            return (Criteria) this;
        }
        
    	public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "city_id");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "city_id");
            return (Criteria) this;
        }
        
    	public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Integer value) {
            addCriterion("district_id =", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Integer value) {
            addCriterion("district_id <>", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Integer value) {
            addCriterion("district_id >", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_id >=", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Integer value) {
            addCriterion("district_id <", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("district_id <=", value, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Integer> values) {
            addCriterion("district_id in", values, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Integer> values) {
            addCriterion("district_id not in", values, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Integer value1, Integer value2) {
            addCriterion("district_id between", value1, value2, "district_id");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("district_id not between", value1, value2, "district_id");
            return (Criteria) this;
        }
        
    	public Criteria andRecommendCustomerIdIsNull() {
            addCriterion("recommend_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdIsNotNull() {
            addCriterion("recommend_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdEqualTo(Integer value) {
            addCriterion("recommend_customer_id =", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdNotEqualTo(Integer value) {
            addCriterion("recommend_customer_id <>", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdGreaterThan(Integer value) {
            addCriterion("recommend_customer_id >", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_customer_id >=", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdLessThan(Integer value) {
            addCriterion("recommend_customer_id <", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_customer_id <=", value, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdIn(List<Integer> values) {
            addCriterion("recommend_customer_id in", values, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdNotIn(List<Integer> values) {
            addCriterion("recommend_customer_id not in", values, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("recommend_customer_id between", value1, value2, "recommend_customer_id");
            return (Criteria) this;
        }

        public Criteria andRecommendCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_customer_id not between", value1, value2, "recommend_customer_id");
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
        
    	public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }
        
    	public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }
    	public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "open_id");
            return (Criteria) this;
        }
        
    	public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "open_id");
            return (Criteria) this;
        }
    	public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }
        
    	public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }
    	public Criteria andCustomerCategoryIsNull() {
            addCriterion("customer_category is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryIsNotNull() {
            addCriterion("customer_category is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryEqualTo(String value) {
            addCriterion("customer_category =", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryNotEqualTo(String value) {
            addCriterion("customer_category <>", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryGreaterThan(String value) {
            addCriterion("customer_category >", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("customer_category >=", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryLessThan(String value) {
            addCriterion("customer_category <", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryLessThanOrEqualTo(String value) {
            addCriterion("customer_category <=", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryIn(List<String> values) {
            addCriterion("customer_category in", values, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryNotIn(List<String> values) {
            addCriterion("customer_category not in", values, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryBetween(String value1, String value2) {
            addCriterion("customer_category between", value1, value2, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryNotBetween(String value1, String value2) {
            addCriterion("customer_category not between", value1, value2, "customer_category");
            return (Criteria) this;
        }
        
    	public Criteria andCustomerCategoryLike(String value) {
            addCriterion("customer_category like", value, "customer_category");
            return (Criteria) this;
        }

        public Criteria andCustomerCategoryNotLike(String value) {
            addCriterion("customer_category not like", value, "customer_category");
            return (Criteria) this;
        }
    	public Criteria andHeadSculptureIsNull() {
            addCriterion("head_sculpture is null");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureIsNotNull() {
            addCriterion("head_sculpture is not null");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureEqualTo(String value) {
            addCriterion("head_sculpture =", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureNotEqualTo(String value) {
            addCriterion("head_sculpture <>", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureGreaterThan(String value) {
            addCriterion("head_sculpture >", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureGreaterThanOrEqualTo(String value) {
            addCriterion("head_sculpture >=", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureLessThan(String value) {
            addCriterion("head_sculpture <", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureLessThanOrEqualTo(String value) {
            addCriterion("head_sculpture <=", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureIn(List<String> values) {
            addCriterion("head_sculpture in", values, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureNotIn(List<String> values) {
            addCriterion("head_sculpture not in", values, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureBetween(String value1, String value2) {
            addCriterion("head_sculpture between", value1, value2, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureNotBetween(String value1, String value2) {
            addCriterion("head_sculpture not between", value1, value2, "head_sculpture");
            return (Criteria) this;
        }
        
    	public Criteria andHeadSculptureLike(String value) {
            addCriterion("head_sculpture like", value, "head_sculpture");
            return (Criteria) this;
        }

        public Criteria andHeadSculptureNotLike(String value) {
            addCriterion("head_sculpture not like", value, "head_sculpture");
            return (Criteria) this;
        }
    	public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }
        
    	public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }
        
    	public Criteria andCashAmountIsNull() {
            addCriterion("cash_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNotNull() {
            addCriterion("cash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashAmountEqualTo(Double value) {
            addCriterion("cash_amount =", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotEqualTo(Double value) {
            addCriterion("cash_amount <>", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThan(Double value) {
            addCriterion("cash_amount >", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_amount >=", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThan(Double value) {
            addCriterion("cash_amount <", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThanOrEqualTo(Double value) {
            addCriterion("cash_amount <=", value, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIn(List<Double> values) {
            addCriterion("cash_amount in", values, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotIn(List<Double> values) {
            addCriterion("cash_amount not in", values, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountBetween(Double value1, Double value2) {
            addCriterion("cash_amount between", value1, value2, "cash_amount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotBetween(Double value1, Double value2) {
            addCriterion("cash_amount not between", value1, value2, "cash_amount");
            return (Criteria) this;
        }
        
    	public Criteria andScoreAmountIsNull() {
            addCriterion("score_amount is null");
            return (Criteria) this;
        }

        public Criteria andScoreAmountIsNotNull() {
            addCriterion("score_amount is not null");
            return (Criteria) this;
        }

        public Criteria andScoreAmountEqualTo(Integer value) {
            addCriterion("score_amount =", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountNotEqualTo(Integer value) {
            addCriterion("score_amount <>", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountGreaterThan(Integer value) {
            addCriterion("score_amount >", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_amount >=", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountLessThan(Integer value) {
            addCriterion("score_amount <", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountLessThanOrEqualTo(Integer value) {
            addCriterion("score_amount <=", value, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountIn(List<Integer> values) {
            addCriterion("score_amount in", values, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountNotIn(List<Integer> values) {
            addCriterion("score_amount not in", values, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountBetween(Integer value1, Integer value2) {
            addCriterion("score_amount between", value1, value2, "score_amount");
            return (Criteria) this;
        }

        public Criteria andScoreAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("score_amount not between", value1, value2, "score_amount");
            return (Criteria) this;
        }
        
    	public Criteria andExtensionAmountIsNull() {
            addCriterion("extension_amount is null");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountIsNotNull() {
            addCriterion("extension_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountEqualTo(Double value) {
            addCriterion("extension_amount =", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountNotEqualTo(Double value) {
            addCriterion("extension_amount <>", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountGreaterThan(Double value) {
            addCriterion("extension_amount >", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("extension_amount >=", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountLessThan(Double value) {
            addCriterion("extension_amount <", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountLessThanOrEqualTo(Double value) {
            addCriterion("extension_amount <=", value, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountIn(List<Double> values) {
            addCriterion("extension_amount in", values, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountNotIn(List<Double> values) {
            addCriterion("extension_amount not in", values, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountBetween(Double value1, Double value2) {
            addCriterion("extension_amount between", value1, value2, "extension_amount");
            return (Criteria) this;
        }

        public Criteria andExtensionAmountNotBetween(Double value1, Double value2) {
            addCriterion("extension_amount not between", value1, value2, "extension_amount");
            return (Criteria) this;
        }
        
    	public Criteria andCashbackAmountIsNull() {
            addCriterion("cashback_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountIsNotNull() {
            addCriterion("cashback_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountEqualTo(Double value) {
            addCriterion("cashback_amount =", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountNotEqualTo(Double value) {
            addCriterion("cashback_amount <>", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountGreaterThan(Double value) {
            addCriterion("cashback_amount >", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("cashback_amount >=", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountLessThan(Double value) {
            addCriterion("cashback_amount <", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountLessThanOrEqualTo(Double value) {
            addCriterion("cashback_amount <=", value, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountIn(List<Double> values) {
            addCriterion("cashback_amount in", values, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountNotIn(List<Double> values) {
            addCriterion("cashback_amount not in", values, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountBetween(Double value1, Double value2) {
            addCriterion("cashback_amount between", value1, value2, "cashback_amount");
            return (Criteria) this;
        }

        public Criteria andCashbackAmountNotBetween(Double value1, Double value2) {
            addCriterion("cashback_amount not between", value1, value2, "cashback_amount");
            return (Criteria) this;
        }
        
    	public Criteria andContributionAmountIsNull() {
            addCriterion("contribution_amount is null");
            return (Criteria) this;
        }

        public Criteria andContributionAmountIsNotNull() {
            addCriterion("contribution_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContributionAmountEqualTo(Double value) {
            addCriterion("contribution_amount =", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountNotEqualTo(Double value) {
            addCriterion("contribution_amount <>", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountGreaterThan(Double value) {
            addCriterion("contribution_amount >", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("contribution_amount >=", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountLessThan(Double value) {
            addCriterion("contribution_amount <", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountLessThanOrEqualTo(Double value) {
            addCriterion("contribution_amount <=", value, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountIn(List<Double> values) {
            addCriterion("contribution_amount in", values, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountNotIn(List<Double> values) {
            addCriterion("contribution_amount not in", values, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountBetween(Double value1, Double value2) {
            addCriterion("contribution_amount between", value1, value2, "contribution_amount");
            return (Criteria) this;
        }

        public Criteria andContributionAmountNotBetween(Double value1, Double value2) {
            addCriterion("contribution_amount not between", value1, value2, "contribution_amount");
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
        
    	public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(java.util.Date value) {
            addCriterion("open_time =", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(java.util.Date value) {
            addCriterion("open_time <>", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(java.util.Date value) {
            addCriterion("open_time >", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("open_time >=", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(java.util.Date value) {
            addCriterion("open_time <", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("open_time <=", value, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<java.util.Date> values) {
            addCriterion("open_time in", values, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<java.util.Date> values) {
            addCriterion("open_time not in", values, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("open_time between", value1, value2, "open_time");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("open_time not between", value1, value2, "open_time");
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
        
    	public Criteria andGetuiIdIsNull() {
            addCriterion("getui_id is null");
            return (Criteria) this;
        }

        public Criteria andGetuiIdIsNotNull() {
            addCriterion("getui_id is not null");
            return (Criteria) this;
        }

        public Criteria andGetuiIdEqualTo(String value) {
            addCriterion("getui_id =", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdNotEqualTo(String value) {
            addCriterion("getui_id <>", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdGreaterThan(String value) {
            addCriterion("getui_id >", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdGreaterThanOrEqualTo(String value) {
            addCriterion("getui_id >=", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdLessThan(String value) {
            addCriterion("getui_id <", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdLessThanOrEqualTo(String value) {
            addCriterion("getui_id <=", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdIn(List<String> values) {
            addCriterion("getui_id in", values, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdNotIn(List<String> values) {
            addCriterion("getui_id not in", values, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdBetween(String value1, String value2) {
            addCriterion("getui_id between", value1, value2, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdNotBetween(String value1, String value2) {
            addCriterion("getui_id not between", value1, value2, "getui_id");
            return (Criteria) this;
        }
        
    	public Criteria andGetuiIdLike(String value) {
            addCriterion("getui_id like", value, "getui_id");
            return (Criteria) this;
        }

        public Criteria andGetuiIdNotLike(String value) {
            addCriterion("getui_id not like", value, "getui_id");
            return (Criteria) this;
        }
    	public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return (Criteria) this;
        }
        
    	public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
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