package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.paie.domain.Cotisation;


public class CotisationServiceMemoire implements CotisationService {

	private List<Cotisation> cotisations = new ArrayList<>();
	
	@Override
	public List<Cotisation> lister() {
		return cotisations;
	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		// Création d'une nouvelle cotisation avec
		// les paramêtres d'entrée de la méthode sauver
			Cotisation cotis = new Cotisation();
			
			cotis.setCode(code);
			cotis.setImposable(imposable);
			cotis.setLibelle(libelle);
			cotis.setTauxPatronal(tauxPatronal);
			cotis.setTauxSalarial(tauxSalarial);
			
			cotisations.add(cotis);
			
		return cotis;
	}

}
