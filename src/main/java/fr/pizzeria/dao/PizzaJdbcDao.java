package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mysql.jdbc.PreparedStatement;

import fr.pizzeria.model.Pizza;

public class PizzaJdbcDao implements IPizzaDao {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaJdbcDao.class);
	private Connection myConnection;
	private Statement statement;

	public PizzaJdbcDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_mysql", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("SQLException au niveau de la connexion BDD");
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException au niveau de la connexion BDD");
			e.printStackTrace();
		}
	}

	public void insertPizza() {
		
		try {
			//statement = myConnection.createStatement();
			//int nbPizzaInsere = statement.executeUpdate("INSERT INTO pizzas(code, libelle, prix) VALUES('REG','Regina',12.0)");
			
			PreparedStatement insertionPizza = this.myConnection.prepareStatement("INSERT INTO pizzas(code, libelle, prix) VALUES(?,?,?)");
			insertionPizza.setString(1, "REG");
			insertionPizza.setString(2, "Regina");
			insertionPizza.setDouble(3, 12.0);
			
			insertionPizza.executeUpdate();
		} catch (SQLException e) {
			LOG.error("SQLException on insertPizza");
			e.printStackTrace();
		}
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
