/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class Comissionado extends Empregado{
    private double valorVendas;

    public Comissionado(String nome, String sobrenome, int numIdent, double valorVendas){
        super(nome, sobrenome, numIdent);
        this.valorVendas = valorVendas;
    }
    
     @Override
    public double getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {
       
        return valorVendas * 0.06;
        
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }
    
    
}
