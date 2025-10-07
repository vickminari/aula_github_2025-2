public class Conta {
    private String numeroConta;
    private String agencia;
    private String titular;
    private double saldo;

    public Conta(String numeroConta, String agencia, String titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = 0.0;
    }
}
