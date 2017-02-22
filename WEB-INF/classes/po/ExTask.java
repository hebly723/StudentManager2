package po;

import java.util.Date;

public class ExTask extends Task{
	
	Integer signNumber;
	Integer excuNumber;
	String tasCreName;
	String tasDueName;
	String tasDueId;
	Date finiDate;
	Date beginDate;
	public Date getFiniDate() {
		return finiDate;
	}
	public void setFiniDate(Date finiDate) {
		this.finiDate = finiDate;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public String getTasDueId() {
		return tasDueId;
	}
	public void setTasDueId(String tasDueId) {
		this.tasDueId = tasDueId;
	}
	public Integer getSignNumber() {
		return signNumber;
	}
	public void setSignNumber(Integer signNumber) {
		this.signNumber = signNumber;
	}
	public Integer getExcuNumber() {
		return excuNumber;
	}
	public void setExcuNumber(Integer excuNumber) {
		this.excuNumber = excuNumber;
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
