package po;

public class Actype {
    private Integer actypeId;

    private String actypeName;

    public Integer getActypeId() {
        return actypeId;
    }

    public void setActypeId(Integer actypeId) {
        this.actypeId = actypeId;
    }

    public String getActypeName() {
        return actypeName;
    }

    public void setActypeName(String actypeName) {
        this.actypeName = actypeName == null ? null : actypeName.trim();
    }
}