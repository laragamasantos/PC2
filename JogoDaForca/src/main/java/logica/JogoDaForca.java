/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author larag
 */
public class JogoDaForca {

    private Integer tentativas;
    private String[] respostaLetras;
    private int[] posicoes;
    private String letraEscolhida;
    private SorteiaPalavra palavraSorteada;
    private boolean fimDeJogo = false;

    public JogoDaForca() throws IOException {
        this.tentativas = 10;
        novoJogo();
    }

    public void novoJogo() throws IOException {
        palavraSorteada = new SorteiaPalavra();
        palavraSorteada.importaPalavra();
        this.respostaLetras = palavraSorteada.separaLetrasDaResposta();
        this.tentativas = 10;

    }

    public void jogar(String letra) { //será chamado no toggle button
        tentativas();
        if (!this.fimDeJogo) {
            this.letraEscolhida = letra;
        } 
    }

    public String conteudoTextField(int posicao, String conteudo) { //será chamado no toggle button
        if (conteudo.equals("") && this.respostaLetras[posicao].equals(this.letraEscolhida)) {
            return this.letraEscolhida;
        }
        return conteudo;
    }

    public boolean acertaPalavra(String palavra) {
        tentativas();
        if (!this.fimDeJogo) {
            if (palavra.equals(palavraSorteada.getResposta())) {
                return true;
            }
        }
        return false;
    }

    public void tentativas() {
        if (this.tentativas > 0) {
            this.tentativas--;
            this.fimDeJogo = false;
        } else {
            this.fimDeJogo = true;
        }
    }

    public boolean vitoria(String textField1, String textField2, String textField3, String textField4, String textField5, String textField6, String textField7) {
        return this.tentativas >= 0
                && this.respostaLetras[0].equals(textField1)
                && this.respostaLetras[1].equals(textField2)
                && this.respostaLetras[2].equals(textField3)
                && this.respostaLetras[3].equals(textField4)
                && this.respostaLetras[4].equals(textField5)
                && this.respostaLetras[5].equals(textField6)
                && this.respostaLetras[6].equals(textField7);
    }
    
    public String imprimeResposta(){
        return palavraSorteada.getResposta();
    }
    
    public boolean isFimDeJogo() {
        return fimDeJogo;
    }  

    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas(Integer tentativas) {
        this.tentativas = tentativas;
    }

}


