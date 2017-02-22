package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DueExample() {
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

        public Criteria andTasidIsNull() {
            addCriterion("tasId is null");
            return (Criteria) this;
        }

        public Criteria andTasidIsNotNull() {
            addCriterion("tasId is not null");
            return (Criteria) this;
        }

        public Criteria andTasidEqualTo(Integer value) {
            addCriterion("tasId =", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidNotEqualTo(Integer value) {
            addCriterion("tasId <>", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidGreaterThan(Integer value) {
            addCriterion("tasId >", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tasId >=", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidLessThan(Integer value) {
            addCriterion("tasId <", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidLessThanOrEqualTo(Integer value) {
            addCriterion("tasId <=", value, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidIn(List<Integer> values) {
            addCriterion("tasId in", values, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidNotIn(List<Integer> values) {
            addCriterion("tasId not in", values, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidBetween(Integer value1, Integer value2) {
            addCriterion("tasId between", value1, value2, "tasid");
            return (Criteria) this;
        }

        public Criteria andTasidNotBetween(Integer value1, Integer value2) {
            addCriterion("tasId not between", value1, value2, "tasid");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTasStatusIsNull() {
            addCriterion("TAS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTasStatusIsNotNull() {
            addCriterion("TAS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTasStatusEqualTo(String value) {
            addCriterion("TAS_STATUS =", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusNotEqualTo(String value) {
            addCriterion("TAS_STATUS <>", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusGreaterThan(String value) {
            addCriterion("TAS_STATUS >", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_STATUS >=", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusLessThan(String value) {
            addCriterion("TAS_STATUS <", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusLessThanOrEqualTo(String value) {
            addCriterion("TAS_STATUS <=", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusLike(String value) {
            addCriterion("TAS_STATUS like", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusNotLike(String value) {
            addCriterion("TAS_STATUS not like", value, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusIn(List<String> values) {
            addCriterion("TAS_STATUS in", values, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusNotIn(List<String> values) {
            addCriterion("TAS_STATUS not in", values, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusBetween(String value1, String value2) {
            addCriterion("TAS_STATUS between", value1, value2, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andTasStatusNotBetween(String value1, String value2) {
            addCriterion("TAS_STATUS not between", value1, value2, "tasStatus");
            return (Criteria) this;
        }

        public Criteria andBeginIsNull() {
            addCriterion("BEGIN is null");
            return (Criteria) this;
        }

        public Criteria andBeginIsNotNull() {
            addCriterion("BEGIN is not null");
            return (Criteria) this;
        }

        public Criteria andBeginEqualTo(Date value) {
            addCriterion("BEGIN =", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginNotEqualTo(Date value) {
            addCriterion("BEGIN <>", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginGreaterThan(Date value) {
            addCriterion("BEGIN >", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN >=", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginLessThan(Date value) {
            addCriterion("BEGIN <", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN <=", value, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginIn(List<Date> values) {
            addCriterion("BEGIN in", values, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginNotIn(List<Date> values) {
            addCriterion("BEGIN not in", values, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginBetween(Date value1, Date value2) {
            addCriterion("BEGIN between", value1, value2, "begin");
            return (Criteria) this;
        }

        public Criteria andBeginNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN not between", value1, value2, "begin");
            return (Criteria) this;
        }

        public Criteria andFiniIsNull() {
            addCriterion("FINI is null");
            return (Criteria) this;
        }

        public Criteria andFiniIsNotNull() {
            addCriterion("FINI is not null");
            return (Criteria) this;
        }

        public Criteria andFiniEqualTo(Date value) {
            addCriterion("FINI =", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniNotEqualTo(Date value) {
            addCriterion("FINI <>", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniGreaterThan(Date value) {
            addCriterion("FINI >", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniGreaterThanOrEqualTo(Date value) {
            addCriterion("FINI >=", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniLessThan(Date value) {
            addCriterion("FINI <", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniLessThanOrEqualTo(Date value) {
            addCriterion("FINI <=", value, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniIn(List<Date> values) {
            addCriterion("FINI in", values, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniNotIn(List<Date> values) {
            addCriterion("FINI not in", values, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniBetween(Date value1, Date value2) {
            addCriterion("FINI between", value1, value2, "fini");
            return (Criteria) this;
        }

        public Criteria andFiniNotBetween(Date value1, Date value2) {
            addCriterion("FINI not between", value1, value2, "fini");
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