package fr.pizzeria.services;

public class MenuServiceFactory {

	public static MenuService getInstance(int choix){
		if (choix==1){
			return new ListerPizzasService();
		}
		else if (choix==2){
			return new AjouterPizzaService();
		}
		else if (choix==3){
			return new ModifierPizzaService();
		}
		return null;
	}
}
