package com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.domain.Professor;
import com.senac.service.ProfessorService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professor")

public class ProfessorController{
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarprofessor")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessor");
		mv.addObject("professores", professorService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		professorService.salvar(professor);
		return listar();
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("professor/alterarProfessor");
		mv.addObject("professor", professorService.buscaPorID(idProfessor));
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Professor professorAlterado) throws ObjectNotFoundException {
		professorService.salvarAlteracao(professorAlterado);
		return listar();
		
	}
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Integer id){
		professorService.excluir(id);
		return listar();
	}
	

}
