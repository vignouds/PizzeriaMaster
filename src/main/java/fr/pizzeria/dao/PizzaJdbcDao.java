package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

public class PizzaJdbcDao implements IPizzaDao {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaJdbcDao.class);
	private Connection myConnection;
	private Statement statement;

	public PizzaJdbcDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_mysql", "root", "");
			myConnection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("SQLException au niveau de la connexion BDD");
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException au niveau de la connexion BDD");
			e.printStackTrace();
		}
	}

	public void transcationCommit(){
		try {
			myConnection.commit();
		} catch (SQLException e) {
			LOG.error("SQLException on transcationCommit");
			e.printStackTrace();
		}
	}
	
	public void transcationRollback(){
		try {
			myConnection.rollback();
		} catch (SQLException e) {
			LOG.error("SQLException on transcationCommit");
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try {
			statement = this.myConnection.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM pizzas");
			
			while (resultats.next()) {
				String code = resultats.getString("code");
				String libelle = resultats.getString("libelle");
				Double prix = resultats.getDouble("prix");
				pizzas.add(new Pizza(code, libelle, prix));
			}		
			resultats.close();
		} catch (SQLException e) {
			LOG.error("SQLException on findPizzaByCode");
			e.printStackTrace();
		}
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			PreparedStatement insertionPizza = this.myConnection.prepareStatement("INSERT INTO pizzas(code, libelle, prix) VALUES(?,?,?)");
			insertionPizza.setString(1, pizza.getCode());
			insertionPizza.setString(2, pizza.getLibelle());
			insertionPizza.setDouble(3, pizza.getPrix());
			
			insertionPizza.executeUpdate();
		} catch (SQLException e) {
			LOG.error("SQLException on saveNewPizza");
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try {
			PreparedStatement updatePizza = this.myConnection.prepareStatement("UPDATE pizzas SET code=?, libelle=?, prix=? WHERE code=?");
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, codePizza);
			updatePizza.executeUpdate();
		} catch (SQLException e) {
			LOG.error("SQLException on updatePizza");
			e.printStackTrace();
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		try {
			PreparedStatement deletePizza = this.myConnection.prepareStatement("DELETE FROM pizzas WHERE code=?");
			deletePizza.setString(1, codePizza);
			deletePizza.executeUpdate();
		} catch (SQLException e) {
			LOG.error("SQLException on deletePizza");
			e.printStackTrace();
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;
		try {
			PreparedStatement selPizzaByCode  = this.myConnection.prepareStatement("SELECT * FROM pizzas WHERE code=?");
			selPizzaByCode.setString(1, codePizza);
			ResultSet resultat = selPizzaByCode.executeQuery();
			while (resultat.next()) {
				String code = resultat.getString("code");
				String libelle = resultat.getString("libelle");
				Double prix = resultat.getDouble("prix");
				pizza = new Pizza(code, libelle, prix);
			}		
			resultat.close();

		} catch (SQLException e) {
			LOG.error("SQLException on findPizzaByCode");
			e.printStackTrace();
		}
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		Pizza pizza = null;
		try {
			PreparedStatement selPizzaByCode = this.myConnection.prepareStatement("SELECT * FROM pizzas WHERE code=?");
			selPizzaByCode.setString(1, codePizza);
			ResultSet resultat = selPizzaByCode.executeQuery();
			while (resultat.next()) {
				String code = resultat.getString("code");
				String libelle = resultat.getString("libelle");
				Double prix = resultat.getDouble("prix");
				pizza = new Pizza(code, libelle, prix);
			}		
			resultat.close();

		} catch (SQLException e) {
			LOG.error("SQLException on findPizzaByCode");
			e.printStackTrace();
		}
		return (pizza != null) ;
	}

}
