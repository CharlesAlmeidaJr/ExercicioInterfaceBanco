package contas;

public abstract class Conta implements IConta{
	
	private static int sequencia = 0;
	protected String agencia;
	protected int numero;
	protected double saldo = 0;
	protected String tipo;
	protected String titular;
	
	public Conta(String agencia, String tipo, String titular) {
		this.numero = sequencia++;
		this.agencia = agencia;
		this.tipo = "Conta " + tipo;
		this.titular = titular;
	}

	public void sacar(double valor) {
		saldo -= valor;
		
	}

	public void depositar(double valor) {
		saldo += valor;
		
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}
	
	public void imprimirExtrato() {
		System.out.println("\nTitular: "+ this.titular);
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Numero: " + this.numero);
		System.out.printf("Saldo: %.2f", this.saldo);
	}
	
	
	public String getTitular() {
		return titular;
	}

	public String getTipo() {
		return tipo;
	}

	public String getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
}
