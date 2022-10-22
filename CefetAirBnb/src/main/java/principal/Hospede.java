
package principal_LaraGama_VictorMontMor;

public class Hospede {
    private String nome;
    private int dias;
    private int indiceImovel; //indica qual imovel o usuario escolheu
    private double valorTotal;

    //metodo para calcular o valor total que será cobrado do hospede
    public void valorEstadia(int dias, double diaria){
        this.valorTotal = dias*diaria;
    }
    
    //metodo construtor
    public Hospede(String nome, int dias, int indiceImovel) {
        this.nome = nome;
        this.dias = dias;
        this.indiceImovel = indiceImovel;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getIndiceImovel() {
        return indiceImovel;
    }

    public void setIndiceImovel(int indiceImovel) {
        this.indiceImovel = indiceImovel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
