package com.bsouza.lightcms;

import org.openqa.selenium.WebDriver;

public class PaginaHome implements ConteudoNavegavel {

	private final WebDriver driver;
	private final String endereco = "http://localhost:8080/lightcms/";

	public PaginaHome(WebDriver driver) {
		this.driver = driver;
	}

	public void ir() {
		driver.get(endereco);
	}

	public ContextoDaPagina contexto() {
		return new ContextoDaPagina(driver);
	}

	public String endereco() {
		return endereco;
	}
	
}