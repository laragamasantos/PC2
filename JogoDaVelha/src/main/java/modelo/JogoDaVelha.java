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
public class JogoDaVelha {

    private String[][] coordenadas;
  
    public JogoDaVelha() {
        this.coordenadas = new String[3][3];

    }

    public void limparTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                coordenadas[i][j] = "";
            }
        }
    }

    public Integer fazAJogada(int linha, int coluna, String peca) {
        //colocar a jogada
        this.coordenadas[linha][coluna] = peca;
        return vitoria();

    }

    public Integer vitoria() {
        if (("X".equals(this.coordenadas[0][0])
                && //linha 1
                "X".equals(this.coordenadas[0][1])
                && "X".equals(this.coordenadas[0][2]))
                
                
                || ("X".equals(this.coordenadas[1][0])
                && //linha 2
                "X".equals(this.coordenadas[1][1])
                && "X".equals(this.coordenadas[1][2]))
                
                
                || ("X".equals(this.coordenadas[2][0])
                && //linha 3
                "X".equals(this.coordenadas[2][1])
                && "X".equals(this.coordenadas[2][2]))
                
                
                || ("X".equals(this.coordenadas[0][0])
                && //coluna 1
                "X".equals(this.coordenadas[1][0])
                && "X".equals(this.coordenadas[2][0]))
                
                
                || ("X".equals(this.coordenadas[0][1])
                && //coluna 2
                "X".equals(this.coordenadas[1][1])
                && "X".equals(this.coordenadas[2][1]))
               
                
                || ("X".equals(this.coordenadas[0][2])
                && //coluna 3
                "X".equals(this.coordenadas[1][2])
                && "X".equals(this.coordenadas[2][2]))
                
                
                || ("X".equals(this.coordenadas[0][2])
                && //coluna 3
                "X".equals(this.coordenadas[1][2])
                && "X".equals(this.coordenadas[2][2]))
               
                
                || ("X".equals(this.coordenadas[0][0])
                && //diagonal 1
                "X".equals(this.coordenadas[1][1])
                && "X".equals(this.coordenadas[2][2]))
               
                
                || ("X".equals(this.coordenadas[0][2])
                && //diagonal 2
                "X".equals(this.coordenadas[1][1])
                && "X".equals(this.coordenadas[2][0]))) {

            return 2; //QUANDO X VENCER
            
            
        } else if (("O".equals(this.coordenadas[0][0])
                && //linha 1
                "O".equals(this.coordenadas[0][1])
                && "O".equals(this.coordenadas[0][2]))
                
                
                || ("O".equals(this.coordenadas[1][0])
                && //linha 2
                "O".equals(this.coordenadas[1][1])
                && "O".equals(this.coordenadas[1][2]))
                
                
                || ("O".equals(this.coordenadas[2][0])
                && //linha 3
                "O".equals(this.coordenadas[2][1])
                && "O".equals(this.coordenadas[2][2]))
                
                
                || ("O".equals(this.coordenadas[0][0])
                && //coluna 1
                "O".equals(this.coordenadas[1][0])
                && "O".equals(this.coordenadas[2][0]))
               
                
                || ("O".equals(this.coordenadas[0][1])
                && //coluna 2
                "O".equals(this.coordenadas[1][1])
                && "O".equals(this.coordenadas[2][1]))
                
                
                || ("O".equals(this.coordenadas[0][2])
                && //coluna 3
                "O".equals(this.coordenadas[1][2])
                && "O".equals(this.coordenadas[2][2]))
               
                
                || ("O".equals(this.coordenadas[0][2])
                && //coluna 3
                "O".equals(this.coordenadas[1][2])
                && "O".equals(this.coordenadas[2][2]))
               
                
                || ("O".equals(this.coordenadas[0][0])
                && //diagonal 1
                "O".equals(this.coordenadas[1][1])
                && "O".equals(this.coordenadas[2][2]))
                
                
                || ("O".equals(this.coordenadas[0][2])
                && //diagonal 2
                "O".equals(this.coordenadas[1][1])
                && "O".equals(this.coordenadas[2][0]))) {

            return 1; //QUANDO O VENCER
        }
        else 
            return 0; 
    }
    
    public boolean velha(String casa1, String casa2, String casa3, String casa4, String casa5, String casa6, String casa7, String casa8, String casa9){
        if(!casa1.equals("") && 
           !casa2.equals("") &&
           !casa3.equals("") &&
           !casa4.equals("") &&
           !casa5.equals("") &&
           !casa6.equals("") &&
           !casa7.equals("") &&
           !casa8.equals("") &&
           !casa9.equals("")){
            return true;
        }
        return false;
    }
    

}
