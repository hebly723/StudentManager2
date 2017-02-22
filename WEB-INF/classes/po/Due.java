package po;

import java.util.Date;

public class Due {
    private Integer tasid;

    private String userId;

    private String tasStatus;

    private Date begin;

    private Date fini;

    public Integer getTasid() {
        return tasid;
    }

    public void setTasid(Integer tasid) {
        this.tasid = tasid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTasStatus() {
        return tasStatus;
    }

    public void setTasStatus(String tasStatus) {
        this.tasStatus = tasStatus == null ? null : tasStatus.trim();
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getFini() {
        return fini;
    }

    public void setFini(Date fini) {
        this.fini = fini;
    }
}