package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Table(name="adresse")
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Adresse(int id, String code, String rue, String ville) {
		super();
		this.id = id;
		this.code = code;
		this.rue = rue;
		this.ville = ville;
	}

	private String code;

	private String rue;

	private String ville;

	

	public Adresse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Bibliotheque getBibliotheque() {
		return this.bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
	
	//bi-directional one-to-one association to Bibliotheque
		@OneToOne(mappedBy="adresse")
		private Bibliotheque bibliotheque;
		

		@Override
		public String toString() {
			return "Adresse [id=" + id + ", code=" + code + ", rue=" + rue
					+ ", ville=" + ville + "]";
		}

}