package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class JobInfoExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public JobInfoExample() {
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
    	public Criteria andJobServiceUrlIsNull() {
            addCriterion("job_service_url is null");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlIsNotNull() {
            addCriterion("job_service_url is not null");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlEqualTo(String value) {
            addCriterion("job_service_url =", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlNotEqualTo(String value) {
            addCriterion("job_service_url <>", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlGreaterThan(String value) {
            addCriterion("job_service_url >", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("job_service_url >=", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlLessThan(String value) {
            addCriterion("job_service_url <", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlLessThanOrEqualTo(String value) {
            addCriterion("job_service_url <=", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlIn(List<String> values) {
            addCriterion("job_service_url in", values, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlNotIn(List<String> values) {
            addCriterion("job_service_url not in", values, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlBetween(String value1, String value2) {
            addCriterion("job_service_url between", value1, value2, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlNotBetween(String value1, String value2) {
            addCriterion("job_service_url not between", value1, value2, "job_service_url");
            return (Criteria) this;
        }
        
    	public Criteria andJobServiceUrlLike(String value) {
            addCriterion("job_service_url like", value, "job_service_url");
            return (Criteria) this;
        }

        public Criteria andJobServiceUrlNotLike(String value) {
            addCriterion("job_service_url not like", value, "job_service_url");
            return (Criteria) this;
        }
    	public Criteria andJobServiceNoIsNull() {
            addCriterion("job_service_no is null");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoIsNotNull() {
            addCriterion("job_service_no is not null");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoEqualTo(Integer value) {
            addCriterion("job_service_no =", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoNotEqualTo(Integer value) {
            addCriterion("job_service_no <>", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoGreaterThan(Integer value) {
            addCriterion("job_service_no >", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_service_no >=", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoLessThan(Integer value) {
            addCriterion("job_service_no <", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoLessThanOrEqualTo(Integer value) {
            addCriterion("job_service_no <=", value, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoIn(List<Integer> values) {
            addCriterion("job_service_no in", values, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoNotIn(List<Integer> values) {
            addCriterion("job_service_no not in", values, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoBetween(Integer value1, Integer value2) {
            addCriterion("job_service_no between", value1, value2, "job_service_no");
            return (Criteria) this;
        }

        public Criteria andJobServiceNoNotBetween(Integer value1, Integer value2) {
            addCriterion("job_service_no not between", value1, value2, "job_service_no");
            return (Criteria) this;
        }
        
    	public Criteria andJobDescriptionIsNull() {
            addCriterion("job_description is null");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionIsNotNull() {
            addCriterion("job_description is not null");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionEqualTo(String value) {
            addCriterion("job_description =", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotEqualTo(String value) {
            addCriterion("job_description <>", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionGreaterThan(String value) {
            addCriterion("job_description >", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("job_description >=", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionLessThan(String value) {
            addCriterion("job_description <", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionLessThanOrEqualTo(String value) {
            addCriterion("job_description <=", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionIn(List<String> values) {
            addCriterion("job_description in", values, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotIn(List<String> values) {
            addCriterion("job_description not in", values, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionBetween(String value1, String value2) {
            addCriterion("job_description between", value1, value2, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotBetween(String value1, String value2) {
            addCriterion("job_description not between", value1, value2, "job_description");
            return (Criteria) this;
        }
        
    	public Criteria andJobDescriptionLike(String value) {
            addCriterion("job_description like", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJobDescriptionNotLike(String value) {
            addCriterion("job_description not like", value, "job_description");
            return (Criteria) this;
        }
    	public Criteria andLastExecutionTimeIsNull() {
            addCriterion("last_execution_time is null");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeIsNotNull() {
            addCriterion("last_execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeEqualTo(java.util.Date value) {
            addCriterion("last_execution_time =", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotEqualTo(java.util.Date value) {
            addCriterion("last_execution_time <>", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeGreaterThan(java.util.Date value) {
            addCriterion("last_execution_time >", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("last_execution_time >=", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeLessThan(java.util.Date value) {
            addCriterion("last_execution_time <", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("last_execution_time <=", value, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeIn(List<java.util.Date> values) {
            addCriterion("last_execution_time in", values, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotIn(List<java.util.Date> values) {
            addCriterion("last_execution_time not in", values, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("last_execution_time between", value1, value2, "last_execution_time");
            return (Criteria) this;
        }

        public Criteria andLastExecutionTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("last_execution_time not between", value1, value2, "last_execution_time");
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
        
    	public Criteria andExecutionCountIsNull() {
            addCriterion("execution_count is null");
            return (Criteria) this;
        }

        public Criteria andExecutionCountIsNotNull() {
            addCriterion("execution_count is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionCountEqualTo(Integer value) {
            addCriterion("execution_count =", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountNotEqualTo(Integer value) {
            addCriterion("execution_count <>", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountGreaterThan(Integer value) {
            addCriterion("execution_count >", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("execution_count >=", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountLessThan(Integer value) {
            addCriterion("execution_count <", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountLessThanOrEqualTo(Integer value) {
            addCriterion("execution_count <=", value, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountIn(List<Integer> values) {
            addCriterion("execution_count in", values, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountNotIn(List<Integer> values) {
            addCriterion("execution_count not in", values, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountBetween(Integer value1, Integer value2) {
            addCriterion("execution_count between", value1, value2, "execution_count");
            return (Criteria) this;
        }

        public Criteria andExecutionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("execution_count not between", value1, value2, "execution_count");
            return (Criteria) this;
        }
        
    	public Criteria andFailedCountIsNull() {
            addCriterion("failed_count is null");
            return (Criteria) this;
        }

        public Criteria andFailedCountIsNotNull() {
            addCriterion("failed_count is not null");
            return (Criteria) this;
        }

        public Criteria andFailedCountEqualTo(Integer value) {
            addCriterion("failed_count =", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountNotEqualTo(Integer value) {
            addCriterion("failed_count <>", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountGreaterThan(Integer value) {
            addCriterion("failed_count >", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed_count >=", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountLessThan(Integer value) {
            addCriterion("failed_count <", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountLessThanOrEqualTo(Integer value) {
            addCriterion("failed_count <=", value, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountIn(List<Integer> values) {
            addCriterion("failed_count in", values, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountNotIn(List<Integer> values) {
            addCriterion("failed_count not in", values, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountBetween(Integer value1, Integer value2) {
            addCriterion("failed_count between", value1, value2, "failed_count");
            return (Criteria) this;
        }

        public Criteria andFailedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("failed_count not between", value1, value2, "failed_count");
            return (Criteria) this;
        }
        
    	public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(Integer value) {
            addCriterion("job_type =", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(Integer value) {
            addCriterion("job_type <>", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(Integer value) {
            addCriterion("job_type >", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_type >=", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(Integer value) {
            addCriterion("job_type <", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(Integer value) {
            addCriterion("job_type <=", value, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<Integer> values) {
            addCriterion("job_type in", values, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<Integer> values) {
            addCriterion("job_type not in", values, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(Integer value1, Integer value2) {
            addCriterion("job_type between", value1, value2, "job_type");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("job_type not between", value1, value2, "job_type");
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