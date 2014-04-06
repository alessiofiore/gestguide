package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the iscrizione database table.
 * 
 */
@Entity
@NamedQuery(name="Iscrizione.findAll", query="SELECT i FROM Iscrizione i")
public class Iscrizione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_iscrizione")
	private int idIscrizione;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	//bi-directional many-to-one association to Autoscuola
	@ManyToOne
	@JoinColumn(name="id_autoscuola")
	private Autoscuola autoscuola;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Patente
	@ManyToOne
	@JoinColumn(name="id_patente")
	private Patente patente;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="iscrizione")
	private List<Prenotazione> prenotaziones;

	public Iscrizione() {
	}

	public int getIdIscrizione() {
		return this.idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Autoscuola getAutoscuola() {
		return this.autoscuola;
	}

	public void setAutoscuola(Autoscuola autoscuola) {
		this.autoscuola = autoscuola;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Patente getPatente() {
		return this.patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setIscrizione(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setIscrizione(null);

		return prenotazione;
	}

}