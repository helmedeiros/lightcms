package com.bsouza.lightcms.login;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Autenticador {

	public EstadoDaAutenticacao autoriza(Login login) {
		EstadoDaAutenticacao estado = EstadoDaAutenticacao.FALHA;
		
		if (login.getUsuario().equals("bsouza") && login.getSenha().equals("teste123")) {
			estado = EstadoDaAutenticacao.SUCESSO;
		}
		
		return estado;
	}

}