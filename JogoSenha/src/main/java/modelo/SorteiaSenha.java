/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author larag
 */
public class SorteiaSenha {
    private final String caracteres[] = {"*", "#", "@", "%", "&"};
    private ArrayList<String> resposta;

    public SorteiaSenha() {
        sorteiaSequencia();
    }
    
    public int caractereAleatorio(){
        Random random = new Random();
        return random.nextInt(5);
    }
    
    public void sorteiaSequencia(){
        this.resposta = new ArrayList(); 
        for(int i=0; i<7; i++){
            this.resposta.add(caracteres[caractereAleatorio()]);
        }
    }

    public ArrayList<String> getResposta() {
        return resposta;
    }

    public void setResposta(ArrayList<String> resposta) {
        this.resposta = resposta;
    }
    
    
}

