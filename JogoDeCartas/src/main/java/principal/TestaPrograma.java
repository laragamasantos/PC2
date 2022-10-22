/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import java.util.Scanner;
/**
 *
 * @author larag
 */
public class TestaPrograma {
    public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
        
       /* Pessoa luciana = new Pessoa("Luciana");
        System.out.println("informe nome da mae");
        luciana.getMae().setNome(input.nextLine());*/
        
        Pessoa[] arvoreGenealogica = new Pessoa[10];
        for (int i = 0; i < 10; i++){
            System.out.println("Insira o nome da pessoa ");
            arvoreGenealogica[i] = new Pessoa(input.nextLine());
            System.out.println("Insira o nome do pai ");
            arvoreGenealogica[i].getPai().setNome(input.nextLine());
            System.out.println("Insira o nome da mae ");
            arvoreGenealogica[i].getMae().setNome(input.nextLine());
        }
        
       
        //verifica se sao a mesma pessoa:
        if(arvoreGenealogica[1].igualdadeSemantica(arvoreGenealogica[2])){
            System.out.println("Sao a mesma pessoa");
        } else{
            System.out.println("Nao sao a mesma pessoa");
        }
        
        //verifica se sao irmas
        if(arvoreGenealogica[3].irmas(arvoreGenealogica[4])){
            System.out.println("Sao irmas");
        } else{
            System.out.println("Nao sao irmas");
        }
        
        //verifica se uma pessoa é pai ou mãe, ou antecessor do pai ou da mãe
        if(arvoreGenealogica[5].antecessor(arvoreGenealogica[6])){
            System.out.println("E antecessor");
        } else{
            System.out.println("Nao e antecessor");
        }
        
        //ler.nextLine(); //esvazia o buffer do teclado
    }
}
