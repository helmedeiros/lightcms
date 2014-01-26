package com.bsouza.lightcms.selenium.navegador;

public class Navegador {

	public static void irPara(ConteudoNavegavel conteudo) {
		conteudo.ir();
	}
	
	public static ContextoDaPagina na(ConteudoNavegavel conteudo) {
		return conteudo.contexto();
	}
	
	public static boolean estouNa(ConteudoNavegavel conteudo) {
		return conteudo.contexto().estouEm(conteudo.endereco());
	}
}