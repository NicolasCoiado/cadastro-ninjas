-- V3: Migrations para adicionar a coluna de imgURL na tabela de ninjas
ALTER TABLE tb_ninjas
ADD COLUMN imgUrl VARCHAR(100);