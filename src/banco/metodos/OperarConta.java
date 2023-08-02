package banco.metodos;

import java.util.ArrayList;
import java.util.Scanner;

import contas.Conta;

public class OperarConta {
	public void operarConta(Conta conta, ArrayList<Conta> contas){
		Scanner scan = new Scanner(System.in);
		String opcao="";
		
		while(!opcao.equals("5")) {
			System.out.println("\nQual operação deseja realizar em sua conta?");
			System.out.println("Sacar (1)  -  Depositar (2)  -  Transferir (3)  -  Imprimir Extrato (4)  -  Sair (5)");
			opcao = scan.next();
			switch (opcao) {
			case "1":
				System.out.println("\nDigite a quantidade para sacar: ");
				try {
					double valorSaque = scan.nextDouble();
					if(valorSaque <= conta.getSaldo()) {
						conta.sacar(valorSaque);					
					}else System.out.println("Saldo inválido");
				}catch (Exception e) {
					System.out.println("Valor inválido");
				}
				break;
			case "2":
				System.out.println("\nDigite a quantidade para depositar: ");
				try {
					double valorDeposito = scan.nextDouble();
					conta.depositar(valorDeposito);
				} catch (Exception e) {
					System.out.println("Valor inválido");
				}
				break;
			case "3":
				System.out.println("\nDigite o valor da Transferência: ");
				try {
					double valorTransferencia = scan.nextDouble();
					if(valorTransferencia <= conta.getSaldo()) {
						System.out.println("Digite o número da conta a transferir: ");
						try {	
							int contaTransferencia = scan.nextInt();
							if (contaTransferencia < contas.size() && contaTransferencia >= 0 && contaTransferencia != conta.getNumero()) {
								for(int i = 0; i < contas.size(); i++) {
									if(contaTransferencia == i) {
										conta.transferir(valorTransferencia, contas.get(i));
									}
								}
							}else {
								System.out.println("Conta inválida");
							}
						}catch (Exception e) {
							System.out.println("Dado inserido inválido");
						}
						
					} else {
						System.out.println("Saldo inválido");
					}
				}catch (Exception e) {
					System.out.println("Valor inválido");
				}
				break;
			case "4":
				conta.imprimirExtrato();
				break;
			case "5":
				System.out.println("Obrigado, até a próxima");
				break;
			default:
				System.out.println("Comando inválido!! Favor selecionar outra operação");
				break;
			}
		}		
		
	}

}
