/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class AssalariadoComissionado extends Comissionado{
    private static final double PERCENTUALBONUS = 1.1;
    
    public AssalariadoComissionado(String nome, String sobrenome, int numIdent, double valorVendas){
        super(nome, sobrenome, numIdent, valorVendas);
    }

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {
        return (ControlePagamento.SALARIO*PERCENTUALBONUS) + (getValorVendas() *0.06);
    }
    
}
