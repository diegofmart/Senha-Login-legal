USE db_sistema;

-- Tabela de logins para acesso
CREATE TABLE IF NOT EXISTS autenticacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

SHOW TABLES;
