package com.bsouza.lightcms.login;

public enum EstadoDaAutenticacao {

	SUCESSO("Autenticação realizada com sucesso!"), 
	FALHA("Falha na autententicação! Por favor revise suas credenciais ou, se o problema persistir, contata-te o administrador.");
	
	private String mensagem;

	private EstadoDaAutenticacao(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String mensagem() {
		return mensagem;
	}
	
	public boolean teveSucesso() {
		return this.equals(SUCESSO);
	}
}