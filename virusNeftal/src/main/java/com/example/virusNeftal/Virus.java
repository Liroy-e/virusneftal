package com.example.virusNeftal;

import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Virus {

	@org.springframework.data.annotation.Id
	private String signature;
	private String name;
	private boolean bad;

	public Virus() {
		super();
	}
	
	public Virus(String signature, String name, boolean b) {
		super();
		this.signature = signature;
		this.name = name;
		this.bad=b;

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
