package com.bsouza.lightcms.paginas;

import org.openqa.selenium.WebDriver;

import com.bsouza.lightcms.selenium.navegador.ConteudoNavegavel;
import com.bsouza.lightcms.selenium.navegador.ContextoDaPagina;

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