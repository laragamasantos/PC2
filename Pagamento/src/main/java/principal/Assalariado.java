/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class Assalariado extends Empregado{
    private double horasExtras;
    
    //método construtor
    public Assalariado(String nome, String sobrenome, int numIdent, double horasExtras){
        super(nome, sobrenome, numIdent);
        this.horasExtras = horasExtras;
    }
    

    @Override
    public double getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {   
        if(horasExtras == 0){
            return ControlePagamento.SALARIO; 
        } else if(horasExtras > 0){
            return ControlePagamento.SALARIO + (ControlePagamento.HORA * horasExtras);
        }
         
      return 0;  
    }
    
}
