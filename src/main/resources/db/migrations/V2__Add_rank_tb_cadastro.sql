--Migration para adicionar coluna rank na minha tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN Rank VARCHAR(50);

--Não posso criar mais colunas aqui, para criar uma nova coluna precisamos criar uma nova versão como V3__