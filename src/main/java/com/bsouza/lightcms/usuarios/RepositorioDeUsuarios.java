package com.bsouza.lightcms.usuarios;

import br.com.caelum.vraptor.ioc.Component;

import com.bsouza.lightcms.login.Login;
import com.bsouza.lightcms.mongo.Conexao;
import com.bsouza.lightcms.mongo.FabricaDeConsulta;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Component
public class RepositorioDeUsuarios {

	private final DBCollection colecao;

	public RepositorioDeUsuarios(Conexao conexao) {
		this.colecao = conexao.colecao("usuarios"); 
	}

	public Usuario validaLogin(Login login) {		
		return pesquisaPadrao(consultaComSenha(login));
	}
	
	public Usuario pesquisa(Login login) {
		return pesquisaPadrao(consultaPorNome(login));
	}
	
	private Usuario pesquisaPadrao(DBObject consulta) {
		DBObject dadosUsuario = colecao.findOne(consulta);
		return (dadosUsuario != null) ? new Usuario((String) dadosUsuario.get("nome")) : null;
	}

	public boolean salva(Login login) {
		Usuario usuario = pesquisa(login);
		
		if (usuario == null) { 
			colecao.insert(consultaPorNome(login)); 
		}
		
		return (usuario == null);
	}
	
	public void exclui(Login login) {
		colecao.remove(consultaPorNome(login));
	}
	
	private DBObject consultaPorNome(Login login) {
		return new FabricaDeConsulta().onde("nome").igualA(login.getUsuario()).criar();
	}
	
	private DBObject consultaComSenha(Login login) {
		return new FabricaDeConsulta()
			.onde("nome").igualA(login.getUsuario())
			.e("senha").igualA(login.getSenha()).criar();
	}
	
}