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
@NamedQuery(name="Mezzo.findAll", query="SELECT m FROM Mezzo m")
public class Mezzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_mezzo")
	private int idMezzo;

	private String alimentazione;

	private short cavalli;

	private short cilindrata;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_prima_immatricolazione")
	private Date dataPrimaImmatricolazione;

	private String marca;

	private String modello;

	private byte stato;

	private String targa;

	private String tipo;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@JoinColumn(name="id_autoscuola")
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

	public Date getDataPrimaImmatricolazione() {
		return this.dataPrimaImmatricolazione;
	}

	public void setDataPrimaImmatricolazione(Date dataPrimaImmatricolazione) {
		this.dataPrimaImmatricolazione = dataPrimaImmatricolazione;
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