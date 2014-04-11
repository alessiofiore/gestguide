package it.mdps.gestguide.database.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrenotazionePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_autoscuola", insertable=false, updatable=false)
	private Long idAutoscuola;
	
	@Column(name="id_mezzo", insertable=false, updatable=false)
	private Long idMezzo;
	
	@Column(name="id_istruttore", insertable=false, updatable=false)
	private Long idIstruttore;
	
	@Column(name="id_iscrizione", insertable=false, updatable=false)
	private Long idIscrizione;

	public Long getIdAutoscuola() {
		return idAutoscuola;
	}

	public void setIdAutoscuola(Long idAutoscuola) {
		this.idAutoscuola = idAutoscuola;
	}

	public Long getIdMezzo() {
		return idMezzo;
	}

	public void setIdMezzo(Long idMezzo) {
		this.idMezzo = idMezzo;
	}

	public Long getIdIstruttore() {
		return idIstruttore;
	}

	public void setIdIstruttore(Long idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

	public Long getIdIscrizione() {
		return idIscrizione;
	}

	public void setIdIscrizione(Long idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAutoscuola.intValue();
		result = prime * result + idIscrizione.intValue();
		result = prime * result + idIstruttore.intValue();
		result = prime * result + idMezzo.intValue();
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