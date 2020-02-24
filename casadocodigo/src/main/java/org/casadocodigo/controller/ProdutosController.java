package org.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.casadocodigo.daos.ProdutoDAO;
import org.casadocodigo.model.Produto;
import org.casadocodigo.model.TipoPrecoEnum;
import org.casadocodigo.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		System.out.println("Entrando no controller form =D");
		modelAndView.addObject("tipos", TipoPrecoEnum.values());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttibutes) {
		
		if(result.hasErrors()) {
			return form(produto);
		}
		
		produtoDao.gravar(produto);
		redirectAttibutes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		List<Produto> produtos = produtoDao.listar();
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
}
