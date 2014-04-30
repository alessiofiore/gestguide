package it.mdps.gestguide.database.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the istruttore database table.
 * 
 */
@Entity
@Table(name="istruttore")
@NamedQuery(name="Istruttore.findAll", query="SELECT i FROM Istruttore i where id_autoscuola = :schoolId")
public class Istruttore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_istruttore", unique=true, nullable=false)
	private int idIstruttore;

	@Column(nullable=false, length=5)
	private String cap;

	@Column(length=15)
	private String cellulare;

	@Column(length=50)
	private String citta;

	@Column(name="codice_fiscale", nullable=false, length=16)
	private String codiceFiscale;

	@Column(nullable=false, length=50)
	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name="data_assunzione")
	private Date dataAssunzione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_creazione", nullable=false)
	private Date dataCreazione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;

	@Column(length=50)
	private String email;

	@Column(length=100)
	private String indirizzo;

	@Column(nullable=false, length=50)
	private String nome;

	@Column(length=2)
	private String provincia;

	@Column(length=15)
	private String telefono;

	//bi-directional many-to-one association to Abilitazione
	@OneToMany(mappedBy="istruttore")
	private List<Abilitazione> abilitaziones;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@JoinColumn(name="id_autoscuola", nullable=false)
	private Autoscuola autoscuola;

	//bi-directional many-to-many association to Patente
	@ManyToMany
	@JoinTable(
		name="abilitazione"
		, joinColumns={
			@JoinColumn(name="id_istruttore", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_patente", nullable=false)
			}
		)
	private List<Patente> patentes;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="istruttore")
	private List<Prenotazione> prenotaziones;

	public Istruttore() {
	}

	public int getIdIstruttore() {
		return this.idIstruttore;
	}

	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCellulare() {
		return this.cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataAssunzione() {
		return this.dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Date getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Abilitazione> getAbilitaziones() {
		return this.abilitaziones;
	}

	public void setAbilitaziones(List<Abilitazione> abilitaziones) {
		this.abilitaziones = abilitaziones;
	}

	public Abilitazione addAbilitazione(Abilitazione abilitazione) {
		getAbilitaziones().add(abilitazione);
		abilitazione.setIstruttore(this);

		return abilitazione;
	}

	public Abilitazione removeAbilitazione(Abilitazione abilitazione) {
		getAbilitaziones().remove(abilitazione);
		abilitazione.setIstruttore(null);

		return abilitazione;
	}

	public Autoscuola getAutoscuola() {
		return this.autoscuola;
	}

	public void setAutoscuola(Autoscuola autoscuola) {
		this.autoscuola = autoscuola;
	}

	public List<Patente> getPatentes() {
		return this.patentes;
	}

	public void setPatentes(List<Patente> patentes) {
		this.patentes = patentes;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setIstruttore(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setIstruttore(null);

		return prenotazione;
	}

}