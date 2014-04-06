package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@Column(insertable=false, updatable=false)
	private PrenotazionePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inizio")
	private Date dataInizio;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@MapsId("idAutoscuola")
	@JoinColumn(name="id_autoscuola", nullable=false, insertable=false, updatable=false)
	private Autoscuola autoscuola;

	//bi-directional many-to-one association to Iscrizione
	@ManyToOne
	@MapsId("idIscrizione")
	@JoinColumn(name="id_iscrizione", nullable=false, insertable=false, updatable=false)
	private Iscrizione iscrizione;

	//bi-directional many-to-one association to Istruttore
	@ManyToOne
	@MapsId("idIstruttore")
	@JoinColumn(name="id_istruttore", nullable=false, insertable=false, updatable=false)
	private Istruttore istruttore;

	//bi-directional many-to-one association to Mezzo
	@ManyToOne
	@MapsId("idMezzo")
	@JoinColumn(name="id_mezzo", nullable=false, insertable=false, updatable=false)
	private Mezzo mezzo;

	public Prenotazione() {
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Autoscuola getAutoscuola() {
		return this.autoscuola;
	}

	public void setAutoscuola(Autoscuola autoscuola) {
		this.autoscuola = autoscuola;
	}

	public Iscrizione getIscrizione() {
		return this.iscrizione;
	}

	public void setIscrizione(Iscrizione iscrizione) {
		this.iscrizione = iscrizione;
	}

	public Istruttore getIstruttore() {
		return this.istruttore;
	}

	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}

	public Mezzo getMezzo() {
		return this.mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

}