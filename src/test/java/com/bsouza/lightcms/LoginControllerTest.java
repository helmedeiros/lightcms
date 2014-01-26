package com.bsouza.lightcms;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

	@Mock
	private Result result;
	
	private LoginController controller;	

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);		
		
		controller = new LoginController(result);
		
		when(result.redirectTo(HomeController.class)).thenReturn(new HomeController());
	}
	
	@Test
	public void deveFalharQuandoASenhaEhInvalida() {
		Login usuario = new Login();
		usuario.setUsuario("bsouza");
		usuario.setSenha("teste123");
		
		controller.validar(usuario);
	}

}