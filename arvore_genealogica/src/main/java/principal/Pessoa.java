
package principal;

public class Pessoa {
   private String nome;
   private Pessoa pai;
   private Pessoa mae;
    
   public Pessoa(String nome){ //inicializa pessoa
        this.nome = nome;
        this.mae = new Pessoa("");
        this.pai  = new Pessoa("");
    }
   
    public Pessoa(String nome, Pessoa pai, Pessoa mae){ //inicializa pessoa e antecessores
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }
    
      public String getNome(){
        return nome; 
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Pessoa getPai(){
        return pai;
    }
    
    public void setPai(Pessoa pai){
        this.pai = pai;
    }
    
    public Pessoa getMae(){
        return mae;
    } 
    
    public void setMae (Pessoa mae){
        this.mae = mae;
    }
    
    public boolean igualdadeSemantica(Pessoa pessoa){ //verifica se sao a mesma pessoa
        if(this.mae != null){
            if(this.nome.equals(pessoa.getNome()) && this.mae.getNome().equals(pessoa.getMae().getNome())){
                return true;
            }
         }
        return false;
    }
    
    public boolean irmas(Pessoa pessoa){ //verifica se sao irmas
        if(this.mae!=null && this.pai!=null){
            if(this.pai.getNome().equals(pessoa.getPai().getNome()) && this.mae.getNome().equals(pessoa.getMae().getNome())){
                return true;
            }    
        }
        return false;
    }
    
    //quero saber se a pessoa dos parametros é a antecessora
    public boolean antecessor(Pessoa pessoa){ //verifica se uma pessoa é pai ou mãe, ou antecessor do pai ou da mãe
        if(this.mae.getNome().equals(pessoa.getNome()) 
           || this.pai.getNome().equals(pessoa.getNome())){
            return true;
        }
        //if(pessoa.getMae()!=null && pessoa.getPai()!=null){
            if(this.mae.getMae().getNome().equals(pessoa.getNome()) 
                || this.pai.getPai().getNome().equals(pessoa.getNome())){
                return true;
            }
        //}
        return false;
    }
}

