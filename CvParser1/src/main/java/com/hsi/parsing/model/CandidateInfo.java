package com.hsi.parsing.model;

import java.io.Serializable;


public class CandidateInfo implements Serializable{
	
	private static final long serialVersionUID = -3838041004870698554L;
	
	private String name;
	private String email;
	private String mobile;
	private String qualification;
	private String experience;
	private String primarySkill;
	private String secondarySkill;
	private String uploadedFileName;	
	
	public CandidateInfo() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPrimarySkill() {
		return primarySkill;
	}
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	public String getSecondarySkill() {
		return secondarySkill;
	}
	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}
	public String getUploadedFileName() {
		return uploadedFileName;
	}
	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}
	 
	
}
