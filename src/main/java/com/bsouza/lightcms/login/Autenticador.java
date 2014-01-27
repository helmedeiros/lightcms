package com.bsouza.lightcms.login;

import com.bsouza.lightcms.usuarios.RepositorioDeUsuarios;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Autenticador {

	private RepositorioDeUsuarios repositorio;

	public Autenticador(RepositorioDeUsuarios repositorio) {
		this.repositorio = repositorio;
	}
	
	public EstadoDaAutenticacao autoriza(Login login) {
		EstadoDaAutenticacao estado = EstadoDaAutenticacao.FALHA;
		
		if (repositorio.validaLogin(login) != null) {
			estado = EstadoDaAutenticacao.SUCESSO;
		}
		
		return estado;
	}

}