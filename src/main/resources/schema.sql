drop table movimentacoes;
drop table produtos;
drop table operadores;
 
CREATE table operadores (
    id SERIAL,
    nome varchar,
    usuario varchar,
    senha varchar,
    primary key (id)
);
 
 
create table produtos(
    id SERIAL,
    nome varchar,
    descricao varchar,  
    preco decimal,
    quantidade int,
    ativo boolean default true,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);
 
create table movimentacoes(
    id serial,
    produto_id int,
    quantidade int,
    operador_id int,
    tipo_registro char,
    created_at timestamp,
    updated_at timestamp,
    primary key (id),
    foreign key (operador_id) references operadores (id),
    foreign key (produto_id) references produtos (id)
);