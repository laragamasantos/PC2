/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

public class Titulo extends Conta{

    //dia, mes e ano de vencimento da conta
    public Titulo(int dia, int mes, int ano, double valor){
        super(dia, mes, ano, valor);
    }
    
    @Override
    //data em que a conta foi paga
    public double getValorAPagar(int diaPagto, int mesPagto, int anoPagto) {
        if(anoPagto == ano){
            if(mesPagto > mes){
               return valor*1.1;
            }
            else if((mesPagto == mes) && (diaPagto>dia)){
               return valor*1.1;
            }
            else{
                return valor;
            }
        }
        
        else if(anoPagto > ano){
            return valor*1.1;
        }
        else{
          return valor;  
        }
        
    }
}
