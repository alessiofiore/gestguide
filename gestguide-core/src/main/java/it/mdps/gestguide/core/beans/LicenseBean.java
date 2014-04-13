package it.mdps.gestguide.core.beans;

public class LicenseBean {

	private int idLicense;
	private String category;
	private short costPerHour;
	
	public int getIdLicense() {
		return idLicense;
	}
	public void setIdLicense(int idLicense) {
		this.idLicense = idLicense;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public short getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(short costPerHour) {
		this.costPerHour = costPerHour;
	}
}
