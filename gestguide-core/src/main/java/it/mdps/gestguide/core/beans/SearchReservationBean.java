package it.mdps.gestguide.core.beans;

import java.util.Map;

public class SearchReservationBean {

	private int licenseId;
	private Map<Integer, String> instructors;
	private Map<Integer, String> vehicles;
	
	public int getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}
	public Map<Integer, String> getInstructors() {
		return instructors;
	}
	public void setInstructors(Map<Integer, String> instructors) {
		this.instructors = instructors;
	}
	public Map<Integer, String> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Map<Integer, String> vehicles) {
		this.vehicles = vehicles;
	}
}
