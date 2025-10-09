import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
	private static final Scanner scanner = new Scanner(System.in);
	private String title;
	private List<String> options;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public void saque(Banco banco) {
		System.out.println("Digite o número da conta:");
		String numConta = scanner.nextLine();
		System.out.println("Digite a agência:");
		String ag = scanner.nextLine();
		Conta conta = banco.getContaPorNumeroAndAgencia(numConta, ag);
		if (conta != null) {
			System.out.println("Digite o valor a ser sacado:");
			String valStr = scanner.nextLine();
			try {
				double valor = Double.parseDouble(valStr);
				if (conta.saque(valor)) {
					System.out.println("Saque realizado com sucesso!");
				} else {
					System.out.println("Saldo insuficiente para saque.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido.");
			}
		} else {
			System.out.println("Conta não encontrada.");
		}	
	}

	public void depositar(Banco banco) {
		System.out.println("Digite o número da conta:");
		String numContaDep = scanner.nextLine();
		System.out.println("Digite a agência:");
		String agDep = scanner.nextLine();
		Conta contaDep = banco.getContaPorNumeroAndAgencia(numContaDep, agDep);
		if (contaDep != null) {
			System.out.println("Digite o valor a ser depositado:");
			String valStr = scanner.nextLine();
			try {
				double valor = Double.parseDouble(valStr);
				if (contaDep.depositar(valor)) {
					System.out.println("Depósito realizado com sucesso!");
				} else {
					System.out.println("Valor inválido para depósito.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido.");
			}
		} else {
			System.out.println("Conta não encontrada.");
		}	
	}

	public void transferencia(Banco banco) {
		System.out.println("Digite o número da conta de origem:");
		String numContaOrigem = scanner.nextLine();
		System.out.println("Digite a agência da conta de origem:");
		String agOrigem = scanner.nextLine();
		Conta contaOrigem = banco.getContaPorNumeroAndAgencia(numContaOrigem, agOrigem);
		
		if (contaOrigem == null) {
			System.out.println("Conta de origem não encontrada.");
			return;
		}	
		
		System.out.println("Digite o número da conta de destino:");
		String numContaDestino = scanner.nextLine();
		System.out.println("Digite a agência da conta de destino:");
		String agDestino = scanner.nextLine();
		Conta contaDestino = banco.getContaPorNumeroAndAgencia(numContaDestino, agDestino);
		
		if (contaDestino == null) {
			System.out.println("Conta de destino não encontrada.");
			return;
		
		}
		System.out.println("Digite o valor a ser transferido:");
		String valStr = scanner.nextLine();
		
		try {
			double valor = Double.parseDouble(valStr);
			if (contaOrigem.transferir(contaDestino, valor)) {
				System.out.println("Transferência realizada com sucesso!");
			} else {
				System.out.println("Saldo insuficiente para transferência.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Valor inválido.");
		}
	}

	public void opcoesOperacoes(Banco banco){
		int option = 0; 
		System.out.println("Opções de Operações:");
		System.out.println("1 - Saque");
		System.out.println("2 - Depósito");
		System.out.println("3 - Transferência");
		System.out.println("4 - Extrato");

		try {
			String op = scanner.nextLine();
			option = Integer.parseInt(op);
			System.out.println(op + " foi selecionada");
		}catch (NumberFormatException e) {
			option = 0;
		}
		switch (option) {
			case 1: // Saque
				saque(banco);
				break;
			case 2: // Depósito
				depositar(banco);
				break;
			case 3: // Transferência
				transferencia(banco);
				break;
			case 4:
				exibirExtrato(banco);
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}
	}

	public void opcoesConta(Banco banco){
		int option = 0; 
		System.out.println("Opções de Conta:");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Acessar conta");

		while(option == 0) {
			try {
				String op = scanner.nextLine();
				option = Integer.parseInt(op);
				System.out.println(op + " foi selecionada");
			}catch (NumberFormatException e) {
				option = 0;
			}
			switch (option) {
				case 1: // Criar conta
					criarConta(banco);
					break;
				case 2: // Acessar conta
					acessarConta(banco);
					break;
				default:
					System.out.println("Opção inválida.");
					option = 0;
					break;
			}
		}
	}

	private void exibirExtrato(Banco banco) {
		System.out.println("Digite o número da conta:");
		String numExtrato = scanner.nextLine();
		System.out.println("Digite a agência:");
		String agExtrato = scanner.nextLine();
		Conta contaExtrato = banco.getContaPorNumeroAndAgencia(numExtrato, agExtrato);
		if (contaExtrato != null) {
			contaExtrato.exibirExtrato();
		} else {
			System.out.println("Conta não encontrada.");
		}	
	}

	private void acessarConta(Banco banco) {
		System.out.println("Digite o número da conta:");
		String numConta = scanner.nextLine();
		System.out.println("Digite a agência:");
		String ag = scanner.nextLine();
		Conta conta = banco.getContaPorNumeroAndAgencia(numConta, ag);
		if (conta != null) {
			System.out.println("Conta encontrada: " + conta);
		} else {
			System.out.println("Conta não encontrada.");
		}	
	}

	private void criarConta(Banco banco) {
		System.out.println("Digite o nome do titular:");
		String nome = scanner.nextLine();
		System.out.println("Digite o CPF do titular:");
		String cpf = scanner.nextLine();
		System.out.println("Digite o endereço do titular:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o número da conta:");
		String numeroConta = scanner.nextLine();
		System.out.println("Digite a agência:");
		String agencia = scanner.nextLine();
		Cliente novoCliente = new Cliente(nome, cpf, endereco);
		Conta novaConta = new Conta(numeroConta, agencia, novoCliente);
		banco.adicionarConta(novaConta);
		System.out.println("Conta criada com sucesso!");
	}

	public void execute(int option, Banco banco){
		switch (option) {
			case 1:
				opcoesConta(banco);
				break;
			case 2:
				//opcoes do cliente
				break;
			case 3:
				opcoesOperacoes(banco);
				break;
			default:
				break;
		}
	}

	public int getSelection() {
		int op = 0;
		while (op==0){
			System.out.println("\n" + title + "\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			String str = scanner.nextLine();
			try {
				op = Integer.parseInt(str);
				System.out.println(op + " foi selecionada");
			}
			catch (NumberFormatException e) {
				op =0;
			}
			if (op>=i){
				System.out.println("Opcao errada!");
				op=0;
			}
		}
		return op;
	}
}
