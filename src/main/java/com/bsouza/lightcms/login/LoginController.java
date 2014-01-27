package com.bsouza.lightcms.login;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.bsouza.lightcms.HomeController;

@Resource
public class LoginController {

	private Result result;
	private Autenticador autenticador;

	public LoginController(Result result, Autenticador autenticador) {
		this.autenticador = autenticador;
		this.result = result;
	}
	
	@Get("/login")
	public void index() { }
	
	@Post("/login/validar")
	public void validar(Login login) {
		if (autenticador.autoriza(login).teveSucesso())
			sucessoNaAutenticacao();
		else
			falhaNaAutenticacao();
	}
	
	private void sucessoNaAutenticacao() {
		result.redirectTo(HomeController.class).index();
	}
	
	private void falhaNaAutenticacao() {
		result.include("mensagem", EstadoDaAutenticacao.FALHA.mensagem());
		result.forwardTo(this).index();
	}
	
}