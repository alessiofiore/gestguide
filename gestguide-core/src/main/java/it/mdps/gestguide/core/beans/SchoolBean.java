package it.mdps.gestguide.core.beans;

import java.io.Serializable;

import it.mdps.gestguide.common.StaticValues;

import com.vaadin.data.fieldgroup.PropertyId;

public class SchoolBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PropertyId(StaticValues.ID)
	private Long id;
	
	@PropertyId(StaticValues.NOME_SEDE)
	private String nomeSede = "";	
	
	@PropertyId(StaticValues.CAP)
	private String cap = "";
	
	@PropertyId(StaticValues.CITTA)
	private String citta = "";

	@PropertyId(StaticValues.PROVINCIA)
	private String provincia = "";

	@PropertyId(StaticValues.INDIRIZZO)
	private String indirizzo = "";
	
	@PropertyId(StaticValues.TELEFONO)
	private String telefono = "";
	
	@PropertyId(StaticValues.FAX)
	private String fax = "";	
	
	@PropertyId(StaticValues.EMAIL)
	private String email = "";
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNomeSede() {
		return nomeSede;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}
	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}
	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}
	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}
	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
