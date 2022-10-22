
package principal_LaraGama_VictorMontMor;


public class Imovel {
    private Proprietario proprietario;
    private String endereco;
    private double valorDiaria;
    private String descricao;
    
    public Imovel(String nome, int telefone, String endereco, double valorDiaria, String descricao) {
        this.proprietario = new Proprietario(nome, telefone);
        this.endereco = endereco;
        this.valorDiaria = valorDiaria;
        this.descricao = descricao;
    }
    
    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
