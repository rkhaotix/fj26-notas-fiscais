package br.com.caelum.notasfiscais.listener;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailComercial;

public class LoginListener implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	@EmailComercial
	private String emailComercial;

	public void onLogin(@Observes Usuario usuario) {
		System.out.println("Usuario se logou no sistema: " + usuario.getLogin());
		System.out.println("Email enviado para: " + emailComercial);
	}

}
