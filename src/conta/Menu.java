package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) throws Exception {
        
        Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		ContaCorrente cc1 = new ContaCorrente(1, 124, 1, "João da Silva", 1000f, 100.0f);
		cc1.visualizar();		

		ContaPoupanca cp1 = new ContaPoupanca(2, 125, 2, "Juliana Ramos", 8000f, 15);
		cp1.visualizar();

		while(true) {

			System.out.println(Cores.TEXT_GREEN      + "*********************************************************************" 
													 + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND 
													 + "                                                                     ");
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND
													 + "                       BANCO DO BRAZIL COM Z                         ");
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND 
													 + "                                                                     ");
			System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN
													 + "*********************************************************************");
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLUE_BACKGROUND
													 + "                                                                     ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            1 - Criar Conta                                          ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            2 - Listar todas as Contas                               ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            3 - Buscar Conta por Numero                              ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            4 - Atualizar Dados da Conta                             ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            5 - Apagar Conta                                         ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            6 - Sacar                                                ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            7 - Depositar                                            ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            8 - Transferir valores entre Contas                      ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "            9 - Sair                                                 ");
			System.out.println(Cores.TEXT_GREEN_BOLD + "                                                                     "); 
            System.out.println(Cores.TEXT_GREEN_BOLD + "                                                                     " 
													+ Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_GREEN + "*********************************************************************");
			System.out.println(Cores.TEXT_YELLOW + " Entre com a opção desejada:                         "
													+ Cores.TEXT_RESET);
			opcao = leia.nextInt();
				
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Conta Corrente\n\n");
				
                    keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
					
                    keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
	
                    keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
					
                    keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
		
                    keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

                    keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
					
                    keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
					
                    keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!");
					
                    keyPress();
					break;
			}
		}	
    }

    public static void keyPress() {
		
		try {
			
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

}