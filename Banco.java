import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<Conta>();
    }

    public void adicionarConta(Conta conta) {
        if (conta == null) {
            System.out.println("Conta inválida.");
            return;
        }

        for (Conta c : contas) {
            // Verifica se número de conta e agência são iguais
            if (c.getNumeroConta().equals(conta.getNumeroConta()) && c.getAgencia().equals(conta.getAgencia())) {
                System.out.println("Já existe uma conta com este número e agência.");
                return;
            }

            // Verifica se CPF do titular é igual
            if (c.getTitular().getCpf().equals(conta.getTitular().getCpf())) {
                System.out.println("Já existe uma conta com este CPF.");
                return;
            }
        }
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public Conta getContaPorCPF(String cpf) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar a conta
    }

    public Conta getContaPorNumeroAndAgencia(String numero, String agencia) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numero) && conta.getAgencia().equals(agencia)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar a conta
    }

    public Conta getContaPorTitular(Cliente titular) {
        for (Conta conta : contas) {
            if (conta.getTitular().equals(titular)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar a conta
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public Conta getClientePorCPF(String cpf) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar o cliente
    }

    public Conta getClientePorNome(String nome) {
        for (Conta conta : contas) {
            if (conta.getTitular().getNome().equals(nome)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar o cliente
    }
}
