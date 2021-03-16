package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the bibliotheque database table.
 * 
 */
@Entity  
@Table(name = "bibliotheque")
@NamedQuery(name="Bibliotheque.findAll", query="SELECT b FROM Bibliotheque b")
public class Bibliotheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name="nom")
	private String nom;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="bibliotheque",cascade={ CascadeType.ALL }) 
	private List<Article> articles;

	//bi-directional one-to-one association to Adresse
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_adresse")
	private Adresse adresse;

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

	@Override
	public String toString() {
		return "Bibliotheque [id=" + id + ", nom=" + nom + "]";
	}

}