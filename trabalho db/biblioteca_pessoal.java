CREATE DATABASE biblioteca_pessoal;
USE biblioteca_pessoal;

CREATE TABLE usuario(
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE categoria(
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) UNIQUE,
    descricao TEXT,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE autor(
    id_autor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE,
    ano_nascimento INT,
    ano_morte INT,
    apresentacao TEXT,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE editora(
    id_editora INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE,
    cidade VARCHAR(255),
    estado VARCHAR(255),
    pais VARCHAR(255),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE livro(
    id_livro INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_autor INT,
    id_editora INT,
    id_categoria INT, 
    titulo VARCHAR(255) NOT NULL,
    sinopse TEXT,
    ano_publicacao INT,
    lido BOOLEAN DEFAULT(0),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_usuario_livro FOREIGN KEY (id_usuario) 
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE,
    
    CONSTRAINT fk_autor_livro FOREIGN KEY (id_autor) 
    REFERENCES autor(id_autor)
    ON DELETE RESTRICT,
    
    CONSTRAINT fk_editora_livro FOREIGN KEY (id_editora) 
    REFERENCES editora(id_editora)
    ON DELETE RESTRICT,
    
    CONSTRAINT fk_categoria_livro FOREIGN KEY (id_categoria) 
    REFERENCES categoria(id_categoria)
    ON DELETE RESTRICT
);

/*USUÁRIOS*/
INSERT INTO usuario (nome, email, senha) VALUES
('Ana Silva', 'ana@email.com', '123'),
('Bruno Souza', 'bruno@email.com', '123'),
('Carla Mendes', 'carla@email.com', '123');

/*CATEGORIAS*/
INSERT INTO categoria (nome, descricao) VALUES
('Ficção Científica', 'Livros com temas futuristas e científicos'),
('Fantasia', 'Mundos imaginários e mágicos'),
('Romance', 'Histórias centradas em relações humanas'),
('Clássicos', 'Obras consagradas da literatura'),
('Suspense', 'Narrativas de tensão e mistério'),
('Filosofia', 'Reflexões filosóficas');

/*AUTORES*/
INSERT INTO autor (nome, ano_nascimento, ano_morte) VALUES
('George Orwell', 1903, 1950),
('J.R.R. Tolkien', 1892, 1973),
('Jane Austen', 1775, 1817),
('Machado de Assis', 1839, 1908),
('Agatha Christie', 1890, 1976),
('Isaac Asimov', 1920, 1992),
('Fyodor Dostoevsky', 1821, 1881),
('J.K. Rowling', 1965, NULL),
('Stephen King', 1947, NULL),
('Aldous Huxley', 1894, 1963);

/*EDITORAS*/
INSERT INTO editora (nome, cidade, estado, pais) VALUES
('Penguin Books', 'Londres', NULL, 'Reino Unido'),
('HarperCollins', 'Nova York', 'NY', 'EUA'),
('Companhia das Letras', 'São Paulo', 'SP', 'Brasil'),
('Editora Record', 'Rio de Janeiro', 'RJ', 'Brasil'),
('Rocco', 'Rio de Janeiro', 'RJ', 'Brasil');

/*LIVROS (42 REGISTROS)*/

/*Usuário 1*/
INSERT INTO livro (id_usuario, id_autor, id_editora, id_categoria, titulo, ano_publicacao, lido) VALUES
(1,1,1,4,'1984',1949,1),
(1,1,1,1,'Animal Farm',1945,1),
(1,2,1,2,'The Hobbit',1937,1),
(1,2,1,2,'The Lord of the Rings',1954,0),
(1,3,1,3,'Pride and Prejudice',1813,1),
(1,3,1,3,'Sense and Sensibility',1811,0),
(1,4,3,4,'Dom Casmurro',1899,1),
(1,4,3,4,'Memórias Póstumas de Brás Cubas',1881,0),
(1,5,2,5,'Murder on the Orient Express',1934,1),
(1,5,2,5,'And Then There Were None',1939,0),
(1,6,2,1,'Foundation',1951,1),
(1,6,2,1,'I, Robot',1950,0),
(1,7,1,6,'Crime and Punishment',1866,1),
(1,7,1,6,'The Brothers Karamazov',1880,0);

/*Usuário 2*/
INSERT INTO livro (id_usuario, id_autor, id_editora, id_categoria, titulo, ano_publicacao, lido) VALUES
(2,8,5,2,'Harry Potter and the Sorcerer''s Stone',1997,1),
(2,8,5,2,'Harry Potter and the Chamber of Secrets',1998,1),
(2,8,5,2,'Harry Potter and the Prisoner of Azkaban',1999,0),
(2,9,2,5,'The Shining',1977,1),
(2,9,2,5,'It',1986,0),
(2,9,2,5,'Misery',1987,1),
(2,10,1,1,'Brave New World',1932,1),
(2,10,1,1,'Island',1962,0),
(2,1,1,1,'Homage to Catalonia',1938,0),
(2,6,2,1,'The Caves of Steel',1953,1),
(2,6,2,1,'The Naked Sun',1957,0),
(2,5,2,5,'Death on the Nile',1937,1),
(2,3,1,3,'Emma',1815,0),
(2,4,3,4,'Quincas Borba',1891,1);

/*Usuário 3*/
INSERT INTO livro (id_usuario, id_autor, id_editora, id_categoria, titulo, ano_publicacao, lido) VALUES
(3,7,1,6,'Notes from Underground',1864,1),
(3,7,1,6,'The Idiot',1869,0),
(3,2,1,2,'Silmarillion',1977,0),
(3,2,1,2,'Unfinished Tales',1980,0),
(3,8,5,2,'Harry Potter and the Goblet of Fire',2000,1),
(3,8,5,2,'Harry Potter and the Order of the Phoenix',2003,0),
(3,9,2,5,'Carrie',1974,1),
(3,9,2,5,'Pet Sematary',1983,0),
(3,10,1,1,'Doors of Perception',1954,1),
(3,6,2,1,'Prelude to Foundation',1988,0),
(3,6,2,1,'Forward the Foundation',1993,0),
(3,5,2,5,'The ABC Murders',1936,1),
(3,4,3,4,'Helena',1876,0),
(3,3,1,3,'Mansfield Park',1814,1);


/* ==================== CONSULTAS BASE ==================== */

/*Carrega todos os livros*/
SELECT * FROM livro;

/*Carrega dados detalhados do livro com Joins*/
SELECT 
    t5.nome AS nome_usuario,
    t2.nome AS nome_autor,
    t1.titulo,
    t3.nome AS nome_categoria,
    t4.nome AS nome_editora
FROM 
    livro t1
JOIN usuario t5 ON (t1.id_usuario = t5.id_usuario)
JOIN autor t2 ON (t1.id_autor = t2.id_autor)
JOIN categoria t3 ON (t1.id_categoria = t3.id_categoria)
JOIN editora t4 ON (t1.id_editora = t4.id_editora);
    
/*Quantidade e percentual de livros por Usuário, Categoria e Editora*/
SELECT
    t1.id_usuario,
    t2.nome AS usuario,
    t1.id_categoria,
    t3.nome AS categoria,
    t1.id_editora,
    t4.nome AS editora,
    COUNT(t1.id_livro) AS qtd_livro,
    (COUNT(t1.id_livro) / (SELECT COUNT(*) FROM livro)) * 100 AS pct
FROM 
    livro t1
JOIN usuario t2 ON (t1.id_usuario = t2.id_usuario)
JOIN categoria t3 ON (t1.id_categoria = t3.id_categoria)
JOIN editora t4 ON (t1.id_editora = t4.id_editora)
GROUP BY
    t1.id_usuario,
    t2.nome,
    t1.id_categoria,
    t3.nome,
    t4.nome
ORDER BY
    t1.id_usuario, t2.nome,
    pct DESC;
    
/*Conta livros lidos e não lidos por usuário*/
SELECT 
    id_usuario,
    lido,
    COUNT(*) AS qtd
FROM 
    livro
GROUP BY
    id_usuario,
    lido;
    
/*Calcula a idade média dos autores (tratando autores vivos com o ano atual)*/
SELECT
    AVG(IF(ano_morte > 0, ano_morte, YEAR(CURRENT_DATE())) - ano_nascimento) AS idade_media_autor
FROM
    autor;
    
/*Métricas de leitura por usuário usando funções de agregação*/
SELECT
    t1.id_usuario,
    t2.nome,
    SUM(t1.lido) AS qtd_livro_lido,
    COUNT(t1.id_livro) AS qtd_livro,
    ROUND((SUM(t1.lido) / COUNT(t1.id_livro)) * 100, 2) AS pct_livro,
    MAX(t1.ano_publicacao) AS ano_mais_recente,
    MIN(t1.ano_publicacao) AS ano_mais_antigo
FROM
    livro t1
JOIN usuario t2 ON (t1.id_usuario = t2.id_usuario)
GROUP BY
    t1.id_usuario,
    t2.nome;


/* ==================== CRIAÇÃO DE VIEWS ==================== */

/*View: Quantidade de livros por categoria*/
CREATE OR REPLACE VIEW vw_categoria_livro AS (
    SELECT
        t2.nome AS categoria,
        COUNT(t1.id_livro) AS qtd
    FROM
        livro t1
    JOIN categoria t2 ON (t1.id_categoria = t2.id_categoria)
    GROUP BY t2.nome
);

SELECT * FROM vw_categoria_livro;

/*View: Quantidade de livros por status de leitura*/
CREATE OR REPLACE VIEW vw_livro_lido_qtd AS (
    SELECT
        t1.lido AS lido,
        COUNT(t1.lido) AS qtd
    FROM
        livro t1
    GROUP BY t1.lido
);

SELECT * FROM vw_livro_lido_qtd;

/*View: Lista com títulos de livros lidos*/
CREATE OR REPLACE VIEW vw_livro_lido AS (
    SELECT titulo 
    FROM livro 
    WHERE lido = 1
);

SELECT * FROM vw_livro_lido;

/*View: Relatório geral de leitura por categoria*/
CREATE OR REPLACE VIEW vw_relatorio AS (
    SELECT 
        t2.nome AS categoria, -- Corrigido de 'categoreia'
        COUNT(t1.id_livro) AS qtd, -- Corrigido de 'count(t1.livro)' para referenciar o ID correto da tabela
        SUM(t1.lido) AS qtd_lido,
        ROUND((SUM(t1.lido) / COUNT(t1.id_livro)) * 100, 2) AS pct_lido -- Removido espaço entre 'SUM' e o parêntese para evitar erros em alguns modos do MySQL
    FROM
        livro t1
    JOIN 
        categoria t2 ON (t1.id_categoria = t2.id_categoria)
    GROUP BY
        t2.nome
);

SELECT * FROM vw_relatorio;


/* ==================== STORED PROCEDURE ==================== */

DELIMITER $$
CREATE PROCEDURE sp_atualizar_relatorio()
BEGIN
    START TRANSACTION;
    
    DROP TABLE IF EXISTS relatorio;
    
    CREATE TABLE relatorio (
        categoria VARCHAR(255),
        qtd INT,
        qtd_lido INT,
        pc_lido DECIMAL(5,2) -- Definido tamanho para a coluna Decimal
    );
    
    INSERT INTO relatorio (categoria, qtd, qtd_lido, pc_lido)
    SELECT categoria, qtd, qtd_lido, pct_lido FROM vw_relatorio;

    COMMIT;    
END$$
DELIMITER ;

/*Executa a procedure para alimentar a tabela relatório física*/
CALL sp_atualizar_relatorio();

/*Verifica o resultado da tabela criada pela procedure*/
SELECT * FROM relatorio;

/*TESTE*/

/*Teste 1: Lista detalhada de livros com os nomes correspondentes*/

SELECT nome_usuario, nome_autor, titulo, nome_categoria FROM (
    SELECT t5.nome AS nome_usuario, t2.nome AS nome_autor, t1.titulo, t3.nome AS nome_categoria
    FROM livro t1
    JOIN usuario t5 ON (t1.id_usuario = t5.id_usuario)
    JOIN autor t2 ON (t1.id_autor = t2.id_autor)
    JOIN categoria t3 ON (t1.id_categoria = t3.id_categoria)
) AS busca_detalhada;

/*Teste 2: Verificando o relatório geral*/
SELECT * FROM vw_relatorio;

/*Teste 3: Chama a procedure para atualizar os dados físicos*/
CALL sp_atualizar_relatorio();

/*Teste 4: Consulte a tabela física criada/alimentada pela procedure*/
SELECT * FROM relatorio;
