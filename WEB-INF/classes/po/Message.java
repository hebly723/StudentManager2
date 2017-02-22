package po;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Message {
    private Integer notId;

    private String notSenId;

    private String notRecId;

    private String notDet;

    private String notStatus;

    private Date notSenDate;
    
    public List<String> getNotRecList() {
		return notRecList;
	}

	public void setNotRecList(List<String> notRecList) {
		this.notRecList = notRecList;
	}
	private List<String> notRecList;

	public Integer getNotId() {
        return notId;
    }

    public void setNotId(Integer notId) {
        this.notId = notId;
    }

    public String getNotSenId() {
        return notSenId;
    }

    public void setNotSenId(String notSenId) {
        this.notSenId = notSenId == null ? null : notSenId.trim();
    }

    public String getNotRecId() {
        return notRecId;
    }

    public void setNotRecId(String notRecId) {
        this.notRecId = notRecId == null ? null : notRecId.trim();
    }

    public String getNotDet() {
        return notDet;
    }

    public void setNotDet(String notDet) {
        this.notDet = notDet == null ? null : notDet.trim();
    }

    public String getNotStatus() {
        return notStatus;
    }

    public void setNotStatus(String notStatus) {
        this.notStatus = notStatus == null ? null : notStatus.trim();
    }

    public Date getNotSenDate() {
        return notSenDate;
    }
    @JsonDeserialize(using = utils.CustomJsonDateDeserializer.class)
    public void setNotSenDate(Date notSenDate) {
        this.notSenDate = notSenDate;
    }
}