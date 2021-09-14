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
package it.veneto.regione.aagg.web;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.veneto.regione.aagg.web.model.Appalto;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface AppaltoRepository extends PagingAndSortingRepository<Appalto, Integer> {
	
	/*@Query(value = "SELECT e from Appalto e order by e.data_fine asc, e.data_inizio asc")
    List<Appalto> findAll();*/ 
	
	List<Appalto> findByFunzionarioAppaltoDipendenteMatricolaAndStatoDescrizione(int matricola, String descrizione);
	
	@Query(value = "SELECT * FROM appalto a, funzionario_appalto fa, dipendente d, stato_appalto s "
			     + "  WHERE a.funzionario_appalto_id=fa.id "
			     + "  AND fa.dipendente_id=d.id "
			     + "  AND a.stato=s.id "
			     + "  AND (s.descrizione='attivo' OR s.descrizione='pianificazione iniziale') "
			     + "  AND d.matricola = ?1 "
			     + "  ORDER BY a.data_fine asc NULLS FIRST, a.data_inizio asc", nativeQuery = true)
	List<Appalto> findApertiMatricolaNative(int matricola);

	List<Appalto> findByCodiceCui(String codiceCui);
}
