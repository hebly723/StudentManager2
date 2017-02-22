package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTasIdIsNull() {
            addCriterion("TAS_ID is null");
            return (Criteria) this;
        }

        public Criteria andTasIdIsNotNull() {
            addCriterion("TAS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTasIdEqualTo(Integer value) {
            addCriterion("TAS_ID =", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotEqualTo(Integer value) {
            addCriterion("TAS_ID <>", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdGreaterThan(Integer value) {
            addCriterion("TAS_ID >", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TAS_ID >=", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdLessThan(Integer value) {
            addCriterion("TAS_ID <", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdLessThanOrEqualTo(Integer value) {
            addCriterion("TAS_ID <=", value, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdIn(List<Integer> values) {
            addCriterion("TAS_ID in", values, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotIn(List<Integer> values) {
            addCriterion("TAS_ID not in", values, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdBetween(Integer value1, Integer value2) {
            addCriterion("TAS_ID between", value1, value2, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TAS_ID not between", value1, value2, "tasId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdIsNull() {
            addCriterion("TAS_CRE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTasCreIdIsNotNull() {
            addCriterion("TAS_CRE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTasCreIdEqualTo(String value) {
            addCriterion("TAS_CRE_ID =", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdNotEqualTo(String value) {
            addCriterion("TAS_CRE_ID <>", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdGreaterThan(String value) {
            addCriterion("TAS_CRE_ID >", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_CRE_ID >=", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdLessThan(String value) {
            addCriterion("TAS_CRE_ID <", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdLessThanOrEqualTo(String value) {
            addCriterion("TAS_CRE_ID <=", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdLike(String value) {
            addCriterion("TAS_CRE_ID like", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdNotLike(String value) {
            addCriterion("TAS_CRE_ID not like", value, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdIn(List<String> values) {
            addCriterion("TAS_CRE_ID in", values, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdNotIn(List<String> values) {
            addCriterion("TAS_CRE_ID not in", values, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdBetween(String value1, String value2) {
            addCriterion("TAS_CRE_ID between", value1, value2, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreIdNotBetween(String value1, String value2) {
            addCriterion("TAS_CRE_ID not between", value1, value2, "tasCreId");
            return (Criteria) this;
        }

        public Criteria andTasCreDateIsNull() {
            addCriterion("TAS_CRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTasCreDateIsNotNull() {
            addCriterion("TAS_CRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTasCreDateEqualTo(Date value) {
            addCriterion("TAS_CRE_DATE =", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateNotEqualTo(Date value) {
            addCriterion("TAS_CRE_DATE <>", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateGreaterThan(Date value) {
            addCriterion("TAS_CRE_DATE >", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateGreaterThanOrEqualTo(Date value) {
            addCriterion("TAS_CRE_DATE >=", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateLessThan(Date value) {
            addCriterion("TAS_CRE_DATE <", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateLessThanOrEqualTo(Date value) {
            addCriterion("TAS_CRE_DATE <=", value, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateIn(List<Date> values) {
            addCriterion("TAS_CRE_DATE in", values, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateNotIn(List<Date> values) {
            addCriterion("TAS_CRE_DATE not in", values, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateBetween(Date value1, Date value2) {
            addCriterion("TAS_CRE_DATE between", value1, value2, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasCreDateNotBetween(Date value1, Date value2) {
            addCriterion("TAS_CRE_DATE not between", value1, value2, "tasCreDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateIsNull() {
            addCriterion("TAS_DUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTasDueDateIsNotNull() {
            addCriterion("TAS_DUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTasDueDateEqualTo(Date value) {
            addCriterion("TAS_DUE_DATE =", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateNotEqualTo(Date value) {
            addCriterion("TAS_DUE_DATE <>", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateGreaterThan(Date value) {
            addCriterion("TAS_DUE_DATE >", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("TAS_DUE_DATE >=", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateLessThan(Date value) {
            addCriterion("TAS_DUE_DATE <", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateLessThanOrEqualTo(Date value) {
            addCriterion("TAS_DUE_DATE <=", value, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateIn(List<Date> values) {
            addCriterion("TAS_DUE_DATE in", values, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateNotIn(List<Date> values) {
            addCriterion("TAS_DUE_DATE not in", values, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateBetween(Date value1, Date value2) {
            addCriterion("TAS_DUE_DATE between", value1, value2, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasDueDateNotBetween(Date value1, Date value2) {
            addCriterion("TAS_DUE_DATE not between", value1, value2, "tasDueDate");
            return (Criteria) this;
        }

        public Criteria andTasTitleIsNull() {
            addCriterion("TAS_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTasTitleIsNotNull() {
            addCriterion("TAS_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTasTitleEqualTo(String value) {
            addCriterion("TAS_TITLE =", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleNotEqualTo(String value) {
            addCriterion("TAS_TITLE <>", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleGreaterThan(String value) {
            addCriterion("TAS_TITLE >", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_TITLE >=", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleLessThan(String value) {
            addCriterion("TAS_TITLE <", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleLessThanOrEqualTo(String value) {
            addCriterion("TAS_TITLE <=", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleLike(String value) {
            addCriterion("TAS_TITLE like", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleNotLike(String value) {
            addCriterion("TAS_TITLE not like", value, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleIn(List<String> values) {
            addCriterion("TAS_TITLE in", values, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleNotIn(List<String> values) {
            addCriterion("TAS_TITLE not in", values, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleBetween(String value1, String value2) {
            addCriterion("TAS_TITLE between", value1, value2, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasTitleNotBetween(String value1, String value2) {
            addCriterion("TAS_TITLE not between", value1, value2, "tasTitle");
            return (Criteria) this;
        }

        public Criteria andTasDescIsNull() {
            addCriterion("TAS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andTasDescIsNotNull() {
            addCriterion("TAS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andTasDescEqualTo(String value) {
            addCriterion("TAS_DESC =", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescNotEqualTo(String value) {
            addCriterion("TAS_DESC <>", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescGreaterThan(String value) {
            addCriterion("TAS_DESC >", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_DESC >=", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescLessThan(String value) {
            addCriterion("TAS_DESC <", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescLessThanOrEqualTo(String value) {
            addCriterion("TAS_DESC <=", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescLike(String value) {
            addCriterion("TAS_DESC like", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescNotLike(String value) {
            addCriterion("TAS_DESC not like", value, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescIn(List<String> values) {
            addCriterion("TAS_DESC in", values, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescNotIn(List<String> values) {
            addCriterion("TAS_DESC not in", values, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescBetween(String value1, String value2) {
            addCriterion("TAS_DESC between", value1, value2, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDescNotBetween(String value1, String value2) {
            addCriterion("TAS_DESC not between", value1, value2, "tasDesc");
            return (Criteria) this;
        }

        public Criteria andTasDocIdIsNull() {
            addCriterion("TAS_DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andTasDocIdIsNotNull() {
            addCriterion("TAS_DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTasDocIdEqualTo(String value) {
            addCriterion("TAS_DOC_ID =", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdNotEqualTo(String value) {
            addCriterion("TAS_DOC_ID <>", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdGreaterThan(String value) {
            addCriterion("TAS_DOC_ID >", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_DOC_ID >=", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdLessThan(String value) {
            addCriterion("TAS_DOC_ID <", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdLessThanOrEqualTo(String value) {
            addCriterion("TAS_DOC_ID <=", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdLike(String value) {
            addCriterion("TAS_DOC_ID like", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdNotLike(String value) {
            addCriterion("TAS_DOC_ID not like", value, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdIn(List<String> values) {
            addCriterion("TAS_DOC_ID in", values, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdNotIn(List<String> values) {
            addCriterion("TAS_DOC_ID not in", values, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdBetween(String value1, String value2) {
            addCriterion("TAS_DOC_ID between", value1, value2, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDocIdNotBetween(String value1, String value2) {
            addCriterion("TAS_DOC_ID not between", value1, value2, "tasDocId");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameIsNull() {
            addCriterion("TAS_DOC1_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameIsNotNull() {
            addCriterion("TAS_DOC1_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameEqualTo(String value) {
            addCriterion("TAS_DOC1_NAME =", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameNotEqualTo(String value) {
            addCriterion("TAS_DOC1_NAME <>", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameGreaterThan(String value) {
            addCriterion("TAS_DOC1_NAME >", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_DOC1_NAME >=", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameLessThan(String value) {
            addCriterion("TAS_DOC1_NAME <", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_DOC1_NAME <=", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameLike(String value) {
            addCriterion("TAS_DOC1_NAME like", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameNotLike(String value) {
            addCriterion("TAS_DOC1_NAME not like", value, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameIn(List<String> values) {
            addCriterion("TAS_DOC1_NAME in", values, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameNotIn(List<String> values) {
            addCriterion("TAS_DOC1_NAME not in", values, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameBetween(String value1, String value2) {
            addCriterion("TAS_DOC1_NAME between", value1, value2, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc1NameNotBetween(String value1, String value2) {
            addCriterion("TAS_DOC1_NAME not between", value1, value2, "tasDoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameIsNull() {
            addCriterion("TAS_DOC2_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameIsNotNull() {
            addCriterion("TAS_DOC2_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameEqualTo(String value) {
            addCriterion("TAS_DOC2_NAME =", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameNotEqualTo(String value) {
            addCriterion("TAS_DOC2_NAME <>", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameGreaterThan(String value) {
            addCriterion("TAS_DOC2_NAME >", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_DOC2_NAME >=", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameLessThan(String value) {
            addCriterion("TAS_DOC2_NAME <", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_DOC2_NAME <=", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameLike(String value) {
            addCriterion("TAS_DOC2_NAME like", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameNotLike(String value) {
            addCriterion("TAS_DOC2_NAME not like", value, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameIn(List<String> values) {
            addCriterion("TAS_DOC2_NAME in", values, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameNotIn(List<String> values) {
            addCriterion("TAS_DOC2_NAME not in", values, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameBetween(String value1, String value2) {
            addCriterion("TAS_DOC2_NAME between", value1, value2, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc2NameNotBetween(String value1, String value2) {
            addCriterion("TAS_DOC2_NAME not between", value1, value2, "tasDoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameIsNull() {
            addCriterion("TAS_DOC3_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameIsNotNull() {
            addCriterion("TAS_DOC3_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameEqualTo(String value) {
            addCriterion("TAS_DOC3_NAME =", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameNotEqualTo(String value) {
            addCriterion("TAS_DOC3_NAME <>", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameGreaterThan(String value) {
            addCriterion("TAS_DOC3_NAME >", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_DOC3_NAME >=", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameLessThan(String value) {
            addCriterion("TAS_DOC3_NAME <", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_DOC3_NAME <=", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameLike(String value) {
            addCriterion("TAS_DOC3_NAME like", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameNotLike(String value) {
            addCriterion("TAS_DOC3_NAME not like", value, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameIn(List<String> values) {
            addCriterion("TAS_DOC3_NAME in", values, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameNotIn(List<String> values) {
            addCriterion("TAS_DOC3_NAME not in", values, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameBetween(String value1, String value2) {
            addCriterion("TAS_DOC3_NAME between", value1, value2, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasDoc3NameNotBetween(String value1, String value2) {
            addCriterion("TAS_DOC3_NAME not between", value1, value2, "tasDoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameIsNull() {
            addCriterion("TAS_FDOC1_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameIsNotNull() {
            addCriterion("TAS_FDOC1_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameEqualTo(String value) {
            addCriterion("TAS_FDOC1_NAME =", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameNotEqualTo(String value) {
            addCriterion("TAS_FDOC1_NAME <>", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameGreaterThan(String value) {
            addCriterion("TAS_FDOC1_NAME >", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC1_NAME >=", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameLessThan(String value) {
            addCriterion("TAS_FDOC1_NAME <", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC1_NAME <=", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameLike(String value) {
            addCriterion("TAS_FDOC1_NAME like", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameNotLike(String value) {
            addCriterion("TAS_FDOC1_NAME not like", value, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameIn(List<String> values) {
            addCriterion("TAS_FDOC1_NAME in", values, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameNotIn(List<String> values) {
            addCriterion("TAS_FDOC1_NAME not in", values, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameBetween(String value1, String value2) {
            addCriterion("TAS_FDOC1_NAME between", value1, value2, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc1NameNotBetween(String value1, String value2) {
            addCriterion("TAS_FDOC1_NAME not between", value1, value2, "tasFdoc1Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameIsNull() {
            addCriterion("TAS_FDOC2_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameIsNotNull() {
            addCriterion("TAS_FDOC2_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameEqualTo(String value) {
            addCriterion("TAS_FDOC2_NAME =", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameNotEqualTo(String value) {
            addCriterion("TAS_FDOC2_NAME <>", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameGreaterThan(String value) {
            addCriterion("TAS_FDOC2_NAME >", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC2_NAME >=", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameLessThan(String value) {
            addCriterion("TAS_FDOC2_NAME <", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC2_NAME <=", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameLike(String value) {
            addCriterion("TAS_FDOC2_NAME like", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameNotLike(String value) {
            addCriterion("TAS_FDOC2_NAME not like", value, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameIn(List<String> values) {
            addCriterion("TAS_FDOC2_NAME in", values, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameNotIn(List<String> values) {
            addCriterion("TAS_FDOC2_NAME not in", values, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameBetween(String value1, String value2) {
            addCriterion("TAS_FDOC2_NAME between", value1, value2, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc2NameNotBetween(String value1, String value2) {
            addCriterion("TAS_FDOC2_NAME not between", value1, value2, "tasFdoc2Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameIsNull() {
            addCriterion("TAS_FDOC3_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameIsNotNull() {
            addCriterion("TAS_FDOC3_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameEqualTo(String value) {
            addCriterion("TAS_FDOC3_NAME =", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameNotEqualTo(String value) {
            addCriterion("TAS_FDOC3_NAME <>", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameGreaterThan(String value) {
            addCriterion("TAS_FDOC3_NAME >", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC3_NAME >=", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameLessThan(String value) {
            addCriterion("TAS_FDOC3_NAME <", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameLessThanOrEqualTo(String value) {
            addCriterion("TAS_FDOC3_NAME <=", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameLike(String value) {
            addCriterion("TAS_FDOC3_NAME like", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameNotLike(String value) {
            addCriterion("TAS_FDOC3_NAME not like", value, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameIn(List<String> values) {
            addCriterion("TAS_FDOC3_NAME in", values, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameNotIn(List<String> values) {
            addCriterion("TAS_FDOC3_NAME not in", values, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameBetween(String value1, String value2) {
            addCriterion("TAS_FDOC3_NAME between", value1, value2, "tasFdoc3Name");
            return (Criteria) this;
        }

        public Criteria andTasFdoc3NameNotBetween(String value1, String value2) {
            addCriterion("TAS_FDOC3_NAME not between", value1, value2, "tasFdoc3Name");
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

        public Criteria andTasAcademyIsNull() {
            addCriterion("TAS_ACADEMY is null");
            return (Criteria) this;
        }

        public Criteria andTasAcademyIsNotNull() {
            addCriterion("TAS_ACADEMY is not null");
            return (Criteria) this;
        }

        public Criteria andTasAcademyEqualTo(String value) {
            addCriterion("TAS_ACADEMY =", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyNotEqualTo(String value) {
            addCriterion("TAS_ACADEMY <>", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyGreaterThan(String value) {
            addCriterion("TAS_ACADEMY >", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_ACADEMY >=", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyLessThan(String value) {
            addCriterion("TAS_ACADEMY <", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyLessThanOrEqualTo(String value) {
            addCriterion("TAS_ACADEMY <=", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyLike(String value) {
            addCriterion("TAS_ACADEMY like", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyNotLike(String value) {
            addCriterion("TAS_ACADEMY not like", value, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyIn(List<String> values) {
            addCriterion("TAS_ACADEMY in", values, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyNotIn(List<String> values) {
            addCriterion("TAS_ACADEMY not in", values, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyBetween(String value1, String value2) {
            addCriterion("TAS_ACADEMY between", value1, value2, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasAcademyNotBetween(String value1, String value2) {
            addCriterion("TAS_ACADEMY not between", value1, value2, "tasAcademy");
            return (Criteria) this;
        }

        public Criteria andTasGradeIsNull() {
            addCriterion("TAS_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andTasGradeIsNotNull() {
            addCriterion("TAS_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andTasGradeEqualTo(String value) {
            addCriterion("TAS_GRADE =", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeNotEqualTo(String value) {
            addCriterion("TAS_GRADE <>", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeGreaterThan(String value) {
            addCriterion("TAS_GRADE >", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeGreaterThanOrEqualTo(String value) {
            addCriterion("TAS_GRADE >=", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeLessThan(String value) {
            addCriterion("TAS_GRADE <", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeLessThanOrEqualTo(String value) {
            addCriterion("TAS_GRADE <=", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeLike(String value) {
            addCriterion("TAS_GRADE like", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeNotLike(String value) {
            addCriterion("TAS_GRADE not like", value, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeIn(List<String> values) {
            addCriterion("TAS_GRADE in", values, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeNotIn(List<String> values) {
            addCriterion("TAS_GRADE not in", values, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeBetween(String value1, String value2) {
            addCriterion("TAS_GRADE between", value1, value2, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasGradeNotBetween(String value1, String value2) {
            addCriterion("TAS_GRADE not between", value1, value2, "tasGrade");
            return (Criteria) this;
        }

        public Criteria andTasAcIdIsNull() {
            addCriterion("TAS_AC_ID is null");
            return (Criteria) this;
        }

        public Criteria andTasAcIdIsNotNull() {
            addCriterion("TAS_AC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTasAcIdEqualTo(Integer value) {
            addCriterion("TAS_AC_ID =", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdNotEqualTo(Integer value) {
            addCriterion("TAS_AC_ID <>", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdGreaterThan(Integer value) {
            addCriterion("TAS_AC_ID >", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TAS_AC_ID >=", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdLessThan(Integer value) {
            addCriterion("TAS_AC_ID <", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdLessThanOrEqualTo(Integer value) {
            addCriterion("TAS_AC_ID <=", value, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdIn(List<Integer> values) {
            addCriterion("TAS_AC_ID in", values, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdNotIn(List<Integer> values) {
            addCriterion("TAS_AC_ID not in", values, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdBetween(Integer value1, Integer value2) {
            addCriterion("TAS_AC_ID between", value1, value2, "tasAcId");
            return (Criteria) this;
        }

        public Criteria andTasAcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TAS_AC_ID not between", value1, value2, "tasAcId");
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