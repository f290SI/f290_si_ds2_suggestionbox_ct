create table if not exists categorias(
    id int primary key auto_increment,
    descricao varchar(50) not null unique
);

insert into categorias (descricao) values 
('Sugestão'),
('Crítica'),
('Elogio');