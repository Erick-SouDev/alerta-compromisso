package erick.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erick.br.model.Evento;
import erick.br.model.Usuario;

@Repository
@Transactional
public interface RepositoryEvento extends JpaRepository<Evento, Long> {

	@Query("select e from  Evento e where e.usuario= ?1")
	public List<Evento> findAllEventosUsuarioLogado(Usuario usuario);

		
}
