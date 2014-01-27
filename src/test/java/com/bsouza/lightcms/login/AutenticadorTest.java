package com.bsouza.lightcms.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bsouza.lightcms.usuarios.RepositorioDeUsuarios;
import com.bsouza.lightcms.usuarios.Usuario;

import static com.bsouza.lightcms.selenium.Verificador.*;
import static org.mockito.Mockito.*;

public class AutenticadorTest {

	@Mock private RepositorioDeUsuarios repositorio;
	
	private Autenticador autenticador;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		autenticador = new Autenticador(repositorio);
	}
	
	@Test
	public void deveAutorizarUsuarioValido() {
		Login login = usaLogin("bsouza", "teste123");
		repositorioDeveRetornar(login);
		verificarQue(autenticador.autoriza(login).equals(EstadoDaAutenticacao.SUCESSO));
	}
	
	public void repositorioDeveRetornar(Login login) {
		when(repositorio.validaLogin(login)).thenReturn(new Usuario(login.getUsuario()));
	}
	
	public Login usaLogin(String usuario, String senha) {
		Login login = new Login();
		login.setUsuario(usuario);
		login.setSenha(senha);
		return login;
	}

}