package br.com.bytebank.banco.modelo;

import br.com.bytebank.banco.exception.SaldoInsulficienteException;

/**
 * @author Rodrigo
 * @version 0.1
 * @author rodrigo_rr
 */
public abstract class Conta implements Comparable {
    private double saldo;
    private Integer agencia;
    private int numero;
    private int digito;
    private Cliente titular;
    private static int total = 0;

    /**
     * Construtor Conta()
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero) {
        this.setAgencia(agencia);
        this.setNumero(numero);
        System.out.println("Conta " + this.getClass().getSimpleName() + " Criada!");
        Conta.total++;
        //System.out.println("Total de Contas: " + Conta.total);
    }

    public Conta(int agencia, int numero, int digito) {
        this(agencia, numero);
        this.setDigito(digito);
        System.out.println("br.com.bytebank.banco.entity.Conta " + this + " Criada 2!");
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if ((agencia <= 0)) {
            System.out.println("Agencia menor ou igual a 0!");
            return;
        }
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        //System.out.println("Saldo da " + this.getClass().getName() + ": " + this.saldo);
        return this.saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    /**
     * Valor > saldo
     * @param valor
     * @throws SaldoInsulficienteException
     */
    public void saca(double valor) throws SaldoInsulficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsulficienteException("Saldo insulficiente; Saldo: " + this.getSaldo() + " Valor solicitado:" + valor);
        }
        this.saldo -= valor;
    }

    public void transfere(double valor, Conta contaDestino) throws SaldoInsulficienteException {
        this.saca(valor);
        contaDestino.deposita(valor);
    }

    public static int getTotal() {
        return Conta.total;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + this.getSaldo() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (numero != conta.numero) return false;
        if (digito != conta.digito) return false;
        return agencia != null ? agencia.equals(conta.agencia) : conta.agencia == null;
    }

    @Override
    public int hashCode() {
        int result = agencia != null ? agencia.hashCode() : 0;
        result = 31 * result + numero;
        result = 31 * result + digito;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.getSaldo(),((Conta)o).getSaldo());
    }
}
