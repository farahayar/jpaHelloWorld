package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the bibliotheque database table.
 * 
 */
@Entity
@NamedQuery(name="Bibliotheque.findAll", query="SELECT b FROM Bibliotheque b")
public class Bibliotheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	public Bibliotheque(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="bibliotheque")
	private List<Article> articles;

	//bi-directional one-to-one association to Adresse
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_adresse")
	private Adresse adresse;

	//bi-directional many-to-one association to BibliothequeAdherent
	@OneToMany(mappedBy="bibliotheque")
	private List<BibliothequeAdherent> bibliothequeAdherents;

	public Bibliotheque() {
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

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setBibliotheque(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setBibliotheque(null);

		return article;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<BibliothequeAdherent> getBibliothequeAdherents() {
		return this.bibliothequeAdherents;
	}

	public void setBibliothequeAdherents(List<BibliothequeAdherent> bibliothequeAdherents) {
		this.bibliothequeAdherents = bibliothequeAdherents;
	}

	public BibliothequeAdherent addBibliothequeAdherent(BibliothequeAdherent bibliothequeAdherent) {
		getBibliothequeAdherents().add(bibliothequeAdherent);
		bibliothequeAdherent.setBibliotheque(this);

		return bibliothequeAdherent;
	}

	public BibliothequeAdherent removeBibliothequeAdherent(BibliothequeAdherent bibliothequeAdherent) {
		getBibliothequeAdherents().remove(bibliothequeAdherent);
		bibliothequeAdherent.setBibliotheque(null);

		return bibliothequeAdherent;
	}

}