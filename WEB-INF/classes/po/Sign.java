package po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class Sign {
    private Integer sigId;

    private Integer sigAcId;

    private String sigPerId;

    private String sigPerName;

    private Date sigDate;

    private Date sigHanDate;

    private String sigDocId;

    private String sigDoc1Name;

    private String sigDoc2Name;

    private String sigDoc3Name;

    private String sigStatus;

    public Integer getSigId() {
        return sigId;
    }

    public void setSigId(Integer sigId) {
        this.sigId = sigId;
    }

    public Integer getSigAcId() {
        return sigAcId;
    }

    public void setSigAcId(Integer sigAcId) {
        this.sigAcId = sigAcId;
    }

    public String getSigPerId() {
        return sigPerId;
    }

    public void setSigPerId(String sigPerId) {
        this.sigPerId = sigPerId == null ? null : sigPerId.trim();
    }

    public String getSigPerName() {
        return sigPerName;
    }

    public void setSigPerName(String sigPerName) {
        this.sigPerName = sigPerName == null ? null : sigPerName.trim();
    }

    public Date getSigDate() {
        return sigDate;
    }
    @JsonDeserialize(using = utils.CustomJsonDateDeserializer.class)
    public void setSigDate(Date sigDate) {
        this.sigDate = sigDate;
    }

    public Date getSigHanDate() {
        return sigHanDate;
    }
    @JsonDeserialize(using = utils.CustomJsonDateDeserializer.class)
    public void setSigHanDate(Date sigHanDate) {
        this.sigHanDate = sigHanDate;
    }

    public String getSigDocId() {
        return sigDocId;
    }

    public void setSigDocId(String sigDocId) {
        this.sigDocId = sigDocId == null ? null : sigDocId.trim();
    }

    public String getSigDoc1Name() {
        return sigDoc1Name;
    }

    public void setSigDoc1Name(String sigDoc1Name) {
        this.sigDoc1Name = sigDoc1Name == null ? null : sigDoc1Name.trim();
    }

    public String getSigDoc2Name() {
        return sigDoc2Name;
    }

    public void setSigDoc2Name(String sigDoc2Name) {
        this.sigDoc2Name = sigDoc2Name == null ? null : sigDoc2Name.trim();
    }

    public String getSigDoc3Name() {
        return sigDoc3Name;
    }

    public void setSigDoc3Name(String sigDoc3Name) {
        this.sigDoc3Name = sigDoc3Name == null ? null : sigDoc3Name.trim();
    }

    public String getSigStatus() {
        return sigStatus;
    }

    public void setSigStatus(String sigStatus) {
        this.sigStatus = sigStatus == null ? null : sigStatus.trim();
    }
}