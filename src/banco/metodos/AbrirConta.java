package banco.metodos;

import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class AbrirConta {
	public Conta adicionarConta() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bem-Vindo a Criação da Sua Conta Bancária");
		System.out.println("Digite o nome do titular: ");
		String titular = scan.next();
		
		System.out.println("Em qual agência abrirá sua conta?");
		String agencia = scan.next();
		
		int opcao;
		do {
		System.out.println("\nDigite 1 para criar uma CONTA CORRENTE");
		System.out.println("Digite 2 para criar uma CONTA POUPANÇA");
		try {
			opcao = scan.nextInt();
			if(opcao != 1 && opcao != 2)
				System.out.println("Opcao inválida");
		} catch (Exception e) {
			opcao = 0;
			System.out.println("Opção inválida");
		}
		} while(opcao != 1 && opcao != 2);
		
		
		if (opcao == 1) {
			ContaCorrente conta = new ContaCorrente(agencia, "Corrente", titular);
			System.out.println(conta.getTipo()+" criada com sucesso\n");
			return conta;
			
		} else {
			ContaPoupanca conta = new ContaPoupanca(agencia, "Poupança", titular);
			System.out.println(conta.getTipo()+" criada com sucesso\n");
			return conta;
		}
		
		
	}
		
}
