package po;

public class Dueactivity {
    private Integer acId;

    private String acAcademy;

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getAcAcademy() {
        return acAcademy;
    }

    public void setAcAcademy(String acAcademy) {
        this.acAcademy = acAcademy == null ? null : acAcademy.trim();
    }
}