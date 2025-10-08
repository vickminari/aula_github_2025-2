import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroConta;
    private String agencia;
    private Cliente titular;
    private double saldo;
    private List<Object> transacoes; // Lista Genérica <Object> para armazenar transações

    public Conta(String numeroConta, String agencia, Cliente titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para saque
    public boolean saque(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
            transacoes.add("Saque: -" + valor);
            return true;
        }
        return false;
    }

    // Método para depósito
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add("Depósito: +" + valor);
            return true;
        }
        return false;
    }

    // Método para transferência
    public boolean transferir(Conta destino, double valor) {
        if (this.saque(valor)) {
            destino.depositar(valor);
            transacoes.add("Transferência para " + destino.getNumeroConta() + ": -" + valor);
            return true;
        }
        return false;
    }

    // Método para exibir extrato
    public void exibirExtrato() {
        System.out.println("Extrato da Conta " + numeroConta + ":");
        for (Object transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", titular=" + titular +
                ", saldo=" + saldo +
                '}';
    }
}
