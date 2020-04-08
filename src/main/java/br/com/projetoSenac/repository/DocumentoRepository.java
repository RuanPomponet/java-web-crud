package br.com.projetoSenac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.projetoSenac.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
