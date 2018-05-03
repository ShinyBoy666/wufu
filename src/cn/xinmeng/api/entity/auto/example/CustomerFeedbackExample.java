package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CustomerFeedbackExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CustomerFeedbackExample() {
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
        
    	public Criteria andFromTypeIsNull() {
            addCriterion("from_type is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNotNull() {
            addCriterion("from_type is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeEqualTo(Integer value) {
            addCriterion("from_type =", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotEqualTo(Integer value) {
            addCriterion("from_type <>", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThan(Integer value) {
            addCriterion("from_type >", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_type >=", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThan(Integer value) {
            addCriterion("from_type <", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThanOrEqualTo(Integer value) {
            addCriterion("from_type <=", value, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeIn(List<Integer> values) {
            addCriterion("from_type in", values, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotIn(List<Integer> values) {
            addCriterion("from_type not in", values, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeBetween(Integer value1, Integer value2) {
            addCriterion("from_type between", value1, value2, "from_type");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("from_type not between", value1, value2, "from_type");
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
    	public Criteria andPhoneTypeIsNull() {
            addCriterion("phone_type is null");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeIsNotNull() {
            addCriterion("phone_type is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeEqualTo(String value) {
            addCriterion("phone_type =", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotEqualTo(String value) {
            addCriterion("phone_type <>", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeGreaterThan(String value) {
            addCriterion("phone_type >", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("phone_type >=", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeLessThan(String value) {
            addCriterion("phone_type <", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeLessThanOrEqualTo(String value) {
            addCriterion("phone_type <=", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeIn(List<String> values) {
            addCriterion("phone_type in", values, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotIn(List<String> values) {
            addCriterion("phone_type not in", values, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeBetween(String value1, String value2) {
            addCriterion("phone_type between", value1, value2, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotBetween(String value1, String value2) {
            addCriterion("phone_type not between", value1, value2, "phone_type");
            return (Criteria) this;
        }
        
    	public Criteria andPhoneTypeLike(String value) {
            addCriterion("phone_type like", value, "phone_type");
            return (Criteria) this;
        }

        public Criteria andPhoneTypeNotLike(String value) {
            addCriterion("phone_type not like", value, "phone_type");
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
    	public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }
        
    	public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }
        
    	public Criteria andAppDesignedIsNull() {
            addCriterion("app_designed is null");
            return (Criteria) this;
        }

        public Criteria andAppDesignedIsNotNull() {
            addCriterion("app_designed is not null");
            return (Criteria) this;
        }

        public Criteria andAppDesignedEqualTo(Integer value) {
            addCriterion("app_designed =", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedNotEqualTo(Integer value) {
            addCriterion("app_designed <>", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedGreaterThan(Integer value) {
            addCriterion("app_designed >", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_designed >=", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedLessThan(Integer value) {
            addCriterion("app_designed <", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedLessThanOrEqualTo(Integer value) {
            addCriterion("app_designed <=", value, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedIn(List<Integer> values) {
            addCriterion("app_designed in", values, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedNotIn(List<Integer> values) {
            addCriterion("app_designed not in", values, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedBetween(Integer value1, Integer value2) {
            addCriterion("app_designed between", value1, value2, "app_designed");
            return (Criteria) this;
        }

        public Criteria andAppDesignedNotBetween(Integer value1, Integer value2) {
            addCriterion("app_designed not between", value1, value2, "app_designed");
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
        
    	public Criteria andAppVeisionIsNull() {
            addCriterion("app_veision is null");
            return (Criteria) this;
        }

        public Criteria andAppVeisionIsNotNull() {
            addCriterion("app_veision is not null");
            return (Criteria) this;
        }

        public Criteria andAppVeisionEqualTo(String value) {
            addCriterion("app_veision =", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionNotEqualTo(String value) {
            addCriterion("app_veision <>", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionGreaterThan(String value) {
            addCriterion("app_veision >", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionGreaterThanOrEqualTo(String value) {
            addCriterion("app_veision >=", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionLessThan(String value) {
            addCriterion("app_veision <", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionLessThanOrEqualTo(String value) {
            addCriterion("app_veision <=", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionIn(List<String> values) {
            addCriterion("app_veision in", values, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionNotIn(List<String> values) {
            addCriterion("app_veision not in", values, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionBetween(String value1, String value2) {
            addCriterion("app_veision between", value1, value2, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionNotBetween(String value1, String value2) {
            addCriterion("app_veision not between", value1, value2, "app_veision");
            return (Criteria) this;
        }
        
    	public Criteria andAppVeisionLike(String value) {
            addCriterion("app_veision like", value, "app_veision");
            return (Criteria) this;
        }

        public Criteria andAppVeisionNotLike(String value) {
            addCriterion("app_veision not like", value, "app_veision");
            return (Criteria) this;
        }
    	public Criteria andSystemVersionIsNull() {
            addCriterion("system_version is null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIsNotNull() {
            addCriterion("system_version is not null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionEqualTo(String value) {
            addCriterion("system_version =", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotEqualTo(String value) {
            addCriterion("system_version <>", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionGreaterThan(String value) {
            addCriterion("system_version >", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionGreaterThanOrEqualTo(String value) {
            addCriterion("system_version >=", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionLessThan(String value) {
            addCriterion("system_version <", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionLessThanOrEqualTo(String value) {
            addCriterion("system_version <=", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIn(List<String> values) {
            addCriterion("system_version in", values, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotIn(List<String> values) {
            addCriterion("system_version not in", values, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionBetween(String value1, String value2) {
            addCriterion("system_version between", value1, value2, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotBetween(String value1, String value2) {
            addCriterion("system_version not between", value1, value2, "system_version");
            return (Criteria) this;
        }
        
    	public Criteria andSystemVersionLike(String value) {
            addCriterion("system_version like", value, "system_version");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotLike(String value) {
            addCriterion("system_version not like", value, "system_version");
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