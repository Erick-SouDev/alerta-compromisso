package erick.br.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erick.br.model.Usuario;

@Repository
@Transactional
public interface RepositoryUsuario  extends CrudRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.email = ?1 and u.senha = ?2")
	public Usuario verificarAutenticacao(String email ,  String senha);
}
