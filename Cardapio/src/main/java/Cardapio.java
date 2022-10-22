/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author larag
 */
public class Cardapio {
    private Refeicao[][] cardapio;

    public Cardapio() {
        this.cardapio = new Refeicao[6][7];
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                cardapio[i][j] = new Refeicao(null, 0);
            }
        }
    }

    public Refeicao[][] getCardapio() {
        return cardapio;
    }

    public void setCardapio(Refeicao[][] cardapio) {
        this.cardapio = cardapio;
    }
    
    public void setRefeicao(int linha,int coluna, String descricao, double calorias){
        this.cardapio[linha][coluna] = new Refeicao(descricao, calorias);
    }
    
    int totalCalorias = 0;
    public double calcularCaloriasSemanal(){ //1)
        for(int i=0; i<cardapio.length; i++){
            for(int j=0; j<cardapio.length; j++){
                totalCalorias += cardapio[i][j].getCalorias();
            }
        }
    return totalCalorias;
    }
    
    public void incluirRefeicao(int linha, int coluna, Refeicao refeicao){ //2)
        this.cardapio[linha][coluna] = refeicao;
    }
    
    public void excluirRefeicao(int linha, int coluna){ //3)
        this.cardapio[linha][coluna].setDescricao(" ");
        this.cardapio[linha][coluna].setCalorias(0);
    }
    
    public void substituirRefeicao(int linha, int coluna, Refeicao refeicao){ //4)
        incluirRefeicao(linha, coluna, refeicao);
    }
    
    public void listarCardapio(){ //5)
        for(int i=0; i<cardapio.length; i++){
            for(int j=0; j<cardapio.length; j++){
                System.out.println(cardapio[i][j].getDescricao() + " - " + cardapio[i][j].getCalorias());
            }
        }
    }
    
    public void listarRefeicoesDia(int coluna){ //6)
        for(int i=0; i<6; i++){
            System.out.println(cardapio[i][coluna].getDescricao() + " - " + cardapio[i][coluna].getCalorias());
        }
    
    }

}
