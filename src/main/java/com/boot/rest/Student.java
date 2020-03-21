package com.boot.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_student")
public class Student {

	@Id
	@Column(name = "sid")
	private int sId;
	
	@Column(name = "sname")
	@Size(min = 3, max = 15, message = "Name should have atleast 3 characters!")
	private String sName;
	
	@Column(name = "sclass")
	@Size(max = 2)
	private String sClass;
	
	@Column(name = "sscore")
	private int sScore;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
}
