package org.diginamic;

import fr.pizzeria.dao.PizzaJdbcDao;
import fr.pizzeria.model.Pizza;

public class App 
{
    public static void main( String[] args )
    {
    	PizzaJdbcDao pizzaJdbcDao = new PizzaJdbcDao();
    	Pizza pizza = new Pizza("opp", "opop", 16.0);
    	//pizzaJdbcDao.saveNewPizza(pizza);
    	pizzaJdbcDao.deletePizza("opp");
    }
}
