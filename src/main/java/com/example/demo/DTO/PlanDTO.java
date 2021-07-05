package com.example.demo.DTO;

public class PlanDTO {
	private String PID;
	private String UID;
	private String PNAME;
	private String PDATE;
	private String PTEXT;
	private String Name;
	private String Number;
	public void setPID(String PID) {
		this.PID = PID;
	}
	
	public String getPID() {
		return PID;
	}
	public void setUID(String UID) {
		this.UID = UID;
	}
	
	public String getUID() {
		return UID;
	}
	
	public void setPNAME(String PNAME) {
		this.PNAME = PNAME;
	}
	
	public String getPNAME() {
		return PNAME;
	}
	
	public void setPDATE(String PDATE) {
		this.PDATE = PDATE;
	}
	
	public String getPDATE() {
		return PDATE;
	}
	
	public void setPTEXT(String PTEXT) {
		this.PTEXT = PTEXT;
	}
	
	public String getPTEXT() {
		return PTEXT;
	}
	
	public String gettuname(String Number) {
		return Name;
	}
}
