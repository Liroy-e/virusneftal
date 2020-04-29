package com.example.upload;





public class Virus {

	private String signature;
	private String name;
	private boolean bad;

	public Virus() {
		super();
	}
	
	public Virus(String signature, String name, boolean bad) {
		super();
		this.signature = signature;
		this.name = name;
		this.bad = bad;

	}

	public String getsignature() {
		return signature;
	}
	
	public void setsignature(String signature) {
		this.signature = signature;
	}
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public boolean getBad() {
		return bad;
	}
	
	public void setBad(boolean bad) {
		this.bad = bad;
	}


}
