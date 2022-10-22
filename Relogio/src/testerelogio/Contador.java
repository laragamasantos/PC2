
package testerelogio;


public class Contador {
    private int limite;
    private int valor;
    
    public Contador(int valor, int limite){ //método construtor
        this.valor = valor;
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
 
    public void incrementar(){
        if(this.valor == limite){
            this.valor = 0; 
            this.valor--;
        }
        this.valor++;
    }
    
}

