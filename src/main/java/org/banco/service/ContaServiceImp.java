package org.banco.service;

import org.banco.model.ContaAbstrata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContaServiceImp implements ContaService {

    private final Map<String, ContaAbstrata> contas;

    public ContaServiceImp() {
        this.contas = new HashMap<>();
    }

    @Override
    public void inserir(ContaAbstrata c) {
        contas.put(c.getNumero(), c);
    }

    @Override
    public boolean existe(String num) {
        return contas.containsKey(num);
    }

    @Override
    public void atualizar(ContaAbstrata c) throws Exception {
        if (!existe(c.getNumero())) {
            throw new Exception("Conta não encontrada");
        }
        contas.put(c.getNumero(), c);
    }

    @Override
    public ContaAbstrata procurar(String num) throws Exception {
        if (!existe(num)) {
            throw new Exception("Conta não encontrada");
        }
        return contas.get(num);
    }

    @Override
    public void remover(String num) throws Exception {
        if (!existe(num)) {
            throw new Exception("Conta não encontrada");
        }
        contas.remove(num);
    }

    @Override
    public List<ContaAbstrata> listar() {
        return new ArrayList<>(contas.values());
    }
}
