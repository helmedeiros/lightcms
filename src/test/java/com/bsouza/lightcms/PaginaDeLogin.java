package com.bsouza.lightcms;

import org.openqa.selenium.WebDriver;

public class PaginaDeLogin implements ConteudoNavegavel {

	private final WebDriver driver;
	private final String endereco = "http://localhost:8080/lightcms/login";

	public PaginaDeLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void ir() {
		driver.get(endereco);
	}

	public ContextoDaPagina contexto() {
		return new ContextoDaPagina(driver);
	}
	
}