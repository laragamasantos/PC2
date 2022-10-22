/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author larag
 */
import java.util.Scanner; 

public class TesteCardapio {
    public static void main(String[] args) {
        Cardapio nomeCardapio = new Cardapio();
        
        int aux = 1;
        while(aux == 1){
        System.out.println("\nObservacao: a coordenada linha vai de 0 a 5 e a coluna vai de 0 a 6");
        System.out.println("Pressione: \n1) para calcular o total de calorias semanal,");
        System.out.println("2) para incluir uma refeicao,");
        System.out.println("3) para excluir uma refeicao,");
        System.out.println("4) para substituir uma refeicao ja existente,");
        System.out.println("5) para listar todo o cardapio,");
        System.out.println("6) para listar as refeicoes de um dia especifico,");
        System.out.println("7) para encerrar o programa\n");
        
        Scanner input = new Scanner(System.in);
        int botao = input.nextInt();
        
        if(botao == 1){
            System.out.println(nomeCardapio.calcularCaloriasSemanal());
        }
        
        if(botao == 2){
            System.out.println("Insira a coordenda linha:");
            int linha = input.nextInt();
            System.out.println("Insira a coordenda coluna:");
            int coluna = input.nextInt();
            
            System.out.println("Insira a descricao da refeicao:");
            String descricao = input.next();
                      
            System.out.println("Insira a quantidade de calorias:");
            double calorias = input.nextDouble();
            
            nomeCardapio.setRefeicao(linha, coluna, descricao, calorias);
        
        }
        
        if(botao == 3){
            System.out.println("Insira a coordenda linha:");
            int linha = input.nextInt();
            System.out.println("Insira a coordenda coluna:");
            int coluna = input.nextInt();
            
            nomeCardapio.excluirRefeicao(linha, coluna);
        }
        
        if(botao == 4){
            System.out.println("Insira a coordenda linha:");
            int linha = input.nextInt();
            
            System.out.println("Insira a coordenda coluna:");
            int coluna = input.nextInt();
            
            System.out.println("Insira a descricao da refeicao:");
            String descricao = input.next();
                      
            System.out.println("Insira a quantidade de calorias:");
            double calorias = input.nextDouble();
            nomeCardapio.substituirRefeicao(linha, coluna, new Refeicao(descricao, calorias));
        }
        
        if(botao == 5){
            nomeCardapio.listarCardapio();
        }
        
        if(botao == 6){
            System.out.println("Insira a coordenda coluna (dia da semana):");
            int coluna = input.nextInt();
            
            nomeCardapio.listarRefeicoesDia(coluna);
        }
        
        if(botao == 7){
            aux = 0;
        }
    }
        
    }
}
