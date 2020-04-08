package br.com.projetoSenac.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.projetoSenac.domain.Carro;
import br.com.projetoSenac.domain.Documento;
import br.com.projetoSenac.service.CarroService;
import br.com.projetoSenac.service.DocumentoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	CarroService carroService;
	
	@Autowired
	DocumentoService documentoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		
		
		Carro pc1 = new Carro();
		pc1.setAno(2010);
		pc1.setMarca("Honda");
		pc1.setNome("Honda civic");
		carroService.save(pc1);
		
		Documento doc1 = new Documento();
		doc1.setCodigo("Honda");
		doc1.setNome("Honda civic");
		documentoService.save(doc1);
		
			
		
		
	}
	
	
	
}