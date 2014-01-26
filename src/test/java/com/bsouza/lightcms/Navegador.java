package com.bsouza.lightcms;

public class Navegador {

	public static void irPara(ConteudoNavegavel conteudo) {
		conteudo.ir();
	}
	
	public static ContextoDaPagina na(ConteudoNavegavel conteudo) {
		return conteudo.contexto();
	}
	
}