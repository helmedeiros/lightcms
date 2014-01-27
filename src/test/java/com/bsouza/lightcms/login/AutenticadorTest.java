package com.bsouza.lightcms.login;

import org.junit.Before;
import org.junit.Test;

import static com.bsouza.lightcms.selenium.Verificador.*;

public class AutenticadorTest {

	private Autenticador autenticador;

	@Before
	public void inicializacao() {
		autenticador = new Autenticador();
	}
	
	@Test
	public void deveAutorizarUsuarioValido() {
		Login login = new Login();
		login.setUsuario("bsouza");
		login.setSenha("teste123");
		
		verificarQue(autenticador.autoriza(login).equals(EstadoDaAutenticacao.SUCESSO));
	}

}