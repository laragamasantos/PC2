//GRUPO: Lara Gama Santos, Victor Samuel Levindo Mont'Mor
package principal;

public class Teste {

    public static void main(String[] args) {
        //criamos valores pré definidos para facilitar o teste das classes
        
        //criando os objetos:
        Terceirizado terceirizado = new Terceirizado("lara", "gama", 34567, 2);
        Comissionado comissionado = new Comissionado("victor", "samuel", 4567, 12.0);
        Assalariado assalariado = new Assalariado("joao", "paulo", 2222, 2);
        AssalariadoComissionado assalariadoComissionado = new AssalariadoComissionado("joao", "pedro", 1111, 4.0);
        Titulo titulo = new Titulo(2, 12, 2021, 5000);
        Concessionaria concessionaria = new Concessionaria(5, 10, 2021, 1000.00);
        ControlePagamento controle = new ControlePagamento();

        //inserindo os objetos no arraylist pagamentos:
        controle.inserirPagamento(terceirizado);
        controle.inserirPagamento(comissionado);
        controle.inserirPagamento(assalariado);
        controle.inserirPagamento(assalariadoComissionado);
        controle.inserirPagamento(titulo);
        controle.inserirPagamento(concessionaria);
        
        System.out.println("Salario do terceirizado:");
        System.out.println(terceirizado.getValorAPagar(23, 6, 2022));
        
        System.out.println("\nSalario do comissionado:");
        System.out.println(comissionado.getValorAPagar(14, 7, 2021));
        
        System.out.println("\nSalario do assalariado:");
        System.out.println(assalariado.getValorAPagar(2, 12, 2021));
        
        System.out.println("\nSalario do assalariadoComissionado:");
        System.out.println(assalariadoComissionado.getValorAPagar(8, 1, 2022));
        
        System.out.println("\nValor do titulo:");
        System.out.println(titulo.getValorAPagar(3, 12, 2021));
        
        System.out.println("\nValor da concessionaria:");
        System.out.println(concessionaria.getValorAPagar(8, 11, 2022));
        
        System.out.println("\nTotal de valores a serem pagos pela empresa:");
        System.out.println(controle.listarPagamentos());
    }

}
