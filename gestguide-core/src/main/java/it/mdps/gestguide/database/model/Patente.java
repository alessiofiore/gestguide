package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patente database table.
 * 
 */
@Entity
@Table(name="patente")
@NamedQuery(name="Patente.findAll", query="SELECT p FROM Patente p")
public class Patente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_patente", unique=true, nullable=false)
	private int idPatente;

	@Column(nullable=false, length=5)
	private String categoria;

	@Column(name="eta_minima")
	private byte etaMinima;

	//bi-directional many-to-one association to Abilitazione
	@OneToMany(mappedBy="patente")
	private List<AbilitazioneIstruttore> abilitaziones;

	//bi-directional many-to-one association to Iscrizione
	@OneToMany(mappedBy="patente")
	private List<Iscrizione> iscriziones;

	//bi-directional many-to-many association to Istruttore
	@ManyToMany(mappedBy="patentes")
	private List<Istruttore> istruttores;

	public Patente() {
	}

	public int getIdPatente() {
		return this.idPatente;
	}

	public void setIdPatente(int idPatente) {
		this.idPatente = idPatente;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public byte getEtaMinima() {
		return this.etaMinima;
	}

	public void setEtaMinima(byte etaMinima) {
		this.etaMinima = etaMinima;
	}

	public List<AbilitazioneIstruttore> getAbilitaziones() {
		return this.abilitaziones;
	}

	public void setAbilitaziones(List<AbilitazioneIstruttore> abilitaziones) {
		this.abilitaziones = abilitaziones;
	}

	public AbilitazioneIstruttore addAbilitazione(AbilitazioneIstruttore abilitazione) {
		getAbilitaziones().add(abilitazione);
		abilitazione.setPatente(this);

		return abilitazione;
	}

	public AbilitazioneIstruttore removeAbilitazione(AbilitazioneIstruttore abilitazione) {
		getAbilitaziones().remove(abilitazione);
		abilitazione.setPatente(null);

		return abilitazione;
	}

	public List<Iscrizione> getIscriziones() {
		return this.iscriziones;
	}

	public void setIscriziones(List<Iscrizione> iscriziones) {
		this.iscriziones = iscriziones;
	}

	public Iscrizione addIscrizione(Iscrizione iscrizione) {
		getIscriziones().add(iscrizione);
		iscrizione.setPatente(this);

		return iscrizione;
	}

	public Iscrizione removeIscrizione(Iscrizione iscrizione) {
		getIscriziones().remove(iscrizione);
		iscrizione.setPatente(null);

		return iscrizione;
	}

	public List<Istruttore> getIstruttores() {
		return this.istruttores;
	}

	public void setIstruttores(List<Istruttore> istruttores) {
		this.istruttores = istruttores;
	}

}