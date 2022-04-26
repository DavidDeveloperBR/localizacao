create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into
    tb_cidade (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 12396372),
    (2, 'Rio de Janeiro', 10000000),
    (3, 'Fortaleza', 800000),
    (4, 'Salvador', 700000),
    (5, 'Belo Horizonte', 600000),
    (6, 'Porto Alegre', 500000),
    (7, 'Porto Velho', 400000),
    (8, 'Palmas', 300000),
    (9, 'Recife', 200000);
