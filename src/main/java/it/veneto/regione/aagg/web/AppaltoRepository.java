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

}
