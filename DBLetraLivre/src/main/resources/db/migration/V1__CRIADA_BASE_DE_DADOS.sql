CREATE SCHEMA aplicacao;

CREATE SEQUENCE aplicacao.default_sequence;

CREATE TABLE aplicacao.usuario
(
   id bigint NOT NULL, 
   nome character varying(20),
   codigo_avatar int,
   pk_usuario PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.palavra
(
   id bigint NOT NULL, 
   texto character varying(20),
   CONSTRAINT pk_palavra PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);

CREATE TABLE aplicacao.pontuacao
(
   id bigint NOT NULL, 
   id_usuario bigint,
   id_palavra bigint,
   tempo_milisegundos bigint,
   CONSTRAINT pk_pontuacao PRIMARY KEY (id),
   CONSTRAINT fk_usuario_pontuacao FOREIGN KEY (id_usuario) REFERENCES aplicacao.usuario (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_palavra_pontuacao FOREIGN KEY (id_palavra) REFERENCES aplicacao.palavra (id) ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS = FALSE
);

