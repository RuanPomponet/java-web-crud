package br.com.projetoSenac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSenac.domain.Documento;
import br.com.projetoSenac.repository.DocumentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository repository;
	
	public Documento search(Integer id) throws ObjectNotFoundException{
		Optional<Documento> documento = repository.findById(id);
		
		return documento.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado o: " + id + "do tipo!" + Documento.class.getName()));
		
	}
	
	public List<Documento> searchAll(){
		return repository.findAll();
		
	}
	public Documento save(Documento documento) {
		return repository.save(documento);
		
	}
	public List<Documento> saveAll(List<Documento> documento) {
		return repository.saveAll(documento);
		
	}
	
	public Documento edit (Documento documento) throws ObjectNotFoundException{
		Documento documentoAntigo = search(documento.getId());
		
		documentoAntigo.setId(documento.getId());
		documentoAntigo.setNome(documento.getNome());
		documentoAntigo.setCodigo(documento.getCodigo());
		
		return save(documentoAntigo);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}
	
	
}
