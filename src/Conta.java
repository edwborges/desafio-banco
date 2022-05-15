
public class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo = 1000.00;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println();
		System.out.println("=== Extrato Conta Corrente ===");
		imprimirInfosComuns();
	}

	@Override
	public void depositar(double quantiaDepositar) {
		saldo += quantiaDepositar;
	}

	@Override
	public void sacar(double quantiaSacar) {
		saldo -= quantiaSacar;
	}

	@Override
	public void transferir(double transferir, Double contaTransferir) {
		this.sacar(transferir);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
