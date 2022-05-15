import java.util.Locale;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Locale.setDefault(Locale.CANADA);
		Scanner sc = new Scanner(System.in);

		Cliente cliente = new Cliente();

		Conta conta = new Conta(cliente);

		System.out.println("------------------------------------------------------");
		System.out.println("----------------------Bem  vindo----------------------");
		System.out.println("------------------------------------------------------");
		System.out.println("----- Selecione a opção que você deseja realizar -----");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Extrato       |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Sair          |");
		System.out.println();
		System.out.print("Selecione a opção desejada: ");
		int opcao = sc.nextInt();

		while (opcao < 1 || opcao > 5) {
			System.out.println();
			System.out.print("Selecione uma opção válida: ");
			opcao = sc.nextInt();
		}

		switch (opcao) {
		case 1:
			conta.imprimirExtrato();
			break;
		case 2:
			conta.imprimirExtrato();
			System.out.println();
			System.out.print("- Quantia para depositar: ");
			double quantiaDepositar = sc.nextDouble();
			conta.depositar(quantiaDepositar);
			conta.imprimirExtrato();
			break;
		case 3:
			conta.imprimirExtrato();
			System.out.println();
			System.out.print("- Quantia para sacar: ");
			double quantiaSacar = sc.nextDouble();
			if (conta.getSaldo() < quantiaSacar) {
				System.err.println("Saldo Insuficiente para sacar!");
				System.exit(0);
			} else {
				conta.sacar(quantiaSacar);
				System.out.println("Saque realizado com sucesso!");
			}
			break;
		case 4:
			conta.imprimirExtrato();
			System.out.println();
			System.out.print("- Quantia para transferir: ");
			double transferir = sc.nextDouble();
			System.out.print("- Conta destinaria: ");
			double contaTransferir = sc.nextDouble();
			conta.transferir(transferir, contaTransferir);
			if (conta.getSaldo() < transferir) {
				System.err.println("Saldo Insuficiente para realizar a transferência!");
				System.exit(0);
			} else {
				System.out.println("Transferencia realizada com sucesso!");
			}
			break;
		case 5:
			System.out.println();
			System.out.print("- Volte sempre!");
			System.exit(0);
			break;
		default:
			System.err.println("- Opção Inválida");
			break;
		}
		sc.close();
	}
}
