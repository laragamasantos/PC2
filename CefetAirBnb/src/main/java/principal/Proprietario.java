
package principal_LaraGama_VictorMontMor;

public class Proprietario {
    private String nome;
    private double contaBancaria;
    private int telefone;

    //metodo deposita (na conta do proprietario)
    public void depositaProprietario(double valor){
        this.contaBancaria += (valor*0.7);
    }
    
    //metodo construtor
    public Proprietario(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.contaBancaria = 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(double contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    
}


