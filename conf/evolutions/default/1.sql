# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table programacao (
  id                        integer not null,
  inicio                    timestamp,
  fim                       timestamp,
  diario_segunda            boolean,
  diario_terca              boolean,
  diario_quarta             boolean,
  diario_quinta             boolean,
  diario_sexta              boolean,
  diario_sabado             boolean,
  diario_domingo            boolean,
  mensal_janeiro            boolean,
  mensal_fevereiro          boolean,
  mensal_marco              boolean,
  mensal_abril              boolean,
  mensal_maio               boolean,
  mensal_junho              boolean,
  mensal_julho              boolean,
  mensal_agosto             boolean,
  mensal_setembro           boolean,
  mensal_outubro            boolean,
  mensal_novembro           boolean,
  mensal_dezembro           boolean,
  semanal_primeira          boolean,
  semanal_segunda           boolean,
  semanal_penultima         boolean,
  semanal_ultima            boolean,
  semanal_acada15dias       boolean,
  constraint pk_programacao primary key (id))
;

create table tarefa (
  id                        integer not null,
  name                      varchar(255),
  notes                     varchar(2000),
  constraint pk_tarefa primary key (id))
;

create sequence programacao_seq;

create sequence tarefa_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists programacao;

drop table if exists tarefa;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists programacao_seq;

drop sequence if exists tarefa_seq;

