CREATE SCHEMA aplicacao;

CREATE SEQUENCE aplicacao.default_sequence;

--Criando Tabelas
CREATE TABLE aplicacao.usuario
(
   id bigint NOT NULL, 
   nome character varying(20), 
   sobrenome character varying(30), 
   senha character varying(10), 
   email character varying(30), 
   data_nascimento date,
   administrador boolean, 
   CONSTRAINT pk_usuario PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);
  
CREATE TABLE aplicacao.video
(
   id bigint NOT NULL, 
   titulo character varying(60), 
   sinopse text, 
   classificacao_etaria integer, 
   midia_video bit, 
   ano integer, 
   nome_diretor character varying(30),
   nome_ator_principal character varying(60), 
   CONSTRAINT pk_video PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.serie_novela
(
   id bigint NOT NULL, 
   sinopse text, 
   classificacao_etaria integer, 
   titulo character varying(60), 
   CONSTRAINT pk_serie_novela PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.filme
(
   id bigint, 
   id_filme bigint, 
   CONSTRAINT pk_filme PRIMARY KEY (id), 
   CONSTRAINT fk_video_filme FOREIGN KEY (id_filme) REFERENCES aplicacao.video (id) ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.genero
(
   id bigint, 
   nome character varying(25), 
   CONSTRAINT pk_genero PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

--Criando relacionamento entre tabelas

CREATE TABLE aplicacao.avaliacao_video
(
   id_usuario bigint, 
   id_filme bigint,
   CONSTRAINT pk_avaliacao_filme PRIMARY KEY (id_filme, id_usuario), 
   CONSTRAINT fk_filme_avaliacao_filme FOREIGN KEY (id_filme) REFERENCES aplicacao.filme (id) ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT fk_usuario_avaliacao_filme FOREIGN KEY (id_usuario) REFERENCES aplicacao.usuario (id) ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.video_serie_novela
(
   id bigint,
   id_video bigint, 
   id_serie_novela bigint, 
   CONSTRAINT pk_video_serie_novela PRIMARY KEY (id), 
   CONSTRAINT fk_video_video_serie_novela FOREIGN KEY (id_video) REFERENCES aplicacao.video (id) ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT fk_serie_novela_video_serie_novela FOREIGN KEY (id_serie_novela) REFERENCES aplicacao.serie_novela (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT unique_id_video UNIQUE (id_video)   
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.genero_video
(
  id_genero bigint NOT NULL,
  id_video bigint NOT NULL,
  CONSTRAINT pk_genero_video PRIMARY KEY (id_genero, id_video),
  CONSTRAINT fk_genero_genero_video FOREIGN KEY (id_genero)
      REFERENCES aplicacao.genero (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_video_genero_video FOREIGN KEY (id_video)
      REFERENCES aplicacao.video (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE aplicacao.usuario_video
(
  id bigint NOT NULL,
  id_usuario bigint NOT NULL,
  id_video bigint NOT NULL,
  ver_depois boolean,
  assistido boolean,
  CONSTRAINT pk_usuario_video PRIMARY KEY (id, id_usuario, id_video),
  CONSTRAINT fk_usuario_usuario_video FOREIGN KEY (id_usuario)
      REFERENCES aplicacao.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_video_usuario_video FOREIGN KEY (id_video)
      REFERENCES aplicacao.video (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
