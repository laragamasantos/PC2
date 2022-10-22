
package principal_LaraGama_VictorMontMor;


public class AdmCefet {
    private double contaBancaria;
    
    //metodo deposita (na conta do administrador)
    public void depositaAdm(double valor){
        this.contaBancaria += (valor*0.3);
    }
    
    //metodo construtor
     public AdmCefet() {
         contaBancaria = 0;
     }
    
    public double getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(double contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
    
    
}
