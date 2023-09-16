package erick.br.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
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

	/*default  Page<Evento> carregarEventosDoUsuarioLogadoPaginado(Long usuarioLogado, org.springframework.data.domain.Pageable pageable) {

		Usuario usuario = new Usuario();
		usuario.setId(usuarioLogado);
		Evento evento = new Evento();
		evento.setUsuario(usuario);
		//paginnacao por usuario logado aqui e feita um  consulta na tabela eventos passando o usuario logado so carrega os eventos desse ususrio 
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("usuario_id", GenericPropertyMatcher.of(StringMatcher.CONTAINING , false ).contains());
		Example<Evento> example = Example.of(evento , exampleMatcher);
		
		return findAll(example, pageable);
*/



}
