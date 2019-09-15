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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;

/**
 *
 * @author luiz.carlos
 */
public class GeraLog {

    private String diretorio = "C:/trabalho_5";

    public GeraLog() {
    }

    public void gravar(String nomeArquivo, String msg) throws IOException {
        String arq = diretorio + "/" + nomeArquivo;

        File arquivo = new File(arq);

        if (!arquivo.exists()) {
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

}
