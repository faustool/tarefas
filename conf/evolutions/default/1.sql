# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tarefa (
  id                        integer not null,
  name                      varchar(255),
  notes                     varchar(2000),
  constraint pk_tarefa primary key (id))
;

create sequence tarefa_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tarefa;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tarefa_seq;

