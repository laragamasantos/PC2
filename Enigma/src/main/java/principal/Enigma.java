/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author larag
 */
import java.util.Scanner;

public class Enigma {

    public static void main(String[] args) {
        boolean loop = true;

        System.out.println("Bem vindo ao cifrador de César!");

        while (loop) {
            System.out.println("\nVoce deseja 1)cifrar uma mensagem ou 2)decifrar uma mensagem?");
            System.out.println("\nPressione outra tecla para sair do programa");

            Scanner scan = new Scanner(System.in);

            int menu = scan.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("\nQual mensagem voce deseja cifrar?");
                    scan.nextLine(); //esvazia o buffer do teclado
                    String msgCifrar = scan.nextLine();

                    System.out.println("\nQual a chave da cifra?");
                    int deslocamento = scan.nextInt();

                    CifraDeCesar cifra1 = new CifraDeCesar();

                    System.out.println("\nA mensagem cifrada é:" + cifra1.cifrar(msgCifrar, deslocamento));
                    break;
                           
                case 2:
                    System.out.println("\nQual mensagem voce deseja decifrar?");

                    CifraDeCesar decifra1 = new CifraDeCesar();

                    //String[] mensagensOcultas = {"luciana", "bola de neve", "pao de queijo", "belo horizonte", "Chocolate"};
                    //mensagens e suas respectivas chaves possuem o mesmo indice
                    String[] mensagensOcultas = {"PYGMERE", "JWTI LM VMDM", "QBP EF RVFJKP", "VYFI BILCTIHNY", "PUBPBYNGR"};
                    int[] chaves = {4, 8, 1, 20, 13};

                    System.out.println("\nEscolha um desafio de número de 0 a 4 para solucionar:");
                    int desafio = scan.nextInt();

                    //chamaremos o metodo decifrar para obter a resposta correta
                  

                    System.out.println("\nA mensagem a ser decifrada e: " + mensagensOcultas[desafio]);
                    System.out.println("A chave para decifra-la e: " + chaves[desafio]);

                    System.out.println("\nInsira a sua solucao:");
                    scan.nextLine();
                    String solucao = scan.nextLine();

                    boolean tmp = true;
                    while(tmp)
                    try {
                        decifra1.verificarDesafio(solucao, mensagensOcultas[desafio], chaves[desafio]); //chamada do metodo
                        if(decifra1.verificarDesafio(solucao, mensagensOcultas[desafio], chaves[desafio])){
                            tmp = false;
                            System.out.println("Resposta correta!");
                        }
                    } catch (DecifragemInvalidaException ex) { //tratamento da exceção
                        //aqui devemos permitir uma nova tentativa e imprimir mensagem
                        System.out.println("\nResposta errada! Insira uma nova solucao:");
                        scan.nextLine();
                        solucao = scan.nextLine();
                    }
                    break;
                    
                default:
                    loop = false;
            }
        }
    }
}
