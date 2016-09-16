package com.gx.model;

import java.util.ArrayList;
import java.util.List;

public class RefAreaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public RefAreaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
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

        public Criteria andAreaidIsNull() {
            addCriterion("areaid is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("areaid is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(Integer value) {
            addCriterion("areaid =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(Integer value) {
            addCriterion("areaid <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(Integer value) {
            addCriterion("areaid >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("areaid >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(Integer value) {
            addCriterion("areaid <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(Integer value) {
            addCriterion("areaid <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<Integer> values) {
            addCriterion("areaid in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<Integer> values) {
            addCriterion("areaid not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(Integer value1, Integer value2) {
            addCriterion("areaid between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(Integer value1, Integer value2) {
            addCriterion("areaid not between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBy_nameIsNull() {
            addCriterion("by_name is null");
            return (Criteria) this;
        }

        public Criteria andBy_nameIsNotNull() {
            addCriterion("by_name is not null");
            return (Criteria) this;
        }

        public Criteria andBy_nameEqualTo(String value) {
            addCriterion("by_name =", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameNotEqualTo(String value) {
            addCriterion("by_name <>", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameGreaterThan(String value) {
            addCriterion("by_name >", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameGreaterThanOrEqualTo(String value) {
            addCriterion("by_name >=", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameLessThan(String value) {
            addCriterion("by_name <", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameLessThanOrEqualTo(String value) {
            addCriterion("by_name <=", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameLike(String value) {
            addCriterion("by_name like", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameNotLike(String value) {
            addCriterion("by_name not like", value, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameIn(List<String> values) {
            addCriterion("by_name in", values, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameNotIn(List<String> values) {
            addCriterion("by_name not in", values, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameBetween(String value1, String value2) {
            addCriterion("by_name between", value1, value2, "by_name");
            return (Criteria) this;
        }

        public Criteria andBy_nameNotBetween(String value1, String value2) {
            addCriterion("by_name not between", value1, value2, "by_name");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNull() {
            addCriterion("fatherid is null");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNotNull() {
            addCriterion("fatherid is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridEqualTo(Integer value) {
            addCriterion("fatherid =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(Integer value) {
            addCriterion("fatherid <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(Integer value) {
            addCriterion("fatherid >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fatherid >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(Integer value) {
            addCriterion("fatherid <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(Integer value) {
            addCriterion("fatherid <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<Integer> values) {
            addCriterion("fatherid in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<Integer> values) {
            addCriterion("fatherid not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(Integer value1, Integer value2) {
            addCriterion("fatherid between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("fatherid not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andPath_levelIsNull() {
            addCriterion("path_level is null");
            return (Criteria) this;
        }

        public Criteria andPath_levelIsNotNull() {
            addCriterion("path_level is not null");
            return (Criteria) this;
        }

        public Criteria andPath_levelEqualTo(Byte value) {
            addCriterion("path_level =", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelNotEqualTo(Byte value) {
            addCriterion("path_level <>", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelGreaterThan(Byte value) {
            addCriterion("path_level >", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelGreaterThanOrEqualTo(Byte value) {
            addCriterion("path_level >=", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelLessThan(Byte value) {
            addCriterion("path_level <", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelLessThanOrEqualTo(Byte value) {
            addCriterion("path_level <=", value, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelIn(List<Byte> values) {
            addCriterion("path_level in", values, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelNotIn(List<Byte> values) {
            addCriterion("path_level not in", values, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelBetween(Byte value1, Byte value2) {
            addCriterion("path_level between", value1, value2, "path_level");
            return (Criteria) this;
        }

        public Criteria andPath_levelNotBetween(Byte value1, Byte value2) {
            addCriterion("path_level not between", value1, value2, "path_level");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIsNull() {
            addCriterion("first_name is null");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIsNotNull() {
            addCriterion("first_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_nameEqualTo(String value) {
            addCriterion("first_name =", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotEqualTo(String value) {
            addCriterion("first_name <>", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThan(String value) {
            addCriterion("first_name >", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThanOrEqualTo(String value) {
            addCriterion("first_name >=", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThan(String value) {
            addCriterion("first_name <", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThanOrEqualTo(String value) {
            addCriterion("first_name <=", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameLike(String value) {
            addCriterion("first_name like", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotLike(String value) {
            addCriterion("first_name not like", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIn(List<String> values) {
            addCriterion("first_name in", values, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotIn(List<String> values) {
            addCriterion("first_name not in", values, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameBetween(String value1, String value2) {
            addCriterion("first_name between", value1, value2, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotBetween(String value1, String value2) {
            addCriterion("first_name not between", value1, value2, "first_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameEqualTo(String value) {
            addCriterion("english_name =", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameGreaterThan(String value) {
            addCriterion("english_name >", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLessThan(String value) {
            addCriterion("english_name <", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameLike(String value) {
            addCriterion("english_name like", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotLike(String value) {
            addCriterion("english_name not like", value, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameIn(List<String> values) {
            addCriterion("english_name in", values, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "english_name");
            return (Criteria) this;
        }

        public Criteria andEnglish_nameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "english_name");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteEqualTo(String value) {
            addCriterion("is_delete =", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThan(String value) {
            addCriterion("is_delete <", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLike(String value) {
            addCriterion("is_delete like", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotLike(String value) {
            addCriterion("is_delete not like", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIn(List<String> values) {
            addCriterion("is_delete in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "is_delete");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ref_area
     *
     * @mbggenerated do_not_delete_during_merge Fri Sep 16 14:52:01 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ref_area
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
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