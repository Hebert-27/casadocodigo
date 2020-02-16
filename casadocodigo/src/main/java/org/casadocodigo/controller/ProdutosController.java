package org.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {
	
	@RequestMapping("/produtos/form")
	public String form() {
		System.out.println("Entrando no controller form =D");
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String gravar(String titulo, String descricao, int paginas) {
		System.out.println(titulo);
		System.out.println(descricao);
		System.out.println(paginas);
		
		return "produtos/ok";
	}
}
