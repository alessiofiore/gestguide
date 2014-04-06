package it.mdps.gestguide.database.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrenotazionePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_autoscuola", insertable=false, updatable=false)
	private int idAutoscuola;
	
	@Column(name="id_mezzo", insertable=false, updatable=false)
	private int idMezzo;
	
	@Column(name="id_istruttore", insertable=false, updatable=false)
	private int idIstruttore;
	
	@Column(name="id_iscrizione", insertable=false, updatable=false)
	private int idIscrizione;

	public int getIdAutoscuola() {
		return idAutoscuola;
	}

	public void setIdAutoscuola(int idAutoscuola) {
		this.idAutoscuola = idAutoscuola;
	}

	public int getIdMezzo() {
		return idMezzo;
	}

	public void setIdMezzo(int idMezzo) {
		this.idMezzo = idMezzo;
	}

	public int getIdIstruttore() {
		return idIstruttore;
	}

	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

	public int getIdIscrizione() {
		return idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAutoscuola;
		result = prime * result + idIscrizione;
		result = prime * result + idIstruttore;
		result = prime * result + idMezzo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PrenotazionePK))
			return false;
		PrenotazionePK other = (PrenotazionePK) obj;
		if (idAutoscuola != other.idAutoscuola)
			return false;
		if (idIscrizione != other.idIscrizione)
			return false;
		if (idIstruttore != other.idIstruttore)
			return false;
		if (idMezzo != other.idMezzo)
			return false;
		return true;
	}
}