CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensagem TEXT NOT NULL,
                         data_criacao DATETIME NOT NULL,
                         estado ENUM('NAO_RESPONDIDO', 'EM_DISCUSSAO', 'SOLUCIONADO', 'FECHADO') NOT NULL,

                         curso_id BIGINT NOT NULL,
                         autor_id BIGINT NOT NULL,

                         FOREIGN KEY (curso_id) REFERENCES cursos(id),
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);