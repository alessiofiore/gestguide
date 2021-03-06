package it.mdps.gestguide.database.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the abilitazione database table.
 * 
 */
@Entity
@Table(name="abilitazione_istruttore")
@NamedQuery(name="AbilitazioneIstruttore.findAll", query="SELECT a FROM AbilitazioneIstruttore a")
public class AbilitazioneIstruttore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilitazioneIstruttorePK id;

	@Column(name="costo_ora")
	private short costoOra;

	//bi-directional many-to-one association to Istruttore
	@ManyToOne
	@MapsId("idIstruttore")
	@JoinColumn(name="id_istruttore")
	private Istruttore istruttore;

	//bi-directional many-to-one association to Patente
	@ManyToOne
	@MapsId("idPatente")
	@JoinColumn(name="id_patente")
	private Patente patente;

	public AbilitazioneIstruttore() {
	}

	public AbilitazioneIstruttorePK getId() {
		return this.id;
	}

	public void setId(AbilitazioneIstruttorePK id) {
		this.id = id;
	}

	public short getCostoOra() {
		return this.costoOra;
	}

	public void setCostoOra(short costoOra) {
		this.costoOra = costoOra;
	}

	public Istruttore getIstruttore() {
		return this.istruttore;
	}

	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}

	public Patente getPatente() {
		return this.patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

}