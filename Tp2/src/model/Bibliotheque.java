package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the bibliotheque database table.
 * 
 */
@Entity
@Table(name="bibliotheque")
@NamedQuery(name="Bibliotheque.findAll", query="SELECT b FROM Bibliotheque b")
public class Bibliotheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	
	public Bibliotheque() {
	}

	public Bibliotheque( String nom, Adresse adresse) {
		super();
		
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	//bi-directional one-to-one association to Adresse
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="id_adresse")
		private Adresse adresse;


}