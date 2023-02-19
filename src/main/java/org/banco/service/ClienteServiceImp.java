package org.banco.service;

import org.banco.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImp implements ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void inserir(Cliente c) {
        clientes.add(c);
    }

    @Override
    public boolean existe(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        if (existe(c.getCpf())) {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(c.getCpf())) {
                    clientes.set(i, c);
                    return;
                }
            }
        } else {
            throw new Exception("Cliente não encontrado.");
        }
    }

    @Override
    public Cliente procurar(String cpf) throws Exception {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        throw new Exception("Cliente não encontrado.");
    }

    @Override
    public void remover(String cpf) throws Exception {
        if (existe(cpf)) {
            clientes.removeIf(c -> c.getCpf().equals(cpf));
        } else {
            throw new Exception("Cliente não encontrado.");
        }
    }


}
