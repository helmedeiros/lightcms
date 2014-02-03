package com.bsouza.lightcms.usuarios;

import static com.bsouza.lightcms.selenium.Verificador.verificarQue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.bsouza.lightcms.login.Login;
import com.bsouza.lightcms.mongo.Conexao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class RepositorioDeUsuariosTest {

	@Mock private Conexao conexao;
	@Mock private DBCollection colecao;
	
	private RepositorioDeUsuarios repositorio;

	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		when(conexao.colecao("usuarios")).thenReturn(colecao);
		repositorio = new RepositorioDeUsuarios(conexao);
	}
	
	@Test
	public void deveRetornarNuloQuandoNaoEncontrarUsuario() {
		retornarNuloQuandoPesquisarPorQualquerUsuario();
		
		Usuario usuario = repositorio.pesquisa(new Login("bsouza", "root"));
		verificarQue(usuario == null);
	}
	
	@Test
	public void deveRetornarUmUsuarioQuandoExistirUmCadastradoComMesmoNome() {
		quandoPesquisarPorNomeRetornarDBObjectCom("nome", "bsouza");

		Usuario usuario = repositorio.pesquisa(new Login("bsouza", "root"));
		verificarQue(usuario.getNome().equals("bsouza"));
	}
	
	@Test
	public void deveSalvarUsuarioQuandoNaoExisteUmOutroSalvoComMesmoNome() {
		retornarNuloQuandoPesquisarPorQualquerUsuario();
		boolean salvou = repositorio.salva(new Login("bsouza", "root"));
		verificarQue(salvou);
	}
	
	@Test
	public void naoDeveSalvarQuandoJaExisteUmUsuarioComMesmoNome() {
		quandoPesquisarPorNomeRetornarDBObjectCom("nome", "bsouza");
		boolean naoSalvou = !repositorio.salva(new Login("bsouza", "root"));
		verificarQue(naoSalvou);
	}
	
	@Test
	public void loginDeveSerValidoQuandoExisteUsuarioSalvoComMesmoNomeESenha() {
		quandoPesquisarPorNomeRetornarDBObjectCom("nome", "bsouza");
		Usuario usuario = repositorio.validaLogin(new Login("bsouza", "root"));
		verificarQue(usuario.getNome().equals("bsouza"));
	}
	
	private void quandoPesquisarPorNomeRetornarDBObjectCom(String chave, String valor) {
		DBObject object = new BasicDBObject();
		object.put(chave, valor);
		
		quandoColecaoPesquisarComQualquerArgumento().thenReturn(object);
	}

	private void retornarNuloQuandoPesquisarPorQualquerUsuario() {
		quandoColecaoPesquisarComQualquerArgumento().thenReturn(null);
	}
	
	private OngoingStubbing<DBObject> quandoColecaoPesquisarComQualquerArgumento() {
		return when(colecao.findOne(any(DBObject.class)));
	}

}