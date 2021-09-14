package it.veneto.regione.aagg.web;
/*
 * Copyright (C) 2021 Fabrizio Candon

 * This file is part of Direzione.
 
 * Direzione is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Direzione is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Direzione.  If not, see <https://www.gnu.org/licenses/>.
 */


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.veneto.regione.aagg.web.model.Appalto;
import it.veneto.regione.aagg.web.model.ProgrammaServizi;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface ProgrammaServiziRepository extends PagingAndSortingRepository<ProgrammaServizi, Integer> {
	
	/*@Query(value = "SELECT e from Appalto e order by e.data_fine asc, e.data_inizio asc")
    List<Appalto> findAll();*/ 
	
	
	
	@Query(value = "SELECT * " 
			     //+ "  a.id, a.anno, a.meseavvioprocedura,  "
			     //+ "  a.cui, a.descrizione, a.importototale, a.acquistoverdi,  "
			     //+ "  a.importototverdi, a.note, a.funzionario_appalto_id "
			     + "  FROM programma_servizi a, funzionario_appalto fa, dipendente d, appalto ap "
			     + "  WHERE a.funzionario_appalto_id=fa.id "
			     + "  AND fa.dipendente_id=d.id "
			     + "  AND ap.codice_cui=a.cui "
			     + "  ORDER BY a.anno asc NULLS FIRST, a.meseavvioprocedura asc", nativeQuery = true)
	List<ProgrammaServizi> findServiziNative();

	List<ProgrammaServizi> findByCui(String cui);
}
