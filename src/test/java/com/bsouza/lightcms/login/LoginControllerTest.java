package com.bsouza.lightcms.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bsouza.lightcms.HomeController;
import com.bsouza.lightcms.login.Login;
import com.bsouza.lightcms.login.LoginController;

import br.com.caelum.vraptor.Result;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

	@Mock private Result result;

	@Mock private Autenticador autenticador;
	
	private LoginController controller;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);		
		controller = new LoginController(result, autenticador);
	}
	
	@Test
	public void deveAutenticarComUsuarioESenhaValidos() {
		Login login = utilizarLogin("bsouza", "teste123");
		autenticacaoDeveTerSucesso(login);
		deveSerRedirecionadoParaHome();
		controller.validar(login);
	}
	
	@Test
	public void deveFalharQuandoASenhaEhInvalida() {
		Login login = utilizarLogin("bsouza", "teste");
		autenticacaoDeveFalhar(login);
		deveSerEncaminhadoParaOLogin();
		controller.validar(login);
		
		deveTerIncluidoMensagemDeFalhaDeAutenticacao();
	}
	
	private Login utilizarLogin(String usuario, String senha) {
		Login login = new Login();
		login.setUsuario(usuario);
		login.setSenha(senha);
		return login;
	}
	
	private void autenticacaoDeveTerSucesso(Login login) {
		when(autenticador.autoriza(login)).thenReturn(EstadoDaAutenticacao.SUCESSO);
	}
	
	private void autenticacaoDeveFalhar(Login login) {
		when(autenticador.autoriza(login)).thenReturn(EstadoDaAutenticacao.FALHA);
	}
	
	private void deveTerIncluidoMensagemDeFalhaDeAutenticacao() {
		verify(result, times(1)).include("mensagem", EstadoDaAutenticacao.FALHA.mensagem());
	}
	
	private void deveSerEncaminhadoParaOLogin() {
		when(result.forwardTo(controller)).thenReturn(controller);
	}
	
	private void deveSerRedirecionadoParaHome() {
		when(result.redirectTo(HomeController.class)).thenReturn(new HomeController());
	}

}