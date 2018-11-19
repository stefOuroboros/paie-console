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
			Cotisation cotisation = new Cotisation();
			
			cotisation.setCode(codeSaisie);
			cotisation.setImposable(imposable);
			cotisation.setLibelle(libelle);
			cotisation.setTauxPatronal(tauxPatronal);
			cotisation.setTauxSalarial(tauxSalarial);
			
		return cotisRepos.save(cotisation);
	}
	@Override
	public void supprimer(String codeSaisie) {
		for(Cotisation cotisation : cotisRepos.findByCode(codeSaisie)) {
			if(cotisation.getCode().equals(codeSaisie)) {
				cotisRepos.delete(cotisation);
			}
		}
	}
//	@Override
//	public Cotisation findByCode (String codeSaisie) {
//		for (Cotisation cotisation : cotisRepos.findByCode(codeSaisie)) {
//			return cotisation;
//		}
//	}
	@Override
	public Cotisation modifier(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal, BigDecimal tauxSalarial) {
		for (Cotisation cotisation : cotisRepos.findByCode(codeSaisie)) {
			cotisRepos.delete(cotisation);
			Cotisation cotisation2 = new Cotisation();
			
			cotisation2.setCode(codeSaisie);
			cotisation2.setImposable(imposable);
			cotisation2.setLibelle(libelle);
			cotisation2.setTauxPatronal(tauxPatronal);
			cotisation2.setTauxSalarial(tauxSalarial);
			return cotisRepos.sauver(codeSaisie, libelle, imposable, tauxPatronal, tauxSalarial);
		}
	}

}
