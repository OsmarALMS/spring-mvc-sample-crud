package br.com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRINHO")
public class Carrinho {
    
	public Carrinho() {}
	
	public Carrinho(Long quantidade, String produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}
	
	@Id
    @GeneratedValue
    private long carrinhoId;

    @Column
    private Long quantidade;

    @Column
    private String produto;

	public long getCarrinhoId() {
		return carrinhoId;
	}

	public void setCarrinhoId(long carrinhoId) {
		this.carrinhoId = carrinhoId;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
}