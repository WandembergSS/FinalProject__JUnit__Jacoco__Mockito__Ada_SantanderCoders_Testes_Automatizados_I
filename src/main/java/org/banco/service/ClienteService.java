package org.banco.service;

import org.banco.model.Cliente;

import java.util.List;

public interface ClienteService {

    void atualizar(Cliente c) throws Exception;

    boolean existe(String cpf);

    void inserir(Cliente c);

    Cliente procurar(String cpf) throws Exception;

    void remover(String cpf) throws Exception;

}