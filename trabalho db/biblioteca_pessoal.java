CREATE DATABASE Cursos;
USE Cursos;

CREATE TABLE Aluno (
    id_aluno INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(128) NOT NULL,
    email VARCHAR(128) UNIQUE NOT NULL,
    dt_nascimento DATE
);

CREATE TABLE Professor (
    id_professor INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(128),
    email VARCHAR(128) UNIQUE NOT NULL,
    especialidade VARCHAR(128) 
);

CREATE TABLE Curso (
    id_curso INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titulo VARCHAR(128) NOT NULL,
    descricao TEXT,
    carga_horaria VARCHAR(128) NOT NULL
);

CREATE TABLE Turma(
    id_turma INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_curso INT,
    id_professor INT,
    horario VARCHAR(64),
    
    CONSTRAINT fk_curso_turma FOREIGN KEY (id_curso)
    REFERENCES Curso (id_curso) ON DELETE CASCADE,
    
    CONSTRAINT fk_professor_turma FOREIGN KEY (id_professor)
    REFERENCES Professor (id_professor) ON DELETE CASCADE
);

CREATE TABLE Matricula (
    id_matricula INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    data_matricula DATE NOT NULL,
    id_aluno INT,
    id_turma INT,
    nota FLOAT,

    CONSTRAINT fk_aluno_matricula FOREIGN KEY (id_aluno)
    REFERENCES Aluno(id_aluno) ON DELETE CASCADE,

    CONSTRAINT fk_turma_matricula FOREIGN KEY (id_turma)
    REFERENCES Turma(id_turma) ON DELETE CASCADE
);

/* ==================== INSERÇÃO DE DADOS ==================== */

/* ALUNOS */
INSERT INTO Aluno(nome, email, dt_nascimento) VALUES
("Luiza de Sousa", "luiza@gmail.com", "2002-07-20"),
("Ana Silva", "ana@gmail.com", "2007-02-21"),
("Pedro Costa","pedro@gmail.com","2003-06-15"),
("Paulo Cunha", "paulo@gmail.com", "2005-11-04"),
('Carlos Henrique Oliver', 'carlos.oliver@gmail.com', '1998-03-12'),
('Mariana Souza Santos', 'mari.santos@gmail.com', '2001-07-25'),
('Lucas Gabriel Lima', 'lucas.lima@outlook.com', '2003-11-02'),
('Beatriz Costa Araujo', 'bia.araujo@gmail.com', '2000-05-18'),
('Gabriel Ribeiro Alves', 'gabs.alves@gmail.com', '1999-09-30'),
('Amanda Martins Melo', 'amanda.melo@hotmail.com', '2002-01-14'),
('Rafael Fonseca Dias', 'rafa.dias@gmail.com', '1997-12-05'),
('Larissa Carvalho Reis', 'lari.reis@gmail.com', '2004-04-22'),
('Mateus Rocha Silva', 'mateus.rocha@outlook.com', '2001-08-09'),
('Camila Nogueira Lima', 'camila.nog@gmail.com', '2000-02-27'),
('Thiago Mendes Cruz', 'thiago.cruz@gmail.com', '1996-10-16'),
('Isabela Freire Gomes', 'isa.freire@gmail.com', '2003-06-21'),
('Bruno Cardoso Pinto', 'bruno.cardoso@hotmail.com', '1999-04-03'),
('Letícia Vieira Rocha', 'le.vieira@gmail.com', '2002-11-11'),
('Rodrigo Cunha Barbosa', 'rodrigo.cunha@gmail.com', '1995-07-08'),
('Juliana Castro Neves', 'ju.castro@gmail.com', '2001-03-19'),
('Diego Fernandes Lima', 'diego.fer@outlook.com', '1998-08-24'),
('Fernanda Ramos Pires', 'fe.ramos@gmail.com', '2004-01-05'),
('Leonardo Moraes Maciel', 'leo.moraes@gmail.com', '2000-09-14'),
('Gabriela Ortiz Farias', 'gabi.ortiz@gmail.com', '2003-05-29'),
('Vitor Hugo Teixeira', 'vitor.hugo@hotmail.com', '1997-11-18'),
('Sophia Malta Fagundes', 'sophia.malta@gmail.com', '2002-06-07'),
('Marcelo Augusto Neto', 'marcelo.guto@gmail.com', '1996-02-23'),
('Natália Guerra Meireles', 'nat.guerra@gmail.com', '2001-10-12'),
('Felipe Dantas Sales', 'felipe.dantas@outlook.com', '1999-01-29'),
('Alice Ramos Nogueira', 'alice.ramos@gmail.com', '2004-08-04'),
('Gustavo Henrique Paz', 'gustavo.paz@gmail.com', '2000-12-15'),
('Heloísa Frota Dorneles', 'helo.frota@gmail.com', '2002-04-09'),
('Caio Vinícius Malta', 'caio.vini@hotmail.com', '1998-05-22'),
('Lorena Vasconcelos', 'lore.vasco@gmail.com', '2003-09-03'),
('Arthur Schimidt Barbosa', 'arthur.sb@gmail.com', '1995-04-17'),
('Cecília Meireles Prado', 'cecilia.prado@gmail.com', '2001-12-26'),
('Danilo Soares Rezende', 'danilo.soares@outlook.com', '1999-07-11'),
('Manuela Antunes Vila', 'manu.vila@gmail.com', '2004-02-13'),
('Samuel Peixoto Correa', 'samuel.peixoto@gmail.com', '2000-03-08'),
('Evelyn Assis Fontes', 'evelyn.assis@gmail.com', '2002-10-20'),
('Igor Guimarães Torres', 'igor.gt@hotmail.com', '1997-06-14'),
('Bárbara Silveira Luz', 'barbara.luz@gmail.com', '2003-01-31'),
('Renan Lopes Pinheiro', 'renan.lopes@gmail.com', '1996-09-05'),
('Clarice Mendes Franco', 'clarice.franco@gmail.com', '2001-05-14');

/* PROFESSORES */
INSERT INTO Professor(nome, email, especialidade) VALUES
("Carlos Eduardo Silva", "carlos@gmail.com", "P.O.O."),
("Ana Beatriz Rodrigues","anab@gmail.com","Rede de Computadores"),
("João Pedro Macleure Nunes dos Santos", "joao@gmail.com", "Laboratorio de banco de dados"),
("Mariana Costa Lima","mariana@gmail.com","Métodos Ágeis"),
("Roberto Alencar", "roberto.alencar@gmail.com", "Arquitetura de Software"),
("Patricia Antunes", "patricia.antunes@gmail.com", "Segurança da Informação"),
("Fernando Malta", "fernando.malta@gmail.com", "DevOps"),
("Juliana Schimidt", "juliana.sch@gmail.com", "Inteligência Artificial");

/* CURSOS */
INSERT INTO Curso(titulo, descricao, carga_horaria) VALUES
("Programação Orientada a Objetos", "Um paradigma de programação fundamental.", "120h"),
("Rede de Computadores", "Um sistema que interconecta computadores para trocar dados.", "80h"),
("Laboratório de Banco de Dados","Desenvolvimento de consultas SQL e modelagem.", "60h"),
("Métodos Ágeis","Abordagens iterativas focadas na entrega de valor contínua.","40h");

/* TURMAS */
INSERT INTO Turma(id_curso, id_professor, horario) VALUES
(1, 1, "Matutino"),
(2, 2, "Vespertino"),
(3, 3, "Vespertino"),
(4, 4, "Noturno"),
(1, 5, "Noturno"),       -- Nova Turma 5: POO com Prof. Roberto à Noite
(3, 8, "Matutino");       -- Nova Turma 6: Banco de Dados com Profª Juliana de Manhã

/* MATRÍCULAS */
INSERT INTO Matricula(id_aluno, data_matricula, id_turma, nota) VALUES
(5, '2026-02-10', 1, 8.5), (5, '2026-02-10', 2, 7.0),
(6, '2026-02-11', 1, 9.2), (6, '2026-02-11', 3, 6.5),
(7, '2026-02-12', 2, 5.8), (7, '2026-02-12', 4, 8.0),
(8, '2026-02-12', 3, 10.0), (8, '2026-02-12', 1, 7.5),
(9, '2026-02-13', 4, 4.5),  (10, '2026-02-15', 1, 8.8),
(11, '2026-02-15', 2, 9.0), (12, '2026-02-16', 3, 7.2),
(13, '2026-02-17', 4, 6.0), (14, '2026-02-18', 1, 8.0),
(15, '2026-02-19', 2, 5.5), (16, '2026-02-20', 3, 7.8),
(17, '2026-02-22', 4, 9.5), (18, '2026-02-22', 1, 6.2),
(19, '2026-02-23', 2, 8.3), (20, '2026-02-24', 3, 4.0),
(21, '2026-02-25', 4, 7.9), (22, '2026-02-25', 1, 8.7),
(23, '2026-02-26', 2, 6.8), (24, '2026-02-27', 3, 9.1),
(25, '2026-03-01', 4, 10.0), (26, '2026-03-02', 1, 5.0),
(27, '2026-03-03', 2, 7.4), (28, '2026-03-04', 3, 8.2),
(29, '2026-03-05', 4, 6.9), (30, '2026-03-05', 1, 9.6),
(31, '2026-03-06', 2, 8.1), (32, '2026-03-08', 3, 7.3),
(33, '2026-03-09', 4, 5.2), (34, '2026-03-10', 1, 8.0),
(35, '2026-03-11', 2, 9.4), (36, '2026-03-12', 3, 6.7),
(37, '2026-03-15', 5, 8.0), (38, '2026-03-15', 5, 7.5), -- Alunos matriculados na nova turma 5
(39, '2026-03-16', 6, 9.0), (40, '2026-03-16', 6, 8.8); -- Alunos matriculados na nova turma 6


/* ==================== CRIAÇÃO DE VIEWS ==================== */

/* View 1: Média de Notas Geral por Aluno */
CREATE OR REPLACE VIEW vw_aluno_nota AS (
    SELECT
        t1.nome AS aluno,
        ROUND(AVG(t2.nota), 2) AS media_notas,
        COUNT(t2.id_matricula) AS total_cursos_matriculados
    FROM Aluno t1
    JOIN Matricula t2 ON (t1.id_aluno = t2.id_aluno)
    GROUP BY t1.id_aluno, t1.nome
);

/* View 2: Indicadores Estatísticos de Rendimento por Curso */
CREATE OR REPLACE VIEW vw_rendimento_curso AS (
    SELECT 
        t3.titulo AS curso,
        COUNT(t5.id_matricula) AS total_alunos,
        ROUND(AVG(t5.nota), 2) AS media_geral_curso,
        MAX(t5.nota) AS maior_nota,
        MIN(t5.nota) AS menor_nota
    FROM Matricula t5
    JOIN Turma t2 ON (t5.id_turma = t2.id_turma)
    JOIN Curso t3 ON (t2.id_curso = t3.id_curso)
    GROUP BY t3.id_curso, t3.titulo
);

/* View 3: Ocupação de Turmas por Horário e Professor */
CREATE OR REPLACE VIEW vw_relatorio_turmas AS (
    SELECT 
        t1.id_turma,
        t2.titulo AS curso,
        t3.nome AS professor,
        t1.horario,
        COUNT(t4.id_matricula) AS qtd_alunos
    FROM Turma t1
    JOIN Curso t2 ON (t1.id_curso = t2.id_curso)
    JOIN Professor t3 ON (t1.id_professor = t3.id_professor)
    LEFT JOIN Matricula t4 ON (t1.id_turma = t4.id_turma)
    GROUP BY t1.id_turma, t2.titulo, t3.nome, t1.horario
);


/* ==================== STORED PROCEDURE ==================== */

DELIMITER $$
CREATE PROCEDURE sp_gerar_snapshot_rendimento()
BEGIN
    START TRANSACTION;
    
    DROP TABLE IF EXISTS relatorio_rendimento;
    
    CREATE TABLE relatorio_rendimento (
        curso VARCHAR(128),
        total_alunos INT,
        media_geral DECIMAL(4,2),
        maior_nota FLOAT,
        menor_nota FLOAT
    );
    
    INSERT INTO relatorio_rendimento (curso, total_alunos, media_geral, maior_nota, menor_nota)
    SELECT curso, total_alunos, media_geral_curso, maior_nota, menor_nota 
    FROM vw_rendimento_curso;
    
    COMMIT;
END$$
DELIMITER ;


/* ============================================================
   ================== SEÇÃO DE TESTES E VALIDAÇÃO =============
   ============================================================ */

-- TESTE 1: Validação Completa de Relacionamentos com Múltiplos JOINs
SELECT
    t1.nome AS nome_aluno,
    t3.titulo AS nome_curso,
    t4.nome AS nome_professor,
    t2.horario AS horario_turma,
    t5.data_matricula,
    t5.nota
FROM Aluno t1
JOIN Matricula t5 ON (t1.id_aluno = t5.id_aluno)
JOIN Turma t2 ON (t5.id_turma = t2.id_turma)
JOIN Curso t3 ON (t2.id_curso = t3.id_curso)
JOIN Professor t4 ON (t2.id_professor = t4.id_professor)
ORDER BY nome_curso ASC, nota DESC;


-- TESTE 2: JOIN com Agrupamento focando na produtividade e distribuição de alunos por professor
SELECT 
    p.nome AS professor,
    p.especialidade,
    COUNT(m.id_matricula) AS total_alunos_atendidos,
    ROUND(AVG(m.nota), 2) AS media_notas_professor
FROM Professor p
LEFT JOIN Turma t ON p.id_professor = t.id_professor
LEFT JOIN Matricula m ON t.id_turma = m.id_turma
GROUP BY p.id_professor, p.nome, p.especialidade
ORDER BY total_alunos_atendidos DESC;


-- TESTE 3: Chamada de Validação das Views Criadas (Veja as novas turmas aparecendo no relatório de turmas!)
SELECT * FROM vw_aluno_nota;
SELECT * FROM vw_rendimento_curso;
SELECT * FROM vw_relatorio_turmas;


-- TESTE 4: Execução da Stored Procedure e Leitura de Dados Persistidos
CALL sp_gerar_snapshot_rendimento();
SELECT * FROM relatorio_rendimento;


-- TESTE 5: Teste de Integridade e Reatividade Dinâmica (Simulação Real)
-- 1. Insere um novo aluno piloto
INSERT INTO Aluno(nome, email, dt_nascimento) VALUES ("Aluno Teste Joins", "teste.joins@gmail.com", "2000-01-01");

-- 2. Vincula o novo aluno à turma 4 usando JOINs/Subqueries implícitas com nota mínima para verificar alteração de cálculos
INSERT INTO Matricula(id_aluno, data_matricula, id_turma, nota) 
VALUES ((SELECT id_aluno FROM Aluno WHERE email = "teste.joins@gmail.com"), '2026-03-25', 4, 1.5);

-- 3. Verifica se as Views com JOINs computaram a alteração dinamicamente
SELECT * FROM vw_rendimento_curso WHERE curso = "Métodos Ágeis";

-- 4. Atualiza o snapshot físico e valida o resultado final
CALL sp_gerar_snapshot_rendimento();
SELECT * FROM relatorio_rendimento WHERE curso = "Métodos Ágeis";
