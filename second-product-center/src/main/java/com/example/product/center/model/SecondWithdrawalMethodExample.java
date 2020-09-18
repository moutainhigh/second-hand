package com.example.product.center.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SecondWithdrawalMethodExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public SecondWithdrawalMethodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
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
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
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

        public Criteria andWithdrawalWayCodeIsNull() {
            addCriterion("withdrawal_way_code is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeIsNotNull() {
            addCriterion("withdrawal_way_code is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeEqualTo(String value) {
            addCriterion("withdrawal_way_code =", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeNotEqualTo(String value) {
            addCriterion("withdrawal_way_code <>", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeGreaterThan(String value) {
            addCriterion("withdrawal_way_code >", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawal_way_code >=", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeLessThan(String value) {
            addCriterion("withdrawal_way_code <", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeLessThanOrEqualTo(String value) {
            addCriterion("withdrawal_way_code <=", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeLike(String value) {
            addCriterion("withdrawal_way_code like", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeNotLike(String value) {
            addCriterion("withdrawal_way_code not like", value, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeIn(List<String> values) {
            addCriterion("withdrawal_way_code in", values, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeNotIn(List<String> values) {
            addCriterion("withdrawal_way_code not in", values, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeBetween(String value1, String value2) {
            addCriterion("withdrawal_way_code between", value1, value2, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayCodeNotBetween(String value1, String value2) {
            addCriterion("withdrawal_way_code not between", value1, value2, "withdrawalWayCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameIsNull() {
            addCriterion("withdrawal_way_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameIsNotNull() {
            addCriterion("withdrawal_way_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameEqualTo(String value) {
            addCriterion("withdrawal_way_name =", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameNotEqualTo(String value) {
            addCriterion("withdrawal_way_name <>", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameGreaterThan(String value) {
            addCriterion("withdrawal_way_name >", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawal_way_name >=", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameLessThan(String value) {
            addCriterion("withdrawal_way_name <", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameLessThanOrEqualTo(String value) {
            addCriterion("withdrawal_way_name <=", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameLike(String value) {
            addCriterion("withdrawal_way_name like", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameNotLike(String value) {
            addCriterion("withdrawal_way_name not like", value, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameIn(List<String> values) {
            addCriterion("withdrawal_way_name in", values, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameNotIn(List<String> values) {
            addCriterion("withdrawal_way_name not in", values, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameBetween(String value1, String value2) {
            addCriterion("withdrawal_way_name between", value1, value2, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalWayNameNotBetween(String value1, String value2) {
            addCriterion("withdrawal_way_name not between", value1, value2, "withdrawalWayName");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionIsNull() {
            addCriterion("withdrawal_commission is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionIsNotNull() {
            addCriterion("withdrawal_commission is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionEqualTo(Integer value) {
            addCriterion("withdrawal_commission =", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionNotEqualTo(Integer value) {
            addCriterion("withdrawal_commission <>", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionGreaterThan(Integer value) {
            addCriterion("withdrawal_commission >", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_commission >=", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionLessThan(Integer value) {
            addCriterion("withdrawal_commission <", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionLessThanOrEqualTo(Integer value) {
            addCriterion("withdrawal_commission <=", value, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionIn(List<Integer> values) {
            addCriterion("withdrawal_commission in", values, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionNotIn(List<Integer> values) {
            addCriterion("withdrawal_commission not in", values, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_commission between", value1, value2, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andWithdrawalCommissionNotBetween(Integer value1, Integer value2) {
            addCriterion("withdrawal_commission not between", value1, value2, "withdrawalCommission");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIsNull() {
            addCriterion("commission_type is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIsNotNull() {
            addCriterion("commission_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeEqualTo(String value) {
            addCriterion("commission_type =", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotEqualTo(String value) {
            addCriterion("commission_type <>", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThan(String value) {
            addCriterion("commission_type >", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("commission_type >=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThan(String value) {
            addCriterion("commission_type <", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThanOrEqualTo(String value) {
            addCriterion("commission_type <=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLike(String value) {
            addCriterion("commission_type like", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotLike(String value) {
            addCriterion("commission_type not like", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIn(List<String> values) {
            addCriterion("commission_type in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotIn(List<String> values) {
            addCriterion("commission_type not in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeBetween(String value1, String value2) {
            addCriterion("commission_type between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotBetween(String value1, String value2) {
            addCriterion("commission_type not between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andGrantAccountIsNull() {
            addCriterion("grant_account is null");
            return (Criteria) this;
        }

        public Criteria andGrantAccountIsNotNull() {
            addCriterion("grant_account is not null");
            return (Criteria) this;
        }

        public Criteria andGrantAccountEqualTo(String value) {
            addCriterion("grant_account =", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountNotEqualTo(String value) {
            addCriterion("grant_account <>", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountGreaterThan(String value) {
            addCriterion("grant_account >", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountGreaterThanOrEqualTo(String value) {
            addCriterion("grant_account >=", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountLessThan(String value) {
            addCriterion("grant_account <", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountLessThanOrEqualTo(String value) {
            addCriterion("grant_account <=", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountLike(String value) {
            addCriterion("grant_account like", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountNotLike(String value) {
            addCriterion("grant_account not like", value, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountIn(List<String> values) {
            addCriterion("grant_account in", values, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountNotIn(List<String> values) {
            addCriterion("grant_account not in", values, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountBetween(String value1, String value2) {
            addCriterion("grant_account between", value1, value2, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andGrantAccountNotBetween(String value1, String value2) {
            addCriterion("grant_account not between", value1, value2, "grantAccount");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(LocalDateTime value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(LocalDateTime value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(LocalDateTime value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(LocalDateTime value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<LocalDateTime> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<LocalDateTime> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated do_not_delete_during_merge Fri Sep 18 10:45:05 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table second_withdrawal_method
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
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