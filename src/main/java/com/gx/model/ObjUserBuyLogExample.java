package com.gx.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjUserBuyLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public ObjUserBuyLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
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
     * This method corresponds to the database table obj_user_buy_log
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
     * This method corresponds to the database table obj_user_buy_log
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_buy_log
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
     * This class corresponds to the database table obj_user_buy_log
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andCreate_tmIsNull() {
            addCriterion("create_tm is null");
            return (Criteria) this;
        }

        public Criteria andCreate_tmIsNotNull() {
            addCriterion("create_tm is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_tmEqualTo(Date value) {
            addCriterion("create_tm =", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmNotEqualTo(Date value) {
            addCriterion("create_tm <>", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmGreaterThan(Date value) {
            addCriterion("create_tm >", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmGreaterThanOrEqualTo(Date value) {
            addCriterion("create_tm >=", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmLessThan(Date value) {
            addCriterion("create_tm <", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmLessThanOrEqualTo(Date value) {
            addCriterion("create_tm <=", value, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmIn(List<Date> values) {
            addCriterion("create_tm in", values, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmNotIn(List<Date> values) {
            addCriterion("create_tm not in", values, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmBetween(Date value1, Date value2) {
            addCriterion("create_tm between", value1, value2, "create_tm");
            return (Criteria) this;
        }

        public Criteria andCreate_tmNotBetween(Date value1, Date value2) {
            addCriterion("create_tm not between", value1, value2, "create_tm");
            return (Criteria) this;
        }

        public Criteria andP_numIsNull() {
            addCriterion("p_num is null");
            return (Criteria) this;
        }

        public Criteria andP_numIsNotNull() {
            addCriterion("p_num is not null");
            return (Criteria) this;
        }

        public Criteria andP_numEqualTo(Integer value) {
            addCriterion("p_num =", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numNotEqualTo(Integer value) {
            addCriterion("p_num <>", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numGreaterThan(Integer value) {
            addCriterion("p_num >", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_num >=", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numLessThan(Integer value) {
            addCriterion("p_num <", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numLessThanOrEqualTo(Integer value) {
            addCriterion("p_num <=", value, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numIn(List<Integer> values) {
            addCriterion("p_num in", values, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numNotIn(List<Integer> values) {
            addCriterion("p_num not in", values, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numBetween(Integer value1, Integer value2) {
            addCriterion("p_num between", value1, value2, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_numNotBetween(Integer value1, Integer value2) {
            addCriterion("p_num not between", value1, value2, "p_num");
            return (Criteria) this;
        }

        public Criteria andP_totalIsNull() {
            addCriterion("p_total is null");
            return (Criteria) this;
        }

        public Criteria andP_totalIsNotNull() {
            addCriterion("p_total is not null");
            return (Criteria) this;
        }

        public Criteria andP_totalEqualTo(BigDecimal value) {
            addCriterion("p_total =", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalNotEqualTo(BigDecimal value) {
            addCriterion("p_total <>", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalGreaterThan(BigDecimal value) {
            addCriterion("p_total >", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("p_total >=", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalLessThan(BigDecimal value) {
            addCriterion("p_total <", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("p_total <=", value, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalIn(List<BigDecimal> values) {
            addCriterion("p_total in", values, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalNotIn(List<BigDecimal> values) {
            addCriterion("p_total not in", values, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("p_total between", value1, value2, "p_total");
            return (Criteria) this;
        }

        public Criteria andP_totalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("p_total not between", value1, value2, "p_total");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Long value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Long value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Long value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Long value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Long value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Long value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Long> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Long> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Long value1, Long value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Long value1, Long value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table obj_user_buy_log
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
     * This class corresponds to the database table obj_user_buy_log
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