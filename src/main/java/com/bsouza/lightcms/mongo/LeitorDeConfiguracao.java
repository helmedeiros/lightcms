package com.bsouza.lightcms.mongo;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class LeitorDeConfiguracao {

	private Yaml yaml = new Yaml();
	
	public Configuracao lerConfiguracaoDoMongo() {
		return (Configuracao) ler("/mongo-config.yml", Configuracao.class);
	}
	
	private <T> Object ler(String nomeDoRecurso, Class<T> classe) {
		return yaml.loadAs(recurso(nomeDoRecurso), classe);
	}
	
	private InputStream recurso(String nomeDoRecurso) {
		return getClass().getResourceAsStream(nomeDoRecurso);
	}
	
}