package com.bsouza.lightcms.mongo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class FabricaDeConsulta {

	private List<Declaracao> declaracoes = new ArrayList<Declaracao>();
	
	public Declaracao onde(String atributo) {
		Declaracao declaracao = new Declaracao(atributo, this);
		this.declaracoes.add(declaracao);
		return declaracao;
	}
	
	public Declaracao e(String atributo) {
		return onde(atributo);
	}
	
	public DBObject criar() {
		BasicDBObject consulta = new BasicDBObject();
		
		for (Declaracao declaracao : declaracoes) {
			consulta.append(declaracao.atributo(), declaracao.valor());
		}
		
		return consulta;
	}
	
}