package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class CommitService extends MenuService {
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		dao.transcationCommit();
		System.out.println("Modifications validées");
	}
}
