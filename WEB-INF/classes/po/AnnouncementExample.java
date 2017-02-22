package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnouncementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnouncementExample() {
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

        public Criteria andAnIdIsNull() {
            addCriterion("AN_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnIdIsNotNull() {
            addCriterion("AN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnIdEqualTo(Integer value) {
            addCriterion("AN_ID =", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdNotEqualTo(Integer value) {
            addCriterion("AN_ID <>", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdGreaterThan(Integer value) {
            addCriterion("AN_ID >", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AN_ID >=", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdLessThan(Integer value) {
            addCriterion("AN_ID <", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdLessThanOrEqualTo(Integer value) {
            addCriterion("AN_ID <=", value, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdIn(List<Integer> values) {
            addCriterion("AN_ID in", values, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdNotIn(List<Integer> values) {
            addCriterion("AN_ID not in", values, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdBetween(Integer value1, Integer value2) {
            addCriterion("AN_ID between", value1, value2, "anId");
            return (Criteria) this;
        }

        public Criteria andAnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AN_ID not between", value1, value2, "anId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdIsNull() {
            addCriterion("AN_CRE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnCreIdIsNotNull() {
            addCriterion("AN_CRE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnCreIdEqualTo(String value) {
            addCriterion("AN_CRE_ID =", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdNotEqualTo(String value) {
            addCriterion("AN_CRE_ID <>", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdGreaterThan(String value) {
            addCriterion("AN_CRE_ID >", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdGreaterThanOrEqualTo(String value) {
            addCriterion("AN_CRE_ID >=", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdLessThan(String value) {
            addCriterion("AN_CRE_ID <", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdLessThanOrEqualTo(String value) {
            addCriterion("AN_CRE_ID <=", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdLike(String value) {
            addCriterion("AN_CRE_ID like", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdNotLike(String value) {
            addCriterion("AN_CRE_ID not like", value, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdIn(List<String> values) {
            addCriterion("AN_CRE_ID in", values, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdNotIn(List<String> values) {
            addCriterion("AN_CRE_ID not in", values, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdBetween(String value1, String value2) {
            addCriterion("AN_CRE_ID between", value1, value2, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnCreIdNotBetween(String value1, String value2) {
            addCriterion("AN_CRE_ID not between", value1, value2, "anCreId");
            return (Criteria) this;
        }

        public Criteria andAnTitleIsNull() {
            addCriterion("AN_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andAnTitleIsNotNull() {
            addCriterion("AN_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andAnTitleEqualTo(String value) {
            addCriterion("AN_TITLE =", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleNotEqualTo(String value) {
            addCriterion("AN_TITLE <>", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleGreaterThan(String value) {
            addCriterion("AN_TITLE >", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleGreaterThanOrEqualTo(String value) {
            addCriterion("AN_TITLE >=", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleLessThan(String value) {
            addCriterion("AN_TITLE <", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleLessThanOrEqualTo(String value) {
            addCriterion("AN_TITLE <=", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleLike(String value) {
            addCriterion("AN_TITLE like", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleNotLike(String value) {
            addCriterion("AN_TITLE not like", value, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleIn(List<String> values) {
            addCriterion("AN_TITLE in", values, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleNotIn(List<String> values) {
            addCriterion("AN_TITLE not in", values, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleBetween(String value1, String value2) {
            addCriterion("AN_TITLE between", value1, value2, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnTitleNotBetween(String value1, String value2) {
            addCriterion("AN_TITLE not between", value1, value2, "anTitle");
            return (Criteria) this;
        }

        public Criteria andAnDescIsNull() {
            addCriterion("AN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAnDescIsNotNull() {
            addCriterion("AN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAnDescEqualTo(String value) {
            addCriterion("AN_DESC =", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescNotEqualTo(String value) {
            addCriterion("AN_DESC <>", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescGreaterThan(String value) {
            addCriterion("AN_DESC >", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescGreaterThanOrEqualTo(String value) {
            addCriterion("AN_DESC >=", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescLessThan(String value) {
            addCriterion("AN_DESC <", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescLessThanOrEqualTo(String value) {
            addCriterion("AN_DESC <=", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescLike(String value) {
            addCriterion("AN_DESC like", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescNotLike(String value) {
            addCriterion("AN_DESC not like", value, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescIn(List<String> values) {
            addCriterion("AN_DESC in", values, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescNotIn(List<String> values) {
            addCriterion("AN_DESC not in", values, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescBetween(String value1, String value2) {
            addCriterion("AN_DESC between", value1, value2, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnDescNotBetween(String value1, String value2) {
            addCriterion("AN_DESC not between", value1, value2, "anDesc");
            return (Criteria) this;
        }

        public Criteria andAnCreDateIsNull() {
            addCriterion("AN_CRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAnCreDateIsNotNull() {
            addCriterion("AN_CRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAnCreDateEqualTo(Date value) {
            addCriterion("AN_CRE_DATE =", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateNotEqualTo(Date value) {
            addCriterion("AN_CRE_DATE <>", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateGreaterThan(Date value) {
            addCriterion("AN_CRE_DATE >", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AN_CRE_DATE >=", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateLessThan(Date value) {
            addCriterion("AN_CRE_DATE <", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateLessThanOrEqualTo(Date value) {
            addCriterion("AN_CRE_DATE <=", value, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateIn(List<Date> values) {
            addCriterion("AN_CRE_DATE in", values, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateNotIn(List<Date> values) {
            addCriterion("AN_CRE_DATE not in", values, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateBetween(Date value1, Date value2) {
            addCriterion("AN_CRE_DATE between", value1, value2, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnCreDateNotBetween(Date value1, Date value2) {
            addCriterion("AN_CRE_DATE not between", value1, value2, "anCreDate");
            return (Criteria) this;
        }

        public Criteria andAnAcademyIsNull() {
            addCriterion("AN_ACADEMY is null");
            return (Criteria) this;
        }

        public Criteria andAnAcademyIsNotNull() {
            addCriterion("AN_ACADEMY is not null");
            return (Criteria) this;
        }

        public Criteria andAnAcademyEqualTo(String value) {
            addCriterion("AN_ACADEMY =", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyNotEqualTo(String value) {
            addCriterion("AN_ACADEMY <>", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyGreaterThan(String value) {
            addCriterion("AN_ACADEMY >", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyGreaterThanOrEqualTo(String value) {
            addCriterion("AN_ACADEMY >=", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyLessThan(String value) {
            addCriterion("AN_ACADEMY <", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyLessThanOrEqualTo(String value) {
            addCriterion("AN_ACADEMY <=", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyLike(String value) {
            addCriterion("AN_ACADEMY like", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyNotLike(String value) {
            addCriterion("AN_ACADEMY not like", value, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyIn(List<String> values) {
            addCriterion("AN_ACADEMY in", values, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyNotIn(List<String> values) {
            addCriterion("AN_ACADEMY not in", values, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyBetween(String value1, String value2) {
            addCriterion("AN_ACADEMY between", value1, value2, "anAcademy");
            return (Criteria) this;
        }

        public Criteria andAnAcademyNotBetween(String value1, String value2) {
            addCriterion("AN_ACADEMY not between", value1, value2, "anAcademy");
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