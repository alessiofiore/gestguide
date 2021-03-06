package it.mdps.gestguide.core.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomerBean {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String mobilePhone;
	private String socialSecurityNumber;
	private String address;
	private String city;
	private String province;
	private String zipCode;
	private Date creationDate;
	private Date dateOfBirth;
	private String email;
	private String phone;
	private Integer schoolId;
	private String schoolName;
	private List<RegistrationBean> registrations;
	private Map<Integer, String> availableLicenses;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public List<RegistrationBean> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<RegistrationBean> registrations) {
		this.registrations = registrations;
	}
	public Map<Integer, String> getAvailableLicenses() {
		return availableLicenses;
	}
	public void setAvailableLicenses(Map<Integer, String> availableLicenses) {
		this.availableLicenses = availableLicenses;
	}
	
}
