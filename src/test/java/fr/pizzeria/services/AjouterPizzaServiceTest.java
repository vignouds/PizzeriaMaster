package fr.pizzeria.services;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import fr.pizzeria.dao.PizzaMemDao;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import java.util.Scanner;

public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testAjouterPizzaService() {
		PizzaMemDao p = new PizzaMemDao();
		AjouterPizzaService aps = new AjouterPizzaService();
		
		systemInMock.provideLines("TES", "test", "15");
		Scanner sc = new Scanner(System.in);
		aps.executeUC(sc, p);
		
		assertEquals("TES", p.findAllPizzas().get(8).getCode());
		assertEquals("test", p.findAllPizzas().get(8).getLibelle());
		assertTrue(p.findAllPizzas().get(8).getPrix()==15);
	}
}