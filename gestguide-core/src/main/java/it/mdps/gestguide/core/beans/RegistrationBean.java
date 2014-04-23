package it.mdps.gestguide.core.beans;

import java.util.Date;
import java.util.List;

public class RegistrationBean {

	private int id;
	private int schoolId;
	private String schoolName;
	private int licenseId;
	private String licenseCategory;
	private Date registrationDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}
	public String getLicenseCategory() {
		return licenseCategory;
	}
	public void setLicenseCategory(String licenseCategory) {
		this.licenseCategory = licenseCategory;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
}
