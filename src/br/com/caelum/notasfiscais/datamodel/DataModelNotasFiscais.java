package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private NotaFiscalDao dao;
	
	@PostConstruct
	void posConstrucao() {
		super.setRowCount(dao.contaTodos());
	}
	
	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao,
			SortOrder sentidoOrdenacao, Map<String,String> filtros) {
		return dao.listaTodosPaginada(inicio, quantidade);	
	}

}
