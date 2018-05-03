package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class ProductCommentReplyExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public ProductCommentReplyExample() {
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
        
    	public Criteria andCommontIdIsNull() {
            addCriterion("commont_id is null");
            return (Criteria) this;
        }

        public Criteria andCommontIdIsNotNull() {
            addCriterion("commont_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommontIdEqualTo(Integer value) {
            addCriterion("commont_id =", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdNotEqualTo(Integer value) {
            addCriterion("commont_id <>", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdGreaterThan(Integer value) {
            addCriterion("commont_id >", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commont_id >=", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdLessThan(Integer value) {
            addCriterion("commont_id <", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdLessThanOrEqualTo(Integer value) {
            addCriterion("commont_id <=", value, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdIn(List<Integer> values) {
            addCriterion("commont_id in", values, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdNotIn(List<Integer> values) {
            addCriterion("commont_id not in", values, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdBetween(Integer value1, Integer value2) {
            addCriterion("commont_id between", value1, value2, "commont_id");
            return (Criteria) this;
        }

        public Criteria andCommontIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commont_id not between", value1, value2, "commont_id");
            return (Criteria) this;
        }
        
    	public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Integer value) {
            addCriterion("reply_id =", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Integer value) {
            addCriterion("reply_id <>", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Integer value) {
            addCriterion("reply_id >", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_id >=", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Integer value) {
            addCriterion("reply_id <", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_id <=", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Integer> values) {
            addCriterion("reply_id in", values, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Integer> values) {
            addCriterion("reply_id not in", values, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_id between", value1, value2, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_id not between", value1, value2, "reply_id");
            return (Criteria) this;
        }
        
    	public Criteria andReplyTypeIsNull() {
            addCriterion("reply_type is null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNotNull() {
            addCriterion("reply_type is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeEqualTo(Integer value) {
            addCriterion("reply_type =", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotEqualTo(Integer value) {
            addCriterion("reply_type <>", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThan(Integer value) {
            addCriterion("reply_type >", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_type >=", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThan(Integer value) {
            addCriterion("reply_type <", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reply_type <=", value, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIn(List<Integer> values) {
            addCriterion("reply_type in", values, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotIn(List<Integer> values) {
            addCriterion("reply_type not in", values, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("reply_type between", value1, value2, "reply_type");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_type not between", value1, value2, "reply_type");
            return (Criteria) this;
        }
        
    	public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("reply_content in", values, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "reply_content");
            return (Criteria) this;
        }
        
    	public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "reply_content");
            return (Criteria) this;
        }
    	public Criteria andReplyUserIsNull() {
            addCriterion("reply_user is null");
            return (Criteria) this;
        }

        public Criteria andReplyUserIsNotNull() {
            addCriterion("reply_user is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUserEqualTo(String value) {
            addCriterion("reply_user =", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserNotEqualTo(String value) {
            addCriterion("reply_user <>", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserGreaterThan(String value) {
            addCriterion("reply_user >", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("reply_user >=", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserLessThan(String value) {
            addCriterion("reply_user <", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserLessThanOrEqualTo(String value) {
            addCriterion("reply_user <=", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserIn(List<String> values) {
            addCriterion("reply_user in", values, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserNotIn(List<String> values) {
            addCriterion("reply_user not in", values, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserBetween(String value1, String value2) {
            addCriterion("reply_user between", value1, value2, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserNotBetween(String value1, String value2) {
            addCriterion("reply_user not between", value1, value2, "reply_user");
            return (Criteria) this;
        }
        
    	public Criteria andReplyUserLike(String value) {
            addCriterion("reply_user like", value, "reply_user");
            return (Criteria) this;
        }

        public Criteria andReplyUserNotLike(String value) {
            addCriterion("reply_user not like", value, "reply_user");
            return (Criteria) this;
        }
    	public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(java.util.Date value) {
            addCriterion("reply_time =", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(java.util.Date value) {
            addCriterion("reply_time <>", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(java.util.Date value) {
            addCriterion("reply_time >", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("reply_time >=", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(java.util.Date value) {
            addCriterion("reply_time <", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("reply_time <=", value, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<java.util.Date> values) {
            addCriterion("reply_time in", values, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<java.util.Date> values) {
            addCriterion("reply_time not in", values, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("reply_time between", value1, value2, "reply_time");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("reply_time not between", value1, value2, "reply_time");
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