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
    dataHora timestamp,
    ativo boolean default true,
    primary key (id)
);
 
create table movimentacoes(
    id serial,
    produto_id int,
    quantidade int,
    dataHora timestamp,
    operador_id int,
    tipo_registro char,
    primary key (id),
    foreign key (operador_id) references operadores (id),
    foreign key (produto_id) references produtos (id)
);