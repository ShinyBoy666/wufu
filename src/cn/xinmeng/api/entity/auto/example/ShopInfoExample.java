package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ShopInfoExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ShopInfoExample() {
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
        
    	public Criteria andShopLogoIsNull() {
            addCriterion("shop_logo is null");
            return (Criteria) this;
        }

        public Criteria andShopLogoIsNotNull() {
            addCriterion("shop_logo is not null");
            return (Criteria) this;
        }

        public Criteria andShopLogoEqualTo(String value) {
            addCriterion("shop_logo =", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoNotEqualTo(String value) {
            addCriterion("shop_logo <>", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoGreaterThan(String value) {
            addCriterion("shop_logo >", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_logo >=", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoLessThan(String value) {
            addCriterion("shop_logo <", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoLessThanOrEqualTo(String value) {
            addCriterion("shop_logo <=", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoIn(List<String> values) {
            addCriterion("shop_logo in", values, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoNotIn(List<String> values) {
            addCriterion("shop_logo not in", values, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoBetween(String value1, String value2) {
            addCriterion("shop_logo between", value1, value2, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoNotBetween(String value1, String value2) {
            addCriterion("shop_logo not between", value1, value2, "shop_logo");
            return (Criteria) this;
        }
        
    	public Criteria andShopLogoLike(String value) {
            addCriterion("shop_logo like", value, "shop_logo");
            return (Criteria) this;
        }

        public Criteria andShopLogoNotLike(String value) {
            addCriterion("shop_logo not like", value, "shop_logo");
            return (Criteria) this;
        }
    	public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shop_name");
            return (Criteria) this;
        }
        
    	public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shop_name");
            return (Criteria) this;
        }
    	public Criteria andShopDescriptionIsNull() {
            addCriterion("shop_description is null");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionIsNotNull() {
            addCriterion("shop_description is not null");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionEqualTo(String value) {
            addCriterion("shop_description =", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionNotEqualTo(String value) {
            addCriterion("shop_description <>", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionGreaterThan(String value) {
            addCriterion("shop_description >", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("shop_description >=", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionLessThan(String value) {
            addCriterion("shop_description <", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionLessThanOrEqualTo(String value) {
            addCriterion("shop_description <=", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionIn(List<String> values) {
            addCriterion("shop_description in", values, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionNotIn(List<String> values) {
            addCriterion("shop_description not in", values, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionBetween(String value1, String value2) {
            addCriterion("shop_description between", value1, value2, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionNotBetween(String value1, String value2) {
            addCriterion("shop_description not between", value1, value2, "shop_description");
            return (Criteria) this;
        }
        
    	public Criteria andShopDescriptionLike(String value) {
            addCriterion("shop_description like", value, "shop_description");
            return (Criteria) this;
        }

        public Criteria andShopDescriptionNotLike(String value) {
            addCriterion("shop_description not like", value, "shop_description");
            return (Criteria) this;
        }
    	public Criteria andShopPhoneIsNull() {
            addCriterion("shop_phone is null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIsNotNull() {
            addCriterion("shop_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneEqualTo(String value) {
            addCriterion("shop_phone =", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotEqualTo(String value) {
            addCriterion("shop_phone <>", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThan(String value) {
            addCriterion("shop_phone >", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shop_phone >=", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThan(String value) {
            addCriterion("shop_phone <", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThanOrEqualTo(String value) {
            addCriterion("shop_phone <=", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIn(List<String> values) {
            addCriterion("shop_phone in", values, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotIn(List<String> values) {
            addCriterion("shop_phone not in", values, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneBetween(String value1, String value2) {
            addCriterion("shop_phone between", value1, value2, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotBetween(String value1, String value2) {
            addCriterion("shop_phone not between", value1, value2, "shop_phone");
            return (Criteria) this;
        }
        
    	public Criteria andShopPhoneLike(String value) {
            addCriterion("shop_phone like", value, "shop_phone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotLike(String value) {
            addCriterion("shop_phone not like", value, "shop_phone");
            return (Criteria) this;
        }
    	public Criteria andServerPhoneIsNull() {
            addCriterion("server_phone is null");
            return (Criteria) this;
        }

        public Criteria andServerPhoneIsNotNull() {
            addCriterion("server_phone is not null");
            return (Criteria) this;
        }

        public Criteria andServerPhoneEqualTo(String value) {
            addCriterion("server_phone =", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneNotEqualTo(String value) {
            addCriterion("server_phone <>", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneGreaterThan(String value) {
            addCriterion("server_phone >", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("server_phone >=", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneLessThan(String value) {
            addCriterion("server_phone <", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneLessThanOrEqualTo(String value) {
            addCriterion("server_phone <=", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneIn(List<String> values) {
            addCriterion("server_phone in", values, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneNotIn(List<String> values) {
            addCriterion("server_phone not in", values, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneBetween(String value1, String value2) {
            addCriterion("server_phone between", value1, value2, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneNotBetween(String value1, String value2) {
            addCriterion("server_phone not between", value1, value2, "server_phone");
            return (Criteria) this;
        }
        
    	public Criteria andServerPhoneLike(String value) {
            addCriterion("server_phone like", value, "server_phone");
            return (Criteria) this;
        }

        public Criteria andServerPhoneNotLike(String value) {
            addCriterion("server_phone not like", value, "server_phone");
            return (Criteria) this;
        }
    	public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agent_id");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agent_id");
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
        
    	public Criteria andShopAddressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("shop_address =", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("shop_address <", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("shop_address in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shop_address");
            return (Criteria) this;
        }
        
    	public Criteria andShopAddressLike(String value) {
            addCriterion("shop_address like", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("shop_address not like", value, "shop_address");
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
        
    	public Criteria andShortUrlIsNull() {
            addCriterion("short_url is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNotNull() {
            addCriterion("short_url is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlEqualTo(String value) {
            addCriterion("short_url =", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotEqualTo(String value) {
            addCriterion("short_url <>", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThan(String value) {
            addCriterion("short_url >", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThanOrEqualTo(String value) {
            addCriterion("short_url >=", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThan(String value) {
            addCriterion("short_url <", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThanOrEqualTo(String value) {
            addCriterion("short_url <=", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlIn(List<String> values) {
            addCriterion("short_url in", values, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotIn(List<String> values) {
            addCriterion("short_url not in", values, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlBetween(String value1, String value2) {
            addCriterion("short_url between", value1, value2, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotBetween(String value1, String value2) {
            addCriterion("short_url not between", value1, value2, "short_url");
            return (Criteria) this;
        }
        
    	public Criteria andShortUrlLike(String value) {
            addCriterion("short_url like", value, "short_url");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotLike(String value) {
            addCriterion("short_url not like", value, "short_url");
            return (Criteria) this;
        }
    	public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qr_code");
            return (Criteria) this;
        }
        
    	public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qr_code");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qr_code");
            return (Criteria) this;
        }
    	public Criteria andWxCodeIsNull() {
            addCriterion("wx_code is null");
            return (Criteria) this;
        }

        public Criteria andWxCodeIsNotNull() {
            addCriterion("wx_code is not null");
            return (Criteria) this;
        }

        public Criteria andWxCodeEqualTo(String value) {
            addCriterion("wx_code =", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeNotEqualTo(String value) {
            addCriterion("wx_code <>", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeGreaterThan(String value) {
            addCriterion("wx_code >", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_code >=", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeLessThan(String value) {
            addCriterion("wx_code <", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeLessThanOrEqualTo(String value) {
            addCriterion("wx_code <=", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeIn(List<String> values) {
            addCriterion("wx_code in", values, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeNotIn(List<String> values) {
            addCriterion("wx_code not in", values, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeBetween(String value1, String value2) {
            addCriterion("wx_code between", value1, value2, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeNotBetween(String value1, String value2) {
            addCriterion("wx_code not between", value1, value2, "wx_code");
            return (Criteria) this;
        }
        
    	public Criteria andWxCodeLike(String value) {
            addCriterion("wx_code like", value, "wx_code");
            return (Criteria) this;
        }

        public Criteria andWxCodeNotLike(String value) {
            addCriterion("wx_code not like", value, "wx_code");
            return (Criteria) this;
        }
    	public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }
        
    	public Criteria andSupportGetuiIsNull() {
            addCriterion("support_getui is null");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiIsNotNull() {
            addCriterion("support_getui is not null");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiEqualTo(Integer value) {
            addCriterion("support_getui =", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiNotEqualTo(Integer value) {
            addCriterion("support_getui <>", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiGreaterThan(Integer value) {
            addCriterion("support_getui >", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiGreaterThanOrEqualTo(Integer value) {
            addCriterion("support_getui >=", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiLessThan(Integer value) {
            addCriterion("support_getui <", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiLessThanOrEqualTo(Integer value) {
            addCriterion("support_getui <=", value, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiIn(List<Integer> values) {
            addCriterion("support_getui in", values, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiNotIn(List<Integer> values) {
            addCriterion("support_getui not in", values, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiBetween(Integer value1, Integer value2) {
            addCriterion("support_getui between", value1, value2, "support_getui");
            return (Criteria) this;
        }

        public Criteria andSupportGetuiNotBetween(Integer value1, Integer value2) {
            addCriterion("support_getui not between", value1, value2, "support_getui");
            return (Criteria) this;
        }
        
    	public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "pay_type");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "pay_type");
            return (Criteria) this;
        }
        
    	public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }
        
    	public Criteria andGeoCodeIsNull() {
            addCriterion("geo_code is null");
            return (Criteria) this;
        }

        public Criteria andGeoCodeIsNotNull() {
            addCriterion("geo_code is not null");
            return (Criteria) this;
        }

        public Criteria andGeoCodeEqualTo(String value) {
            addCriterion("geo_code =", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeNotEqualTo(String value) {
            addCriterion("geo_code <>", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeGreaterThan(String value) {
            addCriterion("geo_code >", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeGreaterThanOrEqualTo(String value) {
            addCriterion("geo_code >=", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeLessThan(String value) {
            addCriterion("geo_code <", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeLessThanOrEqualTo(String value) {
            addCriterion("geo_code <=", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeIn(List<String> values) {
            addCriterion("geo_code in", values, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeNotIn(List<String> values) {
            addCriterion("geo_code not in", values, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeBetween(String value1, String value2) {
            addCriterion("geo_code between", value1, value2, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeNotBetween(String value1, String value2) {
            addCriterion("geo_code not between", value1, value2, "geo_code");
            return (Criteria) this;
        }
        
    	public Criteria andGeoCodeLike(String value) {
            addCriterion("geo_code like", value, "geo_code");
            return (Criteria) this;
        }

        public Criteria andGeoCodeNotLike(String value) {
            addCriterion("geo_code not like", value, "geo_code");
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
        
    	public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Integer value) {
            addCriterion("shop_type =", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Integer value) {
            addCriterion("shop_type <>", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Integer value) {
            addCriterion("shop_type >", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_type >=", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Integer value) {
            addCriterion("shop_type <", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_type <=", value, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Integer> values) {
            addCriterion("shop_type in", values, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Integer> values) {
            addCriterion("shop_type not in", values, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Integer value1, Integer value2) {
            addCriterion("shop_type between", value1, value2, "shop_type");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_type not between", value1, value2, "shop_type");
            return (Criteria) this;
        }
        
    	public Criteria andProductCategoryLevelIsNull() {
            addCriterion("product_category_level is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelIsNotNull() {
            addCriterion("product_category_level is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelEqualTo(Integer value) {
            addCriterion("product_category_level =", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelNotEqualTo(Integer value) {
            addCriterion("product_category_level <>", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelGreaterThan(Integer value) {
            addCriterion("product_category_level >", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_category_level >=", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelLessThan(Integer value) {
            addCriterion("product_category_level <", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelLessThanOrEqualTo(Integer value) {
            addCriterion("product_category_level <=", value, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelIn(List<Integer> values) {
            addCriterion("product_category_level in", values, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelNotIn(List<Integer> values) {
            addCriterion("product_category_level not in", values, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelBetween(Integer value1, Integer value2) {
            addCriterion("product_category_level between", value1, value2, "product_category_level");
            return (Criteria) this;
        }

        public Criteria andProductCategoryLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("product_category_level not between", value1, value2, "product_category_level");
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