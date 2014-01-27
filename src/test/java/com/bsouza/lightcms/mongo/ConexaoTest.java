package com.bsouza.lightcms.mongo;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import com.bsouza.lightcms.mongo.Conexao;
import com.bsouza.lightcms.mongo.LeitorDeConfiguracao;

public class ConexaoTest {

	private LeitorDeConfiguracao leitor;

	@Before
	public void inicializacao() {
		leitor = new LeitorDeConfiguracao();
	}
	
	@Test
	public void testaInicializacaoDaConexaoComBancoLocal() throws UnknownHostException {
		assertNotNull(new Conexao(leitor));
	}

}