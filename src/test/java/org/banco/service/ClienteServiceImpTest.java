package org.banco.service;

import org.banco.model.Cliente;
import org.banco.model.TipoCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceImpTest {
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        clienteService = new ClienteServiceImp();
        cliente = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);

    }

    @Test
    void inserirCliente() {
        clienteService.inserir(cliente);

        assertTrue(clienteService.existe("81983669717"));
    }

    @Test
    void atualizarCliente() throws Exception {
        Cliente cliente = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);
        clienteService.inserir(cliente);

        Cliente clienteAtualizado = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.CLASS);
        clienteService.atualizar(clienteAtualizado);

        assertEquals("Wandemberg Silva dos Santos", clienteService.procurar("81983669717").getNome());
        assertEquals(TipoCliente.CLASS, clienteService.procurar("81983669717").getTipo());
    }

    @Test
    void procurarCliente() throws Exception {
        Cliente cliente = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);
        clienteService.inserir(cliente);

        Cliente clienteEncontrado = clienteService.procurar("81983669717");

        assertNotNull(clienteEncontrado);
        assertEquals("Wandemberg Silva dos Santos", clienteEncontrado.getNome());
        assertEquals(TipoCliente.VIP, clienteEncontrado.getTipo());
    }

    @Test
    void removerCliente() throws Exception {
        Cliente cliente = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.VIP);
        clienteService.inserir(cliente);

        clienteService.remover("81983669717");

        assertFalse(clienteService.existe("81983669717"));
    }

    @Test
    void atualizarClienteNaoExistente() {
        Cliente clienteAtualizado = new Cliente("81983669717", "Wandemberg Silva dos Santos", TipoCliente.CLASS);

        assertThrows(Exception.class, () -> clienteService.atualizar(clienteAtualizado));
    }

    @Test
    void procurarClienteNaoExistente() {
        assertThrows(Exception.class, () -> clienteService.procurar("81983669717"));
    }

    @Test
    void removerClienteNaoExistente() {
        assertThrows(Exception.class, () -> clienteService.remover("81983669717"));
    }
}

