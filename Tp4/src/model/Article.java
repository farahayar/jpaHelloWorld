package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name = "Article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", description="
				+ description + ", bibliotheque=" + bibliotheque + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name="code")
	private String code;

	private String description;

	//bi-directional many-to-one association to Bibliotheque
	@ManyToOne
	@JoinColumn(name="id_biblio")
	private Bibliotheque bibliotheque;

	public Article() {
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

	public String getDescription() {
		return this.description;
	}

	public Article(int id, String code, String description,
			Bibliotheque bibliotheque) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.bibliotheque = bibliotheque;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bibliotheque getBibliotheque() {
		return this.bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

}