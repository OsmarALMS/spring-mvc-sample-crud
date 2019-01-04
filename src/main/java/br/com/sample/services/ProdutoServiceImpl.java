package br.com.sample.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.sample.model.Produto;
import br.com.sample.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService  {
    
	@Autowired
    private ProdutoRepository produtoRepository;
    
	@Override
    public List<Produto> getAll() {
        return (List<Produto>) produtoRepository.findAll();
    }

    @Override
    public Produto get(long id) {
        return produtoRepository.findOne(id);
    }
    
    @Override
    public void add(Produto produto) {
    	produtoRepository.save(produto);
    }
    
    @Override
    public Produto edit(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    @Override
    public void delete(Produto produto) {
    	produtoRepository.delete(produto);
    }
    
    @Override
    public long count() {
        return produtoRepository.count();
    }

    @Override
    public void addList (List<Produto> produtos) {
    	produtoRepository.save(produtos);
    }
}
