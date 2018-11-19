package dev.paie.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class ListerCotisationsOptionMenu extends OptionMenu {
	
	@Autowired
	private CotisationService cotisService;

	public ListerCotisationsOptionMenu(CotisationService cotisService) {
		super("Lister les cotisations");
		this.cotisService = cotisService;
	}

	@Override
	public void executer() {
		System.out.println("Listage en cours");
		this.cotisService.lister().forEach(cotis -> System.out.println("Pour la cotisation : " + cotis.getCode() + " du libelle " +
		cotis.getLibelle() + " imposable ("+ cotis.getImposable() +") ayant un taux patronnal de " + cotis.getTauxPatronal() + "et un taux salarial de " + cotis.getTauxSalarial()));
		
	}

}
