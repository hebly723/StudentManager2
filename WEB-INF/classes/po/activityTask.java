package po;

import java.util.Date;

public class activityTask extends Activity {

	 private Integer tasId;

	    private String tasCreId;

	    private Date tasCreDate;

	    private Date tasDueDate;

	    private String tasTitle;

	    private String tasDesc;

	    private String tasDocId;

	    private String tasDoc1Name;

	    private String tasDoc2Name;

	    private String tasDoc3Name;

	    private String tasFdoc1Name;

	    private String tasFdoc2Name;

	    private String tasFdoc3Name;

	    private String tasStatus;

	    private String tasAcademy;

	    private String tasGrade;

	    private Integer tasAcId;

	    public Integer getTasId() {
	        return tasId;
	    }

	    public void setTasId(Integer tasId) {
	        this.tasId = tasId;
	    }

	    public String getTasCreId() {
	        return tasCreId;
	    }

	    public void setTasCreId(String tasCreId) {
	        this.tasCreId = tasCreId == null ? null : tasCreId.trim();
	    }

	    public Date getTasCreDate() {
	        return tasCreDate;
	    }

	    public void setTasCreDate(Date tasCreDate) {
	        this.tasCreDate = tasCreDate;
	    }

	    public Date getTasDueDate() {
	        return tasDueDate;
	    }

	    public void setTasDueDate(Date tasDueDate) {
	        this.tasDueDate = tasDueDate;
	    }

	    public String getTasTitle() {
	        return tasTitle;
	    }

	    public void setTasTitle(String tasTitle) {
	        this.tasTitle = tasTitle == null ? null : tasTitle.trim();
	    }

	    public String getTasDesc() {
	        return tasDesc;
	    }

	    public void setTasDesc(String tasDesc) {
	        this.tasDesc = tasDesc == null ? null : tasDesc.trim();
	    }

	    public String getTasDocId() {
	        return tasDocId;
	    }

	    public void setTasDocId(String tasDocId) {
	        this.tasDocId = tasDocId == null ? null : tasDocId.trim();
	    }

	    public String getTasDoc1Name() {
	        return tasDoc1Name;
	    }

	    public void setTasDoc1Name(String tasDoc1Name) {
	        this.tasDoc1Name = tasDoc1Name == null ? null : tasDoc1Name.trim();
	    }

	    public String getTasDoc2Name() {
	        return tasDoc2Name;
	    }

	    public void setTasDoc2Name(String tasDoc2Name) {
	        this.tasDoc2Name = tasDoc2Name == null ? null : tasDoc2Name.trim();
	    }

	    public String getTasDoc3Name() {
	        return tasDoc3Name;
	    }

	    public void setTasDoc3Name(String tasDoc3Name) {
	        this.tasDoc3Name = tasDoc3Name == null ? null : tasDoc3Name.trim();
	    }

	    public String getTasFdoc1Name() {
	        return tasFdoc1Name;
	    }

	    public void setTasFdoc1Name(String tasFdoc1Name) {
	        this.tasFdoc1Name = tasFdoc1Name == null ? null : tasFdoc1Name.trim();
	    }

	    public String getTasFdoc2Name() {
	        return tasFdoc2Name;
	    }

	    public void setTasFdoc2Name(String tasFdoc2Name) {
	        this.tasFdoc2Name = tasFdoc2Name == null ? null : tasFdoc2Name.trim();
	    }

	    public String getTasFdoc3Name() {
	        return tasFdoc3Name;
	    }

	    public void setTasFdoc3Name(String tasFdoc3Name) {
	        this.tasFdoc3Name = tasFdoc3Name == null ? null : tasFdoc3Name.trim();
	    }

	    public String getTasStatus() {
	        return tasStatus;
	    }

	    public void setTasStatus(String tasStatus) {
	        this.tasStatus = tasStatus == null ? null : tasStatus.trim();
	    }

	    public String getTasAcademy() {
	        return tasAcademy;
	    }

	    public void setTasAcademy(String tasAcademy) {
	        this.tasAcademy = tasAcademy == null ? null : tasAcademy.trim();
	    }

	    public String getTasGrade() {
	        return tasGrade;
	    }

	    public void setTasGrade(String tasGrade) {
	        this.tasGrade = tasGrade == null ? null : tasGrade.trim();
	    }

	    public Integer getTasAcId() {
	        return tasAcId;
	    }

	    public void setTasAcId(Integer tasAcId) {
	        this.tasAcId = tasAcId;
	    }
	    
	    public Task getTask()
	    {
	    	Task task = new Task();
	    	task.setTasAcademy(this.getTasAcademy());
	    	task.setTasAcId(this.getTasAcId());
			task.setTasCreDate(this.getTasCreDate());
			task.setTasCreId(this.getTasCreId());
//			task.setTasCreName(tasCreName);
			task.setTasDesc(this.getTasDesc());
			task.setTasDoc1Name(this.getTasDoc1Name());
			task.setTasDoc2Name(this.getTasDoc2Name());
			task.setTasDoc3Name(this.getTasDoc3Name());
			task.setTasDocId(this.getTasDocId());
			task.setTasDueDate(this.getTasDueDate());
//			setTasDueId(task.getTasDueId());
//			setTasDueName(tasDueName);
			task.setTasFdoc1Name(this.getTasFdoc1Name());
			task.setTasFdoc2Name(this.getTasFdoc2Name());
			task.setTasFdoc3Name(this.getTasFdoc3Name());
			task.setTasGrade(this.getTasGrade());
			task.setTasId(this.getTasId());
			task.setTasStatus(this.getTasStatus());
			task.setTasTitle(this.getTasTitle());
			return task;
	    }
	    
}
