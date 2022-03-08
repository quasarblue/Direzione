-- Copyright (C) 2021, 2022 Fabrizio Candon

-- This file is part of Direzione.

-- Direzione is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.

-- Direzione is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.

-- You should have received a copy of the GNU General Public License
-- along with Direzione.  If not, see <https://www.gnu.org/licenses/>.
CREATE TABLE public.stato_appalto (
   id int,
   descrizione char(50),
   PRIMARY KEY(id)
);
insert into stato_appalto (id, descrizione) values (0,'chiuso');
insert into stato_appalto (id, descrizione) values (1,'attivo');
insert into stato_appalto (id, descrizione) values (2,'pianificazione iniziale');
   
CREATE TABLE public.dipendente (
    id int generated always as identity,
    matricola integer,
	nome varchar,
	cognome varchar,
	start_date timestamptz DEFAULT CURRENT_TIMESTAMP,
	end_date timestamptz DEFAULT '9999-01-01 00:00',
	PRIMARY KEY(id, matricola)
); 
  
\copy dipendente(matricola, cognome, nome) from './matr-cognome-nome-19-08-21.csv' delimiter ';' csv;
insert into dipendente (matricola, cognome, nome, start_date, end_date) values (100162, 'BROCCATO', 'CHIARA', CURRENT_TIMESTAMP, '2021-05-31 00:00');

CREATE TABLE public.funzionario_appalto (
  id int generated always as identity,
  matricola integer, 
  dipendente_id int,
  start_date timestamptz DEFAULT CURRENT_TIMESTAMP,
	end_date timestamptz DEFAULT '9999-01-01 00:00',
	PRIMARY KEY(id),
	FOREIGN KEY(matricola, dipendente_id) REFERENCES dipendente(matricola, id)
)



 CREATE TABLE public.appalto (
    id int generated always as identity,
	data_inizio date,
	data_fine date,
	descrizione varchar,
	stato int references stato_appalto(id),
	codice_cui varchar(60),
	codice_cui_collegato varchar(60),
	codice_cig varchar(30),
	funzionario_appalto_id integer references funzionario_appalto(id),
	programmazione char(2),
	ricorrente char(2),
	acquisto_verde char(2),
	budget numeric,
	drive varchar,
	tipologia_contratto integer,
	categoria_merceologica varchar,
	avanzamento numeric,
	note varchar,
	start_date timestamptz DEFAULT CURRENT_TIMESTAMP,
	end_date timestamptz DEFAULT '9999-01-01 00:00',
	PRIMARY KEY(id)
);

https://drive.google.com/drive/folders/1C0Z75vwb1TZIE5-mIz3JjoRV_IZpXnoj

\copy appalto(data_inizio, data_fine, descrizione, stato, codice_cui, codice_cui_collegato, codice_cig, funzionario, programmazione, ricorrente, acquisto_verde, budget, tipologia_contratto, categoria_merceologica, avanzamento, note) from './report-chiavi-num-19-08-2021.csv' delimiter ';' csv;


select * from funzionario_appalto funzionari0_ 
                left outer join appalto appalto1_ on funzionari0_.appalto_id=appalto1_.id 
                left outer join funzionario_appalto funzionari2_ on appalto1_.funzionario_appalto_id=funzionari2_.id 
				 where funzionari0_.id=?

CREATE TABLE public.programma_lavori (
    id int generated always as identity,
    cui varchar(60),
    anno int,
    meseAvvioProcedura int,
    funzionario_appalto_id integer references funzionario_appalto(id),
    dirigenteResponsabile integer null,
    codiceRup varchar,
    scadenzaFinanziamento varchar,
    direzioneGenerale varchar,
    strutturaOperativa varchar,
    referenteDati varchar,
    proceduraAffidamento integer null,
    acquistoVerdi integer,
    normativaRiferimento varchar,
    oggettoVerdi varchar,
    cpvVerdi varchar,
    importoNettoIvaVerdi numeric,
    importoIvaVerdi numeric,
    importoTotVerdi numeric,
    acquistoMaterialiRiciclati integer,
    oggettoMatRic varchar,
    cpvMatRic varchar,
    importoNettoIvaMatRic numeric,
    importoIvaMatRic numeric,
    importoTotMatRic numeric,
    coperturaFinanziaria integer,
    valutazione integer,
    importoCapitalePrivato numeric,
    importoTotale numeric,
    descrizione varchar,
    istat varchar,
    tipologia varchar,
    categoria varchar,
    contri varchar,
    conint integer,
    numeroProgressivo integer,
    codiceInterno varchar,
    esenteCup integer,
    cup varchar,
    cpv varchar,
    nuts varchar,
    priorita integer,
    lottoFunzionale integer,
    lavoroComplesso integer,
    finalita varchar,
    conformitaUrbanistica integer,
    conformitaAmbientale integer,
    statoProgettazione integer,
    risorseVincolatePerLegge1 numeric,
    risorseVincolatePerLegge2 numeric,
    risorseVincolatePerLegge3 numeric,
    risorseVincolatePerLeggeSucc numeric,
    risorseMutuo1 numeric,
    risorseMutuo2 numeric,
    risorseMutuo3 numeric,
    risorseMutuoSucc numeric,
    risorsePrivati1 numeric,
    risorsePrivati2 numeric,
    risorsePrivati3 numeric,
    risorsePrivatiSucc numeric,
    risorseBilancio1 numeric,
    risorseBilancio2 numeric,
    risorseBilancio3 numeric,
    risorseBilancioSucc numeric,
    risorseArt3_1 numeric,
    risorseArt3_2 numeric,
    risorseArt3_3 numeric,
    risorseArt3_Succ numeric,
    risorseImmobili1 numeric,
    risorseImmobili2 numeric,
    risorseImmobili3 numeric,
    risorseImmobiliSucc numeric,
    risorseAltro1 numeric,
    risorseAltro2 numeric,
    risorseAltro3 numeric,
    risorseAltroSucc numeric,
    speseSostenute numeric,
    tipologiaCapitalePrivato varchar,
    delega integer,
    codiceSoggettoDelegato varchar,
    nomeSoggettoDelegato varchar,
    variato integer,
    note varchar,
    start_date timestamptz DEFAULT CURRENT_TIMESTAMP,
    end_date timestamptz DEFAULT '9999-01-01 00:00',
    PRIMARY KEY(id)
)

\COPY programma_lavori(cui, anno, meseAvvioProcedura, funzionario_appalto_id, dirigenteResponsabile, codiceRup, scadenzaFinanziamento, direzioneGenerale, strutturaOperativa, referenteDati, proceduraAffidamento, acquistoVerdi, normativaRiferimento, oggettoVerdi, cpvVerdi, importoNettoIvaVerdi, importoIvaVerdi,     importoTotVerdi,     acquistoMaterialiRiciclati,     oggettoMatRic,     cpvMatRic, importoNettoIvaMatRic,     importoIvaMatRic,     importoTotMatRic,     coperturaFinanziaria, valutazione,     importoCapitalePrivato,     importoTotale,     descrizione,     istat, tipologia,     categoria,     contri,     conint,     numeroProgressivo,     codiceInterno, esenteCup,     cup,     cpv,     nuts,     priorita,     lottoFunzionale, lavoroComplesso,     finalita,     conformitaUrbanistica,     conformitaAmbientale, statoProgettazione,     risorseVincolatePerLegge1,     risorseVincolatePerLegge2, risorseVincolatePerLegge3,     risorseVincolatePerLeggeSucc,     risorseMutuo1, risorseMutuo2,     risorseMutuo3,     risorseMutuoSucc,     risorsePrivati1, risorsePrivati2,     risorsePrivati3,     risorsePrivatiSucc,     risorseBilancio1, risorseBilancio2,     risorseBilancio3,     risorseBilancioSucc,     risorseArt3_1, risorseArt3_2,     risorseArt3_3,     risorseArt3_Succ,     risorseImmobili1, risorseImmobili2,     risorseImmobili3,     risorseImmobiliSucc,     risorseAltro1,     risorseAltro2,     risorseAltro3,     risorseAltroSucc,     speseSostenute, tipologiaCapitalePrivato,     delega,     codiceSoggettoDelegato, nomeSoggettoDelegato,     variato,     note) from '.\Programma3-zanette.csv' delimiter ';' null as 'null';

\COPY programma_servizi(cui, anno, meseAvvioProcedura, funzionario_appalto_id, dirigenteResponsabile, codiceRup, scadenzaFinanziamento, direzioneGenerale, strutturaOperativa, referenteDati, proceduraAffidamento, acquistoVerdi, normativaRiferimento, oggettoVerdi, cpvVerdi, importoNettoIvaVerdi, importoIvaVerdi,     importoTotVerdi,     acquistoMaterialiRiciclati,     oggettoMatRic,     cpvMatRic, importoNettoIvaMatRic,     importoIvaMatRic,     importoTotMatRic,     coperturaFinanziaria, valutazione,     importoCapitalePrivato,     importoTotale,     descrizione,     istat, tipologia,     categoria,     contri,     conint,     numeroProgressivo,     codiceInterno, esenteCup,     cup,     cpv,     nuts,     priorita,     lottoFunzionale, lavoroComplesso,     finalita,     conformitaUrbanistica,     conformitaAmbientale, statoProgettazione,     risorseVincolatePerLegge1,     risorseVincolatePerLegge2, risorseVincolatePerLegge3,     risorseVincolatePerLeggeSucc,     risorseMutuo1, risorseMutuo2,     risorseMutuo3,     risorseMutuoSucc,     risorsePrivati1, risorsePrivati2,     risorsePrivati3,     risorsePrivatiSucc,     risorseBilancio1, risorseBilancio2,     risorseBilancio3,     risorseBilancioSucc,     risorseArt3_1, risorseArt3_2,     risorseArt3_3,     risorseArt3_Succ,     risorseImmobili1, risorseImmobili2,     risorseImmobili3,     risorseImmobiliSucc,     risorseAltro1,     risorseAltro2,     risorseAltro3,     risorseAltroSucc,     speseSostenute, tipologiaCapitalePrivato,     delega,     codiceSoggettoDelegato, nomeSoggettoDelegato,     variato,     note) from '.\fs.csv' delimiter ';' null as 'null';