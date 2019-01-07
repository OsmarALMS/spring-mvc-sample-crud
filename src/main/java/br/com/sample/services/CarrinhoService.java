package br.com.sample.services;

import java.util.List;

import br.com.sample.model.Carrinho;

public interface CarrinhoService {
    List<Carrinho> getAll();
    Carrinho get(long id);
    void add(Carrinho carrinho);
    Carrinho edit(Carrinho carrinho);
    void delete(Carrinho carrinho);
    long count();
    void addList (List<Carrinho> carrinho);
    Carrinho getByProduto(String produto);
}
