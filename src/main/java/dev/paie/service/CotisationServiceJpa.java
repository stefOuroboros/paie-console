package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class CotisationServiceJpa implements CotisationService{

	@Autowired
	private CotisationRepository cotisRepos;
	
	@Override
	public List<Cotisation> lister() {

		return cotisRepos.findAll();
	}

	@Override
	public Cotisation sauver(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		// Création d'une nouvelle cotisation avec
		// les paramêtres d'entrée de la méthode sauver
			Cotisation cotis = new Cotisation();
			
			cotis.setCode(codeSaisie);
			cotis.setImposable(imposable);
			cotis.setLibelle(libelle);
			cotis.setTauxPatronal(tauxPatronal);
			cotis.setTauxSalarial(tauxSalarial);
			
		return cotisRepos.save(cotis);
	}
	
	public void supprimer(String codeSaisie) {
		for(Cotisation cotisation : cotisRepos.findByCode(codeSaisie)) {
			if(cotisation.getCode().equals(codeSaisie)) {
				cotisRepos.delete(cotisation);
			}
		}	
	}

}
