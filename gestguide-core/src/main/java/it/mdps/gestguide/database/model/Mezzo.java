package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mezzo database table.
 * 
 */
@Entity
@Table(name="mezzo")
@NamedQuery(name="Mezzo.findAll", query="SELECT m FROM Mezzo m where id_autoscuola = :schoolId")
public class Mezzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_mezzo", unique=true, nullable=false)
	private int idMezzo;

	@Column(nullable=false, length=10)
	private String alimentazione;

	@Column(nullable=false)
	private short cavalli;

	@Column(nullable=false)
	private short cilindrata;

	@Temporal(TemporalType.DATE)
	@Column(name="data_creazione", nullable=false)
	private Date dataCreazione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_immatricolazione")
	private Date dataImmatricolazione;

	@Column(length=45)
	private String marca;

	@Column(length=45)
	private String modello;

	private boolean rimorchio;

	private byte stato;

	@Column(length=10)
	private String targa;

	@Column(name="tempo_cambio")
	private byte tempoCambio;

	@Column(nullable=false, length=45)
	private String tipo;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@JoinColumn(name="id_autoscuola", nullable=false)
	private Autoscuola autoscuola;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="mezzo")
	private List<Prenotazione> prenotaziones;

	public Mezzo() {
	}

	public int getIdMezzo() {
		return this.idMezzo;
	}

	public void setIdMezzo(int idMezzo) {
		this.idMezzo = idMezzo;
	}

	public String getAlimentazione() {
		return this.alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public short getCavalli() {
		return this.cavalli;
	}

	public void setCavalli(short cavalli) {
		this.cavalli = cavalli;
	}

	public short getCilindrata() {
		return this.cilindrata;
	}

	public void setCilindrata(short cilindrata) {
		this.cilindrata = cilindrata;
	}

	public Date getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataImmatricolazione() {
		return this.dataImmatricolazione;
	}

	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public boolean getRimorchio() {
		return this.rimorchio;
	}

	public void setRimorchio(boolean rimorchio) {
		this.rimorchio = rimorchio;
	}

	public byte getStato() {
		return this.stato;
	}

	public void setStato(byte stato) {
		this.stato = stato;
	}

	public String getTarga() {
		return this.targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public byte getTempoCambio() {
		return this.tempoCambio;
	}

	public void setTempoCambio(byte tempoCambio) {
		this.tempoCambio = tempoCambio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		prenotazione.setMezzo(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setMezzo(null);

		return prenotazione;
	}

}