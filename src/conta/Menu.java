package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
    public static void main(String[] args) throws Exception {
        
		
        Scanner leia = new Scanner(System.in);
		
		// Variáveis de entrada de dados
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor; 

		//Instância da Classe ContaController
		ContaController contas = new ContaController();
		
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
				
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
						
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversario da Conta: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}

                    keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
					
					contas.listarTodas();

                    keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
	
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);

                    keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					if (contas.buscarNaCollection(numero) != null) {
						
						System.out.println("Digite o Numero da Agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
							
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						tipo = contas.retornaTipo(numero);
						
						switch(tipo) {
							case 1 -> {
								System.out.println("Digite o Limite de Crédito (R$): ");
								limite = leia.nextFloat();
								contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							}
							case 2 -> {
								System.out.println("Digite o dia do Aniversario da Conta: ");
								aniversario = leia.nextInt();
								contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
							}
							default ->{
								System.out.println("Tipo de conta inválido!");
							}
						}
						
					}else
						System.out.println("\nConta não encontrada!");

                    keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
		
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
						
					contas.deletar(numero);

                    keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

					System.out.println("Digite o Numero da conta: ");
					numero = leia.nextInt();
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leia.nextFloat();
					
					contas.sacar(numero, valor);

                    keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
					
					System.out.println("Digite o Numero da conta: ");
					numero = leia.nextInt();
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
					
					contas.depositar(numero, valor);

                    keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
					
					System.out.println("Digite o Numero da Conta de Origem: ");
					numero = leia.nextInt();
					System.out.println("Digite o Numero da Conta de Destino: ");
					numeroDestino = leia.nextInt();
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
					
					contas.transferir(numero, numeroDestino, valor);

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