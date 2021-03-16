package utils;

import java.util.*;
import java.util.Scanner;

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
				trv.listeArticle();
				break;
			}
			case 2:{
				trv.insertArticle();
				break;
			}
			case 3:{
				trv.modifierArticle();
				break;
			}
			case 4:{
				trv.supprimerArticle();
				break;
			}
			case 5:{
				trv.listeBibliotheque();
				break;
			}
			case 6:{
				trv.insertBibliotheque();
				break;
			}
			case 7:{
				trv.modifierBibliotheque();
				break;
			}
			case 8:{
				trv.supprimerBibliotheque();
				break;
			}
			case 9:{
				trv.listeAdherent();
				break;
			}
			case 10:{
				trv.insertAdherent();
				break;
			}
			case 11:{
				trv.modifierAdherent();
				break;
			}
			case 12:{
				trv.supprimerAdherent();
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
		System.out.println("1 - Afficher la liste des Article");  
		System.out.println("2 - Ajouter un Article"); 
		System.out.println("3 - Modifier un Article");  
		System.out.println("4 - Supprimer un Article"); 
		System.out.println("5 - Afficher la liste des Bibliotheque");  
		System.out.println("6 - Ajouter un Bibliotheque"); 
		System.out.println("7 - Modifier un Bibliotheque");  
		System.out.println("8 - Supprimer un Bibliotheque"); 
		System.out.println("9 - Afficher la liste des Adherent");  
		System.out.println("10 - Ajouter un Adherent"); 
		System.out.println("11 - Modifier un Adherent");  
		System.out.println("12 - Supprimer un Adherent");
		System.out.println("13 - Lister BibliothequeAdherent");
		System.out.println("14 - Fin programe");    
		while(rep<=0 || rep > 13){  
			System.out.println("Donner Votre choix :");  
			rep = sc1.nextInt();  
			}  
		return rep; 
		}
}
