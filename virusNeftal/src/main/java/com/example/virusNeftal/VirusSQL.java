package com.example.virusNeftal;

import javax.persistence.Entity;

@Entity
public class VirusSQL {

	@javax.persistence.Id
	private String signature;
	private String name;
	private boolean bad;


	public VirusSQL() {
		super();
	}

	public VirusSQL(String signature, String name, boolean bad) {
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

	@Override
	public String toString() {
		return "Car [sigature=" + signature + ", name=" + name + ", bad=" + bad + "]";
	}
}
