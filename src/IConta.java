
public interface IConta {

	void imprimirExtrato();

	void depositar(double quantiaDepositar);

	void sacar(double quantiaSacar);

	void transferir(double transferir, Double contaTransferir);
}
