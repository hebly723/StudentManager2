package po;

public class formerTask extends Task {
	private String tasDueId;

	public String getTasDueId() {
		return tasDueId;
	}

	public void setTasDueId(String tasDueId) {
		this.tasDueId = tasDueId;
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
	
	public void setTask(Task task)
	{
		this.setTasAcademy(task.getTasAcademy());
    	this.setTasAcId(task.getTasAcId());
    	this.setTasCreDate(task.getTasCreDate());
    	this.setTasCreId(task.getTasCreId());
//		this.setTasCreName(tasCreName);
    	this.setTasDesc(task.getTasDesc());
    	this.setTasDoc1Name(task.getTasDoc1Name());
    	this.setTasDoc2Name(task.getTasDoc2Name());
    	this.setTasDoc3Name(task.getTasDoc3Name());
    	this.setTasDocId(task.getTasDocId());
    	this.setTasDueDate(task.getTasDueDate());
//		setTasDueId(task.getTasDueId());
//		setTasDueName(tasDueName);
    	this.setTasFdoc1Name(task.getTasFdoc1Name());
    	this.setTasFdoc2Name(task.getTasFdoc2Name());
    	this.setTasFdoc3Name(task.getTasFdoc3Name());
    	this.setTasGrade(task.getTasGrade());
    	this.setTasId(task.getTasId());
    	this.setTasStatus(task.getTasStatus());
    	this.setTasTitle(task.getTasTitle());
	}

}
