INSERT INTO public.system_administrator(
	username, password, cognome, nome)
	VALUES ('Paco', 'nothing', 'Lucci', 'Alessandro');

INSERT INTO public.planner(
	username, password, cognome, nome)
	VALUES ('Giacco', 'giacco1234', 'Facchetti', 'Giacinto');
	
INSERT INTO public.planner(
	username, password, cognome, nome)
	VALUES ('Singo', 'singo99', 'Singolo', 'Primo');
	
INSERT INTO public.planner(
	username, password, cognome, nome)
	VALUES ('Flaco', 'flachito', 'Pastore', 'Javier');

INSERT INTO public.maintainer(
	username, password, cognome, nome)
	VALUES ('Smaug', 'gandalf', 'Lucio', 'Tito');
	
INSERT INTO public.maintainer(
	username, password, cognome, nome)
	VALUES ('Aug', 'procopio12', 'Adami', 'Aureliano');
	
INSERT INTO public.maintainer(
	username, password, cognome, nome)
	VALUES ('Spadino', 'sinti90', 'Anacleti', 'Alberto');

INSERT INTO public.area(
	nome, luogo_geografico)
	VALUES ('carpentry', 'Fisciano');
	
INSERT INTO public.area(
	nome, luogo_geografico)
	VALUES ('molding', 'Nocera');
	
INSERT INTO public.area(
	nome, luogo_geografico)
	VALUES('hydraulic', 'Pagani');

INSERT INTO public.competenza(
	id, descrizione)
	VALUES (1, 'Problem solving');
	
INSERT INTO public.competenza(
	id, descrizione)
	VALUES (2, 'Lateral thinking');

INSERT INTO public.possesso(
	id, maintainer)
	VALUES (1, 'Aug');
	
INSERT INTO public.possesso(
	id, maintainer)
	VALUES (2, 'Spadino');

INSERT INTO public.smp(
	nome, documento_pdf)
	VALUES ('protocollo', '/Users/doc.pdf');

INSERT INTO public.smp(
	nome, documento_pdf)
	VALUES ('appunti', '/Users/doc1.pdf');

INSERT INTO public.ewo(
	id, smp, area, luogo_geografico, maintainer, planner, ambito, data_e_ora, week_number, eta, workspace_notes, interrompibile, stato_del_ticket, stato_del_maintainer, stato_del_dipartimento)
	VALUES (1, 'protocollo', 'molding', 'Nocera', 'Aug', 'Flaco', 'meccanica', current_timestamp, 20, 30, null, true, 'non avviato', 'inviato', 'inviato');

INSERT INTO public.ewo(
	id, smp, area, luogo_geografico, maintainer, planner, ambito, data_e_ora, week_number, eta, workspace_notes, interrompibile, stato_del_ticket, stato_del_maintainer, stato_del_dipartimento)
	VALUES (2, 'appunti', 'carpentry', 'Fisciano', 'Spadino', 'Singo', 'meccanica', current_timestamp, 10, 60, null, true, 'non avviato', 'inviato', 'inviato');

INSERT INTO public.materiale(
	nome, descrizione)
	VALUES ('trapano', null);
	
INSERT INTO public.materiale(
	nome, descrizione)
	VALUES ('fresatrice', null);

INSERT INTO public.requisito_ewo(
	ewo, competenza)
	VALUES (1, 2);
	
INSERT INTO public.requisito_ewo(
	ewo, competenza)
	VALUES (2, 1);

INSERT INTO public.uso_ewo(
	materiale, ewo)
	VALUES ('trapano', 1);
	
INSERT INTO public.uso_ewo(
	materiale, ewo)
	VALUES ('trapano', 2);

INSERT INTO public.attivita_extra(
	id, area, luogo_geografico, planner, smp, maintainer, ambito, data_e_ora, week_number, eta, workspace_notes, interrompibile)
	VALUES (1, 'carpentry', 'Fisciano', 'Flaco', 'appunti','Spadino', 'meccanica', current_timestamp, 30, 40, null, true);

INSERT INTO public.uso_extra(
	materiale, attivita_extra)
	VALUES ('trapano', 1);

INSERT INTO public.attivita_pianificata(
	id, smp, maintainer, area, luogo_geografico, planner, ambito, data_e_ora, week_number, eta, workspace_notes, interrompibile)
		VALUES (1, 'appunti', 'Spadino', 'molding', 'Nocera', 'Flaco', 'meccanica', current_timestamp, 32, 50, null, false);

INSERT INTO public.uso_planned(
	materiale, attivita_pianificata)
	VALUES ('fresatrice', 1);

INSERT INTO public.requisito_extra(
	competenza, attivita_extra)
	VALUES (1, 1);

INSERT INTO public.requisito_planned(
	competenza, attivita_pianificata)
	VALUES (2, 1);

INSERT INTO public.competenza (id,descrizione) VALUES (3,'Java Programming');
INSERT INTO public.competenza (id,descrizione) VALUES (4, 'Electrician');

insert into public.requisito_planned (attivita_pianificata, competenza) values (1,3);
insert into public.requisito_planned (attivita_pianificata, competenza) values (1,4);

insert into public.maintainer (username, password, nome,cognome) values ('maintainer','maintainer','maintainer','maintainer');
insert into public.planner (username, password, nome,cognome) values ('planner','planner','planner','planner');
insert into public.system_administrator (username, password, nome,cognome) values ('admin','admin','admin','admin');

insert into public.possesso (id,maintainer) values (3,'maintainer');
insert into public.possesso (id,maintainer) values (4,'maintainer');

	










