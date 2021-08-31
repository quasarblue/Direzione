package it.veneto.regione.aagg.web;

import org.springframework.data.repository.CrudRepository;

import it.veneto.regione.aagg.web.model.FunzionarioAppalto;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FunzionarioAppaltoRepository extends CrudRepository<FunzionarioAppalto, Integer> {
	
}
