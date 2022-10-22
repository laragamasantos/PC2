/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author larag
 */
public class operacao {
    private String A;
    private String B;
    private char operador;
    
    public void verificaPossuiSete(String A, String B){
       for(int i=0; i<A.length(); i++){
           if(A.substring(i, i+1).equals("7")){
               String.valueOf('0');
               A.substring(i, i+1) = 0;
           }
       }
       
       for(int i=0; i<B.length(); i++){
           if(B.substring(i, i+1).equals("7")){
               B.substring(i, i+1) = '0';
           }
       }
       
    }
    
    public void converteInteiro(){
        
    }
}
