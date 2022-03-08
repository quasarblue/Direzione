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
