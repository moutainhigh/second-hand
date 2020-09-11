package com.example.user.center.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SecondStoreExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public SecondStoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
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
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
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

        public Criteria andStoreTypeIsNull() {
            addCriterion("store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(String value) {
            addCriterion("store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(String value) {
            addCriterion("store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(String value) {
            addCriterion("store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(String value) {
            addCriterion("store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLike(String value) {
            addCriterion("store_type like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotLike(String value) {
            addCriterion("store_type not like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<String> values) {
            addCriterion("store_type in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<String> values) {
            addCriterion("store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(String value1, String value2) {
            addCriterion("store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(String value1, String value2) {
            addCriterion("store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSecondDescIsNull() {
            addCriterion("second_desc is null");
            return (Criteria) this;
        }

        public Criteria andSecondDescIsNotNull() {
            addCriterion("second_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDescEqualTo(String value) {
            addCriterion("second_desc =", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescNotEqualTo(String value) {
            addCriterion("second_desc <>", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescGreaterThan(String value) {
            addCriterion("second_desc >", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescGreaterThanOrEqualTo(String value) {
            addCriterion("second_desc >=", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescLessThan(String value) {
            addCriterion("second_desc <", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescLessThanOrEqualTo(String value) {
            addCriterion("second_desc <=", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescLike(String value) {
            addCriterion("second_desc like", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescNotLike(String value) {
            addCriterion("second_desc not like", value, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescIn(List<String> values) {
            addCriterion("second_desc in", values, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescNotIn(List<String> values) {
            addCriterion("second_desc not in", values, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescBetween(String value1, String value2) {
            addCriterion("second_desc between", value1, value2, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andSecondDescNotBetween(String value1, String value2) {
            addCriterion("second_desc not between", value1, value2, "secondDesc");
            return (Criteria) this;
        }

        public Criteria andBossIdIsNull() {
            addCriterion("boss_id is null");
            return (Criteria) this;
        }

        public Criteria andBossIdIsNotNull() {
            addCriterion("boss_id is not null");
            return (Criteria) this;
        }

        public Criteria andBossIdEqualTo(Integer value) {
            addCriterion("boss_id =", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotEqualTo(Integer value) {
            addCriterion("boss_id <>", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdGreaterThan(Integer value) {
            addCriterion("boss_id >", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("boss_id >=", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdLessThan(Integer value) {
            addCriterion("boss_id <", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdLessThanOrEqualTo(Integer value) {
            addCriterion("boss_id <=", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdIn(List<Integer> values) {
            addCriterion("boss_id in", values, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotIn(List<Integer> values) {
            addCriterion("boss_id not in", values, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdBetween(Integer value1, Integer value2) {
            addCriterion("boss_id between", value1, value2, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotBetween(Integer value1, Integer value2) {
            addCriterion("boss_id not between", value1, value2, "bossId");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceIsNull() {
            addCriterion("second_balance is null");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceIsNotNull() {
            addCriterion("second_balance is not null");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceEqualTo(Integer value) {
            addCriterion("second_balance =", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceNotEqualTo(Integer value) {
            addCriterion("second_balance <>", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceGreaterThan(Integer value) {
            addCriterion("second_balance >", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_balance >=", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceLessThan(Integer value) {
            addCriterion("second_balance <", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("second_balance <=", value, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceIn(List<Integer> values) {
            addCriterion("second_balance in", values, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceNotIn(List<Integer> values) {
            addCriterion("second_balance not in", values, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceBetween(Integer value1, Integer value2) {
            addCriterion("second_balance between", value1, value2, "secondBalance");
            return (Criteria) this;
        }

        public Criteria andSecondBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("second_balance not between", value1, value2, "secondBalance");
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

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(LocalDateTime value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(LocalDateTime value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(LocalDateTime value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(LocalDateTime value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<LocalDateTime> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<LocalDateTime> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(LocalDateTime value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(LocalDateTime value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(LocalDateTime value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(LocalDateTime value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<LocalDateTime> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<LocalDateTime> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andSecondStatusIsNull() {
            addCriterion("second_status is null");
            return (Criteria) this;
        }

        public Criteria andSecondStatusIsNotNull() {
            addCriterion("second_status is not null");
            return (Criteria) this;
        }

        public Criteria andSecondStatusEqualTo(Integer value) {
            addCriterion("second_status =", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusNotEqualTo(Integer value) {
            addCriterion("second_status <>", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusGreaterThan(Integer value) {
            addCriterion("second_status >", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_status >=", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusLessThan(Integer value) {
            addCriterion("second_status <", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusLessThanOrEqualTo(Integer value) {
            addCriterion("second_status <=", value, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusIn(List<Integer> values) {
            addCriterion("second_status in", values, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusNotIn(List<Integer> values) {
            addCriterion("second_status not in", values, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusBetween(Integer value1, Integer value2) {
            addCriterion("second_status between", value1, value2, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andSecondStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("second_status not between", value1, value2, "secondStatus");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Short value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Short value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Short value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Short value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Short value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Short value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Short> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Short> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Short value1, Short value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Short value1, Short value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andConcernCountIsNull() {
            addCriterion("concern_count is null");
            return (Criteria) this;
        }

        public Criteria andConcernCountIsNotNull() {
            addCriterion("concern_count is not null");
            return (Criteria) this;
        }

        public Criteria andConcernCountEqualTo(Integer value) {
            addCriterion("concern_count =", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotEqualTo(Integer value) {
            addCriterion("concern_count <>", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountGreaterThan(Integer value) {
            addCriterion("concern_count >", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("concern_count >=", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountLessThan(Integer value) {
            addCriterion("concern_count <", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountLessThanOrEqualTo(Integer value) {
            addCriterion("concern_count <=", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountIn(List<Integer> values) {
            addCriterion("concern_count in", values, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotIn(List<Integer> values) {
            addCriterion("concern_count not in", values, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountBetween(Integer value1, Integer value2) {
            addCriterion("concern_count between", value1, value2, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotBetween(Integer value1, Integer value2) {
            addCriterion("concern_count not between", value1, value2, "concernCount");
            return (Criteria) this;
        }

        public Criteria andSecondAddressIsNull() {
            addCriterion("second_address is null");
            return (Criteria) this;
        }

        public Criteria andSecondAddressIsNotNull() {
            addCriterion("second_address is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAddressEqualTo(String value) {
            addCriterion("second_address =", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressNotEqualTo(String value) {
            addCriterion("second_address <>", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressGreaterThan(String value) {
            addCriterion("second_address >", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressGreaterThanOrEqualTo(String value) {
            addCriterion("second_address >=", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressLessThan(String value) {
            addCriterion("second_address <", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressLessThanOrEqualTo(String value) {
            addCriterion("second_address <=", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressLike(String value) {
            addCriterion("second_address like", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressNotLike(String value) {
            addCriterion("second_address not like", value, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressIn(List<String> values) {
            addCriterion("second_address in", values, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressNotIn(List<String> values) {
            addCriterion("second_address not in", values, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressBetween(String value1, String value2) {
            addCriterion("second_address between", value1, value2, "secondAddress");
            return (Criteria) this;
        }

        public Criteria andSecondAddressNotBetween(String value1, String value2) {
            addCriterion("second_address not between", value1, value2, "secondAddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_store
     *
     * @mbg.generated do_not_delete_during_merge Fri Sep 11 11:15:05 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_store
     *
     * @mbg.generated Fri Sep 11 11:15:05 CST 2020
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