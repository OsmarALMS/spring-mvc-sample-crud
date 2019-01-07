package br.com.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sample.model.Carrinho;
import br.com.sample.repository.CarrinhoRepository;

@Service
@Transactional
public class CarrinhoServiceImpl implements CarrinhoService  {
    
	@Autowired
    private CarrinhoRepository carrinhoRepository;
    
	@Override
    public List<Carrinho> getAll() {
        return (List<Carrinho>) carrinhoRepository.findAll();
    }

    @Override
    public Carrinho get(long id) {
        return carrinhoRepository.findOne(id);
    }
    
    @Override
    public void add(Carrinho produto) {
    	carrinhoRepository.save(produto);
    }
    
    @Override
    public Carrinho edit(Carrinho produto) {
        return carrinhoRepository.save(produto);
    }
    
    @Override
    public void delete(Carrinho produto) {
    	carrinhoRepository.delete(produto);
    }
    
    @Override
    public long count() {
        return carrinhoRepository.count();
    }

    @Override
    public void addList (List<Carrinho> produtos) {
    	carrinhoRepository.save(produtos);
    }
    
    @Override
    public Carrinho getByProduto (String produto) {
    	return carrinhoRepository.getByProduto(produto);
    }
}
