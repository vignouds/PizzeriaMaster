package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class RollbackService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		dao.transcationRollback();
		System.out.println("Modifications supprimées");
	}
}
