package model;

public class ExceptionForCitizenTZ extends Exception {
	private String msg;
	public ExceptionForCitizenTZ(String msg) {
		this.msg= msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
