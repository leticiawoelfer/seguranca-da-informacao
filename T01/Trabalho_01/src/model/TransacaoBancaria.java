/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leticia Woelfer de Oliveira
 */
public class TransacaoBancaria {
    
    private String cpf;
    private String nome;
    private String agencia;
    private String conta;
    private float valor;
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void sacar(){
        try {
            GeraLog log = new GeraLog("C:/trabalho_01/log_bancario/", "transacao_bancaria_log");        
            log.gravarLogTransacao("INFO - Iniciando processamento da rotina de SAQUE");
            log.gravarLogTransacao("INFO - CPF: "+getCpf());//cpf
            log.gravarLogTransacao("INFO - Nome: "+getNome());//nome
            log.gravarLogTransacao("INFO - Agencia: "+getAgencia());//agencia
            log.gravarLogTransacao("INFO - Conta: "+getConta());//conta
            log.gravarLogTransacao("INFO - Valor: "+getValor());//valor
            log.gravarLogTransacao("INFO - Senha: ****");//senha
            //mock saque bancario
            log.gravarLogTransacao("INFO - Saque no valor de "+getValor()+" retirado da conta de "+getNome());//senha
        } catch (IOException ex) {
            Logger.getLogger(TransacaoBancaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void transferir(){
        try {
            GeraLog log = new GeraLog("C:/trabalho_01/log_bancario/", "transacao_bancaria_log");        
            log.gravarLogTransacao("INFO - Iniciando processamento da rotina de TRANSFERÊNCIA");
            log.gravarLogTransacao("INFO - CPF: "+getCpf());//cpf
            log.gravarLogTransacao("INFO - Nome: "+getNome());//nome
            log.gravarLogTransacao("INFO - Agencia: "+getAgencia());//agencia
            log.gravarLogTransacao("INFO - Conta: "+getConta());//conta
            log.gravarLogTransacao("INFO - Valor: "+getValor());//valor
            log.gravarLogTransacao("INFO - Senha: ****");//senha
            //mock transferência bancária
            log.gravarLogTransacao("INFO - Transferência no valor de "+getValor()+" realizada para a conta de "+getNome());//senha
        } catch (IOException ex) {
            Logger.getLogger(TransacaoBancaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
