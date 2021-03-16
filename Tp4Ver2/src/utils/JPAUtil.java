package utils;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adherent;
import model.Adresse;
import model.Bibliotheque;
import model.Article;


public class JPAUtil {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	Scanner sc=new Scanner(System.in);
	public JPAUtil(){
		emf=Persistence.createEntityManagerFactory("Tp4Ver2");
		em=emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	public void listeBibliotheque(){
		List<Bibliotheque> list=em.createNamedQuery("Bibliotheque.findAll", Bibliotheque.class).getResultList();
		System.out.println("\n| ID | Nom | Adresse");
		for(Bibliotheque e1:list){
			System.out.println("----------------------------------------------------------------");
			System.out.println ("| "+e1.getId()+" | "+e1.getNom()+" | "+e1.getAdresse().toString()+" |"); 
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void insertBibliotheque(){
		tx.begin();
		System.out.println("Donner lid de ladresse:");
		int ida=sc.nextInt();
		System.out.println("Donner le Gouv de ladresse:");
		String code=sc.next();
		System.out.println("Donner Rue adresse:");
		String rue=sc.next();
		System.out.println("Donner ville adresse:");
		String ville=sc.next();
		Adresse Ad=new Adresse(ida,code,rue,ville);
		
		
		//System.out.println("Donner l'ID de la Bibliotheque :");
		//int id=sc.nextInt();
		System.out.println("Donner le Nom de la Bibliotheque :");
		String nom=sc.next();
	
		Bibliotheque bib=new Bibliotheque(nom,new Adresse(ida,code,rue,ville));
		em.persist(bib);
		tx.commit();
	}
	
	public void modifierBibliotheque(){
		tx.begin();
		System.out.println("Donner le ID de a Bibliotheque : ");
		int id=sc.nextInt();
		Bibliotheque b1 = em.find(Bibliotheque.class, id);
		
		System.out.println("\n| ID | Nom | Adresse");
		System.out.println ("| "+b1.getId()+" | "+b1.getNom()+" | "+b1.getAdresse().toString()+" |"); 
		System.out.println("----------------------------------------------------------------");
		
		Bibliotheque bib= em.find(Bibliotheque.class, id);
		System.out.println("Donner le Nom de la Bibliotheque :");
		String nom=sc.next();
		System.out.println("Donner lid de ladresse:");
		int ida=sc.nextInt();
		System.out.println("Donner le Gouv de ladresse:");
		String code=sc.next();
		System.out.println("Donner Rue adresse:");
		String rue=sc.next();
		System.out.println("Donner ville adresse:");
		String ville=sc.next();
		bib.setNom(nom);
		bib.setAdresse(new Adresse(ida,code,rue,ville));
		em.merge(bib);
		tx.commit();
	}
	public void supprimerBibliotheque(){
		tx.begin();
		System.out.println("Donner le ID de la Bibliotheque : ");
		int id=sc.nextInt();
		Bibliotheque fact=em.find(Bibliotheque.class, id);
		em.remove(fact);
		tx.commit();
	}

	
	
	public void listeArticle(){
		List<Article> list=em.createNamedQuery("Article.findAll", Article.class).getResultList();
		System.out.println("\n| ID | Code | description | Bibliothèque");
		for(Article e1:list){
			System.out.println("----------------------------------------------------------------");
			System.out.println ("| "+e1.getId()+" | "+e1.getCode()+"|"+e1.getDescription()+" | "+e1.getBibliotheque().toString()+" |"); 
		}
		System.out.println("----------------------------------------------------------------"); 
	}
	
	public void insertArticle(){
		tx.begin();
		System.out.println("Donner le nom de la bibliothèque dans la quelle vous voulez ajouter un article:");
		String nomb=sc.next();
		System.out.println("Donner l'id de l'article:");
		int id=sc.nextInt();
		System.out.println("Donner le code de l'article:");
		String code=sc.next();
		System.out.println("Donner la description de l'article:");
		String des=sc.next();
		
		Bibliotheque b= (Bibliotheque) em.createQuery("select b from Bibliotheque b where nom='"+nomb+"'").getSingleResult();
		
		Article art=new Article(id,code,des,b);
		em.persist(art);
		tx.commit();
		
	}
	
	public void modifierArticle(){
		
		tx.begin();
		System.out.println("Donner l'id de l'article : ");
		int id=sc.nextInt();
		Article a1 = em.find(Article.class, id);
		
		System.out.println("\n| ID | Code | description | Bibliothèque");
		System.out.println("----------------------------------------------------------------");
		System.out.println ("| "+a1.getId()+" | "+a1.getCode()+"|"+a1.getDescription()+" | "+a1.getBibliotheque().toString()+" |"); 
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("Donner le code de l'Article :");
		String code=sc.next();
		System.out.println("Donner la des l'Article:");
		String des=sc.next();
		a1.setCode(code);
		a1.setDescription(des);
		em.merge(a1);
		tx.commit();
		
	}
	public void supprimerArticle(){
		tx.begin();
		System.out.println("Donner le code de l'article que vous souhaitez supprimer:");
		String nom=sc.next();
		Article a= (Article) em.createQuery("select a from Article a where code='"+nom+"'").getSingleResult();
		em.remove(a);
		tx.commit();
	}
	
	public void listeAdherent(){
		List<Adherent> list=em.createNamedQuery("Adherent.findAll", Adherent.class).getResultList();
		System.out.println("\n| ID | nom | prenom | age");
		for(Adherent e1:list){
			System.out.println("----------------------------------------------------------------");
			System.out.println ("| "+e1.getId()+" | "+e1.getNom()+"|"+e1.getPrenom()+" | "+e1.getAge()+" |"); 
		}
		System.out.println("----------------------------------------------------------------"); 
	}
	
	
	
	public void insertAdherent(){
		tx.begin();
		System.out.println("Donner le nom de la bibliothèque dans la quelle vous voulez ajouter un Adherent:");
		String nomb=sc.next();
		System.out.println("Donner le nom de l'Adherent:");
		String nom=sc.next();
		System.out.println("Donner le prenom de l'Adherent:");
		String prenom=sc.next();
		System.out.println("Donner l'age de l'Adherent:");
		int age=sc.nextInt();
		
		Bibliotheque b= (Bibliotheque) em.createQuery("select b from Bibliotheque b where nom='"+nomb+"'").getSingleResult();
		Adherent ad=new Adherent(age,nom,prenom);
		
		em.persist(ad);
		b.addAdherent(ad);
		em.merge(b);
		tx.commit();
		
	}
	
	public void modifierAdherent(){
		
		tx.begin();
		System.out.println("Donner l'id de l'Adherent : ");
		int id=sc.nextInt();
		Adherent ad = em.find(Adherent.class, id);
		
		System.out.println("\n| ID | nom | prenom | age");
		System.out.println("----------------------------------------------------------------");
		System.out.println ("| "+ad.getId()+" | "+ad.getNom()+"|"+ad.getPrenom()+" | "+ad.getAge()+" |"); 
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("Donner le nom de l'Adherent :");
		String nom=sc.next();
		System.out.println("Donner la prenom l'Adherent:");
		String prenom=sc.next();
		System.out.println("Donner l'age de l'Adherent:");
		int age=sc.nextInt();
		ad.setNom(nom);
		ad.setPrenom(prenom);
		ad.setAge(age);
		em.merge(ad);
		tx.commit();
		
	}
	public void supprimerAdherent(){
		tx.begin();
		System.out.println("Donner le code de l'Adherent que vous souhaitez supprimer:");
		String nom=sc.next();
		Adherent a= (Adherent) em.createQuery("select a from Adherent a where nom='"+nom+"'").getSingleResult();
		em.remove(a);
		tx.commit();
	}


}
