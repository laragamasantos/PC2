/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class Concessionaria extends Conta{
    
    public Concessionaria(int dia, int mes, int ano, double valor){
        super(dia, mes, ano, valor);
    }
    
    @Override
    public double  getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {
        return valor;
    }
}
