package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class SystemErrorLogExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public SystemErrorLogExample() {
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
        
    	public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
        
    	public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }
    	public Criteria andPriIsNull() {
            addCriterion("pri is null");
            return (Criteria) this;
        }

        public Criteria andPriIsNotNull() {
            addCriterion("pri is not null");
            return (Criteria) this;
        }

        public Criteria andPriEqualTo(Integer value) {
            addCriterion("pri =", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotEqualTo(Integer value) {
            addCriterion("pri <>", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThan(Integer value) {
            addCriterion("pri >", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThanOrEqualTo(Integer value) {
            addCriterion("pri >=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThan(Integer value) {
            addCriterion("pri <", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThanOrEqualTo(Integer value) {
            addCriterion("pri <=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriIn(List<Integer> values) {
            addCriterion("pri in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotIn(List<Integer> values) {
            addCriterion("pri not in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriBetween(Integer value1, Integer value2) {
            addCriterion("pri between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotBetween(Integer value1, Integer value2) {
            addCriterion("pri not between", value1, value2, "pri");
            return (Criteria) this;
        }
        
    	public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Integer> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Integer> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("platform not between", value1, value2, "platform");
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
    	public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }
        
    	public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }
    	public Criteria andActionTypeIsNull() {
            addCriterion("action_type is null");
            return (Criteria) this;
        }

        public Criteria andActionTypeIsNotNull() {
            addCriterion("action_type is not null");
            return (Criteria) this;
        }

        public Criteria andActionTypeEqualTo(Integer value) {
            addCriterion("action_type =", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotEqualTo(Integer value) {
            addCriterion("action_type <>", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThan(Integer value) {
            addCriterion("action_type >", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_type >=", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThan(Integer value) {
            addCriterion("action_type <", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("action_type <=", value, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeIn(List<Integer> values) {
            addCriterion("action_type in", values, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotIn(List<Integer> values) {
            addCriterion("action_type not in", values, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeBetween(Integer value1, Integer value2) {
            addCriterion("action_type between", value1, value2, "action_type");
            return (Criteria) this;
        }

        public Criteria andActionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("action_type not between", value1, value2, "action_type");
            return (Criteria) this;
        }
        
    	public Criteria andErrorInformationIsNull() {
            addCriterion("error_information is null");
            return (Criteria) this;
        }

        public Criteria andErrorInformationIsNotNull() {
            addCriterion("error_information is not null");
            return (Criteria) this;
        }

        public Criteria andErrorInformationEqualTo(String value) {
            addCriterion("error_information =", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationNotEqualTo(String value) {
            addCriterion("error_information <>", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationGreaterThan(String value) {
            addCriterion("error_information >", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationGreaterThanOrEqualTo(String value) {
            addCriterion("error_information >=", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationLessThan(String value) {
            addCriterion("error_information <", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationLessThanOrEqualTo(String value) {
            addCriterion("error_information <=", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationIn(List<String> values) {
            addCriterion("error_information in", values, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationNotIn(List<String> values) {
            addCriterion("error_information not in", values, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationBetween(String value1, String value2) {
            addCriterion("error_information between", value1, value2, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationNotBetween(String value1, String value2) {
            addCriterion("error_information not between", value1, value2, "error_information");
            return (Criteria) this;
        }
        
    	public Criteria andErrorInformationLike(String value) {
            addCriterion("error_information like", value, "error_information");
            return (Criteria) this;
        }

        public Criteria andErrorInformationNotLike(String value) {
            addCriterion("error_information not like", value, "error_information");
            return (Criteria) this;
        }
    	public Criteria andRunCommandIsNull() {
            addCriterion("run_command is null");
            return (Criteria) this;
        }

        public Criteria andRunCommandIsNotNull() {
            addCriterion("run_command is not null");
            return (Criteria) this;
        }

        public Criteria andRunCommandEqualTo(String value) {
            addCriterion("run_command =", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandNotEqualTo(String value) {
            addCriterion("run_command <>", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandGreaterThan(String value) {
            addCriterion("run_command >", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandGreaterThanOrEqualTo(String value) {
            addCriterion("run_command >=", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandLessThan(String value) {
            addCriterion("run_command <", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandLessThanOrEqualTo(String value) {
            addCriterion("run_command <=", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandIn(List<String> values) {
            addCriterion("run_command in", values, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandNotIn(List<String> values) {
            addCriterion("run_command not in", values, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandBetween(String value1, String value2) {
            addCriterion("run_command between", value1, value2, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandNotBetween(String value1, String value2) {
            addCriterion("run_command not between", value1, value2, "run_command");
            return (Criteria) this;
        }
        
    	public Criteria andRunCommandLike(String value) {
            addCriterion("run_command like", value, "run_command");
            return (Criteria) this;
        }

        public Criteria andRunCommandNotLike(String value) {
            addCriterion("run_command not like", value, "run_command");
            return (Criteria) this;
        }
    	public Criteria andInformedIsNull() {
            addCriterion("informed is null");
            return (Criteria) this;
        }

        public Criteria andInformedIsNotNull() {
            addCriterion("informed is not null");
            return (Criteria) this;
        }

        public Criteria andInformedEqualTo(Integer value) {
            addCriterion("informed =", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedNotEqualTo(Integer value) {
            addCriterion("informed <>", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedGreaterThan(Integer value) {
            addCriterion("informed >", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedGreaterThanOrEqualTo(Integer value) {
            addCriterion("informed >=", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedLessThan(Integer value) {
            addCriterion("informed <", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedLessThanOrEqualTo(Integer value) {
            addCriterion("informed <=", value, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedIn(List<Integer> values) {
            addCriterion("informed in", values, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedNotIn(List<Integer> values) {
            addCriterion("informed not in", values, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedBetween(Integer value1, Integer value2) {
            addCriterion("informed between", value1, value2, "informed");
            return (Criteria) this;
        }

        public Criteria andInformedNotBetween(Integer value1, Integer value2) {
            addCriterion("informed not between", value1, value2, "informed");
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