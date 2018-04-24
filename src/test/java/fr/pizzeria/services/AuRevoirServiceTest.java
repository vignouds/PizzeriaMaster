package fr.pizzeria.services;

import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import fr.pizzeria.dao.PizzaMemDao;

public class AuRevoirServiceTest {
	@Rule 
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog(); 
	
	@Test
	public void test(){
		AuRevoirService ars = new AuRevoirService();
		PizzaMemDao p = new PizzaMemDao();
		Scanner sc = new Scanner(System.in);
		ars.executeUC(sc, p);
		assertEquals("Au revoir\n", systemOutRule.getLogWithNormalizedLineSeparator());
	}
}
