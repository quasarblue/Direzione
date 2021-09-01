
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

