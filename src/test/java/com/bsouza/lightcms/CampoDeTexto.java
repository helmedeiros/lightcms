package com.bsouza.lightcms;

import org.openqa.selenium.WebElement;

public class CampoDeTexto {

	private WebElement campo;

	public CampoDeTexto(WebElement campo) {
		this.campo = campo;
	}
	
	public void com(String valor) {
		this.campo.sendKeys(valor);
	}
	
	public void limpar() {
		this.campo.clear();
	}
	
}