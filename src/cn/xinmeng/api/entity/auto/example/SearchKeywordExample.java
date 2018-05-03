package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class SearchKeywordExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public SearchKeywordExample() {
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
        
    	public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }
        
    	public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }
    	public Criteria andCustomerCountIsNull() {
            addCriterion("customer_count is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCountIsNotNull() {
            addCriterion("customer_count is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCountEqualTo(Integer value) {
            addCriterion("customer_count =", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountNotEqualTo(Integer value) {
            addCriterion("customer_count <>", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountGreaterThan(Integer value) {
            addCriterion("customer_count >", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_count >=", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountLessThan(Integer value) {
            addCriterion("customer_count <", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountLessThanOrEqualTo(Integer value) {
            addCriterion("customer_count <=", value, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountIn(List<Integer> values) {
            addCriterion("customer_count in", values, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountNotIn(List<Integer> values) {
            addCriterion("customer_count not in", values, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountBetween(Integer value1, Integer value2) {
            addCriterion("customer_count between", value1, value2, "customer_count");
            return (Criteria) this;
        }

        public Criteria andCustomerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_count not between", value1, value2, "customer_count");
            return (Criteria) this;
        }
        
    	public Criteria andKeywordQpIsNull() {
            addCriterion("keyword_qp is null");
            return (Criteria) this;
        }

        public Criteria andKeywordQpIsNotNull() {
            addCriterion("keyword_qp is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordQpEqualTo(String value) {
            addCriterion("keyword_qp =", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpNotEqualTo(String value) {
            addCriterion("keyword_qp <>", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpGreaterThan(String value) {
            addCriterion("keyword_qp >", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_qp >=", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpLessThan(String value) {
            addCriterion("keyword_qp <", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpLessThanOrEqualTo(String value) {
            addCriterion("keyword_qp <=", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpIn(List<String> values) {
            addCriterion("keyword_qp in", values, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpNotIn(List<String> values) {
            addCriterion("keyword_qp not in", values, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpBetween(String value1, String value2) {
            addCriterion("keyword_qp between", value1, value2, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpNotBetween(String value1, String value2) {
            addCriterion("keyword_qp not between", value1, value2, "keyword_qp");
            return (Criteria) this;
        }
        
    	public Criteria andKeywordQpLike(String value) {
            addCriterion("keyword_qp like", value, "keyword_qp");
            return (Criteria) this;
        }

        public Criteria andKeywordQpNotLike(String value) {
            addCriterion("keyword_qp not like", value, "keyword_qp");
            return (Criteria) this;
        }
    	public Criteria andKeywordJpIsNull() {
            addCriterion("keyword_jp is null");
            return (Criteria) this;
        }

        public Criteria andKeywordJpIsNotNull() {
            addCriterion("keyword_jp is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordJpEqualTo(String value) {
            addCriterion("keyword_jp =", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpNotEqualTo(String value) {
            addCriterion("keyword_jp <>", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpGreaterThan(String value) {
            addCriterion("keyword_jp >", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_jp >=", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpLessThan(String value) {
            addCriterion("keyword_jp <", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpLessThanOrEqualTo(String value) {
            addCriterion("keyword_jp <=", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpIn(List<String> values) {
            addCriterion("keyword_jp in", values, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpNotIn(List<String> values) {
            addCriterion("keyword_jp not in", values, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpBetween(String value1, String value2) {
            addCriterion("keyword_jp between", value1, value2, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpNotBetween(String value1, String value2) {
            addCriterion("keyword_jp not between", value1, value2, "keyword_jp");
            return (Criteria) this;
        }
        
    	public Criteria andKeywordJpLike(String value) {
            addCriterion("keyword_jp like", value, "keyword_jp");
            return (Criteria) this;
        }

        public Criteria andKeywordJpNotLike(String value) {
            addCriterion("keyword_jp not like", value, "keyword_jp");
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