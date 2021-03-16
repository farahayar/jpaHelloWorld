package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bibliotheque_adherent database table.
 * 
 */
@Embeddable
public class BibliothequeAdherentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_bib", insertable=false, updatable=false)
	private int idBib;

	@Column(name="id_adherent", insertable=false, updatable=false)
	private int idAdherent;

	public BibliothequeAdherentPK() {
	}
	public int getIdBib() {
		return this.idBib;
	}
	public void setIdBib(int idBib) {
		this.idBib = idBib;
	}
	public int getIdAdherent() {
		return this.idAdherent;
	}
	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BibliothequeAdherentPK)) {
			return false;
		}
		BibliothequeAdherentPK castOther = (BibliothequeAdherentPK)other;
		return 
			(this.idBib == castOther.idBib)
			&& (this.idAdherent == castOther.idAdherent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idBib;
		hash = hash * prime + this.idAdherent;
		
		return hash;
	}
}