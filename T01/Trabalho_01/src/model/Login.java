/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import conectionMsql.ConexaoMySQL;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.swing.JOptionPane;

/**
 *
 * @author lcburigo
 */
public class Login {

    private String login;
    private String senha;

    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void logar() throws SQLException, IOException {

        String sqlString = "SELECT * FROM PESSOA WHERE LOGIN = ? AND SENHA = ?";
        Connection conn = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement ps = conn.prepareStatement(sqlString);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();

        String resultadoConsulta = null;
        if (rs.next() == true) {
            resultadoConsulta = rs.getString("nome");
            JOptionPane.showMessageDialog(null, "Bem vindo " + resultadoConsulta);
        }

        if (resultadoConsulta == null) {
            GeraLog log = new GeraLog();
            String msg = "Erro - login ou login inválido [" + login + senha + "]";
            log.gravar("Cadastro.log", msg);
            JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
        }

    }
}
