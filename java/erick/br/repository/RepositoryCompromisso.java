package erick.br.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erick.br.model.Compromisso;
import erick.br.model.Usuario;

@Repository
@Transactional
public interface RepositoryCompromisso extends JpaRepository<Compromisso, Long> {

	@Query("select e from Compromisso e where e.usuario = ?1 ")
	public  List<Compromisso> findAllCompromissoPorUsuarioLogado(@Param("usuario") Usuario usuario);

	
	
	public default Page<Compromisso> pesquisarCompromissoPaginadosPorUsuarioLogado(Long usuarioLogado, String nomeCompromisso,
			Pageable pageable) {

		Compromisso compromisso = new Compromisso();
		compromisso.setUsuario(new Usuario(usuarioLogado));
		compromisso.setNomeCompromisso(nomeCompromisso);

		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
				.withMatcher("usuario", GenericPropertyMatcher.of(StringMatcher.CONTAINING, false))
				.withMatcher("nomeCompromisso",
						GenericPropertyMatcher.of(StringMatcher.CONTAINING, false).startsWith().ignoreCase());
		Example<Compromisso> example = Example.of(compromisso, exampleMatcher);

		return findAll(example, pageable);

	}

	public default Page<Compromisso> todosCompromissoPaginadosPorUsuarioLogado(Long usuarioLogado, Pageable pageable) {

		Compromisso compromisso = new Compromisso();
		compromisso.setUsuario(new Usuario(usuarioLogado));

		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("usuario_id",
				GenericPropertyMatcher.of(StringMatcher.CONTAINING, false).contains());

		Example<Compromisso> example = Example.of(compromisso, exampleMatcher);
		return findAll(example, pageable);
	}

}
