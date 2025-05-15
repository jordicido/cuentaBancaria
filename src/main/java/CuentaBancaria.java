public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida para depósito");
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida para retirada");
        if (cantidad > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        saldo -= cantidad;
    }
}
