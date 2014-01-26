package com.bsouza.lightcms;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {

	private Result result;

	public LoginController(Result result) {
		this.result = result;
	}
	
	@Get("/login")
	public void index() { }
	
	@Post("/login/validar")
	public void validar() {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
		result.redirectTo(HomeController.class).index();
	}
	
}