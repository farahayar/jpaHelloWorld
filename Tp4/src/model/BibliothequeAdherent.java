package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bibliotheque_adherent database table.
 * 
 */
@Entity
@Table(name="bibliotheque_adherent")
@NamedQuery(name="BibliothequeAdherent.findAll", query="SELECT b FROM BibliothequeAdherent b")
public class BibliothequeAdherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BibliothequeAdherentPK id;

	//bi-directional many-to-one association to Adherent
	@ManyToOne(cascade={CascadeType.ALL})
	@MapsId("idAdherent")
	@JoinColumn(name="id_adherent")
	 Adherent adherent;

	//bi-directional many-to-one association to Bibliotheque
	@ManyToOne(cascade={CascadeType.ALL})
	@MapsId("idBib")
	@JoinColumn(name="id_bib")
	 Bibliotheque bibliotheque;

	public BibliothequeAdherent() {
	}

	public BibliothequeAdherentPK getId() {
		return this.id;
	}

	public void setId(BibliothequeAdherentPK id) {
		this.id = id;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Bibliotheque getBibliotheque() {
		return this.bibliotheque;
	}

	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public BibliothequeAdherent(int a, int b,Adherent adherent,Bibliotheque bibliotheque) {
		super();
		id=new BibliothequeAdherentPK();
		this.id.setIdAdherent(a); 
		this.id.setIdBib(b);
		this.adherent=adherent;
		this.bibliotheque=bibliotheque;
	}

	@Override
	public String toString() {
		return "BibliothequeAdherent [idAd=" + id.getIdAdherent() +", idLib=" + id.getIdBib() + "]";
	}

}