package it.veneto.regione.aagg.web.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "stato_appalto")
@Data
public class StatoAppalto implements Serializable {
	  private static final long serialVersionUID = -1958336209165970790L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  public Integer id;
      public String descrizione;
      
      @OneToMany(mappedBy = "stato")
      public Set<Appalto> appalti;

}
