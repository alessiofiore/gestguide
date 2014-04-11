package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consorzio database table.
 * 
 */
@Entity
@Table(name="consorzio")
@NamedQuery(name="Consorzio.findAll", query="SELECT c FROM Consorzio c")
public class Consorzio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_consorzio", unique=true, nullable=false)
	private int idConsorzio;

	@Column(length=45)
	private String cap;

	@Column(nullable=false, length=45)
	private String citta;

	@Column(length=100)
	private String indirizzo;

	@Column(nullable=false, length=45)
	private String nome;

	@Column(nullable=false, length=2)
	private String provincia;

	//bi-directional many-to-one association to Autoscuola
	@OneToMany(mappedBy="consorzio")
	private List<Autoscuola> autoscuolas;

	public Consorzio() {
	}

	public int getIdConsorzio() {
		return this.idConsorzio;
	}

	public void setIdConsorzio(int idConsorzio) {
		this.idConsorzio = idConsorzio;
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

	public List<Autoscuola> getAutoscuolas() {
		return this.autoscuolas;
	}

	public void setAutoscuolas(List<Autoscuola> autoscuolas) {
		this.autoscuolas = autoscuolas;
	}

	public Autoscuola addAutoscuola(Autoscuola autoscuola) {
		getAutoscuolas().add(autoscuola);
		autoscuola.setConsorzio(this);

		return autoscuola;
	}

	public Autoscuola removeAutoscuola(Autoscuola autoscuola) {
		getAutoscuolas().remove(autoscuola);
		autoscuola.setConsorzio(null);

		return autoscuola;
	}

}