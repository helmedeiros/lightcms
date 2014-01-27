package com.bsouza.lightcms.mongo;

public class Declaracao {

	private String atributo;
	private Object valor;
	private FabricaDeConsulta fabricaDeOrigem;
	
	public Declaracao(String atributo, FabricaDeConsulta fabrica) {
		this.atributo = atributo;
		this.fabricaDeOrigem = fabrica;
	}
	
	public FabricaDeConsulta igualA(Object valor) {
		this.valor = valor;
		return fabricaDeOrigem;
	}
	
	public String atributo() {
		return atributo;
	}
	
	public Object valor() {
		return valor;
	}
	
}