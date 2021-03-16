package utils;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.EntityTransaction; 
import javax.persistence.Persistence;
import gestion.*; 

public class JPAUtil {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	Scanner sc=new Scanner(System.in);
	public JPAUtil(){
		emf=Persistence.createEntityManagerFactory("GestionFacture");
		em=emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	public void listeFacture(){
		List<Facture> list=em.createNamedQuery("Facture.findAll", Facture.class).getResultList();
		System.out.println("\n| ID | Code | Prix | Qte |");
		for(Facture e1:list){
			System.out.println("----------------------------------------------------------------");
			System.out.println ("| "+e1.getId()+" | "+e1.getCode()+" | "+e1.getPrix()+" | "+e1.getQte()+" |"); 
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	public void insert(){
		tx.begin();
		System.out.println("Donner l'ID de la Facture :");
		int id=sc.nextInt();
		System.out.println("Donner le code de la Facture :");
		int code=sc.nextInt();
		System.out.println("Donner la note de la Facture :");
		int prix=sc.nextInt();
		System.out.println("Donner la quantitée :");
		int qte=sc.nextInt();
		
		Facture fact=new Facture(id,code,prix,qte);
		em.persist(fact);
		tx.commit();
	}
	
	public void modifier(){
		tx.begin();
		System.out.println("Donner le ID de a Facture : ");
		int id=sc.nextInt();
		Facture fact= em.find(Facture.class, id);
		System.out.println("Donner le code de la Facture :");
		int code=sc.nextInt();
		System.out.println("Donner le prix de la Facture :");
		int prix=sc.nextInt();
		System.out.println("Donner la quantitée : ");
		int qte=sc.nextInt();
		fact.setCode(code);
		fact.setPrix(prix);
		fact.setQte(qte);
		em.merge(fact);
		tx.commit();
	}
	public void supprimer(){
		tx.begin();
		System.out.println("Donner le ID de la Facture : ");
		int id=sc.nextInt();
		Facture fact=em.find(Facture.class, id);
		em.remove(fact);
		tx.commit();
	}
	
}