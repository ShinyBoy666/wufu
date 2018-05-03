package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CustomerReportExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CustomerReportExample() {
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
        
    	public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customer_name");
            return (Criteria) this;
        }
        
    	public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customer_name");
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
    	public Criteria andTeamNumberIsNull() {
            addCriterion("team_number is null");
            return (Criteria) this;
        }

        public Criteria andTeamNumberIsNotNull() {
            addCriterion("team_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNumberEqualTo(Integer value) {
            addCriterion("team_number =", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotEqualTo(Integer value) {
            addCriterion("team_number <>", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberGreaterThan(Integer value) {
            addCriterion("team_number >", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_number >=", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberLessThan(Integer value) {
            addCriterion("team_number <", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberLessThanOrEqualTo(Integer value) {
            addCriterion("team_number <=", value, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberIn(List<Integer> values) {
            addCriterion("team_number in", values, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotIn(List<Integer> values) {
            addCriterion("team_number not in", values, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberBetween(Integer value1, Integer value2) {
            addCriterion("team_number between", value1, value2, "team_number");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("team_number not between", value1, value2, "team_number");
            return (Criteria) this;
        }
        
    	public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(java.util.Date value) {
            addCriterion("last_update_time =", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(java.util.Date value) {
            addCriterion("last_update_time <>", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(java.util.Date value) {
            addCriterion("last_update_time >", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("last_update_time >=", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(java.util.Date value) {
            addCriterion("last_update_time <", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("last_update_time <=", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<java.util.Date> values) {
            addCriterion("last_update_time in", values, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<java.util.Date> values) {
            addCriterion("last_update_time not in", values, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("last_update_time between", value1, value2, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("last_update_time not between", value1, value2, "last_update_time");
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