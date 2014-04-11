package it.mdps.gestguide.core.beans;


public class VehicleBean {
	
	private Long id;
	private String alimentazione;
	private String marca;
	private String modello;
	private byte rimorchio;
	private byte stato;
	private String targa;
	private byte tempoCambio;
	private String tipo;
	private short cavalli;
	private short cilindrata;
	private Long schoolId;
	private String schoolName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public byte getRimorchio() {
		return rimorchio;
	}
	public void setRimorchio(byte rimorchio) {
		this.rimorchio = rimorchio;
	}
	public byte getStato() {
		return stato;
	}
	public void setStato(byte stato) {
		this.stato = stato;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public byte getTempoCambio() {
		return tempoCambio;
	}
	public void setTempoCambio(byte tempoCambio) {
		this.tempoCambio = tempoCambio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public short getCavalli() {
		return cavalli;
	}
	public void setCavalli(short cavalli) {
		this.cavalli = cavalli;
	}
	public short getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(short cilindrata) {
		this.cilindrata = cilindrata;
	}
}