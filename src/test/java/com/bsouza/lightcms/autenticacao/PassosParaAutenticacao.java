package com.bsouza.lightcms.autenticacao;

import static com.bsouza.lightcms.selenium.Verificador.verificarQue;
import static com.bsouza.lightcms.selenium.navegador.Navegador.estouNa;
import static com.bsouza.lightcms.selenium.navegador.Navegador.irPara;
import static com.bsouza.lightcms.selenium.navegador.Navegador.na;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bsouza.lightcms.paginas.PaginaDeLogin;
import com.bsouza.lightcms.paginas.PaginaHome;

import cucumber.api.java.After;
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
		String enderecoDriver = new File(System.getProperty("user.dir"), "src/test/resources/chromedriver").getPath();
		System.setProperty("webdriver.chrome.driver", enderecoDriver);
		
		this.driver = new ChromeDriver();
		this.paginaHome = new PaginaHome(driver);
		this.paginaDeLogin = new PaginaDeLogin(driver);
	}
	
	@After
	public void fecharNavegador() {
		this.driver.close();
	}
	
	@Dado("^que estou na página de login$")
	public void que_estou_na_página_de_login() throws Throwable {
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
	    verificarQue(estouNa(paginaHome));
	}

	@Então("^devo ver a mensagem \"([^\"]*)\"$")
	public void ver_a_mensagem(String mensagemDeAutenticacaoInvalida) throws Throwable {
		verificarQue(na(paginaDeLogin).aMensagem("mensagem-de-erro").ehIgualA(mensagemDeAutenticacaoInvalida));
	}

	
}