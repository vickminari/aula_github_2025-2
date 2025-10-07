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

    // Método para depósito
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add("Depósito: +" + valor);
            return true;
        }
        return false;
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
