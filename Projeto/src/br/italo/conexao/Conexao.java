package br.italo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // dados de conexao

    private static String servidor ="localhost:";
    private static String senha = "Mineloco28-";
    private static String user = "root";
    private static String porta = "3306/";

    private static String database = "banco?useSSL=false";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url= "jdbc:mysql://";

    private static Connection conexao;

    // jdbc:mysql://localhost:3306/banco

    public static Connection conectar()   {

        try {

            Class.forName(driver);
            conexao = DriverManager.getConnection(url+servidor+porta+database, user, senha);
            return conexao;
        }

        catch (ClassNotFoundException | SQLException e) {

            System.out.println( "Erro gerado: "  + e);
        }

        return null;
    }

}