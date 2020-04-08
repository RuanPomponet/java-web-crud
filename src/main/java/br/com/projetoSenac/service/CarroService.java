package br.com.projetoSenac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSenac.domain.Carro;
import br.com.projetoSenac.repository.CarroRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CarroService {

	@Autowired
	CarroRepository repository;
	
	public Carro search(Integer id) throws ObjectNotFoundException{
		Optional<Carro> carro = repository.findById(id);
		
		return carro.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado o: " + id + "do carro!" + Carro.class.getName()));
		
	}
	
	public List<Carro> searchAll(){
		return repository.findAll();
		
	}
	public Carro save(Carro carro) {
		return repository.save(carro);
		
	}
	public List<Carro> saveAll(List<Carro> carro) {
		return repository.saveAll(carro);
		
	}
	
	public Carro edit (Carro carro) throws ObjectNotFoundException{
		Carro carroAntigo = search(carro.getId());
		
		carroAntigo.setId(carro.getId());
		carroAntigo.setNome(carro.getNome());
		carroAntigo.setMarca(carro.getMarca());
		carroAntigo.setAno(carro.getAno());
		
		return save(carroAntigo);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}
	
	
}
