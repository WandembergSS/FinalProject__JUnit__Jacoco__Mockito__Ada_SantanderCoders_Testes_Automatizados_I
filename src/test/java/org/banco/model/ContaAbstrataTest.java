package org.banco.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ContaAbstrataTest {

    private ContaAbstrata conta;

    Cliente cliente;

    protected abstract ContaAbstrata criarConta(String num, double saldo, Cliente c);
    protected abstract ContaAbstrata criarConta(String num, Cliente c);

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);
        conta = criarConta("5", 100.0, cliente);
    }

    @Test
    public void testCreditar() {
        conta.creditar(50.0);
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    public void testDebitar() throws Exception {
        conta.debitar(50.0);
        assertEquals(50.0, conta.getSaldo());
    }

    @Test
    public void testDebitarSaldoInsuficiente() {
        assertThrows(Exception.class, () -> conta.debitar(200.0));
    }

    @Test
    public void testDiminuiSaldo() {
        conta.diminuiSaldo(50.0);
        assertEquals(50.0, conta.getSaldo());
    }

    @Test
    public void testTransferir() throws Exception {
        Cliente clienteDestino = new Cliente("81932551901", "Wandielle", TipoCliente.VIP);
        ContaAbstrata contaDestino = criarConta("4", 0, clienteDestino);
        conta.transferir(contaDestino, 50.0);
        assertEquals(50.0, conta.getSaldo());
        assertEquals(50.0, contaDestino.getSaldo());
    }

    @Test
    public void testTransferirSaldoInsuficiente() {
        Cliente clienteDestino = new Cliente("81932551901", "Wandielle", TipoCliente.VIP);
        ContaAbstrata contaDestino = criarConta("4", 0, clienteDestino);
        assertThrows(Exception.class, () -> conta.transferir(contaDestino, 200.0));
    }

    @Test
    public void testConstrutor1() {
        assertEquals("5", conta.getNumero());
        assertEquals(100.0, conta.getSaldo());
        assertEquals(cliente, conta.getCliente());
    }

    @Test
    public void testConstrutor2() {
        ContaAbstrata conta2 = criarConta("5", cliente);
        assertEquals("5", conta2.getNumero());
        assertEquals(cliente, conta2.getCliente());
    }

    @Test
    public void testGetCliente() {
        assertNotNull(conta.getCliente());
        assertEquals(cliente, conta.getCliente());
    }
}
