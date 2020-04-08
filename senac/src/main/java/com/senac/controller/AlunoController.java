package com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.senac.domain.Aluno;
import com.senac.service.AlunoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listarAlunos")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
		mv.addObject("alunos", alunoService.listar());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("aluno/cadastraAluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView("aluno/cadastraAluno");
		alunoService.salvar(aluno);
		return listar();
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno", alunoService.buscaPorID(idAluno));
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno alunoAlterado) throws ObjectNotFoundException {
		alunoService.salvarAlteracao(alunoAlterado);
		return listar();
		
	}
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Integer id){
		alunoService.excluir(id);
		return listar();
	}
}
