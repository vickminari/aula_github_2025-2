public class Conta {
    private String numeroConta;
    private String agencia;
    private Cliente titular;
    private double saldo;

    public Conta(String numeroConta, String agencia, Cliente titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = 0.0;
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
