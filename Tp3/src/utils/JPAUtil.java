package utils;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Bibliotheque;
import model.Article;

public class JPAUtil {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	Scanner sc=new Scanner(System.in);
	public JPAUtil(){
		emf=Persistence.createEntityManagerFactory("Tp3");
		em=emf.createEntityManager();
		tx=em.getTransaction();
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
	
	public void insert(){
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
	
	public void modifier(){
		
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
	public void supprimer(){
		tx.begin();
		System.out.println("Donner le code de l'article que vous souhaitez supprimer:");
		String nom=sc.next();
		Article a= (Article) em.createQuery("select a from Article a where code='"+nom+"'").getSingleResult();
		em.remove(a);
		tx.commit();
	}

}
