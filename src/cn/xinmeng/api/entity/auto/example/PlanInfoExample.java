package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class PlanInfoExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public PlanInfoExample() {
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
        
    	public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }
        
    	public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
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
        
    	public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(Integer value) {
            addCriterion("plan_type =", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(Integer value) {
            addCriterion("plan_type <>", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(Integer value) {
            addCriterion("plan_type >", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_type >=", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(Integer value) {
            addCriterion("plan_type <", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("plan_type <=", value, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<Integer> values) {
            addCriterion("plan_type in", values, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<Integer> values) {
            addCriterion("plan_type not in", values, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(Integer value1, Integer value2) {
            addCriterion("plan_type between", value1, value2, "plan_type");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_type not between", value1, value2, "plan_type");
            return (Criteria) this;
        }
        
    	public Criteria andPlanValueIsNull() {
            addCriterion("plan_value is null");
            return (Criteria) this;
        }

        public Criteria andPlanValueIsNotNull() {
            addCriterion("plan_value is not null");
            return (Criteria) this;
        }

        public Criteria andPlanValueEqualTo(Integer value) {
            addCriterion("plan_value =", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotEqualTo(Integer value) {
            addCriterion("plan_value <>", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueGreaterThan(Integer value) {
            addCriterion("plan_value >", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_value >=", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueLessThan(Integer value) {
            addCriterion("plan_value <", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueLessThanOrEqualTo(Integer value) {
            addCriterion("plan_value <=", value, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueIn(List<Integer> values) {
            addCriterion("plan_value in", values, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotIn(List<Integer> values) {
            addCriterion("plan_value not in", values, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueBetween(Integer value1, Integer value2) {
            addCriterion("plan_value between", value1, value2, "plan_value");
            return (Criteria) this;
        }

        public Criteria andPlanValueNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_value not between", value1, value2, "plan_value");
            return (Criteria) this;
        }
        
    	public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(java.util.Date value) {
            addCriterion("begin_time =", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(java.util.Date value) {
            addCriterion("begin_time <>", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(java.util.Date value) {
            addCriterion("begin_time >", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_time >=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(java.util.Date value) {
            addCriterion("begin_time <", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("begin_time <=", value, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<java.util.Date> values) {
            addCriterion("begin_time in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<java.util.Date> values) {
            addCriterion("begin_time not in", values, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_time between", value1, value2, "begin_time");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("begin_time not between", value1, value2, "begin_time");
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
    	public Criteria andMaxRepeatCountIsNull() {
            addCriterion("max_repeat_count is null");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountIsNotNull() {
            addCriterion("max_repeat_count is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountEqualTo(Integer value) {
            addCriterion("max_repeat_count =", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountNotEqualTo(Integer value) {
            addCriterion("max_repeat_count <>", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountGreaterThan(Integer value) {
            addCriterion("max_repeat_count >", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_repeat_count >=", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountLessThan(Integer value) {
            addCriterion("max_repeat_count <", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountLessThanOrEqualTo(Integer value) {
            addCriterion("max_repeat_count <=", value, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountIn(List<Integer> values) {
            addCriterion("max_repeat_count in", values, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountNotIn(List<Integer> values) {
            addCriterion("max_repeat_count not in", values, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountBetween(Integer value1, Integer value2) {
            addCriterion("max_repeat_count between", value1, value2, "max_repeat_count");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_repeat_count not between", value1, value2, "max_repeat_count");
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