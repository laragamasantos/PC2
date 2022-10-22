/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class Terceirizado extends Empregado{
    private double horasTrabalhadas;
    
    public Terceirizado(String nome, String sobrenome, int numIdent, double horasTrabalhadas){
        super(nome, sobrenome, numIdent);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {
    
    return horasTrabalhadas*ControlePagamento.HORA;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
}
