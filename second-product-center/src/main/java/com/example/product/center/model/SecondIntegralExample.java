package com.example.product.center.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SecondIntegralExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public SecondIntegralExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
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
     * This method corresponds to the database table second_integral
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
     * This method corresponds to the database table second_integral
     *
     * @mbg.generated Fri Sep 18 10:45:05 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_integral
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
     * This class corresponds to the database table second_integral
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

        public Criteria andIntegralNameIsNull() {
            addCriterion("integral_name is null");
            return (Criteria) this;
        }

        public Criteria andIntegralNameIsNotNull() {
            addCriterion("integral_name is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralNameEqualTo(String value) {
            addCriterion("integral_name =", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameNotEqualTo(String value) {
            addCriterion("integral_name <>", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameGreaterThan(String value) {
            addCriterion("integral_name >", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameGreaterThanOrEqualTo(String value) {
            addCriterion("integral_name >=", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameLessThan(String value) {
            addCriterion("integral_name <", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameLessThanOrEqualTo(String value) {
            addCriterion("integral_name <=", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameLike(String value) {
            addCriterion("integral_name like", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameNotLike(String value) {
            addCriterion("integral_name not like", value, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameIn(List<String> values) {
            addCriterion("integral_name in", values, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameNotIn(List<String> values) {
            addCriterion("integral_name not in", values, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameBetween(String value1, String value2) {
            addCriterion("integral_name between", value1, value2, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralNameNotBetween(String value1, String value2) {
            addCriterion("integral_name not between", value1, value2, "integralName");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeIsNull() {
            addCriterion("integral_type is null");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeIsNotNull() {
            addCriterion("integral_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeEqualTo(String value) {
            addCriterion("integral_type =", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeNotEqualTo(String value) {
            addCriterion("integral_type <>", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeGreaterThan(String value) {
            addCriterion("integral_type >", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeGreaterThanOrEqualTo(String value) {
            addCriterion("integral_type >=", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeLessThan(String value) {
            addCriterion("integral_type <", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeLessThanOrEqualTo(String value) {
            addCriterion("integral_type <=", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeLike(String value) {
            addCriterion("integral_type like", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeNotLike(String value) {
            addCriterion("integral_type not like", value, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeIn(List<String> values) {
            addCriterion("integral_type in", values, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeNotIn(List<String> values) {
            addCriterion("integral_type not in", values, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeBetween(String value1, String value2) {
            addCriterion("integral_type between", value1, value2, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralTypeNotBetween(String value1, String value2) {
            addCriterion("integral_type not between", value1, value2, "integralType");
            return (Criteria) this;
        }

        public Criteria andIntegralDescIsNull() {
            addCriterion("integral_desc is null");
            return (Criteria) this;
        }

        public Criteria andIntegralDescIsNotNull() {
            addCriterion("integral_desc is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralDescEqualTo(String value) {
            addCriterion("integral_desc =", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescNotEqualTo(String value) {
            addCriterion("integral_desc <>", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescGreaterThan(String value) {
            addCriterion("integral_desc >", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescGreaterThanOrEqualTo(String value) {
            addCriterion("integral_desc >=", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescLessThan(String value) {
            addCriterion("integral_desc <", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescLessThanOrEqualTo(String value) {
            addCriterion("integral_desc <=", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescLike(String value) {
            addCriterion("integral_desc like", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescNotLike(String value) {
            addCriterion("integral_desc not like", value, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescIn(List<String> values) {
            addCriterion("integral_desc in", values, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescNotIn(List<String> values) {
            addCriterion("integral_desc not in", values, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescBetween(String value1, String value2) {
            addCriterion("integral_desc between", value1, value2, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralDescNotBetween(String value1, String value2) {
            addCriterion("integral_desc not between", value1, value2, "integralDesc");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedIsNull() {
            addCriterion("integral_need is null");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedIsNotNull() {
            addCriterion("integral_need is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedEqualTo(Integer value) {
            addCriterion("integral_need =", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedNotEqualTo(Integer value) {
            addCriterion("integral_need <>", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedGreaterThan(Integer value) {
            addCriterion("integral_need >", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_need >=", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedLessThan(Integer value) {
            addCriterion("integral_need <", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedLessThanOrEqualTo(Integer value) {
            addCriterion("integral_need <=", value, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedIn(List<Integer> values) {
            addCriterion("integral_need in", values, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedNotIn(List<Integer> values) {
            addCriterion("integral_need not in", values, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedBetween(Integer value1, Integer value2) {
            addCriterion("integral_need between", value1, value2, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andIntegralNeedNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_need not between", value1, value2, "integralNeed");
            return (Criteria) this;
        }

        public Criteria andInetgralFileIsNull() {
            addCriterion("inetgral_file is null");
            return (Criteria) this;
        }

        public Criteria andInetgralFileIsNotNull() {
            addCriterion("inetgral_file is not null");
            return (Criteria) this;
        }

        public Criteria andInetgralFileEqualTo(String value) {
            addCriterion("inetgral_file =", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileNotEqualTo(String value) {
            addCriterion("inetgral_file <>", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileGreaterThan(String value) {
            addCriterion("inetgral_file >", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileGreaterThanOrEqualTo(String value) {
            addCriterion("inetgral_file >=", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileLessThan(String value) {
            addCriterion("inetgral_file <", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileLessThanOrEqualTo(String value) {
            addCriterion("inetgral_file <=", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileLike(String value) {
            addCriterion("inetgral_file like", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileNotLike(String value) {
            addCriterion("inetgral_file not like", value, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileIn(List<String> values) {
            addCriterion("inetgral_file in", values, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileNotIn(List<String> values) {
            addCriterion("inetgral_file not in", values, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileBetween(String value1, String value2) {
            addCriterion("inetgral_file between", value1, value2, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andInetgralFileNotBetween(String value1, String value2) {
            addCriterion("inetgral_file not between", value1, value2, "inetgralFile");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(LocalDateTime value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(LocalDateTime value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(LocalDateTime value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(LocalDateTime value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<LocalDateTime> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<LocalDateTime> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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

        public Criteria andEndTimeEqualTo(LocalDateTime value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(LocalDateTime value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(LocalDateTime value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(LocalDateTime value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<LocalDateTime> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<LocalDateTime> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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
     * This class corresponds to the database table second_integral
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
     * This class corresponds to the database table second_integral
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