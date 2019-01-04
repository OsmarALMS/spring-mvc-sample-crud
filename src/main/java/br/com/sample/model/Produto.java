package br.com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
public class Produto {
    
	public Produto() {}
	
	public Produto(String nome, String preco, String produtor, String pais, String regiao,
			String safra, String tipo, String uva, String teorAlcoolico, String volume) {
		this.nome = nome;
		this.preco = preco;
		this.produtor = produtor;
		this.pais = pais;
		this.regiao = regiao;
		this.safra = safra;
		this.tipo = tipo;
		this.uva = uva;
		this.teorAlcoolico = teorAlcoolico;
		this.volume = volume;
	}
	
	@Id
    @GeneratedValue
    private long produtoId;

    @Column(nullable = false,unique = true)
    private String nome;

    @Column
    private String preco;

    @Column
    private String produtor;
    
    @Column
    private String pais;
    
    @Column
    private String regiao;
    
    @Column
    private String safra;
    
    @Column
    private String tipo;
    
    @Column
    private String uva;
    
    @Column
    private String teorAlcoolico;

    @Column
    private String volume;
    
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isAtivo = true;

	public long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSafra() {
		return safra;
	}

	public void setSafra(String safra) {
		this.safra = safra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}

	public String getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(String teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	
}
