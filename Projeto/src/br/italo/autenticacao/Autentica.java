package br.italo.autenticacao;

import br.italo.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autentica {

    public static boolean autenticarSistema(String username, String password) throws SQLException {

        String SELECT_DADOS = "SELECT * FROM cliente WHERE CPF = ? AND senha = ?";

        try {

            Connection con = Conexao.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(SELECT_DADOS);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean autenticarResetdeSenha(String CPF, String email) throws SQLException {

        String SELECT_DADOS = "SELECT * FROM cliente WHERE CPF = ? AND email = ?";

        try {

            Connection con = Conexao.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(SELECT_DADOS);

            preparedStatement.setString(1, CPF);
            preparedStatement.setString(2, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}