package br.com.atos.bd;

import br.com.atos.exceptions.BancoDadosException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    private String url = "jdbc:mysql://localhost:3306/projeto1";
    private String user = "sistemas";
    private String password = "";


    // criando a conexão com o banco de dados
    // evitar conexão permanente. Me conecto a cada ação
    // evita que muitas conexões sejam abertas ao mesmo tempo
    // deixa as conexões sobrecarregadas
    public Connection conectar() throws BancoDadosException {
        Connection c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new BancoDadosException("Erro ao conectar no banco de dados", e);
        }
        return c;
    }
}
