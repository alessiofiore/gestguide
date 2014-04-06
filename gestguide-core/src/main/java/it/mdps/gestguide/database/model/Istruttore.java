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
@NamedQuery(name="Istruttore.findAll", query="SELECT i FROM Istruttore i")
public class Istruttore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_istruttore")
	private int idIstruttore;

	private String cellulare;

	private String citta;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_assunzione")
	private Date dataAssunzione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_nascita")
	private Date dataNascita;

	private String email;

	private String indirizzo;

	private String nome;

	private String provincia;

	private String telefono;

	//bi-directional many-to-many association to Patente
	@ManyToMany
	@JoinTable(
		name="abilitazione"
		, joinColumns={
			@JoinColumn(name="id_istruttore")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_patente")
			}
		)
	private List<Patente> patentes;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@JoinColumn(name="id_autoscuola")
	private Autoscuola autoscuola;

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

	public List<Patente> getPatentes() {
		return this.patentes;
	}

	public void setPatentes(List<Patente> patentes) {
		this.patentes = patentes;
	}

	public Autoscuola getAutoscuola() {
		return this.autoscuola;
	}

	public void setAutoscuola(Autoscuola autoscuola) {
		this.autoscuola = autoscuola;
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