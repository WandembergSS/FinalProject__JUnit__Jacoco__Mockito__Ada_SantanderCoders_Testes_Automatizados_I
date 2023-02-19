package org.banco.model;

public class ContaTest extends ContaAbstrataTest {

    @Override
    protected ContaAbstrata criarConta(String num, double saldo, Cliente c) {
        return new Conta(num, saldo, c);
    }

    @Override
    protected ContaAbstrata criarConta(String num, Cliente c) {
        return new Conta(num, c);
    }
}
