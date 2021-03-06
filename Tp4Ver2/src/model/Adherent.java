package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the adherent database table.
 * 
 */
@Entity
@NamedQuery(name="Adherent.findAll", query="SELECT a FROM Adherent a")
public class Adherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int age;

	private String nom;

	private String prenom;

	//bi-directional many-to-many association to Bibliotheque
	@ManyToMany(mappedBy="adherents", cascade={CascadeType.ALL})
	private List<Bibliotheque> bibliotheques;

	public Adherent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adherent(int age, String nom, String prenom) {
		super();
		this.age = age;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Bibliotheque> getBibliotheques() {
		return this.bibliotheques;
	}

	public void setBibliotheques(List<Bibliotheque> bibliotheques) {
		this.bibliotheques = bibliotheques;
	}

}