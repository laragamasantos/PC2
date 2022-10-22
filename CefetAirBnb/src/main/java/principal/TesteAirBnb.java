package principal_LaraGama_VictorMontMor;

import java.util.Scanner;

public class TesteAirBnb {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo ao Cefet-AirBnb!");

        int loop = 1;
        int i = 0; //receberá indice de hospedes
        int j = 0; //receberá indice de imoveis

        Hospede[] listaHospedes = new Hospede[12]; //3 hospedagens para cada imóvel, de clientes diversos (pode ser 2 ou mais)
        Imovel[] listaImoveis = new Imovel[2]; //É NECESSÁRIO INCLUIR DOIS IMÓVEIS
        AdmCefet administrador = new AdmCefet();

        while (loop == 1) {

            System.out.println("\nVocê procura por uma estadia (digite 1) ou deseja anunciar o seu imóvel (digite 2)?");
            System.out.println("*Digite 3 para imprimir a conta bancária do administrador e do proprietário (para critérios de correção)");
            System.out.println("Digite outro valor para encerrar o programa");
            int menu = input.nextInt();

            if (menu == 1) { //MENU HOSPEDE
                System.out.println("\nOs imóveis disponíveis são:");

                for (int aux = 0; aux < j; aux++) {
                    System.out.println("\nÍndice do imóvel: " + aux);
                    System.out.println("Descrição: " + listaImoveis[aux].getDescricao());
                    System.out.println("Endereço: " + listaImoveis[aux].getEndereco());
                    System.out.println("Valor da diária: " + listaImoveis[aux].getValorDiaria());
                    System.out.println("Nome do proprietário: " + listaImoveis[aux].getProprietario().getNome() + "\n");
                }

                System.out.println("\nDigite o seu nome: (Utilizar underline ao invés de espaços)");
                String nome = input.next();

                System.out.println("\nDigite o número de dias que deseja permanecer na instalação:");
                int dias = input.nextInt();

                System.out.println("\nDigite o índice do imóvel que deseja alugar:");
                int indice = input.nextInt();
                
                listaHospedes[i] = new Hospede(nome, dias, indice);

                //CALCULA VALOR TOTAL DA ESTADIA DO HOSPEDE:
                listaHospedes[i].valorEstadia(dias, listaImoveis[indice].getValorDiaria());
                
                //SOMA 70% DO VALOR TOTAL NA CONTA BANCARIA DO PROPRIETARIO DO IMOVEL ESCOLHIDO
                listaImoveis[indice].getProprietario().depositaProprietario(listaHospedes[i].getValorTotal());
                
                //SOMA 30% DO VALOR TOTAL NA CONTA BANCÁRIA DO ADMNISTRADOR:
                administrador.depositaAdm(listaHospedes[i].getValorTotal());
                
                System.out.println("\nSua reserva foi concluída!");
                System.out.println("O valor total da sua estadia será de: " + listaHospedes[i].getValorTotal() + "\n");
                                
                i++;
                
            } else if (menu == 2) { //MENU PROPRIETARIO

                System.out.println("\nDigite o nome do proprietario: (Utilizar underline ao invés de espaços)");
                String nomeProprietario = input.next();

                System.out.println("\nDigite o telefone do proprietario (sem caracteres especiais):");
                int telefone = input.nextInt();

                System.out.println("\nDigite o endereço do imóvel: (Utilizar underline ao invés de espaços)");
                String endereco = input.next();

                System.out.println("\nDigite o valor da diária (variável do tipo double)");
                double diaria = input.nextDouble();

                System.out.println("\nDigite a descrição do imóvel: (Utilizar underline ao invés de espaços)");
                String descricao = input.next();

                listaImoveis[j] = new Imovel(nomeProprietario, telefone, endereco, diaria, descricao);

                j++;
            } else if(menu == 3){
                System.out.println("\nO menu abaixo foi criado para facilitar a correção:");
                
                System.out.println("\nO valor total da conta bancária de TODOS os proprietários é:");
                for(int tmp=0; tmp<listaImoveis.length; tmp++){
                    System.out.println(tmp + ": " + listaImoveis[tmp].getProprietario().getNome() + " - " + 
                            listaImoveis[tmp].getProprietario().getContaBancaria() + " reais");
                }
                System.out.println("\nO valor da conta bancária do administrador é: " + administrador.getContaBancaria() + " reais\n");
                
            } 
            
            else {
                loop = 0;
            }
        }
    }
}
