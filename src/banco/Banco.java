package banco;

import java.util.ArrayList;
import java.util.Scanner;

import banco.metodos.AbrirConta;
import banco.metodos.OperarConta;
import contas.Conta;

public class Banco {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AbrirConta addConta = new AbrirConta();
		OperarConta opConta = new OperarConta();
		String operacao = "0";
		ArrayList<Conta> conta = new ArrayList<Conta>();
		
		while(!operacao.equals("3")) {
			System.out.println("\nDeseja Realizar alguma operação?");
			System.out.println("Abrir Conta (1)  -  Operar Conta (2)  -  Sair (3)");
			operacao = scan.next();
			switch (operacao) {
			case "1":
				conta.add(addConta.adicionarConta());
				break;
				
			case "2":
				if (conta.size() == 0) {
					System.out.println("Nenhuma conta existente, crie uma!\n");
				}else {
					System.out.println("Selecione o número da Conta para operar");
					for(int i = 0; i < conta.size(); i++) {
						System.out.print(conta.get(i).getNumero());
						System.out.println("  - Titular: " + conta.get(i).getTitular());
					}
					try {
						int selecionarConta = scan.nextInt();
						if(selecionarConta < conta.size() && selecionarConta >= 0)
							opConta.operarConta(conta.get(selecionarConta),conta);
						else
							System.out.println("Conta inexistente");
					} catch (Exception e) {
						System.out.println("Opção inválida");
					}
				}
				break;
				
			case "3":
				System.out.println("Tenha um bom-dia, obrigado pela presença");
				break;
			default:
				System.out.println("Operação inexistente, digite outra!!\n");
				break;
			}
		}
		
		scan.close();
	}	
}
