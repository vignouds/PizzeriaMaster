package fr.pizzeria.services;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;

public class AuRevoirService extends MenuService {

	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("Au revoir");
	}

}
