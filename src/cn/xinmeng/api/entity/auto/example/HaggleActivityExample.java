package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class HaggleActivityExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public HaggleActivityExample() {
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
        
    	public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shop_id");
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
    	public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "image_url");
            return (Criteria) this;
        }
        
    	public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "image_url");
            return (Criteria) this;
        }
    	public Criteria andShowTimeIsNull() {
            addCriterion("show_time is null");
            return (Criteria) this;
        }

        public Criteria andShowTimeIsNotNull() {
            addCriterion("show_time is not null");
            return (Criteria) this;
        }

        public Criteria andShowTimeEqualTo(java.util.Date value) {
            addCriterion("show_time =", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotEqualTo(java.util.Date value) {
            addCriterion("show_time <>", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThan(java.util.Date value) {
            addCriterion("show_time >", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("show_time >=", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThan(java.util.Date value) {
            addCriterion("show_time <", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("show_time <=", value, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeIn(List<java.util.Date> values) {
            addCriterion("show_time in", values, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotIn(List<java.util.Date> values) {
            addCriterion("show_time not in", values, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("show_time between", value1, value2, "show_time");
            return (Criteria) this;
        }

        public Criteria andShowTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("show_time not between", value1, value2, "show_time");
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
        
    	public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(java.util.Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(java.util.Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(java.util.Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(java.util.Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<java.util.Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<java.util.Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }
        
    	public Criteria andIsFreePostageIsNull() {
            addCriterion("is_free_postage is null");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageIsNotNull() {
            addCriterion("is_free_postage is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageEqualTo(Integer value) {
            addCriterion("is_free_postage =", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageNotEqualTo(Integer value) {
            addCriterion("is_free_postage <>", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageGreaterThan(Integer value) {
            addCriterion("is_free_postage >", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_free_postage >=", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageLessThan(Integer value) {
            addCriterion("is_free_postage <", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageLessThanOrEqualTo(Integer value) {
            addCriterion("is_free_postage <=", value, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageIn(List<Integer> values) {
            addCriterion("is_free_postage in", values, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageNotIn(List<Integer> values) {
            addCriterion("is_free_postage not in", values, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageBetween(Integer value1, Integer value2) {
            addCriterion("is_free_postage between", value1, value2, "is_free_postage");
            return (Criteria) this;
        }

        public Criteria andIsFreePostageNotBetween(Integer value1, Integer value2) {
            addCriterion("is_free_postage not between", value1, value2, "is_free_postage");
            return (Criteria) this;
        }
        
    	public Criteria andPostageIsNull() {
            addCriterion("postage is null");
            return (Criteria) this;
        }

        public Criteria andPostageIsNotNull() {
            addCriterion("postage is not null");
            return (Criteria) this;
        }

        public Criteria andPostageEqualTo(Double value) {
            addCriterion("postage =", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotEqualTo(Double value) {
            addCriterion("postage <>", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThan(Double value) {
            addCriterion("postage >", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThanOrEqualTo(Double value) {
            addCriterion("postage >=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThan(Double value) {
            addCriterion("postage <", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThanOrEqualTo(Double value) {
            addCriterion("postage <=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageIn(List<Double> values) {
            addCriterion("postage in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotIn(List<Double> values) {
            addCriterion("postage not in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageBetween(Double value1, Double value2) {
            addCriterion("postage between", value1, value2, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotBetween(Double value1, Double value2) {
            addCriterion("postage not between", value1, value2, "postage");
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
        
    	public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
        
    	public Criteria andHighPriceIsNull() {
            addCriterion("high_price is null");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNotNull() {
            addCriterion("high_price is not null");
            return (Criteria) this;
        }

        public Criteria andHighPriceEqualTo(Double value) {
            addCriterion("high_price =", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotEqualTo(Double value) {
            addCriterion("high_price <>", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThan(Double value) {
            addCriterion("high_price >", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("high_price >=", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThan(Double value) {
            addCriterion("high_price <", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThanOrEqualTo(Double value) {
            addCriterion("high_price <=", value, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceIn(List<Double> values) {
            addCriterion("high_price in", values, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotIn(List<Double> values) {
            addCriterion("high_price not in", values, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceBetween(Double value1, Double value2) {
            addCriterion("high_price between", value1, value2, "high_price");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotBetween(Double value1, Double value2) {
            addCriterion("high_price not between", value1, value2, "high_price");
            return (Criteria) this;
        }
        
    	public Criteria andLowPriceIsNull() {
            addCriterion("low_price is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("low_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(Double value) {
            addCriterion("low_price =", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(Double value) {
            addCriterion("low_price <>", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(Double value) {
            addCriterion("low_price >", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("low_price >=", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(Double value) {
            addCriterion("low_price <", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(Double value) {
            addCriterion("low_price <=", value, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<Double> values) {
            addCriterion("low_price in", values, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<Double> values) {
            addCriterion("low_price not in", values, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(Double value1, Double value2) {
            addCriterion("low_price between", value1, value2, "low_price");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(Double value1, Double value2) {
            addCriterion("low_price not between", value1, value2, "low_price");
            return (Criteria) this;
        }
        
    	public Criteria andHaggleNumberIsNull() {
            addCriterion("haggle_number is null");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberIsNotNull() {
            addCriterion("haggle_number is not null");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberEqualTo(Integer value) {
            addCriterion("haggle_number =", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberNotEqualTo(Integer value) {
            addCriterion("haggle_number <>", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberGreaterThan(Integer value) {
            addCriterion("haggle_number >", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("haggle_number >=", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberLessThan(Integer value) {
            addCriterion("haggle_number <", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("haggle_number <=", value, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberIn(List<Integer> values) {
            addCriterion("haggle_number in", values, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberNotIn(List<Integer> values) {
            addCriterion("haggle_number not in", values, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberBetween(Integer value1, Integer value2) {
            addCriterion("haggle_number between", value1, value2, "haggle_number");
            return (Criteria) this;
        }

        public Criteria andHaggleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("haggle_number not between", value1, value2, "haggle_number");
            return (Criteria) this;
        }
        
    	public Criteria andDegressionIsNull() {
            addCriterion("degression is null");
            return (Criteria) this;
        }

        public Criteria andDegressionIsNotNull() {
            addCriterion("degression is not null");
            return (Criteria) this;
        }

        public Criteria andDegressionEqualTo(Double value) {
            addCriterion("degression =", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionNotEqualTo(Double value) {
            addCriterion("degression <>", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionGreaterThan(Double value) {
            addCriterion("degression >", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionGreaterThanOrEqualTo(Double value) {
            addCriterion("degression >=", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionLessThan(Double value) {
            addCriterion("degression <", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionLessThanOrEqualTo(Double value) {
            addCriterion("degression <=", value, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionIn(List<Double> values) {
            addCriterion("degression in", values, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionNotIn(List<Double> values) {
            addCriterion("degression not in", values, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionBetween(Double value1, Double value2) {
            addCriterion("degression between", value1, value2, "degression");
            return (Criteria) this;
        }

        public Criteria andDegressionNotBetween(Double value1, Double value2) {
            addCriterion("degression not between", value1, value2, "degression");
            return (Criteria) this;
        }
        
    	public Criteria andPatternIsNull() {
            addCriterion("pattern is null");
            return (Criteria) this;
        }

        public Criteria andPatternIsNotNull() {
            addCriterion("pattern is not null");
            return (Criteria) this;
        }

        public Criteria andPatternEqualTo(Integer value) {
            addCriterion("pattern =", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotEqualTo(Integer value) {
            addCriterion("pattern <>", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThan(Integer value) {
            addCriterion("pattern >", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThanOrEqualTo(Integer value) {
            addCriterion("pattern >=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThan(Integer value) {
            addCriterion("pattern <", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThanOrEqualTo(Integer value) {
            addCriterion("pattern <=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternIn(List<Integer> values) {
            addCriterion("pattern in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotIn(List<Integer> values) {
            addCriterion("pattern not in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternBetween(Integer value1, Integer value2) {
            addCriterion("pattern between", value1, value2, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotBetween(Integer value1, Integer value2) {
            addCriterion("pattern not between", value1, value2, "pattern");
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