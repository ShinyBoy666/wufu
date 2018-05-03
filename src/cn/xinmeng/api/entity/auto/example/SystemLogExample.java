package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class SystemLogExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public SystemLogExample() {
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
        
    	public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employee_id");
            return (Criteria) this;
        }
        
    	public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employee_id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employee_id");
            return (Criteria) this;
        }
    	public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employee_name");
            return (Criteria) this;
        }
        
    	public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employee_name");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employee_name");
            return (Criteria) this;
        }
    	public Criteria andModuleNameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("module_name =", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("module_name <>", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("module_name >", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("module_name >=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("module_name <", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("module_name <=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("module_name in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("module_name not in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("module_name between", value1, value2, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("module_name not between", value1, value2, "module_name");
            return (Criteria) this;
        }
        
    	public Criteria andModuleNameLike(String value) {
            addCriterion("module_name like", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("module_name not like", value, "module_name");
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
    	public Criteria andPageUrlIsNull() {
            addCriterion("page_url is null");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNotNull() {
            addCriterion("page_url is not null");
            return (Criteria) this;
        }

        public Criteria andPageUrlEqualTo(String value) {
            addCriterion("page_url =", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotEqualTo(String value) {
            addCriterion("page_url <>", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThan(String value) {
            addCriterion("page_url >", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("page_url >=", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThan(String value) {
            addCriterion("page_url <", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThanOrEqualTo(String value) {
            addCriterion("page_url <=", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlIn(List<String> values) {
            addCriterion("page_url in", values, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotIn(List<String> values) {
            addCriterion("page_url not in", values, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlBetween(String value1, String value2) {
            addCriterion("page_url between", value1, value2, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotBetween(String value1, String value2) {
            addCriterion("page_url not between", value1, value2, "page_url");
            return (Criteria) this;
        }
        
    	public Criteria andPageUrlLike(String value) {
            addCriterion("page_url like", value, "page_url");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotLike(String value) {
            addCriterion("page_url not like", value, "page_url");
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
    	public Criteria andHistoryRecordIsNull() {
            addCriterion("history_record is null");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordIsNotNull() {
            addCriterion("history_record is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordEqualTo(String value) {
            addCriterion("history_record =", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotEqualTo(String value) {
            addCriterion("history_record <>", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordGreaterThan(String value) {
            addCriterion("history_record >", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordGreaterThanOrEqualTo(String value) {
            addCriterion("history_record >=", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordLessThan(String value) {
            addCriterion("history_record <", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordLessThanOrEqualTo(String value) {
            addCriterion("history_record <=", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordIn(List<String> values) {
            addCriterion("history_record in", values, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotIn(List<String> values) {
            addCriterion("history_record not in", values, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordBetween(String value1, String value2) {
            addCriterion("history_record between", value1, value2, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotBetween(String value1, String value2) {
            addCriterion("history_record not between", value1, value2, "history_record");
            return (Criteria) this;
        }
        
    	public Criteria andHistoryRecordLike(String value) {
            addCriterion("history_record like", value, "history_record");
            return (Criteria) this;
        }

        public Criteria andHistoryRecordNotLike(String value) {
            addCriterion("history_record not like", value, "history_record");
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