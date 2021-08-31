package it.veneto.regione.aagg.web.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "appalto")
@Data
public class Appalto implements Serializable {
	  private static final long serialVersionUID = -7391815754041229994L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  public Integer id;
	  @Column(name="data_inizio")
	  public Date dataInizio;
	  @Column(name="data_fine")
	  public Date dataFine;
	  public String descrizione;
	  //public String stato;
	  public String codice_cui;
	  public String codice_cui_collegato;
	  public String codice_cig;
	  //public Integer funzionario_appalto_id;
	  public String programmazione;
	  public String ricorrente;
	  public String acquisto_verde;
	  public String note;
	  public Integer budget;
	  public String drive;
	  public Integer tipologia_contratto;
	  public String categoria_merceologica;
	  public Integer avanzamento;

	  @ManyToOne(cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
      @JoinColumn(name = "funzionario_appalto_id", referencedColumnName = "id")
      public FunzionarioAppalto funzionarioAppalto;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "stato", referencedColumnName = "id")
      public StatoAppalto stato;
	  
}
