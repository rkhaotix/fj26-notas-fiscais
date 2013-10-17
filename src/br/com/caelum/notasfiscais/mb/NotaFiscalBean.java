package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;
import br.com.caelum.notasfiscais.util.ViewModel;

@Named @ConversationScoped
public class NotaFiscalBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	@Inject
	private NotaFiscalDao notaFiscalDao;
	
	@Inject
	private ProdutoDao produtoDao;
	
	@Inject
	private Conversation conversation;
	
	@Transactional
	public String gravar() {
		this.notaFiscalDao.adiciona(notaFiscal);
		conversation.end();
		return "notafiscal?faces-redirect=true";
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	
	public void guardaItem() {
		Produto produto = produtoDao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
	}
	
	public String avancar() {
		
		if(conversation.isTransient())
		{
			conversation.begin();	
		}
		
		return "item?faces-redirect=true";
	}
}
