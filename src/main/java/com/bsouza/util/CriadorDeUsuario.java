package com.bsouza.util;

import java.net.UnknownHostException;

import com.bsouza.lightcms.login.Login;
import com.bsouza.lightcms.mongo.Conexao;
import com.bsouza.lightcms.mongo.LeitorDeConfiguracao;
import com.bsouza.lightcms.usuarios.RepositorioDeUsuarios;

public class CriadorDeUsuario {

	public static void main(String[] args) throws UnknownHostException {
		Conexao conexao = new Conexao(new LeitorDeConfiguracao());
		RepositorioDeUsuarios repositorio = new RepositorioDeUsuarios(conexao);
		repositorio.salva(new Login("bsouza", "root"));
	}
	
}