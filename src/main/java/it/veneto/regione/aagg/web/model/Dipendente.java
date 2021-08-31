package it.veneto.regione.aagg.web.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "dipendente")
@Data
public class Dipendente implements Serializable {
	  private static final long serialVersionUID = -776904346252759869L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  public Integer id;
      public String nome;
	  public String cognome;
      public Integer matricola;
      
      @OneToMany(mappedBy = "dipendente")
      public Set<FunzionarioAppalto> funzionarioAppalto;
      
	  
}
