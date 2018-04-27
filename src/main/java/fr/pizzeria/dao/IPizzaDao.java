package fr.pizzeria.dao;

import java.sql.DriverManager;
import java.util.List;

import com.mysql.jdbc.Connection;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
	void transcationCommit();
	void transcationRollback();
}

