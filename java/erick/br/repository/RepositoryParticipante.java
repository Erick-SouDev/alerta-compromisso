package erick.br.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erick.br.model.Participante;

@Repository
@Transactional
public interface RepositoryParticipante  extends CrudRepository<Participante, Long> {

	@Query("select p from Participante p where p.email = ?1 and p.senha = senha")
	public Participante verificarAutenticacao(String email ,  String senha);
}
