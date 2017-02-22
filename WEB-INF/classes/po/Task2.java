package po;

public class Task2 extends Task {

	String tasCreName;
	String tasDueName;
	
	public Task2(Task task, String tasCreName, String tasDueName) {
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
		setTasDueName(tasDueName);
		setTasFdoc1Name(task.getTasFdoc1Name());
		setTasFdoc2Name(task.getTasFdoc2Name());
		setTasFdoc3Name(task.getTasFdoc3Name());
		setTasGrade(task.getTasGrade());
		setTasId(task.getTasId());
		setTasStatus(task.getTasStatus());
		setTasTitle(task.getTasTitle());
	}

	public String getTasCreName() {
		return tasCreName;
	}

	public void setTasCreName(String tasCreName) {
		this.tasCreName = tasCreName;
	}

	public String getTasDueName() {
		return tasDueName;
	}

	public void setTasDueName(String tasDueName) {
		this.tasDueName = tasDueName;
	}
	
	
	
}
