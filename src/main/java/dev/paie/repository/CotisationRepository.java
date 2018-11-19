package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.domain.Cotisation;


public interface CotisationRepository extends JpaRepository<Cotisation, Integer>{
	List<Cotisation> findByCode(String code);
}
