package br.com.caelum.notasfiscais.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {
	@Inject
	private EntityManager manager;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("Abrindo a transação");
		manager.getTransaction().begin();
		
		Object resultado = ctx.proceed();
		
		manager.getTransaction().commit();
		System.out.println("Commitando a transação");
		
		return resultado;
	}
}
