package com.bsouza.lightcms;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class LoginController {

	@Path("/login")
	public void pagina() { }
	
	public void validar() {
		System.out.println("OK");
	}
	
}