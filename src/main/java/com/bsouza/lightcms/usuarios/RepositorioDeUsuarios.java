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

	public Usuario busca(Login login) {		
		DBObject dadosUsuario = colecao.findOne(consulta(login));
		Usuario usuario = null;
		
		if (dadosUsuario != null) {
			usuario = new Usuario((String) dadosUsuario.get("nome"));
		}
		
		return usuario;
	}

	public void salva(Login login) {
		colecao.insert(consulta(login));
	}
	
	public void exclui(Login login) {
		colecao.remove(consulta(login));
	}
	
	private DBObject consulta(Login login) {
		return new FabricaDeConsulta()
			.onde("nome").igualA(login.getUsuario())
			.e("senha").igualA(login.getSenha()).criar();
	}
	
}