/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luiz.carlos
 */
public class GeraLog {

    private String diretorio;
    private String nomeArquivo;
    
    public GeraLog(String dir, String nomeArq){
        this.diretorio = dir;
        this.nomeArquivo = nomeArq;
    }
    
    public void gravar(String msg) throws IOException {
        String arq = diretorio + "/" + nomeArquivo;
        File arquivo = new File(arq);
        
        if (arquivo.exists() && arquivo.length() >= 1000000) {
            arquivo.delete();
            arquivo.createNewFile();
        } else if (!arquivo.exists()){
            arquivo.createNewFile();
        }       

        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
        
        List<String> lista = new ArrayList<>();
        lista.add("=============================================================================================");
        lista.add(df.format(hoje) + " - " + msg);

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }
    
    public void gravarLogTransacao(String msg) throws IOException{
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy-HH");
        File arquivo = new File(diretorio + nomeArquivo +"_"+df.format(new Date())+"hrs.log");        
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
        List<String> lista = new ArrayList<>();
        if (msg.contains("\n")) {
            msg = msg.substring(0, msg.indexOf("\n"));
        }
        lista.add(df.format(new Date()) + " - " + msg);

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
    }

}
