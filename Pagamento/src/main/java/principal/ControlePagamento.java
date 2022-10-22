/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;

public class ControlePagamento {
    //geralmente atributo final e de acesso publico
    public static final double SALARIO = 1192.40;
    public static final double HORA = 20.00;
    
    private ArrayList<Pagavel> pagamentos;
    
    public ControlePagamento(){
        this.pagamentos = new ArrayList();
    }
    
    public void inserirPagamento(Pagavel elemento){
        pagamentos.add(elemento);
    }
    
    public double listarPagamentos(){
        double total = 0.0;
        for(Pagavel item: pagamentos){ //cada pagamento e chamado de item

            if(item instanceof Terceirizado){
                total += item.getValorAPagar(23, 6, 2022);
            }
            else if(item instanceof Comissionado){
                total += item.getValorAPagar(14, 7, 2021);
            }
            else if(item instanceof Assalariado){
                total += item.getValorAPagar(2, 12, 2021);
            }
            else if(item instanceof AssalariadoComissionado){
                total += item.getValorAPagar(8, 1, 2022);
            }
            else if(item instanceof Titulo){
                total += item.getValorAPagar(3, 12, 2021);
            }
            else if(item instanceof Concessionaria){
                total += item.getValorAPagar(8, 11, 2022);
            }
                
        }
        return total;
    }

    public ArrayList<Pagavel> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagavel> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    
}
