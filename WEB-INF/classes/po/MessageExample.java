package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andNotIdIsNull() {
            addCriterion("NOT_ID is null");
            return (Criteria) this;
        }

        public Criteria andNotIdIsNotNull() {
            addCriterion("NOT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNotIdEqualTo(Integer value) {
            addCriterion("NOT_ID =", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdNotEqualTo(Integer value) {
            addCriterion("NOT_ID <>", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdGreaterThan(Integer value) {
            addCriterion("NOT_ID >", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NOT_ID >=", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdLessThan(Integer value) {
            addCriterion("NOT_ID <", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdLessThanOrEqualTo(Integer value) {
            addCriterion("NOT_ID <=", value, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdIn(List<Integer> values) {
            addCriterion("NOT_ID in", values, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdNotIn(List<Integer> values) {
            addCriterion("NOT_ID not in", values, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdBetween(Integer value1, Integer value2) {
            addCriterion("NOT_ID between", value1, value2, "notId");
            return (Criteria) this;
        }

        public Criteria andNotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NOT_ID not between", value1, value2, "notId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdIsNull() {
            addCriterion("NOT_SEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andNotSenIdIsNotNull() {
            addCriterion("NOT_SEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNotSenIdEqualTo(String value) {
            addCriterion("NOT_SEN_ID =", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdNotEqualTo(String value) {
            addCriterion("NOT_SEN_ID <>", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdGreaterThan(String value) {
            addCriterion("NOT_SEN_ID >", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdGreaterThanOrEqualTo(String value) {
            addCriterion("NOT_SEN_ID >=", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdLessThan(String value) {
            addCriterion("NOT_SEN_ID <", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdLessThanOrEqualTo(String value) {
            addCriterion("NOT_SEN_ID <=", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdLike(String value) {
            addCriterion("NOT_SEN_ID like", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdNotLike(String value) {
            addCriterion("NOT_SEN_ID not like", value, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdIn(List<String> values) {
            addCriterion("NOT_SEN_ID in", values, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdNotIn(List<String> values) {
            addCriterion("NOT_SEN_ID not in", values, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdBetween(String value1, String value2) {
            addCriterion("NOT_SEN_ID between", value1, value2, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotSenIdNotBetween(String value1, String value2) {
            addCriterion("NOT_SEN_ID not between", value1, value2, "notSenId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdIsNull() {
            addCriterion("NOT_REC_ID is null");
            return (Criteria) this;
        }

        public Criteria andNotRecIdIsNotNull() {
            addCriterion("NOT_REC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNotRecIdEqualTo(String value) {
            addCriterion("NOT_REC_ID =", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdNotEqualTo(String value) {
            addCriterion("NOT_REC_ID <>", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdGreaterThan(String value) {
            addCriterion("NOT_REC_ID >", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdGreaterThanOrEqualTo(String value) {
            addCriterion("NOT_REC_ID >=", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdLessThan(String value) {
            addCriterion("NOT_REC_ID <", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdLessThanOrEqualTo(String value) {
            addCriterion("NOT_REC_ID <=", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdLike(String value) {
            addCriterion("NOT_REC_ID like", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdNotLike(String value) {
            addCriterion("NOT_REC_ID not like", value, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdIn(List<String> values) {
            addCriterion("NOT_REC_ID in", values, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdNotIn(List<String> values) {
            addCriterion("NOT_REC_ID not in", values, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdBetween(String value1, String value2) {
            addCriterion("NOT_REC_ID between", value1, value2, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotRecIdNotBetween(String value1, String value2) {
            addCriterion("NOT_REC_ID not between", value1, value2, "notRecId");
            return (Criteria) this;
        }

        public Criteria andNotDetIsNull() {
            addCriterion("NOT_DET is null");
            return (Criteria) this;
        }

        public Criteria andNotDetIsNotNull() {
            addCriterion("NOT_DET is not null");
            return (Criteria) this;
        }

        public Criteria andNotDetEqualTo(String value) {
            addCriterion("NOT_DET =", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetNotEqualTo(String value) {
            addCriterion("NOT_DET <>", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetGreaterThan(String value) {
            addCriterion("NOT_DET >", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetGreaterThanOrEqualTo(String value) {
            addCriterion("NOT_DET >=", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetLessThan(String value) {
            addCriterion("NOT_DET <", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetLessThanOrEqualTo(String value) {
            addCriterion("NOT_DET <=", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetLike(String value) {
            addCriterion("NOT_DET like", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetNotLike(String value) {
            addCriterion("NOT_DET not like", value, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetIn(List<String> values) {
            addCriterion("NOT_DET in", values, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetNotIn(List<String> values) {
            addCriterion("NOT_DET not in", values, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetBetween(String value1, String value2) {
            addCriterion("NOT_DET between", value1, value2, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotDetNotBetween(String value1, String value2) {
            addCriterion("NOT_DET not between", value1, value2, "notDet");
            return (Criteria) this;
        }

        public Criteria andNotStatusIsNull() {
            addCriterion("NOT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andNotStatusIsNotNull() {
            addCriterion("NOT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andNotStatusEqualTo(String value) {
            addCriterion("NOT_STATUS =", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusNotEqualTo(String value) {
            addCriterion("NOT_STATUS <>", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusGreaterThan(String value) {
            addCriterion("NOT_STATUS >", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusGreaterThanOrEqualTo(String value) {
            addCriterion("NOT_STATUS >=", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusLessThan(String value) {
            addCriterion("NOT_STATUS <", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusLessThanOrEqualTo(String value) {
            addCriterion("NOT_STATUS <=", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusLike(String value) {
            addCriterion("NOT_STATUS like", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusNotLike(String value) {
            addCriterion("NOT_STATUS not like", value, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusIn(List<String> values) {
            addCriterion("NOT_STATUS in", values, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusNotIn(List<String> values) {
            addCriterion("NOT_STATUS not in", values, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusBetween(String value1, String value2) {
            addCriterion("NOT_STATUS between", value1, value2, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotStatusNotBetween(String value1, String value2) {
            addCriterion("NOT_STATUS not between", value1, value2, "notStatus");
            return (Criteria) this;
        }

        public Criteria andNotSenDateIsNull() {
            addCriterion("NOT_SEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNotSenDateIsNotNull() {
            addCriterion("NOT_SEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNotSenDateEqualTo(Date value) {
            addCriterion("NOT_SEN_DATE =", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateNotEqualTo(Date value) {
            addCriterion("NOT_SEN_DATE <>", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateGreaterThan(Date value) {
            addCriterion("NOT_SEN_DATE >", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateGreaterThanOrEqualTo(Date value) {
            addCriterion("NOT_SEN_DATE >=", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateLessThan(Date value) {
            addCriterion("NOT_SEN_DATE <", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateLessThanOrEqualTo(Date value) {
            addCriterion("NOT_SEN_DATE <=", value, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateIn(List<Date> values) {
            addCriterion("NOT_SEN_DATE in", values, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateNotIn(List<Date> values) {
            addCriterion("NOT_SEN_DATE not in", values, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateBetween(Date value1, Date value2) {
            addCriterion("NOT_SEN_DATE between", value1, value2, "notSenDate");
            return (Criteria) this;
        }

        public Criteria andNotSenDateNotBetween(Date value1, Date value2) {
            addCriterion("NOT_SEN_DATE not between", value1, value2, "notSenDate");
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