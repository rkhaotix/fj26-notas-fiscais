package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;

@Model
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	@Inject
	private ProdutoDao dao;

	public Produto getProduto() {
		return produto;
	}

	@Transactional
	public void grava() {
		if(produto.getId()==null)
			dao.adiciona(produto);
		else
			dao.atualiza(produto);
		
		produtos = dao.listaTodos();
		this.produto = new Produto();
	}
	
	public List<Produto> getProdutos() {
		if(produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = dao.listaTodos();
		}
		
		return produtos;
	}
	
	@Transactional
	public void remove(Produto produto) {
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
