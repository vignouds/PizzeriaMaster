package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.diginamic.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

public class PizzaJdbcDao implements IPizzaDao {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaJdbcDao.class);

	public void dbConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			LOG.error("Erreur sur Class.forName");
		}

		try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_mysql", "root", "");
		} catch (SQLException e) {
			LOG.error("Impossible de se connecter à la BDD");
			e.printStackTrace();
		}

		LOG.info("Connexion réussie");
	}

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
