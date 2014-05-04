package it.mdps.gestguide.database.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the abilitazione database table.
 * 
 */
@Entity
@Table(name="abilitazione_mezzo")
@NamedQuery(name="AbilitazioneMezzo.findAll", query="SELECT a FROM AbilitazioneMezzo a")
public class AbilitazioneMezzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilitazioneMezzoPK id;

	//bi-directional many-to-one association to Mezzo
	@ManyToOne
	@MapsId("idMezzo")
	@JoinColumn(name="id_mezzo")
	private Mezzo mezzo;

	//bi-directional many-to-one association to Patente
	@ManyToOne
	@MapsId("idPatente")
	@JoinColumn(name="id_patente")
	private Patente patente;

	public AbilitazioneMezzo() {
	}

	public AbilitazioneMezzoPK getId() {
		return this.id;
	}

	public void setId(AbilitazioneMezzoPK id) {
		this.id = id;
	}

	public Mezzo getMezzo() {
		return this.mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public Patente getPatente() {
		return this.patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

}