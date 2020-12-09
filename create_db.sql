/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     23/11/2020 17:40:02                          */
/*==============================================================*/

drop table if exists ACCESSO cascade;

drop index if exists AREA_PK cascade;

drop index if exists ADMIN_ACCESSO_FK cascade;

drop index if exists PLANNER_ACCESSO_FK cascade;

drop index if exists MAINTAINER_ACCESSO_FK cascade;

drop table if exists AREA cascade;

drop index if exists REGOLAMENTAZIONE_EXTRA_FK cascade;

drop index if exists APPARTENENZA_EXTRA_FK cascade;

drop index if exists ASSEGNAZIONE_EXTRA_FK cascade;

drop index if exists SVOLGIMENTO_EXTRA_FK cascade;

drop index if exists ATTIVITA_EXTRA_PK cascade;

drop table if exists ATTIVITA_EXTRA cascade;

drop index if exists REGOLAMENTAZIONE_PLANNED_FK cascade;

drop index if exists APPARTENENZA_PLANNED_FK cascade;

drop index if exists ASSEGNAZIONE_PLANNED_FK cascade;

drop index if exists SVOLGIMENTO_PLANNED_FK cascade;

drop index if exists ATTIVITA_PIANIFICATA_PK cascade;

drop table if exists ATTIVITA_PIANIFICATA cascade;

drop index if exists COMPETENZA_PK cascade;

drop table if exists COMPETENZA cascade;

drop index if exists REGOLAMENTAZIONE_EWO_FK cascade;

drop index if exists APPARTENENZA_EWO_FK cascade;

drop index if exists ASSEGNAZIONE_EWO_FK cascade;

drop index if exists SVOLGIMENTO_EWO_FK cascade;

drop index if exists EWO_PK cascade;

drop table if exists EWO cascade;

drop index if exists MAINTAINER_PK cascade;

drop table if exists MAINTAINER cascade;

drop index if exists MATERIALE_PK cascade;

drop table if exists MATERIALE cascade;

drop index if exists PLANNER_PK cascade;

drop table if exists PLANNER cascade;

drop index if exists POSSESSO2_FK cascade;

drop index if exists POSSESSO_FK cascade;

drop index if exists POSSESSO_PK cascade;

drop table if exists POSSESSO cascade;

drop index if exists REQUISITO_EWO2_FK cascade;

drop index if exists REQUISITO_EWO_FK cascade;

drop index if exists REQUISITO_EWO_PK cascade;

drop table if exists REQUISITO_EWO cascade;

drop index if exists REQUISITO_EXTRA2_FK cascade;

drop index if exists REQUISITO_EXTRA_FK cascade;

drop index if exists REQUISITO_EXTRA_PK cascade;

drop table if exists REQUISITO_EXTRA cascade;

drop index if exists REQUISITO_PLANNED2_FK cascade;

drop index if exists REQUISITO_PLANNED_FK cascade;

drop index if exists REQUISITO_PLANNED_PK cascade;

drop table if exists REQUISITO_PLANNED cascade;

drop index if exists SMP_PK cascade;

drop table if exists SMP cascade;

drop index if exists SYSTEM_ADMINISTRATOR_PK cascade;

drop table if exists SYSTEM_ADMINISTRATOR cascade;

drop index if exists USO_EWO2_FK cascade;

drop index if exists USO_EWO_FK cascade;

drop index if exists USO_EWO_PK cascade;

drop table if exists USO_EWO cascade;

drop index if exists USO_EXTRA2_FK cascade;

drop index if exists USO_EXTRA_FK cascade;

drop index if exists USO_EXTRA_PK cascade;

drop table if exists USO_EXTRA cascade;

drop index if exists USO_PLANNED2_FK cascade;

drop index if exists USO_PLANNED_FK cascade;

drop index if exists USO_PLANNED_PK cascade;

drop table if exists USO_PLANNED cascade;

/*==============================================================*/
/* Table: ACCESSO                                               */
/*==============================================================*/
create table ACCESSO (
   ID_ACCESSO           INT               not null,
   DATA_E_ORA_LOGIN     TIMESTAMP                 not null,
   DATA_E_ORA_LOGOFF    TIMESTAMP                 null,
   SYSTEM_ADMINISTRATOR VARCHAR(20)          null,
   PLANNER              VARCHAR(20)          null,
   MAINTAINER           VARCHAR(20)          null,
   constraint PK_ACCESSO primary key (ID_ACCESSO)
);

/*==============================================================*/
/* Table: AREA                                                  */
/*==============================================================*/
create table AREA (
   NOME                 VARCHAR(16)          not null,
   LUOGO_GEOGRAFICO     VARCHAR(25)          not null,
   constraint PK_AREA primary key (NOME, LUOGO_GEOGRAFICO)
);

/*==============================================================*/
/* Index: AREA_PK                                               */
/*==============================================================*/
create unique index AREA_PK on AREA (
NOME,
LUOGO_GEOGRAFICO
);

/*==============================================================*/
/* Table: ATTIVITA_EXTRA                                        */
/*==============================================================*/
create table ATTIVITA_EXTRA (
   ID                   INT               not null,
   AREA                 VARCHAR(16)          not null,
   LUOGO_GEOGRAFICO     VARCHAR(25)          not null,
   PLANNER              VARCHAR(20)          null,
   SMP                  VARCHAR(16)          null,
   MAINTAINER           VARCHAR(20)          null,
   AMBITO               VARCHAR(16)          not null,
   DATA_E_ORA           TIMESTAMP                 not null,
   WEEK_NUMBER          INT                  not null,
   ETA                  INT                  not null,
   WORKSPACE_NOTES      VARCHAR(100)         null,
   descrizione_intervento varchar(50)        null,
   INTERROMPIBILE       BOOLEAN              not null,
   constraint PK_ATTIVITA_EXTRA primary key (ID)
);

/*==============================================================*/
/* Index: ATTIVITA_EXTRA_PK                                     */
/*==============================================================*/
create unique index ATTIVITA_EXTRA_PK on ATTIVITA_EXTRA (
ID
);

/*==============================================================*/
/* Index: SVOLGIMENTO_EXTRA_FK                                  */
/*==============================================================*/
create  index SVOLGIMENTO_EXTRA_FK on ATTIVITA_EXTRA (
MAINTAINER
);

/*==============================================================*/
/* Index: ASSEGNAZIONE_EXTRA_FK                                 */
/*==============================================================*/
create  index ASSEGNAZIONE_EXTRA_FK on ATTIVITA_EXTRA (
PLANNER
);

/*==============================================================*/
/* Index: APPARTENENZA_EXTRA_FK                                 */
/*==============================================================*/
create  index APPARTENENZA_EXTRA_FK on ATTIVITA_EXTRA (
AREA,
LUOGO_GEOGRAFICO
);

/*==============================================================*/
/* Index: REGOLAMENTAZIONE_EXTRA_FK                             */
/*==============================================================*/
create  index REGOLAMENTAZIONE_EXTRA_FK on ATTIVITA_EXTRA (
SMP
);

/*==============================================================*/
/* Table: ATTIVITA_PIANIFICATA                                  */
/*==============================================================*/
create table ATTIVITA_PIANIFICATA (
   ID                   INT               not null,
   SMP                  VARCHAR(16)          null,
   MAINTAINER           VARCHAR(20)          null,
   AREA                 VARCHAR(16)          not null,
   LUOGO_GEOGRAFICO     VARCHAR(25)          not null,
   PLANNER              VARCHAR(20)          null,
   AMBITO               VARCHAR(16)          not null,
   DATA_E_ORA           TIMESTAMP                 not null,
   WEEK_NUMBER          INT                  not null,
   ETA                  INT                  not null,
   WORKSPACE_NOTES      VARCHAR(100)         null,
   descrizione_intervento varchar(50)        null,
   INTERROMPIBILE       BOOLEAN              not null,
   constraint PK_ATTIVITA_PIANIFICATA primary key (ID)
);

/*==============================================================*/
/* Index: ATTIVITA_PIANIFICATA_PK                               */
/*==============================================================*/
create unique index ATTIVITA_PIANIFICATA_PK on ATTIVITA_PIANIFICATA (
ID
);

/*==============================================================*/
/* Index: SVOLGIMENTO_PLANNED_FK                                */
/*==============================================================*/
create  index SVOLGIMENTO_PLANNED_FK on ATTIVITA_PIANIFICATA (
MAINTAINER
);

/*==============================================================*/
/* Index: ASSEGNAZIONE_PLANNED_FK                               */
/*==============================================================*/
create  index ASSEGNAZIONE_PLANNED_FK on ATTIVITA_PIANIFICATA (
PLANNER
);

/*==============================================================*/
/* Index: APPARTENENZA_PLANNED_FK                               */
/*==============================================================*/
create  index APPARTENENZA_PLANNED_FK on ATTIVITA_PIANIFICATA (
AREA,
LUOGO_GEOGRAFICO
);

/*==============================================================*/
/* Index: REGOLAMENTAZIONE_PLANNED_FK                           */
/*==============================================================*/
create  index REGOLAMENTAZIONE_PLANNED_FK on ATTIVITA_PIANIFICATA (
SMP
);

/*==============================================================*/
/* Table: COMPETENZA                                            */
/*==============================================================*/
create table COMPETENZA (
   ID                   INT               not null,
   DESCRIZIONE          VARCHAR(20)          null,
   constraint PK_COMPETENZA primary key (ID)
);

/*==============================================================*/
/* Index: COMPETENZA_PK                                         */
/*==============================================================*/
create unique index COMPETENZA_PK on COMPETENZA (
ID
);

/*==============================================================*/
/* Table: EWO                                                   */
/*==============================================================*/
create table EWO (
   ID                   INT               not null,
   SMP                  VARCHAR(16)          null,
   AREA                 VARCHAR(16)          not null,
   LUOGO_GEOGRAFICO     VARCHAR(25)          not null,
   MAINTAINER           VARCHAR(20)          null,
   PLANNER              VARCHAR(20)          null,
   AMBITO               VARCHAR(16)          not null,
   DATA_E_ORA           TIMESTAMP                 not null,
   WEEK_NUMBER          INT                  not null,
   ETA                  INT                  not null,
   WORKSPACE_NOTES      VARCHAR(100)         null,
   INTERROMPIBILE       BOOL                 not null,
   descrizione_intervento varchar(50)        null,
   STATO_DEL_TICKET     VARCHAR(12)          not null check (STATO_DEL_TICKET = 'non avviato' or STATO_DEL_TICKET = 'in corso' or STATO_DEL_TICKET = 'chiuso'),
   STATO_DEL_MAINTAINER VARCHAR(12)          not null check (STATO_DEL_MAINTAINER ='inviato' or STATO_DEL_MAINTAINER ='ricevuto' or STATO_DEL_MAINTAINER ='letto'),
   STATO_DEL_DIPARTIMENTO VARCHAR(15)        not null check (STATO_DEL_DIPARTIMENTO='inviato' or STATO_DEL_DIPARTIMENTO ='ricevuto' or STATO_DEL_DIPARTIMENTO ='non inviato'),
   constraint PK_EWO primary key (ID)
);

/*==============================================================*/
/* Index: EWO_PK                                                */
/*==============================================================*/
create unique index EWO_PK on EWO (
ID
);

/*==============================================================*/
/* Index: SVOLGIMENTO_EWO_FK                                    */
/*==============================================================*/
create  index SVOLGIMENTO_EWO_FK on EWO (
MAINTAINER
);

/*==============================================================*/
/* Index: ASSEGNAZIONE_EWO_FK                                   */
/*==============================================================*/
create  index ASSEGNAZIONE_EWO_FK on EWO (
PLANNER
);

/*==============================================================*/
/* Index: APPARTENENZA_EWO_FK                                   */
/*==============================================================*/
create  index APPARTENENZA_EWO_FK on EWO (
AREA,
LUOGO_GEOGRAFICO
);

/*==============================================================*/
/* Index: REGOLAMENTAZIONE_EWO_FK                               */
/*==============================================================*/
create  index REGOLAMENTAZIONE_EWO_FK on EWO (
SMP
);

/*==============================================================*/
/* Table: MAINTAINER                                            */
/*==============================================================*/
create table MAINTAINER (
   USERNAME             VARCHAR(20)          not null,
   PASSWORD             VARCHAR(20)          not null,
   COGNOME              VARCHAR(20)          null,
   NOME                 VARCHAR(20)          null,
   constraint PK_MAINTAINER primary key (USERNAME)
);

/*==============================================================*/
/* Index: MAINTAINER_PK                                         */
/*==============================================================*/
create unique index MAINTAINER_PK on MAINTAINER (
USERNAME
);

/*==============================================================*/
/* Table: MATERIALE                                             */
/*==============================================================*/
create table MATERIALE (
   NOME                 VARCHAR(20)          not null,
   DESCRIZIONE          VARCHAR(20)          null,
   constraint PK_MATERIALE primary key (NOME)
);

/*==============================================================*/
/* Index: MATERIALE_PK                                          */
/*==============================================================*/
create unique index MATERIALE_PK on MATERIALE (
NOME
);

/*==============================================================*/
/* Table: PLANNER                                               */
/*==============================================================*/
create table PLANNER (
   USERNAME             VARCHAR(20)          not null,
   PASSWORD             VARCHAR(20)          not null,
   COGNOME              VARCHAR(20)          null,
   NOME                 VARCHAR(20)          null,
   constraint PK_PLANNER primary key (USERNAME)
);

/*==============================================================*/
/* Index: PLANNER_PK                                            */
/*==============================================================*/
create unique index PLANNER_PK on PLANNER (
USERNAME
);

/*==============================================================*/
/* Table: POSSESSO                                              */
/*==============================================================*/
create table POSSESSO (
   ID                   INT               not null,
   MAINTAINER           VARCHAR(20)          not null,
   constraint PK_POSSESSO primary key (ID, MAINTAINER)
);

/*==============================================================*/
/* Index: POSSESSO_PK                                           */
/*==============================================================*/
create unique index POSSESSO_PK on POSSESSO (
ID,
MAINTAINER
);

/*==============================================================*/
/* Index: POSSESSO_FK                                           */
/*==============================================================*/
create  index POSSESSO_FK on POSSESSO (
ID
);

/*==============================================================*/
/* Index: POSSESSO2_FK                                          */
/*==============================================================*/
create  index POSSESSO2_FK on POSSESSO (
MAINTAINER
);

/*==============================================================*/
/* Table: REQUISITO_EWO                                         */
/*==============================================================*/
create table REQUISITO_EWO (
   EWO                  INT               not null,
   COMPETENZA           INT               not null,
   constraint PK_REQUISITO_EWO primary key (EWO, COMPETENZA)
);

/*==============================================================*/
/* Index: REQUISITO_EWO_PK                                      */
/*==============================================================*/
create unique index REQUISITO_EWO_PK on REQUISITO_EWO (
EWO,
COMPETENZA
);

/*==============================================================*/
/* Index: REQUISITO_EWO_FK                                      */
/*==============================================================*/
create  index REQUISITO_EWO_FK on REQUISITO_EWO (
EWO
);

/*==============================================================*/
/* Index: REQUISITO_EWO2_FK                                     */
/*==============================================================*/
create  index REQUISITO_EWO2_FK on REQUISITO_EWO (
COMPETENZA
);

/*==============================================================*/
/* Table: REQUISITO_EXTRA                                       */
/*==============================================================*/
create table REQUISITO_EXTRA (
   COMPETENZA           INT               not null,
   ATTIVITA_EXTRA       INT               not null,
   constraint PK_REQUISITO_EXTRA primary key (COMPETENZA, ATTIVITA_EXTRA)
);

/*==============================================================*/
/* Index: REQUISITO_EXTRA_PK                                    */
/*==============================================================*/
create unique index REQUISITO_EXTRA_PK on REQUISITO_EXTRA (
COMPETENZA,
ATTIVITA_EXTRA
);

/*==============================================================*/
/* Index: REQUISITO_EXTRA_FK                                    */
/*==============================================================*/
create  index REQUISITO_EXTRA_FK on REQUISITO_EXTRA (
COMPETENZA
);

/*==============================================================*/
/* Index: REQUISITO_EXTRA2_FK                                   */
/*==============================================================*/
create  index REQUISITO_EXTRA2_FK on REQUISITO_EXTRA (
ATTIVITA_EXTRA
);

/*==============================================================*/
/* Table: REQUISITO_PLANNED                                     */
/*==============================================================*/
create table REQUISITO_PLANNED (
   COMPETENZA           INT               not null,
   ATTIVITA_PIANIFICATA INT               not null,
   constraint PK_REQUISITO_PLANNED primary key (COMPETENZA, ATTIVITA_PIANIFICATA)
);

/*==============================================================*/
/* Index: REQUISITO_PLANNED_PK                                  */
/*==============================================================*/
create unique index REQUISITO_PLANNED_PK on REQUISITO_PLANNED (
COMPETENZA,
ATTIVITA_PIANIFICATA
);

/*==============================================================*/
/* Index: REQUISITO_PLANNED_FK                                  */
/*==============================================================*/
create  index REQUISITO_PLANNED_FK on REQUISITO_PLANNED (
COMPETENZA
);

/*==============================================================*/
/* Index: REQUISITO_PLANNED2_FK                                 */
/*==============================================================*/
create  index REQUISITO_PLANNED2_FK on REQUISITO_PLANNED (
ATTIVITA_PIANIFICATA
);

/*==============================================================*/
/* Table: SMP                                                   */
/*==============================================================*/
create table SMP (
   NOME                 VARCHAR(16)          not null,
   DOCUMENTO_PDF        VARCHAR(100)         not null,
   constraint PK_SMP primary key (NOME)
);

/*==============================================================*/
/* Index: SMP_PK                                                */
/*==============================================================*/
create unique index SMP_PK on SMP (
NOME
);

/*==============================================================*/
/* Table: SYSTEM_ADMINISTRATOR                                  */
/*==============================================================*/
create table SYSTEM_ADMINISTRATOR (
   USERNAME             VARCHAR(20)          not null,
   PASSWORD             VARCHAR(20)          not null,
   COGNOME              VARCHAR(20)          null,
   NOME                 VARCHAR(20)          null,
   constraint PK_SYSTEM_ADMINISTRATOR primary key (USERNAME)
);

/*==============================================================*/
/* Index: SYSTEM_ADMINISTRATOR_PK                               */
/*==============================================================*/
create unique index SYSTEM_ADMINISTRATOR_PK on SYSTEM_ADMINISTRATOR (
USERNAME
);

/*==============================================================*/
/* Table: USO_EWO                                               */
/*==============================================================*/
create table USO_EWO (
   MATERIALE            VARCHAR(20)          not null,
   EWO                  INT               not null,
   constraint PK_USO_EWO primary key (MATERIALE, EWO)
);

/*==============================================================*/
/* Index: USO_EWO_PK                                            */
/*==============================================================*/
create unique index USO_EWO_PK on USO_EWO (
MATERIALE,
EWO
);

/*==============================================================*/
/* Index: USO_EWO_FK                                            */
/*==============================================================*/
create  index USO_EWO_FK on USO_EWO (
MATERIALE
);

/*==============================================================*/
/* Index: USO_EWO2_FK                                           */
/*==============================================================*/
create  index USO_EWO2_FK on USO_EWO (
EWO
);

/*==============================================================*/
/* Table: USO_EXTRA                                             */
/*==============================================================*/
create table USO_EXTRA (
   MATERIALE            VARCHAR(20)          not null,
   ATTIVITA_EXTRA       INT               not null,
   constraint PK_USO_EXTRA primary key (MATERIALE, ATTIVITA_EXTRA)
);

/*==============================================================*/
/* Index: USO_EXTRA_PK                                          */
/*==============================================================*/
create unique index USO_EXTRA_PK on USO_EXTRA (
MATERIALE,
ATTIVITA_EXTRA
);

/*==============================================================*/
/* Index: USO_EXTRA_FK                                          */
/*==============================================================*/
create  index USO_EXTRA_FK on USO_EXTRA (
MATERIALE
);

/*==============================================================*/
/* Index: USO_EXTRA2_FK                                         */
/*==============================================================*/
create  index USO_EXTRA2_FK on USO_EXTRA (
ATTIVITA_EXTRA
);

/*==============================================================*/
/* Table: USO_PLANNED                                           */
/*==============================================================*/
create table USO_PLANNED (
   MATERIALE            VARCHAR(20)          not null,
   ATTIVITA_PIANIFICATA INT               not null,
   constraint PK_USO_PLANNED primary key (MATERIALE, ATTIVITA_PIANIFICATA)
);

/*==============================================================*/
/* Index: USO_PLANNED_PK                                        */
/*==============================================================*/
create unique index USO_PLANNED_PK on USO_PLANNED (
MATERIALE,
ATTIVITA_PIANIFICATA
);

/*==============================================================*/
/* Index: USO_PLANNED_FK                                        */
/*==============================================================*/
create  index USO_PLANNED_FK on USO_PLANNED (
MATERIALE
);

/*==============================================================*/
/* Index: USO_PLANNED2_FK                                       */
/*==============================================================*/
create  index USO_PLANNED2_FK on USO_PLANNED (
ATTIVITA_PIANIFICATA
);

alter table ACCESSO
   add constraint FK_ACCESSO_REFERENCE_SYSTEM_A foreign key (SYSTEM_ADMINISTRATOR)
      references SYSTEM_ADMINISTRATOR (USERNAME)
      on delete cascade on update cascade;

alter table ACCESSO
   add constraint FK_ACCESSO_REFERENCE_PLANNER foreign key (PLANNER)
      references PLANNER (USERNAME)
      on delete cascade on update cascade;

alter table ACCESSO
   add constraint FK_ACCESSO_REFERENCE_MAINTAIN foreign key (MAINTAINER)
      references MAINTAINER (USERNAME)
      on delete cascade on update cascade;

alter table ATTIVITA_EXTRA
   add constraint FK_ATTIVITA_APPARTENE_AREA foreign key (AREA, LUOGO_GEOGRAFICO)
      references AREA (NOME, LUOGO_GEOGRAFICO)
      on delete restrict on update restrict;

alter table ATTIVITA_EXTRA
   add constraint FK_ATTIVITA_ASSEGNAZI_PLANNER foreign key (PLANNER)
      references PLANNER (USERNAME)
      on delete restrict on update restrict;

alter table ATTIVITA_EXTRA
   add constraint FK_ATTIVITA_REGOLAMEN_SMP foreign key (SMP)
      references SMP (NOME)
      on delete restrict on update restrict;

alter table ATTIVITA_EXTRA
   add constraint FK_ATTIVITA_SVOLGIMEN_MAINTAIN foreign key (MAINTAINER)
      references MAINTAINER (USERNAME)
      on delete restrict on update restrict;

alter table ATTIVITA_PIANIFICATA
   add constraint FK_ATTIVITA_APPARTENE_AREA foreign key (AREA, LUOGO_GEOGRAFICO)
      references AREA (NOME, LUOGO_GEOGRAFICO)
      on delete restrict on update restrict;

alter table ATTIVITA_PIANIFICATA
   add constraint FK_ATTIVITA_ASSEGNAZI_PLANNER foreign key (PLANNER)
      references PLANNER (USERNAME)
      on delete restrict on update restrict;

alter table ATTIVITA_PIANIFICATA
   add constraint FK_ATTIVITA_REGOLAMEN_SMP foreign key (SMP)
      references SMP (NOME)
      on delete restrict on update restrict;

alter table ATTIVITA_PIANIFICATA
   add constraint FK_ATTIVITA_SVOLGIMEN_MAINTAIN foreign key (MAINTAINER)
      references MAINTAINER (USERNAME)
      on delete restrict on update restrict;

alter table EWO
   add constraint FK_EWO_APPARTENE_AREA foreign key (AREA, LUOGO_GEOGRAFICO)
      references AREA (NOME, LUOGO_GEOGRAFICO)
      on delete restrict on update restrict;

alter table EWO
   add constraint FK_EWO_ASSEGNAZI_PLANNER foreign key (PLANNER)
      references PLANNER (USERNAME)
      on delete restrict on update restrict;

alter table EWO
   add constraint FK_EWO_REGOLAMEN_SMP foreign key (SMP)
      references SMP (NOME)
      on delete restrict on update restrict;

alter table EWO
   add constraint FK_EWO_SVOLGIMEN_MAINTAIN foreign key (MAINTAINER)
      references MAINTAINER (USERNAME)
      on delete restrict on update restrict;

alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO_COMPETEN foreign key (ID)
      references COMPETENZA (ID)
      on delete restrict on update restrict;

alter table POSSESSO
   add constraint FK_POSSESSO_POSSESSO2_MAINTAIN foreign key (MAINTAINER)
      references MAINTAINER (USERNAME)
      on delete restrict on update restrict;

alter table REQUISITO_EWO
   add constraint FK_REQUISIT_REQUISITO_EWO foreign key (EWO)
      references EWO (ID)
      on delete restrict on update restrict;

alter table REQUISITO_EWO
   add constraint FK_REQUISIT_REQUISITO_COMPETEN foreign key (COMPETENZA)
      references COMPETENZA (ID)
      on delete restrict on update restrict;

alter table REQUISITO_EXTRA
   add constraint FK_REQUISIT_REQUISITO_COMPETEN foreign key (COMPETENZA)
      references COMPETENZA (ID)
      on delete restrict on update restrict;

alter table REQUISITO_EXTRA
   add constraint FK_REQUISIT_REQUISITO_ATTIVITA foreign key (ATTIVITA_EXTRA)
      references ATTIVITA_EXTRA (ID)
      on delete restrict on update restrict;

alter table REQUISITO_PLANNED
   add constraint FK_REQUISIT_REQUISITO_COMPETEN foreign key (COMPETENZA)
      references COMPETENZA (ID)
      on delete restrict on update restrict;

alter table REQUISITO_PLANNED
   add constraint FK_REQUISIT_REQUISITO_ATTIVITA foreign key (ATTIVITA_PIANIFICATA)
      references ATTIVITA_PIANIFICATA (ID)
      on delete restrict on update restrict;

alter table USO_EWO
   add constraint FK_USO_EWO_USO_EWO_MATERIAL foreign key (MATERIALE)
      references MATERIALE (NOME)
      on delete restrict on update restrict;

alter table USO_EWO
   add constraint FK_USO_EWO_USO_EWO2_EWO foreign key (EWO)
      references EWO (ID)
      on delete restrict on update restrict;

alter table USO_EXTRA
   add constraint FK_USO_EXTR_USO_EXTRA_MATERIAL foreign key (MATERIALE)
      references MATERIALE (NOME)
      on delete restrict on update restrict;

alter table USO_EXTRA
   add constraint FK_USO_EXTR_USO_EXTRA_ATTIVITA foreign key (ATTIVITA_EXTRA)
      references ATTIVITA_EXTRA (ID)
      on delete restrict on update restrict;

alter table USO_PLANNED
   add constraint FK_USO_PLAN_USO_PLANN_MATERIAL foreign key (MATERIALE)
      references MATERIALE (NOME)
      on delete restrict on update restrict;

alter table USO_PLANNED
   add constraint FK_USO_PLAN_USO_PLANN_ATTIVITA foreign key (ATTIVITA_PIANIFICATA)
      references ATTIVITA_PIANIFICATA (ID)
      on delete restrict on update restrict;