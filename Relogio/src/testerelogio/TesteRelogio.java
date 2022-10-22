
package testerelogio;

import java.util.Scanner;

public class TesteRelogio {

    public static void main(String[] args) {
        Relogio nomeRelogio = new Relogio();
                
        System.out.println("Selecione o formato de horas desejado:");
        System.out.println("Pressione 1) para o formato 24h ou 2) para o formato 12h");
        
        Scanner input = new Scanner(System.in);
        int menu = input.nextInt();
       
        if(menu == 1){
            nomeRelogio.getHora().setValor(0);
            nomeRelogio.getHora().setLimite(23); 
            nomeRelogio.getMinuto().setValor(0);
            nomeRelogio.getMinuto().setLimite(59);
            for(int i=0; i<24; i++){
               for(int j=0; j<60; j++){
                    System.out.printf("%02d:%02d\n", nomeRelogio.getHora().getValor(), nomeRelogio.getMinuto().getValor());//Hora e minuto sao contadores
                    nomeRelogio.ticTac();
                }
             }
        }
        
        if(menu == 2){
            nomeRelogio.getHora().setValor(0); 
            nomeRelogio.getHora().setLimite(11); 
            nomeRelogio.getMinuto().setValor(0);
            nomeRelogio.getMinuto().setLimite(59);
            for(int w=0; w<2; w++){
                String turno = " a.m.";
                if(w==1){
                    turno = " p.m.";
                }
                for(int i=0; i<12; i++){
                    for(int j=0; j<60; j++){
                        System.out.printf("%02d:%02d %s\n", nomeRelogio.getHora().getValor(), nomeRelogio.getMinuto().getValor(), turno); //Hora e minuto sao contadores
                        
                        nomeRelogio.ticTac();
                    }
                }
            }
        }
        
        if(menu!=1 && menu!=2){
            System.out.println("Entrada inválida");
        }
    }
}
