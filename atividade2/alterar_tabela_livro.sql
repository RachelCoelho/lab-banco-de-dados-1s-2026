ALTER TABLE Livro 
    /*Remoção das colunas antigas*/
    DROP COLUMN autor,
    DROP COLUMN editora,
    DROP COLUMN categoria,
    
    /*Inclusão das novas colunas de controle e FKs*/
    ADD COLUMN data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ADD COLUMN id_usuario INT,
    ADD COLUMN id_autor INT,
    ADD COLUMN id_editora INT,
    ADD COLUMN id_categoria INT,

    /*Definição das Constraints de Relacionamento*/
    ADD CONSTRAINT fk_livro_usuario FOREIGN KEY (id_usuario) 
        REFERENCES Usuario(id_usuario) ON DELETE CASCADE,
    
    ADD CONSTRAINT fk_livro_autor FOREIGN KEY (id_autor) 
        REFERENCES Autor(id_autor) ON DELETE RESTRICT,
        
    ADD CONSTRAINT fk_livro_editora FOREIGN KEY (id_editora) 
        REFERENCES Editora(id_editora) ON DELETE RESTRICT,
        
    ADD CONSTRAINT fk_livro_categoria FOREIGN KEY (id_categoria) 
        REFERENCES Categoria(id_categoria) ON DELETE RESTRICT;
