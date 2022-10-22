/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author larag
 */
public class ComparaSenha {

    private SorteiaSenha senhaSorteada;
    private int tentativas;
    private boolean venceu;

    public ComparaSenha() {
        this.senhaSorteada = new SorteiaSenha();
    }

    public ArrayList tentar(ArrayList tentativa) {
        //compara posição por posição da tentativa e da senha definida aleatoriamente em novoJogo()

        tentativas--;
        ArrayList<Integer> colors = new ArrayList();

        for (int tmp = 0; tmp < 7; tmp++) {

            //se a o caracter na posição x for igual a resposta na posição x:
            if (senhaSorteada.getResposta().get(tmp).equals(tentativa.get(tmp))) {

                colors.add(2); //pintar jPanel de AMARELO

            } else {
                boolean temCaracter = false;

                for (int i = 0; i < 7; i++) {
                    //se o caracter existir, porém, não nessa posição:
                    if (senhaSorteada.getResposta().get(i).equals(tentativa.get(tmp))) {
                        //pintar jPanel na tentativa 'tmp' da posição de AZUL
                        temCaracter = true;
                        break;

                        //se o caracter não existir em nenhum lugar da resposta
                    }
                }
                if (temCaracter) {
                    colors.add(1); //pintar jPanel de AZUL
                } else {
                    //se o caracter não existir em nenhum lugar da resposta

                    colors.add(0);//pintar jPanel de BRANCO
                }
            }

        }
        //Confere se todos os 7 quadrados estão em amarelo (condição de vitória:
        int j = 0;
        for (Integer elemento : colors) {
            if (elemento == 2) {
                j++;
            }
        }
        if (j == 7) {
            venceu = true;
        }

        //Retorna o arraylist com as cores que deverão ser impressas:
        return colors;
    }

    public String tentativas() {
        if (tentativas > 0 && !venceu) {
            return ("Você tem " + tentativas + " tentativas restantes.");
        } else if (!venceu) {
            return ("Você perdeu! A sequência correta era: " + senhaSorteada.getResposta());
        }
        return "Parabéns! Você venceu!";
    }

    public void novoJogo() {
        senhaSorteada.sorteiaSequencia();
        tentativas = 4;
        venceu = false;
    }

    public int getTentativas() {
        return tentativas;
    }

    public boolean isVenceu() {
        return venceu;
    }

}
