import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<Conta>();
    }

    public void adicionarConta(Conta conta) {
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
}
