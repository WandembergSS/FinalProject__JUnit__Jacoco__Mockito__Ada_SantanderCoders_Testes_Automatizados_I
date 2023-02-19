package org.banco.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteTest {

    @Mock
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(cliente.getCpf()).thenReturn("81983669717");
        when(cliente.getNome()).thenReturn("Wandemberg Silva dos Santos");
        when(cliente.getTipo()).thenReturn(TipoCliente.ESPECIAL);
    }

    @Test
    public void testSetCpf() {
        when(cliente.getCpf()).thenReturn("81932551901");
        cliente.setCpf("81932551901");
        assertEquals("81932551901", cliente.getCpf());
    }

    @Test
    public void testSetNome() {
        when(cliente.getNome()).thenReturn("Wandielle");
        cliente.setNome("Wandielle");
        assertEquals("Wandielle", cliente.getNome());
    }

    @Test
    public void testSetTipo() {
        when(cliente.getTipo()).thenReturn(TipoCliente.VIP);
        cliente.setTipo(TipoCliente.VIP);
        assertEquals(TipoCliente.VIP, cliente.getTipo());
    }
}
