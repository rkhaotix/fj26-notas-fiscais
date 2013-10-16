package br.com.caelum.notasfiscais.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class JSFProducer {
	
	@Produces @RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces @RequestScoped
	public NavigationHandler getNavigationHandler(FacesContext ctx) {
		return ctx.getApplication().getNavigationHandler();
	}

}
