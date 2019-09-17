/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import conectionMsql.ConexaoMySQL;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void logar() {
        String sqlString = "SELECT * FROM PESSOA WHERE LOGIN = ? AND SENHA = ?";
        Connection conn;
        PreparedStatement ps;
        try {
            conn = ConexaoMySQL.getConexaoMySQL();
            ps = conn.prepareStatement(sqlString);        
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            String resultadoConsulta = null;
            if (rs.next() == true) {
                resultadoConsulta = rs.getString("nome");
                JOptionPane.showMessageDialog(null, "Bem vindo " + resultadoConsulta);
            }
            if (resultadoConsulta == null) {
                GeraLog log = new GeraLog("C:/trabalho_01", "Cadastro.log");
                String msg = "Erro - login ou senha inválido [" + login + senha + "]";
                log.gravar(msg);
                JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
