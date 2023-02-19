package org.banco.service;

import org.banco.model.Cliente;
import org.banco.model.Conta;
import org.banco.model.TipoCliente;
import org.banco.model.ContaAbstrata;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaServiceImpTest {

    private ContaServiceImp contaService;
    private ContaAbstrata conta;

    private Cliente cliente;


    @BeforeEach
    void setUp() {
        contaService = new ContaServiceImp();
        cliente = new Cliente("81986669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);
        conta = new Conta("5", 100.0, cliente);
    }

    @Test
    void testInserir() {
        contaService.inserir(conta);
        List<ContaAbstrata> contas = contaService.listar();
        Assertions.assertEquals(1, contas.size());
        Assertions.assertEquals(conta, contas.get(0));
    }

    @Test
    void testExiste() {
        contaService.inserir(conta);
        boolean existe = contaService.existe("5");
        Assertions.assertTrue(existe);
    }

    @Test
    void testAtualizar() throws Exception {
        contaService.inserir(conta);
        conta.setSaldo(200.0);
        contaService.atualizar(conta);
        ContaAbstrata contaAtualizada = contaService.procurar("5");
        Assertions.assertEquals(200.0, contaAtualizada.getSaldo());
    }

    @Test
    public void testAtualizarException() {
        assertThrows(Exception.class, () -> contaService.atualizar(conta));
    }

    @Test
    void testProcurar() throws Exception {
        contaService.inserir(conta);

        ContaAbstrata contaProcurada = contaService.procurar("5");
        Assertions.assertEquals(conta, contaProcurada);
    }

    @Test
    public void testProcurarException() {
        assertThrows(Exception.class, () -> contaService.procurar("55"));
    }

    @Test
    void testRemover() throws Exception {
        contaService.inserir(conta);
        contaService.remover("5");
        List<ContaAbstrata> contas = contaService.listar();
        Assertions.assertEquals(0, contas.size());
    }

    @Test
    public void testRemoverException() {
        assertThrows(Exception.class, () -> contaService.remover("5"));
    }

}
