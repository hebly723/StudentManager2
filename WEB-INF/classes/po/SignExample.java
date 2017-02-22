package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignExample() {
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

        public Criteria andSigIdIsNull() {
            addCriterion("SIG_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigIdIsNotNull() {
            addCriterion("SIG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigIdEqualTo(Integer value) {
            addCriterion("SIG_ID =", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdNotEqualTo(Integer value) {
            addCriterion("SIG_ID <>", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdGreaterThan(Integer value) {
            addCriterion("SIG_ID >", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIG_ID >=", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdLessThan(Integer value) {
            addCriterion("SIG_ID <", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdLessThanOrEqualTo(Integer value) {
            addCriterion("SIG_ID <=", value, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdIn(List<Integer> values) {
            addCriterion("SIG_ID in", values, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdNotIn(List<Integer> values) {
            addCriterion("SIG_ID not in", values, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdBetween(Integer value1, Integer value2) {
            addCriterion("SIG_ID between", value1, value2, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SIG_ID not between", value1, value2, "sigId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdIsNull() {
            addCriterion("SIG_AC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigAcIdIsNotNull() {
            addCriterion("SIG_AC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigAcIdEqualTo(Integer value) {
            addCriterion("SIG_AC_ID =", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdNotEqualTo(Integer value) {
            addCriterion("SIG_AC_ID <>", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdGreaterThan(Integer value) {
            addCriterion("SIG_AC_ID >", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIG_AC_ID >=", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdLessThan(Integer value) {
            addCriterion("SIG_AC_ID <", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdLessThanOrEqualTo(Integer value) {
            addCriterion("SIG_AC_ID <=", value, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdIn(List<Integer> values) {
            addCriterion("SIG_AC_ID in", values, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdNotIn(List<Integer> values) {
            addCriterion("SIG_AC_ID not in", values, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdBetween(Integer value1, Integer value2) {
            addCriterion("SIG_AC_ID between", value1, value2, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigAcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SIG_AC_ID not between", value1, value2, "sigAcId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdIsNull() {
            addCriterion("SIG_PER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigPerIdIsNotNull() {
            addCriterion("SIG_PER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigPerIdEqualTo(String value) {
            addCriterion("SIG_PER_ID =", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdNotEqualTo(String value) {
            addCriterion("SIG_PER_ID <>", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdGreaterThan(String value) {
            addCriterion("SIG_PER_ID >", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_PER_ID >=", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdLessThan(String value) {
            addCriterion("SIG_PER_ID <", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdLessThanOrEqualTo(String value) {
            addCriterion("SIG_PER_ID <=", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdLike(String value) {
            addCriterion("SIG_PER_ID like", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdNotLike(String value) {
            addCriterion("SIG_PER_ID not like", value, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdIn(List<String> values) {
            addCriterion("SIG_PER_ID in", values, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdNotIn(List<String> values) {
            addCriterion("SIG_PER_ID not in", values, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdBetween(String value1, String value2) {
            addCriterion("SIG_PER_ID between", value1, value2, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerIdNotBetween(String value1, String value2) {
            addCriterion("SIG_PER_ID not between", value1, value2, "sigPerId");
            return (Criteria) this;
        }

        public Criteria andSigPerNameIsNull() {
            addCriterion("SIG_PER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSigPerNameIsNotNull() {
            addCriterion("SIG_PER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSigPerNameEqualTo(String value) {
            addCriterion("SIG_PER_NAME =", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameNotEqualTo(String value) {
            addCriterion("SIG_PER_NAME <>", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameGreaterThan(String value) {
            addCriterion("SIG_PER_NAME >", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_PER_NAME >=", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameLessThan(String value) {
            addCriterion("SIG_PER_NAME <", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameLessThanOrEqualTo(String value) {
            addCriterion("SIG_PER_NAME <=", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameLike(String value) {
            addCriterion("SIG_PER_NAME like", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameNotLike(String value) {
            addCriterion("SIG_PER_NAME not like", value, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameIn(List<String> values) {
            addCriterion("SIG_PER_NAME in", values, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameNotIn(List<String> values) {
            addCriterion("SIG_PER_NAME not in", values, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameBetween(String value1, String value2) {
            addCriterion("SIG_PER_NAME between", value1, value2, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigPerNameNotBetween(String value1, String value2) {
            addCriterion("SIG_PER_NAME not between", value1, value2, "sigPerName");
            return (Criteria) this;
        }

        public Criteria andSigDateIsNull() {
            addCriterion("SIG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSigDateIsNotNull() {
            addCriterion("SIG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSigDateEqualTo(Date value) {
            addCriterion("SIG_DATE =", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateNotEqualTo(Date value) {
            addCriterion("SIG_DATE <>", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateGreaterThan(Date value) {
            addCriterion("SIG_DATE >", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SIG_DATE >=", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateLessThan(Date value) {
            addCriterion("SIG_DATE <", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateLessThanOrEqualTo(Date value) {
            addCriterion("SIG_DATE <=", value, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateIn(List<Date> values) {
            addCriterion("SIG_DATE in", values, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateNotIn(List<Date> values) {
            addCriterion("SIG_DATE not in", values, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateBetween(Date value1, Date value2) {
            addCriterion("SIG_DATE between", value1, value2, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigDateNotBetween(Date value1, Date value2) {
            addCriterion("SIG_DATE not between", value1, value2, "sigDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateIsNull() {
            addCriterion("SIG_HAN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSigHanDateIsNotNull() {
            addCriterion("SIG_HAN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSigHanDateEqualTo(Date value) {
            addCriterion("SIG_HAN_DATE =", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateNotEqualTo(Date value) {
            addCriterion("SIG_HAN_DATE <>", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateGreaterThan(Date value) {
            addCriterion("SIG_HAN_DATE >", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SIG_HAN_DATE >=", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateLessThan(Date value) {
            addCriterion("SIG_HAN_DATE <", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateLessThanOrEqualTo(Date value) {
            addCriterion("SIG_HAN_DATE <=", value, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateIn(List<Date> values) {
            addCriterion("SIG_HAN_DATE in", values, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateNotIn(List<Date> values) {
            addCriterion("SIG_HAN_DATE not in", values, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateBetween(Date value1, Date value2) {
            addCriterion("SIG_HAN_DATE between", value1, value2, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigHanDateNotBetween(Date value1, Date value2) {
            addCriterion("SIG_HAN_DATE not between", value1, value2, "sigHanDate");
            return (Criteria) this;
        }

        public Criteria andSigDocIdIsNull() {
            addCriterion("SIG_DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigDocIdIsNotNull() {
            addCriterion("SIG_DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigDocIdEqualTo(String value) {
            addCriterion("SIG_DOC_ID =", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdNotEqualTo(String value) {
            addCriterion("SIG_DOC_ID <>", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdGreaterThan(String value) {
            addCriterion("SIG_DOC_ID >", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_DOC_ID >=", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdLessThan(String value) {
            addCriterion("SIG_DOC_ID <", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdLessThanOrEqualTo(String value) {
            addCriterion("SIG_DOC_ID <=", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdLike(String value) {
            addCriterion("SIG_DOC_ID like", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdNotLike(String value) {
            addCriterion("SIG_DOC_ID not like", value, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdIn(List<String> values) {
            addCriterion("SIG_DOC_ID in", values, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdNotIn(List<String> values) {
            addCriterion("SIG_DOC_ID not in", values, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdBetween(String value1, String value2) {
            addCriterion("SIG_DOC_ID between", value1, value2, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDocIdNotBetween(String value1, String value2) {
            addCriterion("SIG_DOC_ID not between", value1, value2, "sigDocId");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameIsNull() {
            addCriterion("SIG_DOC1_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameIsNotNull() {
            addCriterion("SIG_DOC1_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameEqualTo(String value) {
            addCriterion("SIG_DOC1_NAME =", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameNotEqualTo(String value) {
            addCriterion("SIG_DOC1_NAME <>", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameGreaterThan(String value) {
            addCriterion("SIG_DOC1_NAME >", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_DOC1_NAME >=", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameLessThan(String value) {
            addCriterion("SIG_DOC1_NAME <", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameLessThanOrEqualTo(String value) {
            addCriterion("SIG_DOC1_NAME <=", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameLike(String value) {
            addCriterion("SIG_DOC1_NAME like", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameNotLike(String value) {
            addCriterion("SIG_DOC1_NAME not like", value, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameIn(List<String> values) {
            addCriterion("SIG_DOC1_NAME in", values, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameNotIn(List<String> values) {
            addCriterion("SIG_DOC1_NAME not in", values, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameBetween(String value1, String value2) {
            addCriterion("SIG_DOC1_NAME between", value1, value2, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc1NameNotBetween(String value1, String value2) {
            addCriterion("SIG_DOC1_NAME not between", value1, value2, "sigDoc1Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameIsNull() {
            addCriterion("SIG_DOC2_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameIsNotNull() {
            addCriterion("SIG_DOC2_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameEqualTo(String value) {
            addCriterion("SIG_DOC2_NAME =", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameNotEqualTo(String value) {
            addCriterion("SIG_DOC2_NAME <>", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameGreaterThan(String value) {
            addCriterion("SIG_DOC2_NAME >", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_DOC2_NAME >=", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameLessThan(String value) {
            addCriterion("SIG_DOC2_NAME <", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameLessThanOrEqualTo(String value) {
            addCriterion("SIG_DOC2_NAME <=", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameLike(String value) {
            addCriterion("SIG_DOC2_NAME like", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameNotLike(String value) {
            addCriterion("SIG_DOC2_NAME not like", value, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameIn(List<String> values) {
            addCriterion("SIG_DOC2_NAME in", values, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameNotIn(List<String> values) {
            addCriterion("SIG_DOC2_NAME not in", values, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameBetween(String value1, String value2) {
            addCriterion("SIG_DOC2_NAME between", value1, value2, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc2NameNotBetween(String value1, String value2) {
            addCriterion("SIG_DOC2_NAME not between", value1, value2, "sigDoc2Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameIsNull() {
            addCriterion("SIG_DOC3_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameIsNotNull() {
            addCriterion("SIG_DOC3_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameEqualTo(String value) {
            addCriterion("SIG_DOC3_NAME =", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameNotEqualTo(String value) {
            addCriterion("SIG_DOC3_NAME <>", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameGreaterThan(String value) {
            addCriterion("SIG_DOC3_NAME >", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_DOC3_NAME >=", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameLessThan(String value) {
            addCriterion("SIG_DOC3_NAME <", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameLessThanOrEqualTo(String value) {
            addCriterion("SIG_DOC3_NAME <=", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameLike(String value) {
            addCriterion("SIG_DOC3_NAME like", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameNotLike(String value) {
            addCriterion("SIG_DOC3_NAME not like", value, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameIn(List<String> values) {
            addCriterion("SIG_DOC3_NAME in", values, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameNotIn(List<String> values) {
            addCriterion("SIG_DOC3_NAME not in", values, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameBetween(String value1, String value2) {
            addCriterion("SIG_DOC3_NAME between", value1, value2, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigDoc3NameNotBetween(String value1, String value2) {
            addCriterion("SIG_DOC3_NAME not between", value1, value2, "sigDoc3Name");
            return (Criteria) this;
        }

        public Criteria andSigStatusIsNull() {
            addCriterion("SIG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSigStatusIsNotNull() {
            addCriterion("SIG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSigStatusEqualTo(String value) {
            addCriterion("SIG_STATUS =", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusNotEqualTo(String value) {
            addCriterion("SIG_STATUS <>", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusGreaterThan(String value) {
            addCriterion("SIG_STATUS >", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusGreaterThanOrEqualTo(String value) {
            addCriterion("SIG_STATUS >=", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusLessThan(String value) {
            addCriterion("SIG_STATUS <", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusLessThanOrEqualTo(String value) {
            addCriterion("SIG_STATUS <=", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusLike(String value) {
            addCriterion("SIG_STATUS like", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusNotLike(String value) {
            addCriterion("SIG_STATUS not like", value, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusIn(List<String> values) {
            addCriterion("SIG_STATUS in", values, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusNotIn(List<String> values) {
            addCriterion("SIG_STATUS not in", values, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusBetween(String value1, String value2) {
            addCriterion("SIG_STATUS between", value1, value2, "sigStatus");
            return (Criteria) this;
        }

        public Criteria andSigStatusNotBetween(String value1, String value2) {
            addCriterion("SIG_STATUS not between", value1, value2, "sigStatus");
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