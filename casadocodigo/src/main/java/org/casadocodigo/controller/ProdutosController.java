package org.casadocodigo.controller;

import org.casadocodigo.daos.ProdutoDAO;
import org.casadocodigo.model.Produto;
import org.casadocodigo.model.TipoPrecoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		System.out.println("Entrando no controller form =D");
		modelAndView.addObject("tipos", TipoPrecoEnum.values());
		
		return modelAndView;
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {

		System.out.println(produto.getTitulo());
		System.out.println(produto.getDescricao());
		System.out.println(produto.getPaginas());
		
		produtoDao.gravar(produto);
		
		return "produtos/ok";
	}
}
