create table topicos (
    id bigint auto_increment not null primary key,
    titulo varchar(255) not null,
    mensagem text not null,
    data_criacao date not null,
    nome_autor varchar(100) not null,
    email_autor varchar(100) not null,
    estado_do_topico varchar(100) not null,
    curso varchar(255) not null
);









