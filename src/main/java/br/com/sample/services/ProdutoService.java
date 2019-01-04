package br.com.sample.services;

import java.util.List;

import br.com.sample.model.Produto;

public interface ProdutoService {
    List<Produto> getAll();
    Produto get(long id);
    void add(Produto produto);
    Produto edit(Produto produto);
    void delete(Produto produto);
    long count();
    void addList (List<Produto> produtos);
}
