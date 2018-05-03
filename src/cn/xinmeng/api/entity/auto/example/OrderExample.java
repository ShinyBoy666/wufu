package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class OrderExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public OrderExample() {
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
    	public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zip_code");
            return (Criteria) this;
        }
        
    	public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zip_code");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zip_code");
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
        
    	public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Double value) {
            addCriterion("total_amount =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Double value) {
            addCriterion("total_amount <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Double value) {
            addCriterion("total_amount >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("total_amount >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Double value) {
            addCriterion("total_amount <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
            addCriterion("total_amount <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Double> values) {
            addCriterion("total_amount in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Double> values) {
            addCriterion("total_amount not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Double value1, Double value2) {
            addCriterion("total_amount between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
            addCriterion("total_amount not between", value1, value2, "total_amount");
            return (Criteria) this;
        }
        
    	public Criteria andAccountPaymentIsNull() {
            addCriterion("account_payment is null");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentIsNotNull() {
            addCriterion("account_payment is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentEqualTo(Double value) {
            addCriterion("account_payment =", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentNotEqualTo(Double value) {
            addCriterion("account_payment <>", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentGreaterThan(Double value) {
            addCriterion("account_payment >", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("account_payment >=", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentLessThan(Double value) {
            addCriterion("account_payment <", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentLessThanOrEqualTo(Double value) {
            addCriterion("account_payment <=", value, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentIn(List<Double> values) {
            addCriterion("account_payment in", values, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentNotIn(List<Double> values) {
            addCriterion("account_payment not in", values, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentBetween(Double value1, Double value2) {
            addCriterion("account_payment between", value1, value2, "account_payment");
            return (Criteria) this;
        }

        public Criteria andAccountPaymentNotBetween(Double value1, Double value2) {
            addCriterion("account_payment not between", value1, value2, "account_payment");
            return (Criteria) this;
        }
        
    	public Criteria andOnlinePaymentIsNull() {
            addCriterion("online_payment is null");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentIsNotNull() {
            addCriterion("online_payment is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentEqualTo(Double value) {
            addCriterion("online_payment =", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentNotEqualTo(Double value) {
            addCriterion("online_payment <>", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentGreaterThan(Double value) {
            addCriterion("online_payment >", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("online_payment >=", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentLessThan(Double value) {
            addCriterion("online_payment <", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentLessThanOrEqualTo(Double value) {
            addCriterion("online_payment <=", value, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentIn(List<Double> values) {
            addCriterion("online_payment in", values, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentNotIn(List<Double> values) {
            addCriterion("online_payment not in", values, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentBetween(Double value1, Double value2) {
            addCriterion("online_payment between", value1, value2, "online_payment");
            return (Criteria) this;
        }

        public Criteria andOnlinePaymentNotBetween(Double value1, Double value2) {
            addCriterion("online_payment not between", value1, value2, "online_payment");
            return (Criteria) this;
        }
        
    	public Criteria andOnlinePayTypeIsNull() {
            addCriterion("online_pay_type is null");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeIsNotNull() {
            addCriterion("online_pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeEqualTo(Integer value) {
            addCriterion("online_pay_type =", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeNotEqualTo(Integer value) {
            addCriterion("online_pay_type <>", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeGreaterThan(Integer value) {
            addCriterion("online_pay_type >", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("online_pay_type >=", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeLessThan(Integer value) {
            addCriterion("online_pay_type <", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("online_pay_type <=", value, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeIn(List<Integer> values) {
            addCriterion("online_pay_type in", values, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeNotIn(List<Integer> values) {
            addCriterion("online_pay_type not in", values, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeBetween(Integer value1, Integer value2) {
            addCriterion("online_pay_type between", value1, value2, "online_pay_type");
            return (Criteria) this;
        }

        public Criteria andOnlinePayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("online_pay_type not between", value1, value2, "online_pay_type");
            return (Criteria) this;
        }
        
    	public Criteria andCouponPaymentIsNull() {
            addCriterion("coupon_payment is null");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentIsNotNull() {
            addCriterion("coupon_payment is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentEqualTo(Double value) {
            addCriterion("coupon_payment =", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentNotEqualTo(Double value) {
            addCriterion("coupon_payment <>", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentGreaterThan(Double value) {
            addCriterion("coupon_payment >", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("coupon_payment >=", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentLessThan(Double value) {
            addCriterion("coupon_payment <", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentLessThanOrEqualTo(Double value) {
            addCriterion("coupon_payment <=", value, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentIn(List<Double> values) {
            addCriterion("coupon_payment in", values, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentNotIn(List<Double> values) {
            addCriterion("coupon_payment not in", values, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentBetween(Double value1, Double value2) {
            addCriterion("coupon_payment between", value1, value2, "coupon_payment");
            return (Criteria) this;
        }

        public Criteria andCouponPaymentNotBetween(Double value1, Double value2) {
            addCriterion("coupon_payment not between", value1, value2, "coupon_payment");
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
    	public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(Double value) {
            addCriterion("discount_amount =", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(Double value) {
            addCriterion("discount_amount <>", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(Double value) {
            addCriterion("discount_amount >", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount_amount >=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(Double value) {
            addCriterion("discount_amount <", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(Double value) {
            addCriterion("discount_amount <=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<Double> values) {
            addCriterion("discount_amount in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<Double> values) {
            addCriterion("discount_amount not in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(Double value1, Double value2) {
            addCriterion("discount_amount between", value1, value2, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(Double value1, Double value2) {
            addCriterion("discount_amount not between", value1, value2, "discount_amount");
            return (Criteria) this;
        }
        
    	public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Double value) {
            addCriterion("pay_amount =", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Double value) {
            addCriterion("pay_amount <>", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Double value) {
            addCriterion("pay_amount >", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_amount >=", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Double value) {
            addCriterion("pay_amount <", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Double value) {
            addCriterion("pay_amount <=", value, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Double> values) {
            addCriterion("pay_amount in", values, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Double> values) {
            addCriterion("pay_amount not in", values, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Double value1, Double value2) {
            addCriterion("pay_amount between", value1, value2, "pay_amount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Double value1, Double value2) {
            addCriterion("pay_amount not between", value1, value2, "pay_amount");
            return (Criteria) this;
        }
        
    	public Criteria andPostageIsNull() {
            addCriterion("postage is null");
            return (Criteria) this;
        }

        public Criteria andPostageIsNotNull() {
            addCriterion("postage is not null");
            return (Criteria) this;
        }

        public Criteria andPostageEqualTo(Double value) {
            addCriterion("postage =", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotEqualTo(Double value) {
            addCriterion("postage <>", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThan(Double value) {
            addCriterion("postage >", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThanOrEqualTo(Double value) {
            addCriterion("postage >=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThan(Double value) {
            addCriterion("postage <", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThanOrEqualTo(Double value) {
            addCriterion("postage <=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageIn(List<Double> values) {
            addCriterion("postage in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotIn(List<Double> values) {
            addCriterion("postage not in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageBetween(Double value1, Double value2) {
            addCriterion("postage between", value1, value2, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotBetween(Double value1, Double value2) {
            addCriterion("postage not between", value1, value2, "postage");
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
    	public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "order_type");
            return (Criteria) this;
        }
        
    	public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activity_id");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activity_id");
            return (Criteria) this;
        }
        
    	public Criteria andOrderFromIsNull() {
            addCriterion("order_from is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNotNull() {
            addCriterion("order_from is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromEqualTo(Integer value) {
            addCriterion("order_from =", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotEqualTo(Integer value) {
            addCriterion("order_from <>", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThan(Integer value) {
            addCriterion("order_from >", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_from >=", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThan(Integer value) {
            addCriterion("order_from <", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThanOrEqualTo(Integer value) {
            addCriterion("order_from <=", value, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromIn(List<Integer> values) {
            addCriterion("order_from in", values, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotIn(List<Integer> values) {
            addCriterion("order_from not in", values, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromBetween(Integer value1, Integer value2) {
            addCriterion("order_from between", value1, value2, "order_from");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotBetween(Integer value1, Integer value2) {
            addCriterion("order_from not between", value1, value2, "order_from");
            return (Criteria) this;
        }
        
    	public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "order_state");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "order_state");
            return (Criteria) this;
        }
        
    	public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "pay_state");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "pay_state");
            return (Criteria) this;
        }
        
    	public Criteria andLogisticsNameIsNull() {
            addCriterion("logistics_name is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIsNotNull() {
            addCriterion("logistics_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameEqualTo(String value) {
            addCriterion("logistics_name =", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotEqualTo(String value) {
            addCriterion("logistics_name <>", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThan(String value) {
            addCriterion("logistics_name >", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_name >=", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThan(String value) {
            addCriterion("logistics_name <", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_name <=", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIn(List<String> values) {
            addCriterion("logistics_name in", values, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotIn(List<String> values) {
            addCriterion("logistics_name not in", values, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameBetween(String value1, String value2) {
            addCriterion("logistics_name between", value1, value2, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotBetween(String value1, String value2) {
            addCriterion("logistics_name not between", value1, value2, "logistics_name");
            return (Criteria) this;
        }
        
    	public Criteria andLogisticsNameLike(String value) {
            addCriterion("logistics_name like", value, "logistics_name");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotLike(String value) {
            addCriterion("logistics_name not like", value, "logistics_name");
            return (Criteria) this;
        }
    	public Criteria andLogisticsNumberIsNull() {
            addCriterion("logistics_number is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIsNotNull() {
            addCriterion("logistics_number is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberEqualTo(String value) {
            addCriterion("logistics_number =", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotEqualTo(String value) {
            addCriterion("logistics_number <>", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThan(String value) {
            addCriterion("logistics_number >", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_number >=", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThan(String value) {
            addCriterion("logistics_number <", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberLessThanOrEqualTo(String value) {
            addCriterion("logistics_number <=", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberIn(List<String> values) {
            addCriterion("logistics_number in", values, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotIn(List<String> values) {
            addCriterion("logistics_number not in", values, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberBetween(String value1, String value2) {
            addCriterion("logistics_number between", value1, value2, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotBetween(String value1, String value2) {
            addCriterion("logistics_number not between", value1, value2, "logistics_number");
            return (Criteria) this;
        }
        
    	public Criteria andLogisticsNumberLike(String value) {
            addCriterion("logistics_number like", value, "logistics_number");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumberNotLike(String value) {
            addCriterion("logistics_number not like", value, "logistics_number");
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