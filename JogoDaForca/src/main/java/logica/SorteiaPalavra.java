/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 *
 * @author larag
 */
public class SorteiaPalavra {

    private String resposta;
    private Path caminho;

    public SorteiaPalavra() {
        caminho = Paths.get("C:/Users/larag/OneDrive/Documentos/NetBeansProjects/JogoDaForca/palavras.txt");
    }

    public void importaPalavra()  {
        try {
            List<String> linhasArquivo = Files.readAllLines(caminho);

            SecureRandom random = new SecureRandom();
            int randomInt = random.nextInt(94);

            this.resposta = linhasArquivo.get(randomInt);
            
        } catch (Exception erro) {
            System.out.println("Qual o endereço do arquivo com as palavras?");
            Scanner scan = new Scanner(System.in);
            String endereco = scan.nextLine();
            caminho = Paths.get(endereco);
            importaPalavra();
        }
    }

    //coloca cada uma das letras de resposta em uma posição do array LETRAS
    public String[] separaLetrasDaResposta() {
        String[] letras = new String[7];
        for(int i=0; i<7; i++){
           letras[i] = this.resposta.substring(i, i+1);
        }
        return letras;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

}
