package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskIdentification {

	/**
	 * tasDue下发人员信息
	 */
	List<NameAndId> tasDue = new ArrayList<NameAndId>();
	/**
	 * 学院为1
	 * 单人为2
	 */
	int type;
	/**
	 * 任务ID
	 */
    private Integer tasId;
    /**
  	 * 任务创建人(Boss)ID
  	 */
      private String tasCreId;
      private String tasCreName;
      /**
       *	任务创建时间 
       */
      private Date tasCreDate;
      /**
       * 任务截止时间
       */
      private Date tasDueDate;
      /**
       * 任务标题
       */
      private String tasTitle;
      /**
       * 任务概述
       */
      private String tasDesc;
      /**
       * 任务存储文件ID
       */
      private String tasDocId;
      /**
       * 任务文件一名
       */
      private String tasDoc1Name;
      /**
       * 任务文件二名
       */
      private String tasDoc2Name;
      /**
       * 任务文件三名
       */
      private String tasDoc3Name;
      /**
       * 任务提交文件一名
       */
      private String tasFdoc1Name;
      /**
       * 任务提交文件二名
       */
      private String tasFdoc2Name;
      /**
       * 任务提交文件三名
       */
      private String tasFdoc3Name;
      /**
       * 任务状态
       */
      private String tasStatus;
      /**
       * 任务对应学院
       */
      private String tasAcademy;
      /**
       * 任务对应年级
       */
      private String tasGrade;
      /**
       * 任务对应活动ID
       */
      private int tasAcId;
    
	public String getTasCreName() {
		return tasCreName;
	}
	public void setTasCreName(String tasCreName) {
		this.tasCreName = tasCreName;
	}
	public int getTasAcId() {
		return tasAcId;
	}
	public void setTasAcId(int tasAcId) {
		this.tasAcId = tasAcId;
	}
	public void setTasDue(List<NameAndId> tasDue) {
		this.tasDue = tasDue;
	}
	public List<NameAndId> getTasDue() {
		return tasDue;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
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
		this.tasCreId = tasCreId;
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
		this.tasTitle = tasTitle;
	}
	public String getTasDesc() {
		return tasDesc;
	}
	public void setTasDesc(String tasDesc) {
		this.tasDesc = tasDesc;
	}
	public String getTasDocId() {
		return tasDocId;
	}
	public void setTasDocId(String tasDocId) {
		this.tasDocId = tasDocId;
	}
	public String getTasDoc1Name() {
		return tasDoc1Name;
	}
	public void setTasDoc1Name(String tasDoc1Name) {
		this.tasDoc1Name = tasDoc1Name;
	}
	public String getTasDoc2Name() {
		return tasDoc2Name;
	}
	public void setTasDoc2Name(String tasDoc2Name) {
		this.tasDoc2Name = tasDoc2Name;
	}
	public String getTasDoc3Name() {
		return tasDoc3Name;
	}
	public void setTasDoc3Name(String tasDoc3Name) {
		this.tasDoc3Name = tasDoc3Name;
	}
	public String getTasFdoc1Name() {
		return tasFdoc1Name;
	}
	public void setTasFdoc1Name(String tasFdoc1Name) {
		this.tasFdoc1Name = tasFdoc1Name;
	}
	public String getTasFdoc2Name() {
		return tasFdoc2Name;
	}
	public void setTasFdoc2Name(String tasFdoc2Name) {
		this.tasFdoc2Name = tasFdoc2Name;
	}
	public String getTasFdoc3Name() {
		return tasFdoc3Name;
	}
	public void setTasFdoc3Name(String tasFdoc3Name) {
		this.tasFdoc3Name = tasFdoc3Name;
	}
	public String getTasStatus() {
		return tasStatus;
	}
	public void setTasStatus(String tasStatus) {
		this.tasStatus = tasStatus;
	}
	public String getTasAcademy() {
		return tasAcademy;
	}
	public void setTasAcademy(String tasAcademy) {
		this.tasAcademy = tasAcademy;
	}
	public String getTasGrade() {
		return tasGrade;
	}
	public void setTasGrade(String tasGrade) {
		this.tasGrade = tasGrade;
	}
    public TaskIdentification(Task task, String tasCreName){
    	setTasAcademy(task.getTasAcademy());
		setTasAcId(task.getTasAcId());
		setTasCreDate(task.getTasCreDate());
		setTasCreId(task.getTasCreId());
		setTasCreName(tasCreName);
		setTasDesc(task.getTasDesc());
		setTasDoc1Name(task.getTasDoc1Name());
		setTasDoc2Name(task.getTasDoc2Name());
		setTasDoc3Name(task.getTasDoc3Name());
		setTasDocId(task.getTasDocId());
		setTasDueDate(task.getTasDueDate());
//		setTasDueId(task.getTasDueId());
//		setTasDueName(tasDueName);
		setTasFdoc1Name(task.getTasFdoc1Name());
		setTasFdoc2Name(task.getTasFdoc2Name());
		setTasFdoc3Name(task.getTasFdoc3Name());
		setTasGrade(task.getTasGrade());
		setTasId(task.getTasId());
		setTasStatus(task.getTasStatus());
		setTasTitle(task.getTasTitle());
    }
    public Task getTask()
    {
    	Task task = new Task();
    	task.setTasAcademy(this.getTasAcademy());
    	task.setTasAcId(this.getTasAcId());
		task.setTasCreDate(this.getTasCreDate());
		task.setTasCreId(this.getTasCreId());
//		task.setTasCreName(tasCreName);
		task.setTasDesc(this.getTasDesc());
		task.setTasDoc1Name(this.getTasDoc1Name());
		task.setTasDoc2Name(this.getTasDoc2Name());
		task.setTasDoc3Name(this.getTasDoc3Name());
		task.setTasDocId(this.getTasDocId());
		task.setTasDueDate(this.getTasDueDate());
//		setTasDueId(task.getTasDueId());
//		setTasDueName(tasDueName);
		task.setTasFdoc1Name(this.getTasFdoc1Name());
		task.setTasFdoc2Name(this.getTasFdoc2Name());
		task.setTasFdoc3Name(this.getTasFdoc3Name());
		task.setTasGrade(this.getTasGrade());
		task.setTasId(this.getTasId());
		task.setTasStatus(this.getTasStatus());
		task.setTasTitle(this.getTasTitle());
		return task;
    }
    public void extendTask(String tasDueName, String tasDueId, String status){
    	NameAndId naAndId = new NameAndId(tasDueName, tasDueId, status);
    	this.tasDue.add(naAndId);
    }
    public void extendTask(NameAndId naAndId){
    	this.tasDue.add(naAndId);
    } 
		
}
