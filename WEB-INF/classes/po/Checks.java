package po;

public class Checks {
    private String cheId;

    private Integer cheYear;

    private Integer tasRecNum;

    private Integer tasExeNum;

    private Integer appNum;

    private Integer appHanNum;

    public String getCheId() {
        return cheId;
    }

    public void setCheId(String cheId) {
        this.cheId = cheId == null ? null : cheId.trim();
    }

    public Integer getCheYear() {
        return cheYear;
    }

    public void setCheYear(Integer cheYear) {
        this.cheYear = cheYear;
    }

    public Integer getTasRecNum() {
        return tasRecNum;
    }

    public void setTasRecNum(Integer tasRecNum) {
        this.tasRecNum = tasRecNum;
    }

    public Integer getTasExeNum() {
        return tasExeNum;
    }

    public void setTasExeNum(Integer tasExeNum) {
        this.tasExeNum = tasExeNum;
    }

    public Integer getAppNum() {
        return appNum;
    }

    public void setAppNum(Integer appNum) {
        this.appNum = appNum;
    }

    public Integer getAppHanNum() {
        return appHanNum;
    }

    public void setAppHanNum(Integer appHanNum) {
        this.appHanNum = appHanNum;
    }
}