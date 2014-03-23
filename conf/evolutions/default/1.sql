# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table programacao (
  id                        integer not null,
  inicio                    timestamp,
  fim                       timestamp,
  recorrencia               varchar(255),
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

