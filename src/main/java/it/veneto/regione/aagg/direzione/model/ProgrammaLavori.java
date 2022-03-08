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
package it.veneto.regione.aagg.direzione.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "programma_lavori")
@Data
public class ProgrammaLavori implements Serializable {
	private static final long serialVersionUID = 8284545525971265813L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	
	@Column(name="cui")
	public String cui;
	
	@Column(name="anno")
	public Integer anno;
	
	@Column(name="meseavvioprocedura")
	public Integer meseavvioprocedura;


	
	@Column(name="acquistoverdi")
	public Integer acquistoverdi;
	
	@Column(name="importototverdi")
	public Integer importototverdi;
	
	@Column(name="importototale")
	public Integer importototale;
	
	@Column(name="descrizione")
	public String descrizione;

	@Column(name="nomesoggettodelegato")
	public String nomeSoggettoDelegato;
	
	@Column(name="note")
	  public String note;
	  

	@ManyToOne(cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
    @JoinColumn(name = "funzionario_appalto_id", referencedColumnName = "id")
    public FunzionarioAppalto funzionarioAppalto;
	
	/*@OneToOne(optional = true)
	@JoinColumn(name = "cui", referencedColumnName = "codice_cui", nullable=true )
	public Appalto appalto;*/
	
	@ElementCollection
	public List<Appalto> appalti = new ArrayList<Appalto>();
	  
}
