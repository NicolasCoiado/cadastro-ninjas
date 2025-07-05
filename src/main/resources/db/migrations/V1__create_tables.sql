-- Cria a tabela de missões
CREATE TABLE tb_missoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    dificuldade VARCHAR(255)
);

-- Cria a tabela de ninjas
CREATE TABLE tb_ninjas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    idade INT,
    missoes_id BIGINT,
    CONSTRAINT fk_missoes FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id)
);