package br.com.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sample.model.Carrinho;

@Repository
@Transactional
public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {
	Carrinho getByProduto(String produto); 
}
