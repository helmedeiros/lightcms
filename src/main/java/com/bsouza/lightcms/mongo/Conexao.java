package com.bsouza.lightcms.mongo;

import java.net.UnknownHostException;

import br.com.caelum.vraptor.ioc.Component;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Component
public class Conexao {
	
	private DB mongo;

	public Conexao(LeitorDeConfiguracao leitorDeConfiguracao) throws UnknownHostException {
		Configuracao configuracao = leitorDeConfiguracao.lerConfiguracaoDoMongo();
		mongo = new MongoClient(configuracao.getHost(), configuracao.getPorta()).getDB(configuracao.getBase());
		mongo.authenticate(configuracao.getUsuario(), configuracao.getSenha().toCharArray());
	}
	
	public DBCollection colecao(String nome) {
		return mongo.getCollection(nome);
	}

}