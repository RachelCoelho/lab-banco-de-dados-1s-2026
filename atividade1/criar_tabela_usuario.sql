create table usuario (
	id_usuario int primary key auto_increment not null,
    nome varchar(255) not null,
    email varchar(128) not null unique,
    data_cadastro date default(current_date) not null
);
