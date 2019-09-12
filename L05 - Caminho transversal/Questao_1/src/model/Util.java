/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.swing.JOptionPane;

/**
 *
 * @author lcburigo
 */
public class Util {

    private String destino;
    private String arquivo;

    public boolean verificaServico(String arq, char tipo) {

        if (tipo == 'D') {
            arquivo = "C:/Users/luiz.carlos/Desktop/STR/Lista05/pc_servidor/" + arq;
            destino = "C:/Users/luiz.carlos/Desktop/STR/Lista05/pc_usuario/testeDowload.txt";
        } else {
            if (tipo == 'U') {
                arquivo = arq;
                destino = "C:/Users/luiz.carlos/Desktop/STR/Lista05/pc_servidor/texteUpload.txt";
            }
        }
        return true;
    }

    public boolean servico(String arq, char tipo) throws IOException {
        /*/../privado/privado.txt*/

        // copia os dados
        InputStream in;
        // escreve os dados
        OutputStream out;
        try {
            // arquivos que vamos copiar
            File toFile = new File(arquivo);
            // destino para onde vamos mover o arquivo
            File fromFile = new File(destino);
            //verifica se o arquivo existe
            if (!fromFile.exists()) {
                //verifica se a pasta existe
                if (!fromFile.getParentFile().exists()) {
                    //cria a pasta
                    fromFile.getParentFile().mkdir();
                }
                // cria o arquivo
                fromFile.createNewFile();
            }
            in = new FileInputStream(toFile);
            out = new FileOutputStream(fromFile);
            // buffer para transportar os dados
            byte[] buffer = new byte[1024];
            int length;
            // enquanto tiver dados para ler..
            while ((length = in.read(buffer)) > 0) {
                // escreve no novo arquivo
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo invalido");
        }
        return true;
    }

}
