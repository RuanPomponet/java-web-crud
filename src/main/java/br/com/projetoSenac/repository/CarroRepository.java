package br.com.projetoSenac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSenac.domain.Carro;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
