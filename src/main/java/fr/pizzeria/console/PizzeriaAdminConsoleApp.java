package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.MenuService;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		
		/* Initialisation du TDB de pizzas */
		IPizzaDao dao = new PizzaMemDao();
		
		/* Initialisation du scanner */
		Scanner scanner = new Scanner(System.in);
		int choix = 0;
		
		/* Structure de r�p�tition de la boucle principale */
		do {
			println("***** Pizzeria Administration *****");
			println("1. Lister les pizzas ");
			println("2. Ajouter une nouvelle pizza ");
			println("3. Mettre � jour une pizza ");
			println("4. Supprimer une pizza ");
			println("99. Sortir ");
	
			System.out.print("Veuillez choisir une option:");
			choix = scanner.nextInt();
			
			MenuService service = MenuServiceFactory.getInstance(choix);
			service.executeUC(scanner, dao);
			
		} while(choix!=99);
		
		scanner.close();
		
	}
	
	

	private static void println(String msg){
		System.out.println(msg);
	}
}
