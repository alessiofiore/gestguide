package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the abilitazione database table.
 * 
 */
@Embeddable
public class AbilitazioneMezzoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_patente", insertable=false, updatable=false, unique=true, nullable=false)
	private int idPatente;

	@Column(name="id_mezzo", insertable=false, updatable=false, unique=true, nullable=false)
	private int idMezzo;

	public AbilitazioneMezzoPK() {
	}
	public int getIdPatente() {
		return this.idPatente;
	}
	public void setIdPatente(int idPatente) {
		this.idPatente = idPatente;
	}
	public int getIdMezzo() {
		return this.idMezzo;
	}
	public void setIdMezzo(int idMezzo) {
		this.idMezzo = idMezzo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AbilitazioneMezzoPK)) {
			return false;
		}
		AbilitazioneMezzoPK castOther = (AbilitazioneMezzoPK)other;
		return 
			(this.idPatente == castOther.idPatente)
			&& (this.idMezzo == castOther.idMezzo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPatente;
		hash = hash * prime + this.idMezzo;
		
		return hash;
	}
}