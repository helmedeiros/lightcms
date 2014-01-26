package com.bsouza.lightcms;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class HomeController {

	@Get("/")
	public void index() { }
	
}