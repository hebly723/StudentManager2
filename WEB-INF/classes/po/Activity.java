package po;

import java.util.Date;

public class Activity {
    private Integer acId;

    private String acType;

    private String acCreId;

    private Date acCreDate;

    private Date acDueDate;

    private Date acSigDueDate;

    private String acTitle;

    private String acDesc;

    private String acDocId;

    private String acDoc1Name;

    private String acDoc2Name;

    private String acDoc3Name;

    private Integer acSigNum;

    private String acStatus;

    private String acAcademy;

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType == null ? null : acType.trim();
    }

    public String getAcCreId() {
        return acCreId;
    }

    public void setAcCreId(String acCreId) {
        this.acCreId = acCreId == null ? null : acCreId.trim();
    }

    public Date getAcCreDate() {
        return acCreDate;
    }

    public void setAcCreDate(Date acCreDate) {
        this.acCreDate = acCreDate;
    }

    public Date getAcDueDate() {
        return acDueDate;
    }

    public void setAcDueDate(Date acDueDate) {
        this.acDueDate = acDueDate;
    }

    public Date getAcSigDueDate() {
        return acSigDueDate;
    }

    public void setAcSigDueDate(Date acSigDueDate) {
        this.acSigDueDate = acSigDueDate;
    }

    public String getAcTitle() {
        return acTitle;
    }

    public void setAcTitle(String acTitle) {
        this.acTitle = acTitle == null ? null : acTitle.trim();
    }

    public String getAcDesc() {
        return acDesc;
    }

    public void setAcDesc(String acDesc) {
        this.acDesc = acDesc == null ? null : acDesc.trim();
    }

    public String getAcDocId() {
        return acDocId;
    }

    public void setAcDocId(String acDocId) {
        this.acDocId = acDocId == null ? null : acDocId.trim();
    }

    public String getAcDoc1Name() {
        return acDoc1Name;
    }

    public void setAcDoc1Name(String acDoc1Name) {
        this.acDoc1Name = acDoc1Name == null ? null : acDoc1Name.trim();
    }

    public String getAcDoc2Name() {
        return acDoc2Name;
    }

    public void setAcDoc2Name(String acDoc2Name) {
        this.acDoc2Name = acDoc2Name == null ? null : acDoc2Name.trim();
    }

    public String getAcDoc3Name() {
        return acDoc3Name;
    }

    public void setAcDoc3Name(String acDoc3Name) {
        this.acDoc3Name = acDoc3Name == null ? null : acDoc3Name.trim();
    }

    public Integer getAcSigNum() {
        return acSigNum;
    }

    public void setAcSigNum(Integer acSigNum) {
        this.acSigNum = acSigNum;
    }

    public String getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(String acStatus) {
        this.acStatus = acStatus == null ? null : acStatus.trim();
    }

    public String getAcAcademy() {
        return acAcademy;
    }

    public void setAcAcademy(String acAcademy) {
        this.acAcademy = acAcademy == null ? null : acAcademy.trim();
    }
}