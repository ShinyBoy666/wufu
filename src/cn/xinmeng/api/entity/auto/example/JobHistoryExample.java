package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class JobHistoryExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public JobHistoryExample() {
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
        
    	public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id in", values, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in", values, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between", value1, value2, "job_id");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between", value1, value2, "job_id");
            return (Criteria) this;
        }
        
    	public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Integer value) {
            addCriterion("plan_id =", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Integer value) {
            addCriterion("plan_id <>", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Integer value) {
            addCriterion("plan_id >", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_id >=", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Integer value) {
            addCriterion("plan_id <", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_id <=", value, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Integer> values) {
            addCriterion("plan_id in", values, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Integer> values) {
            addCriterion("plan_id not in", values, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_id between", value1, value2, "plan_id");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_id not between", value1, value2, "plan_id");
            return (Criteria) this;
        }
        
    	public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "job_name");
            return (Criteria) this;
        }
        
    	public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "job_name");
            return (Criteria) this;
        }
    	public Criteria andBeginExecutionTimeIsNull() {
            addCriterion("begin_execution_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeIsNotNull() {
            addCriterion("begin_execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeEqualTo(java.util.Date value) {
            addCriterion("begin_execution_time =", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeNotEqualTo(java.util.Date value) {
            addCriterion("begin_execution_time <>", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeGreaterThan(java.util.Date value) {
            addCriterion("begin_execution_time >", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_execution_time >=", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeLessThan(java.util.Date value) {
            addCriterion("begin_execution_time <", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_execution_time <=", value, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeIn(List<java.util.Date> values) {
            addCriterion("begin_execution_time in", values, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeNotIn(List<java.util.Date> values) {
            addCriterion("begin_execution_time not in", values, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_execution_time between", value1, value2, "begin_execution_time");
            return (Criteria) this;
        }

        public Criteria andBeginExecutionTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_execution_time not between", value1, value2, "begin_execution_time");
            return (Criteria) this;
        }
        
    	public Criteria andEndExecutionTimeIsNull() {
            addCriterion("end_execution_time is null");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeIsNotNull() {
            addCriterion("end_execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeEqualTo(java.util.Date value) {
            addCriterion("end_execution_time =", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeNotEqualTo(java.util.Date value) {
            addCriterion("end_execution_time <>", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeGreaterThan(java.util.Date value) {
            addCriterion("end_execution_time >", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("end_execution_time >=", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeLessThan(java.util.Date value) {
            addCriterion("end_execution_time <", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("end_execution_time <=", value, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeIn(List<java.util.Date> values) {
            addCriterion("end_execution_time in", values, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeNotIn(List<java.util.Date> values) {
            addCriterion("end_execution_time not in", values, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_execution_time between", value1, value2, "end_execution_time");
            return (Criteria) this;
        }

        public Criteria andEndExecutionTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_execution_time not between", value1, value2, "end_execution_time");
            return (Criteria) this;
        }
        
    	public Criteria andExecutionLongIsNull() {
            addCriterion("execution_long is null");
            return (Criteria) this;
        }

        public Criteria andExecutionLongIsNotNull() {
            addCriterion("execution_long is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionLongEqualTo(Long value) {
            addCriterion("execution_long =", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongNotEqualTo(Long value) {
            addCriterion("execution_long <>", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongGreaterThan(Long value) {
            addCriterion("execution_long >", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongGreaterThanOrEqualTo(Long value) {
            addCriterion("execution_long >=", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongLessThan(Long value) {
            addCriterion("execution_long <", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongLessThanOrEqualTo(Long value) {
            addCriterion("execution_long <=", value, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongIn(List<Long> values) {
            addCriterion("execution_long in", values, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongNotIn(List<Long> values) {
            addCriterion("execution_long not in", values, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongBetween(Long value1, Long value2) {
            addCriterion("execution_long between", value1, value2, "execution_long");
            return (Criteria) this;
        }

        public Criteria andExecutionLongNotBetween(Long value1, Long value2) {
            addCriterion("execution_long not between", value1, value2, "execution_long");
            return (Criteria) this;
        }
        
    	public Criteria andExecutionStateIsNull() {
            addCriterion("execution_state is null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIsNotNull() {
            addCriterion("execution_state is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateEqualTo(Integer value) {
            addCriterion("execution_state =", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotEqualTo(Integer value) {
            addCriterion("execution_state <>", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThan(Integer value) {
            addCriterion("execution_state >", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("execution_state >=", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThan(Integer value) {
            addCriterion("execution_state <", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThanOrEqualTo(Integer value) {
            addCriterion("execution_state <=", value, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIn(List<Integer> values) {
            addCriterion("execution_state in", values, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotIn(List<Integer> values) {
            addCriterion("execution_state not in", values, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateBetween(Integer value1, Integer value2) {
            addCriterion("execution_state between", value1, value2, "execution_state");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("execution_state not between", value1, value2, "execution_state");
            return (Criteria) this;
        }
        
    	public Criteria andExecutionInfoIsNull() {
            addCriterion("execution_info is null");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoIsNotNull() {
            addCriterion("execution_info is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoEqualTo(String value) {
            addCriterion("execution_info =", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoNotEqualTo(String value) {
            addCriterion("execution_info <>", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoGreaterThan(String value) {
            addCriterion("execution_info >", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("execution_info >=", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoLessThan(String value) {
            addCriterion("execution_info <", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoLessThanOrEqualTo(String value) {
            addCriterion("execution_info <=", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoIn(List<String> values) {
            addCriterion("execution_info in", values, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoNotIn(List<String> values) {
            addCriterion("execution_info not in", values, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoBetween(String value1, String value2) {
            addCriterion("execution_info between", value1, value2, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoNotBetween(String value1, String value2) {
            addCriterion("execution_info not between", value1, value2, "execution_info");
            return (Criteria) this;
        }
        
    	public Criteria andExecutionInfoLike(String value) {
            addCriterion("execution_info like", value, "execution_info");
            return (Criteria) this;
        }

        public Criteria andExecutionInfoNotLike(String value) {
            addCriterion("execution_info not like", value, "execution_info");
            return (Criteria) this;
        }
    	public Criteria andExecutionUserIsNull() {
            addCriterion("execution_user is null");
            return (Criteria) this;
        }

        public Criteria andExecutionUserIsNotNull() {
            addCriterion("execution_user is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionUserEqualTo(String value) {
            addCriterion("execution_user =", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserNotEqualTo(String value) {
            addCriterion("execution_user <>", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserGreaterThan(String value) {
            addCriterion("execution_user >", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserGreaterThanOrEqualTo(String value) {
            addCriterion("execution_user >=", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserLessThan(String value) {
            addCriterion("execution_user <", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserLessThanOrEqualTo(String value) {
            addCriterion("execution_user <=", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserIn(List<String> values) {
            addCriterion("execution_user in", values, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserNotIn(List<String> values) {
            addCriterion("execution_user not in", values, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserBetween(String value1, String value2) {
            addCriterion("execution_user between", value1, value2, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserNotBetween(String value1, String value2) {
            addCriterion("execution_user not between", value1, value2, "execution_user");
            return (Criteria) this;
        }
        
    	public Criteria andExecutionUserLike(String value) {
            addCriterion("execution_user like", value, "execution_user");
            return (Criteria) this;
        }

        public Criteria andExecutionUserNotLike(String value) {
            addCriterion("execution_user not like", value, "execution_user");
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