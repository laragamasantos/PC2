
package testerelogio;

public class Relogio {
 private Contador hora;
    private Contador minuto;
    
    public Relogio(){ //método construtor
        this.hora = new Contador(0,0);
        this.minuto = new Contador(0,0);
    }
    
    public Relogio(Contador hora, Contador minuto){ //método construtor
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public Contador getHora() {
        return hora;
    }

    public void setHora(Contador hora) {
        this.hora = hora;
    }

    public Contador getMinuto() {
        return minuto;
    }

    public void setMinuto(Contador minuto) {
        this.minuto = minuto;
    }
    
    public void ticTac(){
        minuto.incrementar();
        if(minuto.getValor() == 0){
            hora.incrementar();
        }
    }
}

