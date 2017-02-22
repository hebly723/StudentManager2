package po;

import java.util.ArrayList;
import java.util.List;

public class ActypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActypeExample() {
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

        public Criteria andActypeIdIsNull() {
            addCriterion("ACTYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andActypeIdIsNotNull() {
            addCriterion("ACTYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActypeIdEqualTo(Integer value) {
            addCriterion("ACTYPE_ID =", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdNotEqualTo(Integer value) {
            addCriterion("ACTYPE_ID <>", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdGreaterThan(Integer value) {
            addCriterion("ACTYPE_ID >", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTYPE_ID >=", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdLessThan(Integer value) {
            addCriterion("ACTYPE_ID <", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACTYPE_ID <=", value, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdIn(List<Integer> values) {
            addCriterion("ACTYPE_ID in", values, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdNotIn(List<Integer> values) {
            addCriterion("ACTYPE_ID not in", values, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdBetween(Integer value1, Integer value2) {
            addCriterion("ACTYPE_ID between", value1, value2, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTYPE_ID not between", value1, value2, "actypeId");
            return (Criteria) this;
        }

        public Criteria andActypeNameIsNull() {
            addCriterion("ACTYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andActypeNameIsNotNull() {
            addCriterion("ACTYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andActypeNameEqualTo(String value) {
            addCriterion("ACTYPE_NAME =", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameNotEqualTo(String value) {
            addCriterion("ACTYPE_NAME <>", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameGreaterThan(String value) {
            addCriterion("ACTYPE_NAME >", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACTYPE_NAME >=", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameLessThan(String value) {
            addCriterion("ACTYPE_NAME <", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameLessThanOrEqualTo(String value) {
            addCriterion("ACTYPE_NAME <=", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameLike(String value) {
            addCriterion("ACTYPE_NAME like", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameNotLike(String value) {
            addCriterion("ACTYPE_NAME not like", value, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameIn(List<String> values) {
            addCriterion("ACTYPE_NAME in", values, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameNotIn(List<String> values) {
            addCriterion("ACTYPE_NAME not in", values, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameBetween(String value1, String value2) {
            addCriterion("ACTYPE_NAME between", value1, value2, "actypeName");
            return (Criteria) this;
        }

        public Criteria andActypeNameNotBetween(String value1, String value2) {
            addCriterion("ACTYPE_NAME not between", value1, value2, "actypeName");
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