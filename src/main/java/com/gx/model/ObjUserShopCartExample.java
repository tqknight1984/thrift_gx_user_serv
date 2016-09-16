package com.gx.model;

import java.util.ArrayList;
import java.util.List;

public class ObjUserShopCartExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public ObjUserShopCartExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
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
     * This method corresponds to the database table obj_user_shop_cart
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
     * This method corresponds to the database table obj_user_shop_cart
     *
     * @mbggenerated Fri Sep 16 14:52:01 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table obj_user_shop_cart
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
     * This class corresponds to the database table obj_user_shop_cart
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andBuy_numIsNull() {
            addCriterion("buy_num is null");
            return (Criteria) this;
        }

        public Criteria andBuy_numIsNotNull() {
            addCriterion("buy_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_numEqualTo(Integer value) {
            addCriterion("buy_num =", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numNotEqualTo(Integer value) {
            addCriterion("buy_num <>", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numGreaterThan(Integer value) {
            addCriterion("buy_num >", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_num >=", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numLessThan(Integer value) {
            addCriterion("buy_num <", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numLessThanOrEqualTo(Integer value) {
            addCriterion("buy_num <=", value, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numIn(List<Integer> values) {
            addCriterion("buy_num in", values, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numNotIn(List<Integer> values) {
            addCriterion("buy_num not in", values, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numBetween(Integer value1, Integer value2) {
            addCriterion("buy_num between", value1, value2, "buy_num");
            return (Criteria) this;
        }

        public Criteria andBuy_numNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_num not between", value1, value2, "buy_num");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRejectIsNull() {
            addCriterion("reject is null");
            return (Criteria) this;
        }

        public Criteria andRejectIsNotNull() {
            addCriterion("reject is not null");
            return (Criteria) this;
        }

        public Criteria andRejectEqualTo(String value) {
            addCriterion("reject =", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectNotEqualTo(String value) {
            addCriterion("reject <>", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectGreaterThan(String value) {
            addCriterion("reject >", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectGreaterThanOrEqualTo(String value) {
            addCriterion("reject >=", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectLessThan(String value) {
            addCriterion("reject <", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectLessThanOrEqualTo(String value) {
            addCriterion("reject <=", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectLike(String value) {
            addCriterion("reject like", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectNotLike(String value) {
            addCriterion("reject not like", value, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectIn(List<String> values) {
            addCriterion("reject in", values, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectNotIn(List<String> values) {
            addCriterion("reject not in", values, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectBetween(String value1, String value2) {
            addCriterion("reject between", value1, value2, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectNotBetween(String value1, String value2) {
            addCriterion("reject not between", value1, value2, "reject");
            return (Criteria) this;
        }

        public Criteria andRejectorIsNull() {
            addCriterion("rejector is null");
            return (Criteria) this;
        }

        public Criteria andRejectorIsNotNull() {
            addCriterion("rejector is not null");
            return (Criteria) this;
        }

        public Criteria andRejectorEqualTo(String value) {
            addCriterion("rejector =", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorNotEqualTo(String value) {
            addCriterion("rejector <>", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorGreaterThan(String value) {
            addCriterion("rejector >", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorGreaterThanOrEqualTo(String value) {
            addCriterion("rejector >=", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorLessThan(String value) {
            addCriterion("rejector <", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorLessThanOrEqualTo(String value) {
            addCriterion("rejector <=", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorLike(String value) {
            addCriterion("rejector like", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorNotLike(String value) {
            addCriterion("rejector not like", value, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorIn(List<String> values) {
            addCriterion("rejector in", values, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorNotIn(List<String> values) {
            addCriterion("rejector not in", values, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorBetween(String value1, String value2) {
            addCriterion("rejector between", value1, value2, "rejector");
            return (Criteria) this;
        }

        public Criteria andRejectorNotBetween(String value1, String value2) {
            addCriterion("rejector not between", value1, value2, "rejector");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table obj_user_shop_cart
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
     * This class corresponds to the database table obj_user_shop_cart
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