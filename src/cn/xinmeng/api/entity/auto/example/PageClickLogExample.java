package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class PageClickLogExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public PageClickLogExample() {
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
        
    	public Criteria andPageNameIsNull() {
            addCriterion("page_name is null");
            return (Criteria) this;
        }

        public Criteria andPageNameIsNotNull() {
            addCriterion("page_name is not null");
            return (Criteria) this;
        }

        public Criteria andPageNameEqualTo(String value) {
            addCriterion("page_name =", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameNotEqualTo(String value) {
            addCriterion("page_name <>", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThan(String value) {
            addCriterion("page_name >", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThanOrEqualTo(String value) {
            addCriterion("page_name >=", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThan(String value) {
            addCriterion("page_name <", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThanOrEqualTo(String value) {
            addCriterion("page_name <=", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameIn(List<String> values) {
            addCriterion("page_name in", values, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameNotIn(List<String> values) {
            addCriterion("page_name not in", values, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameBetween(String value1, String value2) {
            addCriterion("page_name between", value1, value2, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameNotBetween(String value1, String value2) {
            addCriterion("page_name not between", value1, value2, "page_name");
            return (Criteria) this;
        }
        
    	public Criteria andPageNameLike(String value) {
            addCriterion("page_name like", value, "page_name");
            return (Criteria) this;
        }

        public Criteria andPageNameNotLike(String value) {
            addCriterion("page_name not like", value, "page_name");
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
        
    	public Criteria andLeaveTimeIsNull() {
            addCriterion("leave_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("leave_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(java.util.Date value) {
            addCriterion("leave_time =", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(java.util.Date value) {
            addCriterion("leave_time <>", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(java.util.Date value) {
            addCriterion("leave_time >", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("leave_time >=", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(java.util.Date value) {
            addCriterion("leave_time <", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("leave_time <=", value, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<java.util.Date> values) {
            addCriterion("leave_time in", values, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<java.util.Date> values) {
            addCriterion("leave_time not in", values, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("leave_time between", value1, value2, "leave_time");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("leave_time not between", value1, value2, "leave_time");
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