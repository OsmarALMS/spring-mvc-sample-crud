package br.com.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sample.model.Produto;

@Repository
@Transactional
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
