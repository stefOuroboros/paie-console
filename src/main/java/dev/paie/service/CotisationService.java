package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import dev.paie.domain.Cotisation;

public interface CotisationService {
	
	List<Cotisation> lister();
	
	Cotisation sauver(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal, BigDecimal tauxSalarial);
	Cotisation modifier(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal, BigDecimal tauxSalarial);
	void supprimer(String codeSaisie);
}
