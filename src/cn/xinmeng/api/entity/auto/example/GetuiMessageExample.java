package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class GetuiMessageExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public GetuiMessageExample() {
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
        
    	public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
        
    	public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
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
    	public Criteria andShowTypeIsNull() {
            addCriterion("show_type is null");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNotNull() {
            addCriterion("show_type is not null");
            return (Criteria) this;
        }

        public Criteria andShowTypeEqualTo(Integer value) {
            addCriterion("show_type =", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotEqualTo(Integer value) {
            addCriterion("show_type <>", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThan(Integer value) {
            addCriterion("show_type >", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_type >=", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThan(Integer value) {
            addCriterion("show_type <", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("show_type <=", value, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeIn(List<Integer> values) {
            addCriterion("show_type in", values, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotIn(List<Integer> values) {
            addCriterion("show_type not in", values, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeBetween(Integer value1, Integer value2) {
            addCriterion("show_type between", value1, value2, "show_type");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("show_type not between", value1, value2, "show_type");
            return (Criteria) this;
        }
        
    	public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Integer value) {
            addCriterion("send_type =", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Integer value) {
            addCriterion("send_type <>", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Integer value) {
            addCriterion("send_type >", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_type >=", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Integer value) {
            addCriterion("send_type <", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("send_type <=", value, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Integer> values) {
            addCriterion("send_type in", values, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Integer> values) {
            addCriterion("send_type not in", values, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("send_type between", value1, value2, "send_type");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("send_type not between", value1, value2, "send_type");
            return (Criteria) this;
        }
        
    	public Criteria andUrlLinkIsNull() {
            addCriterion("url_link is null");
            return (Criteria) this;
        }

        public Criteria andUrlLinkIsNotNull() {
            addCriterion("url_link is not null");
            return (Criteria) this;
        }

        public Criteria andUrlLinkEqualTo(String value) {
            addCriterion("url_link =", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkNotEqualTo(String value) {
            addCriterion("url_link <>", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkGreaterThan(String value) {
            addCriterion("url_link >", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkGreaterThanOrEqualTo(String value) {
            addCriterion("url_link >=", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkLessThan(String value) {
            addCriterion("url_link <", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkLessThanOrEqualTo(String value) {
            addCriterion("url_link <=", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkIn(List<String> values) {
            addCriterion("url_link in", values, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkNotIn(List<String> values) {
            addCriterion("url_link not in", values, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkBetween(String value1, String value2) {
            addCriterion("url_link between", value1, value2, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkNotBetween(String value1, String value2) {
            addCriterion("url_link not between", value1, value2, "url_link");
            return (Criteria) this;
        }
        
    	public Criteria andUrlLinkLike(String value) {
            addCriterion("url_link like", value, "url_link");
            return (Criteria) this;
        }

        public Criteria andUrlLinkNotLike(String value) {
            addCriterion("url_link not like", value, "url_link");
            return (Criteria) this;
        }
    	public Criteria andReceiveTypeIsNull() {
            addCriterion("receive_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIsNotNull() {
            addCriterion("receive_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeEqualTo(Integer value) {
            addCriterion("receive_type =", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotEqualTo(Integer value) {
            addCriterion("receive_type <>", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThan(Integer value) {
            addCriterion("receive_type >", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_type >=", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThan(Integer value) {
            addCriterion("receive_type <", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("receive_type <=", value, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIn(List<Integer> values) {
            addCriterion("receive_type in", values, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotIn(List<Integer> values) {
            addCriterion("receive_type not in", values, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeBetween(Integer value1, Integer value2) {
            addCriterion("receive_type between", value1, value2, "receive_type");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_type not between", value1, value2, "receive_type");
            return (Criteria) this;
        }
        
    	public Criteria andReceiveObjectIsNull() {
            addCriterion("receive_object is null");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectIsNotNull() {
            addCriterion("receive_object is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectEqualTo(String value) {
            addCriterion("receive_object =", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectNotEqualTo(String value) {
            addCriterion("receive_object <>", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectGreaterThan(String value) {
            addCriterion("receive_object >", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectGreaterThanOrEqualTo(String value) {
            addCriterion("receive_object >=", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectLessThan(String value) {
            addCriterion("receive_object <", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectLessThanOrEqualTo(String value) {
            addCriterion("receive_object <=", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectIn(List<String> values) {
            addCriterion("receive_object in", values, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectNotIn(List<String> values) {
            addCriterion("receive_object not in", values, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectBetween(String value1, String value2) {
            addCriterion("receive_object between", value1, value2, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectNotBetween(String value1, String value2) {
            addCriterion("receive_object not between", value1, value2, "receive_object");
            return (Criteria) this;
        }
        
    	public Criteria andReceiveObjectLike(String value) {
            addCriterion("receive_object like", value, "receive_object");
            return (Criteria) this;
        }

        public Criteria andReceiveObjectNotLike(String value) {
            addCriterion("receive_object not like", value, "receive_object");
            return (Criteria) this;
        }
    	public Criteria andWhetherSendIsNull() {
            addCriterion("whether_send is null");
            return (Criteria) this;
        }

        public Criteria andWhetherSendIsNotNull() {
            addCriterion("whether_send is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherSendEqualTo(Integer value) {
            addCriterion("whether_send =", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendNotEqualTo(Integer value) {
            addCriterion("whether_send <>", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendGreaterThan(Integer value) {
            addCriterion("whether_send >", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("whether_send >=", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendLessThan(Integer value) {
            addCriterion("whether_send <", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendLessThanOrEqualTo(Integer value) {
            addCriterion("whether_send <=", value, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendIn(List<Integer> values) {
            addCriterion("whether_send in", values, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendNotIn(List<Integer> values) {
            addCriterion("whether_send not in", values, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendBetween(Integer value1, Integer value2) {
            addCriterion("whether_send between", value1, value2, "whether_send");
            return (Criteria) this;
        }

        public Criteria andWhetherSendNotBetween(Integer value1, Integer value2) {
            addCriterion("whether_send not between", value1, value2, "whether_send");
            return (Criteria) this;
        }
        
    	public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(java.util.Date value) {
            addCriterion("send_time =", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(java.util.Date value) {
            addCriterion("send_time <>", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(java.util.Date value) {
            addCriterion("send_time >", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("send_time >=", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(java.util.Date value) {
            addCriterion("send_time <", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("send_time <=", value, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<java.util.Date> values) {
            addCriterion("send_time in", values, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<java.util.Date> values) {
            addCriterion("send_time not in", values, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("send_time between", value1, value2, "send_time");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("send_time not between", value1, value2, "send_time");
            return (Criteria) this;
        }
        
    	public Criteria andSendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            addCriterion("send_status =", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            addCriterion("send_status <>", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            addCriterion("send_status >", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_status >=", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Integer value) {
            addCriterion("send_status <", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("send_status <=", value, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            addCriterion("send_status in", values, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            addCriterion("send_status not in", values, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("send_status between", value1, value2, "send_status");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("send_status not between", value1, value2, "send_status");
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