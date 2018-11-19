package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;
import dev.paie.service.CotisationServiceMemoire;


@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	private Scanner scanner;
	@Autowired
	private CotisationService cotis;

	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");
		String code = this.scanner.next();
		System.out.println("Veuillez saisir le libelle : ");
		String libelle = this.scanner.next();
		System.out.println("La cotisation est-elle imposable ? Saisir true || false");
		Boolean imposable = this.scanner.nextBoolean();
		System.out.println("Veuillez saisir le taux patronal");
		String tauxPatronal = this.scanner.next();
		System.out.println("Veuillez saisir le taux salarial");
		String tauxSalarial = this.scanner.next();
		
		cotis.sauver(code, libelle, imposable, new BigDecimal(tauxPatronal), new BigDecimal(tauxSalarial));
		
	}

}
