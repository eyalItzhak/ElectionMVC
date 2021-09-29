package model;

public class ExceptionForCitizenAGE extends Exception{
	private String msg;
	
	public ExceptionForCitizenAGE(String msg) {
		this.msg= msg;
	}
	
	public String getMessage () {
		return msg;
		
	}

}
