package it.mdps.gestguide.core.beans;

public class LicenseBean {

	private int id;
	private String category;
	private short costPerHour;
	
	public int getId() {
		return id;
	}
	public void setId(int idLicense) {
		this.id = idLicense;
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
