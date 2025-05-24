DROP DATABASE IF EXISTS Academia;
CREATE DATABASE Academia;
USE Academia;

CREATE TABLE Aluno (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    altura FLOAT,
    peso FLOAT,
    objetivo VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE PlanoTreino (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_treino VARCHAR(100) NOT NULL,
    tipo VARCHAR(50),
    descricao TEXT,
    duracao_semanas INT,
    frequencia_semanal INT,
    data_inicio DATE,
    data_fim DATE,
    observacoes TEXT,
    aluno_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);

-- Inserindo alunos
INSERT INTO Aluno (nome, cpf, data_nascimento, email, telefone, endereco, altura, peso, objetivo)
VALUES 
('Carlos Silva', '123.456.789-00', '1995-06-15', 'carlos@email.com', '(16)99999-1111', 'Rua A, 100', 1.75, 82.5, 'Hipertrofia'),
('Ana Souza', '987.654.321-00', '1998-03-22', 'ana@email.com', '(16)98888-2222', 'Rua B, 200', 1.62, 58.3, 'Definição');

-- Inserindo planos de treino
INSERT INTO PlanoTreino (nome_treino, tipo, descricao, duracao_semanas, frequencia_semanal, data_inicio, data_fim, observacoes, aluno_id)
VALUES 
('Treino A', 'Hipertrofia', 'Foco em membros superiores', 8, 5, '2024-05-01', '2024-06-26', 'Incluir progressão de carga', 1),
('Treino B', 'Cardio + Força', 'Circuito funcional', 6, 3, '2024-05-05', '2024-06-15', 'Monitorar frequência cardíaca', 2);
