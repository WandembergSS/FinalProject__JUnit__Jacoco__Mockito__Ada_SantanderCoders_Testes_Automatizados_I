package org.banco.model;

public abstract class ContaAbstrata {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public ContaAbstrata(String num, Cliente c) {
        this(num, 0, c);
    }

    public ContaAbstrata(String num, double s, Cliente c) {
        setNumero(num);
        setSaldo(s);
        setCliente(c);
    }

    public void creditar(double valor) {
        saldo = saldo + valor;
    }

    public abstract void debitar(double valor) throws Exception;

    protected void diminuiSaldo(double valor) {
        saldo = saldo - valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumero(String num) {
        this.numero = num;
    }

    public void setSaldo(double valor) {
        saldo = valor;
    }

    public void transferir(ContaAbstrata c, double v) throws Exception {
        this.debitar(v);
        c.creditar(v);
    }
}