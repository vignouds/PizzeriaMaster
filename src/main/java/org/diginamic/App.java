package org.diginamic;

import fr.pizzeria.dao.PizzaJdbcDao;

public class App 
{
    public static void main( String[] args )
    {
    	PizzaJdbcDao pizzaJdbcDao = new PizzaJdbcDao();
    	pizzaJdbcDao.insertPizza();
    }
}
