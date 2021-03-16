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

	//bi-directional many-to-one association to BibliothequeAdherent
	@OneToMany(mappedBy="adherent")
	private List<BibliothequeAdherent> bibliothequeAdherents;

	public Adherent( int age, String nom, String prenom) {
		super();
		this.age = age;
		this.nom = nom;
		this.prenom = prenom;
	}

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

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<BibliothequeAdherent> getBibliothequeAdherents() {
		return this.bibliothequeAdherents;
	}

	public void setBibliothequeAdherents(List<BibliothequeAdherent> bibliothequeAdherents) {
		this.bibliothequeAdherents = bibliothequeAdherents;
	}

	public BibliothequeAdherent addBibliothequeAdherent(BibliothequeAdherent bibliothequeAdherent) {
		getBibliothequeAdherents().add(bibliothequeAdherent);
		bibliothequeAdherent.setAdherent(this);

		return bibliothequeAdherent;
	}

	public BibliothequeAdherent removeBibliothequeAdherent(BibliothequeAdherent bibliothequeAdherent) {
		getBibliothequeAdherents().remove(bibliothequeAdherent);
		bibliothequeAdherent.setAdherent(null);

		return bibliothequeAdherent;
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", age=" + age + ", nom=" + nom
				+ ", prenom=" + prenom + ", bibliothequeAdherents="
				+ bibliothequeAdherents + "]";
	}

}