package it.veneto.regione.aagg.web;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.veneto.regione.aagg.web.model.Dipendente;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DipendenteRepository extends CrudRepository<Dipendente, Integer> {
	
	@Query(value = "SELECT e from Dipendente e order by e.matricola asc")
    List<Dipendente> findDipendentiMatricolaAsc(); 
}
