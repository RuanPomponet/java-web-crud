package br.com.projetoSenac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projetoSenac.domain.Documento;
import br.com.projetoSenac.service.DocumentoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/documento")
public class DocumentoController {
	@Autowired
	DocumentoService service;
	
	@GetMapping("/listar")
	public ModelAndView listarDocumentos() {
		ModelAndView mv = new ModelAndView("documento/paginaListaDocumento");
		mv.addObject("documentos", service.searchAll());
		return mv;		
	}
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDocumento() {
		ModelAndView mv = new ModelAndView("documento/cadastraDocumento");
		mv.addObject("documento", new Documento());
		return mv;		
	}
	
	@PostMapping("/Salvar")
	public ModelAndView salvarDocumento(Documento documento) {
		service.save(documento);
		return listarDocumentos();
		
	}
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarDocumento(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("documento/alteraDocumento");
		mv.addObject("documento", new Documento());
		return mv;		
	}
	@PostMapping("/alterar")
	public ModelAndView alterarDocumento(Documento documento)throws ObjectNotFoundException {
		service.edit(documento);
		return listarDocumentos();
	}
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarDocumento(@PathVariable("id") Integer id){
		service.delete(id); 		
		return listarDocumentos();
	}
	
	
}
