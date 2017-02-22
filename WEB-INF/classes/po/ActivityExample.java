package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andAcIdIsNull() {
            addCriterion("AC_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcIdIsNotNull() {
            addCriterion("AC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcIdEqualTo(Integer value) {
            addCriterion("AC_ID =", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotEqualTo(Integer value) {
            addCriterion("AC_ID <>", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThan(Integer value) {
            addCriterion("AC_ID >", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AC_ID >=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThan(Integer value) {
            addCriterion("AC_ID <", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdLessThanOrEqualTo(Integer value) {
            addCriterion("AC_ID <=", value, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdIn(List<Integer> values) {
            addCriterion("AC_ID in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotIn(List<Integer> values) {
            addCriterion("AC_ID not in", values, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdBetween(Integer value1, Integer value2) {
            addCriterion("AC_ID between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AC_ID not between", value1, value2, "acId");
            return (Criteria) this;
        }

        public Criteria andAcTypeIsNull() {
            addCriterion("AC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAcTypeIsNotNull() {
            addCriterion("AC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAcTypeEqualTo(String value) {
            addCriterion("AC_TYPE =", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeNotEqualTo(String value) {
            addCriterion("AC_TYPE <>", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeGreaterThan(String value) {
            addCriterion("AC_TYPE >", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("AC_TYPE >=", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeLessThan(String value) {
            addCriterion("AC_TYPE <", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeLessThanOrEqualTo(String value) {
            addCriterion("AC_TYPE <=", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeLike(String value) {
            addCriterion("AC_TYPE like", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeNotLike(String value) {
            addCriterion("AC_TYPE not like", value, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeIn(List<String> values) {
            addCriterion("AC_TYPE in", values, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeNotIn(List<String> values) {
            addCriterion("AC_TYPE not in", values, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeBetween(String value1, String value2) {
            addCriterion("AC_TYPE between", value1, value2, "acType");
            return (Criteria) this;
        }

        public Criteria andAcTypeNotBetween(String value1, String value2) {
            addCriterion("AC_TYPE not between", value1, value2, "acType");
            return (Criteria) this;
        }

        public Criteria andAcCreIdIsNull() {
            addCriterion("AC_CRE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcCreIdIsNotNull() {
            addCriterion("AC_CRE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcCreIdEqualTo(String value) {
            addCriterion("AC_CRE_ID =", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdNotEqualTo(String value) {
            addCriterion("AC_CRE_ID <>", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdGreaterThan(String value) {
            addCriterion("AC_CRE_ID >", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdGreaterThanOrEqualTo(String value) {
            addCriterion("AC_CRE_ID >=", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdLessThan(String value) {
            addCriterion("AC_CRE_ID <", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdLessThanOrEqualTo(String value) {
            addCriterion("AC_CRE_ID <=", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdLike(String value) {
            addCriterion("AC_CRE_ID like", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdNotLike(String value) {
            addCriterion("AC_CRE_ID not like", value, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdIn(List<String> values) {
            addCriterion("AC_CRE_ID in", values, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdNotIn(List<String> values) {
            addCriterion("AC_CRE_ID not in", values, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdBetween(String value1, String value2) {
            addCriterion("AC_CRE_ID between", value1, value2, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreIdNotBetween(String value1, String value2) {
            addCriterion("AC_CRE_ID not between", value1, value2, "acCreId");
            return (Criteria) this;
        }

        public Criteria andAcCreDateIsNull() {
            addCriterion("AC_CRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAcCreDateIsNotNull() {
            addCriterion("AC_CRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAcCreDateEqualTo(Date value) {
            addCriterion("AC_CRE_DATE =", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateNotEqualTo(Date value) {
            addCriterion("AC_CRE_DATE <>", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateGreaterThan(Date value) {
            addCriterion("AC_CRE_DATE >", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AC_CRE_DATE >=", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateLessThan(Date value) {
            addCriterion("AC_CRE_DATE <", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateLessThanOrEqualTo(Date value) {
            addCriterion("AC_CRE_DATE <=", value, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateIn(List<Date> values) {
            addCriterion("AC_CRE_DATE in", values, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateNotIn(List<Date> values) {
            addCriterion("AC_CRE_DATE not in", values, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateBetween(Date value1, Date value2) {
            addCriterion("AC_CRE_DATE between", value1, value2, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcCreDateNotBetween(Date value1, Date value2) {
            addCriterion("AC_CRE_DATE not between", value1, value2, "acCreDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateIsNull() {
            addCriterion("AC_DUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAcDueDateIsNotNull() {
            addCriterion("AC_DUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAcDueDateEqualTo(Date value) {
            addCriterion("AC_DUE_DATE =", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateNotEqualTo(Date value) {
            addCriterion("AC_DUE_DATE <>", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateGreaterThan(Date value) {
            addCriterion("AC_DUE_DATE >", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AC_DUE_DATE >=", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateLessThan(Date value) {
            addCriterion("AC_DUE_DATE <", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateLessThanOrEqualTo(Date value) {
            addCriterion("AC_DUE_DATE <=", value, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateIn(List<Date> values) {
            addCriterion("AC_DUE_DATE in", values, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateNotIn(List<Date> values) {
            addCriterion("AC_DUE_DATE not in", values, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateBetween(Date value1, Date value2) {
            addCriterion("AC_DUE_DATE between", value1, value2, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcDueDateNotBetween(Date value1, Date value2) {
            addCriterion("AC_DUE_DATE not between", value1, value2, "acDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateIsNull() {
            addCriterion("AC_SIG_DUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateIsNotNull() {
            addCriterion("AC_SIG_DUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateEqualTo(Date value) {
            addCriterion("AC_SIG_DUE_DATE =", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateNotEqualTo(Date value) {
            addCriterion("AC_SIG_DUE_DATE <>", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateGreaterThan(Date value) {
            addCriterion("AC_SIG_DUE_DATE >", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AC_SIG_DUE_DATE >=", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateLessThan(Date value) {
            addCriterion("AC_SIG_DUE_DATE <", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateLessThanOrEqualTo(Date value) {
            addCriterion("AC_SIG_DUE_DATE <=", value, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateIn(List<Date> values) {
            addCriterion("AC_SIG_DUE_DATE in", values, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateNotIn(List<Date> values) {
            addCriterion("AC_SIG_DUE_DATE not in", values, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateBetween(Date value1, Date value2) {
            addCriterion("AC_SIG_DUE_DATE between", value1, value2, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcSigDueDateNotBetween(Date value1, Date value2) {
            addCriterion("AC_SIG_DUE_DATE not between", value1, value2, "acSigDueDate");
            return (Criteria) this;
        }

        public Criteria andAcTitleIsNull() {
            addCriterion("AC_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andAcTitleIsNotNull() {
            addCriterion("AC_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andAcTitleEqualTo(String value) {
            addCriterion("AC_TITLE =", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotEqualTo(String value) {
            addCriterion("AC_TITLE <>", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleGreaterThan(String value) {
            addCriterion("AC_TITLE >", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleGreaterThanOrEqualTo(String value) {
            addCriterion("AC_TITLE >=", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLessThan(String value) {
            addCriterion("AC_TITLE <", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLessThanOrEqualTo(String value) {
            addCriterion("AC_TITLE <=", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLike(String value) {
            addCriterion("AC_TITLE like", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotLike(String value) {
            addCriterion("AC_TITLE not like", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleIn(List<String> values) {
            addCriterion("AC_TITLE in", values, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotIn(List<String> values) {
            addCriterion("AC_TITLE not in", values, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleBetween(String value1, String value2) {
            addCriterion("AC_TITLE between", value1, value2, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotBetween(String value1, String value2) {
            addCriterion("AC_TITLE not between", value1, value2, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcDescIsNull() {
            addCriterion("AC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAcDescIsNotNull() {
            addCriterion("AC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAcDescEqualTo(String value) {
            addCriterion("AC_DESC =", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescNotEqualTo(String value) {
            addCriterion("AC_DESC <>", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescGreaterThan(String value) {
            addCriterion("AC_DESC >", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescGreaterThanOrEqualTo(String value) {
            addCriterion("AC_DESC >=", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescLessThan(String value) {
            addCriterion("AC_DESC <", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescLessThanOrEqualTo(String value) {
            addCriterion("AC_DESC <=", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescLike(String value) {
            addCriterion("AC_DESC like", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescNotLike(String value) {
            addCriterion("AC_DESC not like", value, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescIn(List<String> values) {
            addCriterion("AC_DESC in", values, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescNotIn(List<String> values) {
            addCriterion("AC_DESC not in", values, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescBetween(String value1, String value2) {
            addCriterion("AC_DESC between", value1, value2, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDescNotBetween(String value1, String value2) {
            addCriterion("AC_DESC not between", value1, value2, "acDesc");
            return (Criteria) this;
        }

        public Criteria andAcDocIdIsNull() {
            addCriterion("AC_DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcDocIdIsNotNull() {
            addCriterion("AC_DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcDocIdEqualTo(String value) {
            addCriterion("AC_DOC_ID =", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdNotEqualTo(String value) {
            addCriterion("AC_DOC_ID <>", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdGreaterThan(String value) {
            addCriterion("AC_DOC_ID >", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("AC_DOC_ID >=", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdLessThan(String value) {
            addCriterion("AC_DOC_ID <", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdLessThanOrEqualTo(String value) {
            addCriterion("AC_DOC_ID <=", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdLike(String value) {
            addCriterion("AC_DOC_ID like", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdNotLike(String value) {
            addCriterion("AC_DOC_ID not like", value, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdIn(List<String> values) {
            addCriterion("AC_DOC_ID in", values, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdNotIn(List<String> values) {
            addCriterion("AC_DOC_ID not in", values, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdBetween(String value1, String value2) {
            addCriterion("AC_DOC_ID between", value1, value2, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDocIdNotBetween(String value1, String value2) {
            addCriterion("AC_DOC_ID not between", value1, value2, "acDocId");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameIsNull() {
            addCriterion("AC_DOC1_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameIsNotNull() {
            addCriterion("AC_DOC1_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameEqualTo(String value) {
            addCriterion("AC_DOC1_NAME =", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameNotEqualTo(String value) {
            addCriterion("AC_DOC1_NAME <>", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameGreaterThan(String value) {
            addCriterion("AC_DOC1_NAME >", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameGreaterThanOrEqualTo(String value) {
            addCriterion("AC_DOC1_NAME >=", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameLessThan(String value) {
            addCriterion("AC_DOC1_NAME <", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameLessThanOrEqualTo(String value) {
            addCriterion("AC_DOC1_NAME <=", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameLike(String value) {
            addCriterion("AC_DOC1_NAME like", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameNotLike(String value) {
            addCriterion("AC_DOC1_NAME not like", value, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameIn(List<String> values) {
            addCriterion("AC_DOC1_NAME in", values, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameNotIn(List<String> values) {
            addCriterion("AC_DOC1_NAME not in", values, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameBetween(String value1, String value2) {
            addCriterion("AC_DOC1_NAME between", value1, value2, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc1NameNotBetween(String value1, String value2) {
            addCriterion("AC_DOC1_NAME not between", value1, value2, "acDoc1Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameIsNull() {
            addCriterion("AC_DOC2_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameIsNotNull() {
            addCriterion("AC_DOC2_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameEqualTo(String value) {
            addCriterion("AC_DOC2_NAME =", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameNotEqualTo(String value) {
            addCriterion("AC_DOC2_NAME <>", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameGreaterThan(String value) {
            addCriterion("AC_DOC2_NAME >", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameGreaterThanOrEqualTo(String value) {
            addCriterion("AC_DOC2_NAME >=", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameLessThan(String value) {
            addCriterion("AC_DOC2_NAME <", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameLessThanOrEqualTo(String value) {
            addCriterion("AC_DOC2_NAME <=", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameLike(String value) {
            addCriterion("AC_DOC2_NAME like", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameNotLike(String value) {
            addCriterion("AC_DOC2_NAME not like", value, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameIn(List<String> values) {
            addCriterion("AC_DOC2_NAME in", values, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameNotIn(List<String> values) {
            addCriterion("AC_DOC2_NAME not in", values, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameBetween(String value1, String value2) {
            addCriterion("AC_DOC2_NAME between", value1, value2, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc2NameNotBetween(String value1, String value2) {
            addCriterion("AC_DOC2_NAME not between", value1, value2, "acDoc2Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameIsNull() {
            addCriterion("AC_DOC3_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameIsNotNull() {
            addCriterion("AC_DOC3_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameEqualTo(String value) {
            addCriterion("AC_DOC3_NAME =", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameNotEqualTo(String value) {
            addCriterion("AC_DOC3_NAME <>", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameGreaterThan(String value) {
            addCriterion("AC_DOC3_NAME >", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameGreaterThanOrEqualTo(String value) {
            addCriterion("AC_DOC3_NAME >=", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameLessThan(String value) {
            addCriterion("AC_DOC3_NAME <", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameLessThanOrEqualTo(String value) {
            addCriterion("AC_DOC3_NAME <=", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameLike(String value) {
            addCriterion("AC_DOC3_NAME like", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameNotLike(String value) {
            addCriterion("AC_DOC3_NAME not like", value, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameIn(List<String> values) {
            addCriterion("AC_DOC3_NAME in", values, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameNotIn(List<String> values) {
            addCriterion("AC_DOC3_NAME not in", values, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameBetween(String value1, String value2) {
            addCriterion("AC_DOC3_NAME between", value1, value2, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcDoc3NameNotBetween(String value1, String value2) {
            addCriterion("AC_DOC3_NAME not between", value1, value2, "acDoc3Name");
            return (Criteria) this;
        }

        public Criteria andAcSigNumIsNull() {
            addCriterion("AC_SIG_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAcSigNumIsNotNull() {
            addCriterion("AC_SIG_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAcSigNumEqualTo(Integer value) {
            addCriterion("AC_SIG_NUM =", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumNotEqualTo(Integer value) {
            addCriterion("AC_SIG_NUM <>", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumGreaterThan(Integer value) {
            addCriterion("AC_SIG_NUM >", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("AC_SIG_NUM >=", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumLessThan(Integer value) {
            addCriterion("AC_SIG_NUM <", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumLessThanOrEqualTo(Integer value) {
            addCriterion("AC_SIG_NUM <=", value, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumIn(List<Integer> values) {
            addCriterion("AC_SIG_NUM in", values, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumNotIn(List<Integer> values) {
            addCriterion("AC_SIG_NUM not in", values, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumBetween(Integer value1, Integer value2) {
            addCriterion("AC_SIG_NUM between", value1, value2, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcSigNumNotBetween(Integer value1, Integer value2) {
            addCriterion("AC_SIG_NUM not between", value1, value2, "acSigNum");
            return (Criteria) this;
        }

        public Criteria andAcStatusIsNull() {
            addCriterion("AC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAcStatusIsNotNull() {
            addCriterion("AC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAcStatusEqualTo(String value) {
            addCriterion("AC_STATUS =", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotEqualTo(String value) {
            addCriterion("AC_STATUS <>", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusGreaterThan(String value) {
            addCriterion("AC_STATUS >", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AC_STATUS >=", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusLessThan(String value) {
            addCriterion("AC_STATUS <", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusLessThanOrEqualTo(String value) {
            addCriterion("AC_STATUS <=", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusLike(String value) {
            addCriterion("AC_STATUS like", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotLike(String value) {
            addCriterion("AC_STATUS not like", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusIn(List<String> values) {
            addCriterion("AC_STATUS in", values, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotIn(List<String> values) {
            addCriterion("AC_STATUS not in", values, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusBetween(String value1, String value2) {
            addCriterion("AC_STATUS between", value1, value2, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotBetween(String value1, String value2) {
            addCriterion("AC_STATUS not between", value1, value2, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcAcademyIsNull() {
            addCriterion("AC_ACADEMY is null");
            return (Criteria) this;
        }

        public Criteria andAcAcademyIsNotNull() {
            addCriterion("AC_ACADEMY is not null");
            return (Criteria) this;
        }

        public Criteria andAcAcademyEqualTo(String value) {
            addCriterion("AC_ACADEMY =", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyNotEqualTo(String value) {
            addCriterion("AC_ACADEMY <>", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyGreaterThan(String value) {
            addCriterion("AC_ACADEMY >", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyGreaterThanOrEqualTo(String value) {
            addCriterion("AC_ACADEMY >=", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyLessThan(String value) {
            addCriterion("AC_ACADEMY <", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyLessThanOrEqualTo(String value) {
            addCriterion("AC_ACADEMY <=", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyLike(String value) {
            addCriterion("AC_ACADEMY like", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyNotLike(String value) {
            addCriterion("AC_ACADEMY not like", value, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyIn(List<String> values) {
            addCriterion("AC_ACADEMY in", values, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyNotIn(List<String> values) {
            addCriterion("AC_ACADEMY not in", values, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyBetween(String value1, String value2) {
            addCriterion("AC_ACADEMY between", value1, value2, "acAcademy");
            return (Criteria) this;
        }

        public Criteria andAcAcademyNotBetween(String value1, String value2) {
            addCriterion("AC_ACADEMY not between", value1, value2, "acAcademy");
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