package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the autoscuola database table.
 * 
 */
@Entity
@Table(name="autoscuola")
@NamedQuery(name="Autoscuola.findAll", query="SELECT a FROM Autoscuola a")
public class Autoscuola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_autoscuola", unique=true, nullable=false)
	private int idAutoscuola;

	@Column(nullable=false, length=5)
	private String cap;

	@Column(nullable=false, length=50)
	private String citta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_creazione", nullable=false)
	private Date dataCreazione;

	@Column(length=50)
	private String email;

	@Column(length=15)
	private String fax;

	@Column(nullable=false, length=100)
	private String indirizzo;

	@Column(nullable=false, length=50)
	private String nome;

	@Column(length=2)
	private String provincia;

	@Column(length=15)
	private String telefono;

	//bi-directional many-to-one association to Consorzio
	@ManyToOne
	@JoinColumn(name="id_consorzio")
	private Consorzio consorzio;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="autoscuola")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Iscrizione
	@OneToMany(mappedBy="autoscuola")
	private List<Iscrizione> iscriziones;

	//bi-directional many-to-one association to Istruttore
	@OneToMany(mappedBy="autoscuola")
	private List<Istruttore> istruttores;

	//bi-directional many-to-one association to Mezzo
	@OneToMany(mappedBy="autoscuola")
	private List<Mezzo> mezzos;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="autoscuola")
	private List<Prenotazione> prenotaziones;

	public Autoscuola() {
	}

	public int getIdAutoscuola() {
		return this.idAutoscuola;
	}

	public void setIdAutoscuola(int idAutoscuola) {
		this.idAutoscuola = idAutoscuola;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Date getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Consorzio getConsorzio() {
		return this.consorzio;
	}

	public void setConsorzio(Consorzio consorzio) {
		this.consorzio = consorzio;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setAutoscuola(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setAutoscuola(null);

		return cliente;
	}

	public List<Iscrizione> getIscriziones() {
		return this.iscriziones;
	}

	public void setIscriziones(List<Iscrizione> iscriziones) {
		this.iscriziones = iscriziones;
	}

	public Iscrizione addIscrizione(Iscrizione iscrizione) {
		getIscriziones().add(iscrizione);
		iscrizione.setAutoscuola(this);

		return iscrizione;
	}

	public Iscrizione removeIscrizione(Iscrizione iscrizione) {
		getIscriziones().remove(iscrizione);
		iscrizione.setAutoscuola(null);

		return iscrizione;
	}

	public List<Istruttore> getIstruttores() {
		return this.istruttores;
	}

	public void setIstruttores(List<Istruttore> istruttores) {
		this.istruttores = istruttores;
	}

	public Istruttore addIstruttore(Istruttore istruttore) {
		getIstruttores().add(istruttore);
		istruttore.setAutoscuola(this);

		return istruttore;
	}

	public Istruttore removeIstruttore(Istruttore istruttore) {
		getIstruttores().remove(istruttore);
		istruttore.setAutoscuola(null);

		return istruttore;
	}

	public List<Mezzo> getMezzos() {
		return this.mezzos;
	}

	public void setMezzos(List<Mezzo> mezzos) {
		this.mezzos = mezzos;
	}

	public Mezzo addMezzo(Mezzo mezzo) {
		getMezzos().add(mezzo);
		mezzo.setAutoscuola(this);

		return mezzo;
	}

	public Mezzo removeMezzo(Mezzo mezzo) {
		getMezzos().remove(mezzo);
		mezzo.setAutoscuola(null);

		return mezzo;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setAutoscuola(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setAutoscuola(null);

		return prenotazione;
	}

}