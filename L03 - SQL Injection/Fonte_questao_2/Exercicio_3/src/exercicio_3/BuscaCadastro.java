/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_3;

import br.com.ConexaoBanco.ConexaoMySQL;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lcburigo
 */
public class BuscaCadastro {

    private String login;
    private String senha;

    public BuscaCadastro(String login, String senha) {
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

    public void logar() throws SQLException {
        String comando = "SELECT * FROM PESSOA"
                + " WHERE LOGIN = '" + login
                + "' AND SENHA = '" + senha   
                + "'";

        try {
            int value = Integer.parseInt(senha);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Senha deve ser númerica");
            return;
        }

        Statement st = ConexaoMySQL.getConexaoMySQL().createStatement();
        st.executeQuery(comando);
        ResultSet rs = st.getResultSet();
        
        String resultadoConsulta = null;
        if (rs.next() == true) {
            resultadoConsulta = rs.getString("nome");
            JOptionPane.showMessageDialog(null, "Bem vindo " + resultadoConsulta);
        }
        
        if(resultadoConsulta == null){
           JOptionPane.showMessageDialog(null, "Login ou Senha invÃ¡lidos");
        }
        
    }
}
