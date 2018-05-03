package cn.xinmeng.api.entity.auto.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class CategoryExample {
	
    protected String orderByClause;

    protected boolean distinct;
    
    protected String fieldList;
    
    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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
        
    	public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "category_name");
            return (Criteria) this;
        }
        
    	public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "category_name");
            return (Criteria) this;
        }
    	public Criteria andCategoryDescriptionIsNull() {
            addCriterion("category_description is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionIsNotNull() {
            addCriterion("category_description is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionEqualTo(String value) {
            addCriterion("category_description =", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotEqualTo(String value) {
            addCriterion("category_description <>", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionGreaterThan(String value) {
            addCriterion("category_description >", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("category_description >=", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionLessThan(String value) {
            addCriterion("category_description <", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionLessThanOrEqualTo(String value) {
            addCriterion("category_description <=", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionIn(List<String> values) {
            addCriterion("category_description in", values, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotIn(List<String> values) {
            addCriterion("category_description not in", values, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionBetween(String value1, String value2) {
            addCriterion("category_description between", value1, value2, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotBetween(String value1, String value2) {
            addCriterion("category_description not between", value1, value2, "category_description");
            return (Criteria) this;
        }
        
    	public Criteria andCategoryDescriptionLike(String value) {
            addCriterion("category_description like", value, "category_description");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotLike(String value) {
            addCriterion("category_description not like", value, "category_description");
            return (Criteria) this;
        }
    	public Criteria andFirstIdIsNull() {
            addCriterion("first_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstIdIsNotNull() {
            addCriterion("first_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIdEqualTo(Integer value) {
            addCriterion("first_id =", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotEqualTo(Integer value) {
            addCriterion("first_id <>", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThan(Integer value) {
            addCriterion("first_id >", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_id >=", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThan(Integer value) {
            addCriterion("first_id <", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdLessThanOrEqualTo(Integer value) {
            addCriterion("first_id <=", value, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdIn(List<Integer> values) {
            addCriterion("first_id in", values, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotIn(List<Integer> values) {
            addCriterion("first_id not in", values, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdBetween(Integer value1, Integer value2) {
            addCriterion("first_id between", value1, value2, "first_id");
            return (Criteria) this;
        }

        public Criteria andFirstIdNotBetween(Integer value1, Integer value2) {
            addCriterion("first_id not between", value1, value2, "first_id");
            return (Criteria) this;
        }
        
    	public Criteria andSecondIdIsNull() {
            addCriterion("second_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondIdIsNotNull() {
            addCriterion("second_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondIdEqualTo(Integer value) {
            addCriterion("second_id =", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotEqualTo(Integer value) {
            addCriterion("second_id <>", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThan(Integer value) {
            addCriterion("second_id >", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_id >=", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThan(Integer value) {
            addCriterion("second_id <", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThanOrEqualTo(Integer value) {
            addCriterion("second_id <=", value, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdIn(List<Integer> values) {
            addCriterion("second_id in", values, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotIn(List<Integer> values) {
            addCriterion("second_id not in", values, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdBetween(Integer value1, Integer value2) {
            addCriterion("second_id between", value1, value2, "second_id");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotBetween(Integer value1, Integer value2) {
            addCriterion("second_id not between", value1, value2, "second_id");
            return (Criteria) this;
        }
        
    	public Criteria andIcoIsNull() {
            addCriterion("ico is null");
            return (Criteria) this;
        }

        public Criteria andIcoIsNotNull() {
            addCriterion("ico is not null");
            return (Criteria) this;
        }

        public Criteria andIcoEqualTo(String value) {
            addCriterion("ico =", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotEqualTo(String value) {
            addCriterion("ico <>", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoGreaterThan(String value) {
            addCriterion("ico >", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoGreaterThanOrEqualTo(String value) {
            addCriterion("ico >=", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoLessThan(String value) {
            addCriterion("ico <", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoLessThanOrEqualTo(String value) {
            addCriterion("ico <=", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoIn(List<String> values) {
            addCriterion("ico in", values, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotIn(List<String> values) {
            addCriterion("ico not in", values, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoBetween(String value1, String value2) {
            addCriterion("ico between", value1, value2, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotBetween(String value1, String value2) {
            addCriterion("ico not between", value1, value2, "ico");
            return (Criteria) this;
        }
        
    	public Criteria andIcoLike(String value) {
            addCriterion("ico like", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotLike(String value) {
            addCriterion("ico not like", value, "ico");
            return (Criteria) this;
        }
    	public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
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