package br.com.projetoSenac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetoSenac.domain.Carro;
import br.com.projetoSenac.service.CarroService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	CarroService service;
	
	@GetMapping("/listar")
	public ModelAndView listarCarros() {
		ModelAndView mv = new ModelAndView("carro/paginaListaCarros");
		mv.addObject("carros", service.searchAll());
		return mv;		
	}
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDocumento() {
		ModelAndView mv = new ModelAndView("carro/cadastraCarro");
		mv.addObject("carro", new Carro());
		return mv;		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCarro(Carro carro) {
		service.save(carro);
		return listarCarros();
		
	}
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCarro(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("carro/alterarCarro");
		mv.addObject("carro",  service.search(id));
		return mv;		
	}
	@PostMapping("/alterar")
	public ModelAndView alterarCarro(Carro carro)throws ObjectNotFoundException {
		service.edit(carro);
		return listarCarros();
	}
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarCarro(@PathVariable("id") Integer id){
		service.delete(id); 		
		return listarCarros();
	}
	
	
}
