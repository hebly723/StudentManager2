package po;

import java.util.ArrayList;
import java.util.List;

public class ChecksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChecksExample() {
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

        public Criteria andCheIdIsNull() {
            addCriterion("CHE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheIdIsNotNull() {
            addCriterion("CHE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheIdEqualTo(String value) {
            addCriterion("CHE_ID =", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotEqualTo(String value) {
            addCriterion("CHE_ID <>", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdGreaterThan(String value) {
            addCriterion("CHE_ID >", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHE_ID >=", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdLessThan(String value) {
            addCriterion("CHE_ID <", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdLessThanOrEqualTo(String value) {
            addCriterion("CHE_ID <=", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdLike(String value) {
            addCriterion("CHE_ID like", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotLike(String value) {
            addCriterion("CHE_ID not like", value, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdIn(List<String> values) {
            addCriterion("CHE_ID in", values, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotIn(List<String> values) {
            addCriterion("CHE_ID not in", values, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdBetween(String value1, String value2) {
            addCriterion("CHE_ID between", value1, value2, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheIdNotBetween(String value1, String value2) {
            addCriterion("CHE_ID not between", value1, value2, "cheId");
            return (Criteria) this;
        }

        public Criteria andCheYearIsNull() {
            addCriterion("CHE_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andCheYearIsNotNull() {
            addCriterion("CHE_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andCheYearEqualTo(Integer value) {
            addCriterion("CHE_YEAR =", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearNotEqualTo(Integer value) {
            addCriterion("CHE_YEAR <>", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearGreaterThan(Integer value) {
            addCriterion("CHE_YEAR >", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHE_YEAR >=", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearLessThan(Integer value) {
            addCriterion("CHE_YEAR <", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearLessThanOrEqualTo(Integer value) {
            addCriterion("CHE_YEAR <=", value, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearIn(List<Integer> values) {
            addCriterion("CHE_YEAR in", values, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearNotIn(List<Integer> values) {
            addCriterion("CHE_YEAR not in", values, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearBetween(Integer value1, Integer value2) {
            addCriterion("CHE_YEAR between", value1, value2, "cheYear");
            return (Criteria) this;
        }

        public Criteria andCheYearNotBetween(Integer value1, Integer value2) {
            addCriterion("CHE_YEAR not between", value1, value2, "cheYear");
            return (Criteria) this;
        }

        public Criteria andTasRecNumIsNull() {
            addCriterion("TAS_REC_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTasRecNumIsNotNull() {
            addCriterion("TAS_REC_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTasRecNumEqualTo(Integer value) {
            addCriterion("TAS_REC_NUM =", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumNotEqualTo(Integer value) {
            addCriterion("TAS_REC_NUM <>", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumGreaterThan(Integer value) {
            addCriterion("TAS_REC_NUM >", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("TAS_REC_NUM >=", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumLessThan(Integer value) {
            addCriterion("TAS_REC_NUM <", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumLessThanOrEqualTo(Integer value) {
            addCriterion("TAS_REC_NUM <=", value, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumIn(List<Integer> values) {
            addCriterion("TAS_REC_NUM in", values, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumNotIn(List<Integer> values) {
            addCriterion("TAS_REC_NUM not in", values, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumBetween(Integer value1, Integer value2) {
            addCriterion("TAS_REC_NUM between", value1, value2, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasRecNumNotBetween(Integer value1, Integer value2) {
            addCriterion("TAS_REC_NUM not between", value1, value2, "tasRecNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumIsNull() {
            addCriterion("TAS_EXE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTasExeNumIsNotNull() {
            addCriterion("TAS_EXE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTasExeNumEqualTo(Integer value) {
            addCriterion("TAS_EXE_NUM =", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumNotEqualTo(Integer value) {
            addCriterion("TAS_EXE_NUM <>", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumGreaterThan(Integer value) {
            addCriterion("TAS_EXE_NUM >", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("TAS_EXE_NUM >=", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumLessThan(Integer value) {
            addCriterion("TAS_EXE_NUM <", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumLessThanOrEqualTo(Integer value) {
            addCriterion("TAS_EXE_NUM <=", value, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumIn(List<Integer> values) {
            addCriterion("TAS_EXE_NUM in", values, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumNotIn(List<Integer> values) {
            addCriterion("TAS_EXE_NUM not in", values, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumBetween(Integer value1, Integer value2) {
            addCriterion("TAS_EXE_NUM between", value1, value2, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andTasExeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("TAS_EXE_NUM not between", value1, value2, "tasExeNum");
            return (Criteria) this;
        }

        public Criteria andAppNumIsNull() {
            addCriterion("APP_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAppNumIsNotNull() {
            addCriterion("APP_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAppNumEqualTo(Integer value) {
            addCriterion("APP_NUM =", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumNotEqualTo(Integer value) {
            addCriterion("APP_NUM <>", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumGreaterThan(Integer value) {
            addCriterion("APP_NUM >", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("APP_NUM >=", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumLessThan(Integer value) {
            addCriterion("APP_NUM <", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumLessThanOrEqualTo(Integer value) {
            addCriterion("APP_NUM <=", value, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumIn(List<Integer> values) {
            addCriterion("APP_NUM in", values, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumNotIn(List<Integer> values) {
            addCriterion("APP_NUM not in", values, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumBetween(Integer value1, Integer value2) {
            addCriterion("APP_NUM between", value1, value2, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppNumNotBetween(Integer value1, Integer value2) {
            addCriterion("APP_NUM not between", value1, value2, "appNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumIsNull() {
            addCriterion("APP_HAN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAppHanNumIsNotNull() {
            addCriterion("APP_HAN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAppHanNumEqualTo(Integer value) {
            addCriterion("APP_HAN_NUM =", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumNotEqualTo(Integer value) {
            addCriterion("APP_HAN_NUM <>", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumGreaterThan(Integer value) {
            addCriterion("APP_HAN_NUM >", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("APP_HAN_NUM >=", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumLessThan(Integer value) {
            addCriterion("APP_HAN_NUM <", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumLessThanOrEqualTo(Integer value) {
            addCriterion("APP_HAN_NUM <=", value, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumIn(List<Integer> values) {
            addCriterion("APP_HAN_NUM in", values, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumNotIn(List<Integer> values) {
            addCriterion("APP_HAN_NUM not in", values, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumBetween(Integer value1, Integer value2) {
            addCriterion("APP_HAN_NUM between", value1, value2, "appHanNum");
            return (Criteria) this;
        }

        public Criteria andAppHanNumNotBetween(Integer value1, Integer value2) {
            addCriterion("APP_HAN_NUM not between", value1, value2, "appHanNum");
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