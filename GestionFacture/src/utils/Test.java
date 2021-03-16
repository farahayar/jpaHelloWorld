package utils;

import java.util.*;
import java.util.Scanner;
import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction; 
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

public class Test {
	Scanner sc1 = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		JPAUtil trv=new JPAUtil();
		Test obj=new Test();
		String choix="Y";
		while(choix.equals("Y")){
			int x=obj.menu();
			
			switch(x){
			case 1:{
				trv.listeFacture();
				break;
			}
			case 2:{
				trv.insert();
				break;
			}
			case 3:{
				trv.modifier();
				break;
			}
			case 4:{
				trv.supprimer();
				break;
			}
			default:{
				System.out.println("Choix erroné");
				break;
				}
			}
			System.out.println("Voulez-vous continuez [N/Y]?");
			choix=sc.next();
		}
		
	}
	public int menu(){ 
		int rep = 0; 
		System.out.println("1 - Afficher la liste des Facture");  
		System.out.println("2 - Ajouter une Facture"); 
		System.out.println("3 - Modifier une Facture");  
		System.out.println("4 - Supprimer une Facture"); 
		System.out.println("5 - Fin programe");    
		while(rep<=0 || rep > 4){  
			System.out.println("Donner Votre choix :");  
			rep = sc1.nextInt();  
			}  
		return rep; 
		}
}
