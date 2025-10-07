import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroConta;
    private String agencia;
    private Cliente titular;
    private double saldo;
    private List<Object> transacoes; // Lista Genérica <Object> para armazenar transações (ex.: String ou tipo Transacao)

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

    // Adicionar métodos para depósito, saque, transferência e relatório de transações aqui

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
