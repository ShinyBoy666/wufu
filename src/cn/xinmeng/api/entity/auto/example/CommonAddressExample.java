package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CommonAddressExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CommonAddressExample() {
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
        
    	public Criteria andRecipientNameIsNull() {
            addCriterion("recipient_name is null");
            return (Criteria) this;
        }

        public Criteria andRecipientNameIsNotNull() {
            addCriterion("recipient_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientNameEqualTo(String value) {
            addCriterion("recipient_name =", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameNotEqualTo(String value) {
            addCriterion("recipient_name <>", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameGreaterThan(String value) {
            addCriterion("recipient_name >", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameGreaterThanOrEqualTo(String value) {
            addCriterion("recipient_name >=", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameLessThan(String value) {
            addCriterion("recipient_name <", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameLessThanOrEqualTo(String value) {
            addCriterion("recipient_name <=", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameIn(List<String> values) {
            addCriterion("recipient_name in", values, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameNotIn(List<String> values) {
            addCriterion("recipient_name not in", values, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameBetween(String value1, String value2) {
            addCriterion("recipient_name between", value1, value2, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameNotBetween(String value1, String value2) {
            addCriterion("recipient_name not between", value1, value2, "recipient_name");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientNameLike(String value) {
            addCriterion("recipient_name like", value, "recipient_name");
            return (Criteria) this;
        }

        public Criteria andRecipientNameNotLike(String value) {
            addCriterion("recipient_name not like", value, "recipient_name");
            return (Criteria) this;
        }
    	public Criteria andRecipientIdentityCardIsNull() {
            addCriterion("recipient_identity_card is null");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardIsNotNull() {
            addCriterion("recipient_identity_card is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardEqualTo(String value) {
            addCriterion("recipient_identity_card =", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardNotEqualTo(String value) {
            addCriterion("recipient_identity_card <>", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardGreaterThan(String value) {
            addCriterion("recipient_identity_card >", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardGreaterThanOrEqualTo(String value) {
            addCriterion("recipient_identity_card >=", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardLessThan(String value) {
            addCriterion("recipient_identity_card <", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardLessThanOrEqualTo(String value) {
            addCriterion("recipient_identity_card <=", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardIn(List<String> values) {
            addCriterion("recipient_identity_card in", values, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardNotIn(List<String> values) {
            addCriterion("recipient_identity_card not in", values, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardBetween(String value1, String value2) {
            addCriterion("recipient_identity_card between", value1, value2, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardNotBetween(String value1, String value2) {
            addCriterion("recipient_identity_card not between", value1, value2, "recipient_identity_card");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientIdentityCardLike(String value) {
            addCriterion("recipient_identity_card like", value, "recipient_identity_card");
            return (Criteria) this;
        }

        public Criteria andRecipientIdentityCardNotLike(String value) {
            addCriterion("recipient_identity_card not like", value, "recipient_identity_card");
            return (Criteria) this;
        }
    	public Criteria andAddressTypeIsNull() {
            addCriterion("address_type is null");
            return (Criteria) this;
        }

        public Criteria andAddressTypeIsNotNull() {
            addCriterion("address_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddressTypeEqualTo(Integer value) {
            addCriterion("address_type =", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeNotEqualTo(Integer value) {
            addCriterion("address_type <>", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeGreaterThan(Integer value) {
            addCriterion("address_type >", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_type >=", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeLessThan(Integer value) {
            addCriterion("address_type <", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeLessThanOrEqualTo(Integer value) {
            addCriterion("address_type <=", value, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeIn(List<Integer> values) {
            addCriterion("address_type in", values, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeNotIn(List<Integer> values) {
            addCriterion("address_type not in", values, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeBetween(Integer value1, Integer value2) {
            addCriterion("address_type between", value1, value2, "address_type");
            return (Criteria) this;
        }

        public Criteria andAddressTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("address_type not between", value1, value2, "address_type");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientPhoneIsNull() {
            addCriterion("recipient_phone is null");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneIsNotNull() {
            addCriterion("recipient_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneEqualTo(String value) {
            addCriterion("recipient_phone =", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneNotEqualTo(String value) {
            addCriterion("recipient_phone <>", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneGreaterThan(String value) {
            addCriterion("recipient_phone >", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("recipient_phone >=", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneLessThan(String value) {
            addCriterion("recipient_phone <", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneLessThanOrEqualTo(String value) {
            addCriterion("recipient_phone <=", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneIn(List<String> values) {
            addCriterion("recipient_phone in", values, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneNotIn(List<String> values) {
            addCriterion("recipient_phone not in", values, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneBetween(String value1, String value2) {
            addCriterion("recipient_phone between", value1, value2, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneNotBetween(String value1, String value2) {
            addCriterion("recipient_phone not between", value1, value2, "recipient_phone");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientPhoneLike(String value) {
            addCriterion("recipient_phone like", value, "recipient_phone");
            return (Criteria) this;
        }

        public Criteria andRecipientPhoneNotLike(String value) {
            addCriterion("recipient_phone not like", value, "recipient_phone");
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
        
    	public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(Integer value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(Integer value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(Integer value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(Integer value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(Integer value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(Integer value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<Integer> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<Integer> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(Integer value1, Integer value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(Integer value1, Integer value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientzipCodeIsNull() {
            addCriterion("recipientzip_code is null");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeIsNotNull() {
            addCriterion("recipientzip_code is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeEqualTo(String value) {
            addCriterion("recipientzip_code =", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeNotEqualTo(String value) {
            addCriterion("recipientzip_code <>", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeGreaterThan(String value) {
            addCriterion("recipientzip_code >", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("recipientzip_code >=", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeLessThan(String value) {
            addCriterion("recipientzip_code <", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeLessThanOrEqualTo(String value) {
            addCriterion("recipientzip_code <=", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeIn(List<String> values) {
            addCriterion("recipientzip_code in", values, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeNotIn(List<String> values) {
            addCriterion("recipientzip_code not in", values, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeBetween(String value1, String value2) {
            addCriterion("recipientzip_code between", value1, value2, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeNotBetween(String value1, String value2) {
            addCriterion("recipientzip_code not between", value1, value2, "recipientzip_code");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientzipCodeLike(String value) {
            addCriterion("recipientzip_code like", value, "recipientzip_code");
            return (Criteria) this;
        }

        public Criteria andRecipientzipCodeNotLike(String value) {
            addCriterion("recipientzip_code not like", value, "recipientzip_code");
            return (Criteria) this;
        }
    	public Criteria andRecipientAddressIsNull() {
            addCriterion("recipient_address is null");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressIsNotNull() {
            addCriterion("recipient_address is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressEqualTo(String value) {
            addCriterion("recipient_address =", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressNotEqualTo(String value) {
            addCriterion("recipient_address <>", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressGreaterThan(String value) {
            addCriterion("recipient_address >", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressGreaterThanOrEqualTo(String value) {
            addCriterion("recipient_address >=", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressLessThan(String value) {
            addCriterion("recipient_address <", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressLessThanOrEqualTo(String value) {
            addCriterion("recipient_address <=", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressIn(List<String> values) {
            addCriterion("recipient_address in", values, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressNotIn(List<String> values) {
            addCriterion("recipient_address not in", values, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressBetween(String value1, String value2) {
            addCriterion("recipient_address between", value1, value2, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressNotBetween(String value1, String value2) {
            addCriterion("recipient_address not between", value1, value2, "recipient_address");
            return (Criteria) this;
        }
        
    	public Criteria andRecipientAddressLike(String value) {
            addCriterion("recipient_address like", value, "recipient_address");
            return (Criteria) this;
        }

        public Criteria andRecipientAddressNotLike(String value) {
            addCriterion("recipient_address not like", value, "recipient_address");
            return (Criteria) this;
        }
    	public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Integer value) {
            addCriterion("is_default =", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Integer value) {
            addCriterion("is_default <>", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Integer value) {
            addCriterion("is_default >", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default >=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Integer value) {
            addCriterion("is_default <", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("is_default <=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Integer> values) {
            addCriterion("is_default in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Integer> values) {
            addCriterion("is_default not in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            addCriterion("is_default between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default not between", value1, value2, "is_default");
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