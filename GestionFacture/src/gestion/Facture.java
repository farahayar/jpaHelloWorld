package gestion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
@Table(name="facture")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int code;

	private float prix;

	private int qte;

	public Facture() {
	}
	public Facture(int id, int code, float prix, int qte) {
		super();
		this.id = id;
		this.code = code;
		this.prix = prix;
		this.qte = qte;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

}