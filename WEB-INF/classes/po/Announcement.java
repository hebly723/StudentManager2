package po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class Announcement {
    private Integer anId;

    private String anCreId;

    private String anTitle;

    private String anDesc;

    private Date anCreDate;

    private String anAcademy;

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getAnCreId() {
        return anCreId;
    }

    public void setAnCreId(String anCreId) {
        this.anCreId = anCreId == null ? null : anCreId.trim();
    }

    public String getAnTitle() {
        return anTitle;
    }

    public void setAnTitle(String anTitle) {
        this.anTitle = anTitle == null ? null : anTitle.trim();
    }

    public String getAnDesc() {
        return anDesc;
    }

    public void setAnDesc(String anDesc) {
        this.anDesc = anDesc == null ? null : anDesc.trim();
    }

    public Date getAnCreDate() {
        return anCreDate;
    }
    @JsonDeserialize(using = utils.CustomJsonDateDeserializer.class)
    public void setAnCreDate(Date anCreDate) {
        this.anCreDate = anCreDate;
    }

    public String getAnAcademy() {
        return anAcademy;
    }

    public void setAnAcademy(String anAcademy) {
        this.anAcademy = anAcademy == null ? null : anAcademy.trim();
    }
}