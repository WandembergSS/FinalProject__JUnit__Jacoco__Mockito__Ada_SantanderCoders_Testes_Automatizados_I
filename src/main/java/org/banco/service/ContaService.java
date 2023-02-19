package org.banco.service;

import org.banco.model.ContaAbstrata;

import java.util.List;

public interface ContaService {

    void inserir(ContaAbstrata c);

    boolean existe(String num);

    void atualizar(ContaAbstrata c) throws Exception;

    ContaAbstrata procurar(String num) throws Exception;

    void remover(String num) throws Exception;

    List<ContaAbstrata> listar();

}