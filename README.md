# lab-banco-de-dados-1s-2026

Alterações em relação a versão anterior:

Criação das tabelas Categoria, Autor e Editora;
Usuario: atualização do campo data_cadastro para TIMESTAMP;
Usuario: inclusão de novo campo data_atualizacao;
Livro: remoção das colunas autor, editora e categoria;
Livro: inclusão das colunas data_cadastro, data_atualizacao, id_usuario(FK), id_autor(FK), id_editora(FK) e id_categoria(FK).

Restrições:
O nome da categoria não pode ser duplicado, deve ser único;
O nome da editora não pode ser duplicado, deve ser único;
O nome da autor não pode ser duplicado, deve ser único;
O campo nome nas tabelas Autor, Edtora e Categoria não pode ser nulo;
Não se pode excluir registros nas tabelas Autor, Editora, Cetegoria que possuam vínculos na tabela Livro;
Ao deletar um usuário, deve-se também deletar todos os registros de livros.
