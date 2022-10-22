/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author larag
 */
public class DecifragemInvalidaException extends Exception{
    
    public DecifragemInvalidaException(){
        super("Erro ao tentar decifrar a mensagem.");
    }
    
}
