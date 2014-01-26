package com.bsouza.lightcms;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextoDaPagina {

	private WebDriver  driver;
	
	public ContextoDaPagina(WebDriver driver) {
		this.driver = driver;
	}
	
	public CampoDeTexto preenchoCampo(String elementoId) {
		return new CampoDeTexto(procuraElemento(elementoId));
	}
	
	public void clicoEm(String elementoId) {
		procuraElemento(elementoId).click();
	}
	
	private WebElement procuraElemento(String elementoId) {
		return driver.findElement(id(elementoId));
	}
	
}