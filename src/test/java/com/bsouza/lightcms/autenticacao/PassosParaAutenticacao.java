package com.bsouza.lightcms.autenticacao;

import static org.junit.Assert.*;
import static com.bsouza.lightcms.Navegador.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bsouza.lightcms.PaginaDeLogin;
import com.bsouza.lightcms.PaginaHome;

import cucumber.api.java.Before;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

public class PassosParaAutenticacao {
	
	private WebDriver driver;
	private PaginaHome paginaHome;
	private PaginaDeLogin paginaDeLogin;
	
	@Before
	public void inicializacao() {
		this.driver = new FirefoxDriver();
		this.paginaHome = new PaginaHome(driver);
		this.paginaDeLogin = new PaginaDeLogin(driver);
	}
	
	@Dado("^que estou na página de Login$")
	public void que_estou_na_página_de_Login() throws Throwable {
	    irPara(paginaDeLogin);
	}

	@Quando("^eu informo o usuário \"([^\"]*)\"$")
	public void eu_informo_o_usuário(String nome) throws Throwable {
	    na(paginaDeLogin).preenchoCampo("usuario").com(nome);
	}

	@Quando("^informo a senha \"([^\"]*)\"$")
	public void informo_a_senha(String senha) throws Throwable {
		na(paginaDeLogin).preenchoCampo("senha").com(senha);
	}
	
	@Quando("^clico no botão \"([^\"]*)\"$")
	public void clico_no_botão(String botaoEnviar) throws Throwable {
	    na(paginaDeLogin).clicoEm(botaoEnviar);
	}


	@Então("^devo ser redirecionado para a página Home$")
	public void devo_ser_redirecionado_para_a_página_Home() throws Throwable {
	    assertTrue(estouNa(paginaHome));
	}
	
}