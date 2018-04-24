package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("Mettre � jour une pizza");
		
		
		System.out.println("Code de la pizza � modifier:");
		String codePizza = scanner.next();
		
		System.out.println("Nouveau code :");
		String nvCode = scanner.next();
		
		System.out.println("Nouveau libell� :");
		String nvLibelle = scanner.next();
		
		System.out.println("Nouveau prix :");
		double nvPrix = scanner.nextDouble();
		
		dao.updatePizza(codePizza, new Pizza(nvCode, nvLibelle, nvPrix));

	}

}
