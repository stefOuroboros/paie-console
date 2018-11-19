package dev.paie.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.ihm.Menu;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static void main(String[] args) {
		
		// Création context Spring
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
			
		}
	}
}
