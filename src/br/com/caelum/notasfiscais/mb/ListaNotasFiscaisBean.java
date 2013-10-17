package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.util.ViewModel;

@ViewModel
public class ListaNotasFiscaisBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NotaFiscalDao notaFiscalDao;
	
	@Inject
	private LazyDataModel<NotaFiscal> dataModel;
	
	public List<NotaFiscal> getNotasFiscais() {
		return notaFiscalDao.listaTodos();
	}

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
}
