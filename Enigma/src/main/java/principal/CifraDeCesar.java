/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//a exceção é tratada quando o metodo verificarDesafio for chamado (quando o metodo for chamado deve estar dentro de um bloco try catch)
package principal;

/**
 *
 * @author larag
 */
public class CifraDeCesar {
    private Chave chave;

    public CifraDeCesar() {
        this.chave = new Chave();
    }
    
    public String decifrar(String mensagem, int deslocamento){
        String mensagemDecifrada = "";
                
        for(int i=0; i<mensagem.length(); i++){
            boolean naoELetra = true;
            
            for(int j=0; j<26; j++){
                if(chave.getLetra(j).equalsIgnoreCase(mensagem.substring(i, i+1))){
                    naoELetra = false;
                    
                    if(deslocamento <= j){
                        mensagemDecifrada = mensagemDecifrada.concat(chave.getLetra((j-deslocamento) % 26));
                    }
                    else{
                        mensagemDecifrada = mensagemDecifrada.concat(chave.getLetra(26 - deslocamento + j));
                    }
                }
            }
            
            if(naoELetra){
                mensagemDecifrada = mensagemDecifrada.concat(mensagem.substring(i, i+1));
            }
 
        }
        
        return mensagemDecifrada;
    }
    
    public String cifrar(String mensagem, int deslocamento){
        String mensagemCifrada = "";
              
        for(int i=0; i<mensagem.length(); i++){
            boolean naoELetra = true;
            
            for(int j=0; j<26; j++){
                if(chave.getLetra(j).equalsIgnoreCase(mensagem.substring(i, i+1))){
                    naoELetra = false;
                    mensagemCifrada = mensagemCifrada.concat(chave.getLetra((j+deslocamento) % 26));
                }
            }
            
            if(naoELetra){
                mensagemCifrada = mensagemCifrada.concat(mensagem.substring(i, i+1));
            }
 
        }
        
        return mensagemCifrada;
    }
    
     //retorna true quando o usuario acerta a mensagem
    public boolean verificarDesafio(String tentativa, String mensagem, int deslocamento) throws DecifragemInvalidaException{
        if(!tentativa.equals(decifrar(mensagem, deslocamento))){ //se a tentativa for diferente da mensagem decifrada, devemos lançar uma exceção
            throw new DecifragemInvalidaException();
        }
        
        return true;
    }
}
