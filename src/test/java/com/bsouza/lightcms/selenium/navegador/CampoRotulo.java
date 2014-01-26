package com.bsouza.lightcms.selenium.navegador;

import org.openqa.selenium.WebElement;

public class CampoRotulo {

	private WebElement campo;

	public CampoRotulo(WebElement elemento) {
		this.campo = elemento;
	}
	
	public boolean ehIgualA(String mensagem) {
		return this.campo.getText().equals(mensagem);
	}
	
}