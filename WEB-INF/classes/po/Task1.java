package po;

public class Task1 extends formerTask {

	Integer pageNow;

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	
	public String toString(){
		return "\n" + "tasCreId = " + this.getTasCreId() + "\n" + 
				"tasId = " + this.getTasId() + "\n" +
					"pageNow = " + this.getPageNow();
	}
}
