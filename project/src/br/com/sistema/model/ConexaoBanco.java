package br.com.sistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL = "jdbc:mysql://localhost:3306/db_sistema?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Altere se o seu usuário for diferente
    private static final String SENHA = "";       // Digite a senha do seu MySQL

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}