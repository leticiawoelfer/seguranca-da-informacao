/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectionMsql;

/**
 *
 * @author luiz.carlos
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoMySQL {

    public static String status = "Não conectou...";

//Método Construtor da Classe//
    public ConexaoMySQL() {

    }
//Método de Conexão//

    public static java.sql.Connection getConexaoMySQL() {
//atributo do tipo Connection
        Connection connection = null;

        try {

// Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost:3306";    //caminho do servidor do BD

            String mydatabase = "exercicio_3";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";

            String username = "luiz";        //nome de um usuário de seu BD      

            String password = "123456";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

//Testa sua conexão//  
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (SQLException e) {

//Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

//Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

//Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {

            ConexaoMySQL.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

//Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConexaoMySQL.getConexaoMySQL();

    }

}
