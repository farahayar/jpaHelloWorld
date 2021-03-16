package utils;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Adresse;
import model.Bibliotheque;

public class JPAUtil {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	Scanner sc=new Scanner(System.in);
	public JPAUtil(){
		emf=Persistence.createEntityManagerFactory("Tp2");
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
	
	public void insert(){
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
	
	public void modifier(){
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
	public void supprimer(){
		tx.begin();
		System.out.println("Donner le ID de la Bibliotheque : ");
		int id=sc.nextInt();
		Bibliotheque fact=em.find(Bibliotheque.class, id);
		em.remove(fact);
		tx.commit();
	}

}
