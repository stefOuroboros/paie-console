package dev.paie.ihm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class Menu {
	
	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;

	
	@Autowired
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService, context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);
		Collection<OptionMenu> optionsTrouves = beansTrouves.values();
		int i = 1;
		for(OptionMenu opt : optionsTrouves) {
			this.options.put(i, opt);
			i++;
		}
	}
	
//	private void init2(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
//		
//		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);
//		//Autre méthode de faire init();
//		AtomicInteger increment = new AtomicInteger();
//		beansTrouves.forEach((idSpring, valeur) -> {
//			this.options.put(increment.incrementAndGet(), valeur);
//			});
//	}
	
	public void demarrer() {
		
		while(true) {
		// Afficher les libellés des options
		this.options.forEach((key, option) -> {
			System.out.println(key + ". " + option.getLibelle());
		});
		
		int optionMenuChoisie = this.scanner.nextInt();
		
		this.options.get(optionMenuChoisie).executer();
		}
		
	}
	
	
	
	


}
