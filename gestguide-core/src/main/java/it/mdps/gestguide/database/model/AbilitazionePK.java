package it.mdps.gestguide.database.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the abilitazione database table.
 * 
 */
@Embeddable
public class AbilitazionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_patente", insertable=false, updatable=false, unique=true, nullable=false)
	private int idPatente;

	@Column(name="id_istruttore", insertable=false, updatable=false, unique=true, nullable=false)
	private int idIstruttore;

	public AbilitazionePK() {
	}
	public int getIdPatente() {
		return this.idPatente;
	}
	public void setIdPatente(int idPatente) {
		this.idPatente = idPatente;
	}
	public int getIdIstruttore() {
		return this.idIstruttore;
	}
	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AbilitazionePK)) {
			return false;
		}
		AbilitazionePK castOther = (AbilitazionePK)other;
		return 
			(this.idPatente == castOther.idPatente)
			&& (this.idIstruttore == castOther.idIstruttore);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPatente;
		hash = hash * prime + this.idIstruttore;
		
		return hash;
	}
}