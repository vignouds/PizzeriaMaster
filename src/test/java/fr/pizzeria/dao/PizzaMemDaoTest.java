package fr.pizzeria.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	PizzaMemDao p;
	Pizza pizza;
	
	@Before
	public void setUp() {
		p = new PizzaMemDao();
		pizza = new Pizza("TES", "test", 15.50);
	}
	
    @Test
    public void testFindAllPizzas()
    {
    	PizzaMemDao p = new PizzaMemDao();
    	assertTrue(p.findAllPizzas().size()==8);
    }
    
   @Test
   public void TestSaveNewPizza()
   {
	p.saveNewPizza(pizza);
   	assertTrue(p.findAllPizzas().get(8).getPrix()==15.50);
   }
   
   @Test
   public void testUpdatePizza() {
	   p.updatePizza("PEP", pizza);
	   assertTrue(p.findAllPizzas().get(0).getPrix()==15.50);
   }
   
   @Test
   public void testDeletePizza() {
	   p.deletePizza("PEP");
	   assertTrue(p.findAllPizzas().size()==7);
   }
   
   @Test
   public void testFindPizzaByCode() {
	   assertTrue(true);
   }
   
   @Test
   public void TestPizzaExists() {
	   assertTrue(true);
   }
}
