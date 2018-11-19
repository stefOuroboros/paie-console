package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationServiceJpa;

@Controller
public class SupprimerCostisationOptionMenu extends OptionMenu {

	Scanner scanner;
	@Autowired
	private CotisationServiceJpa cotis;
	
	public SupprimerCostisationOptionMenu(Scanner scanner) {
		super("Supprimer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		System.out.println("Veuillez saisir le code de la cotisation à supprimer :");
		String codeSaisie = this.scanner.next();
		
		System.out.println("Vous allez supprimer la cotisation : " + codeSaisie);
		cotis.supprimer(codeSaisie);
	}

}
