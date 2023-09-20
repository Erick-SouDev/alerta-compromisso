package erick.br.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erick.br.model.Evento;
import erick.br.model.Usuario;

@Repository
@Transactional
public interface RepositoryEvento extends JpaRepository<Evento, Long> {

	public default Page<Evento> pesquisarEventosPaginadosPorUsuarioLogado(Long usuarioLogado, String nomeEvento , Pageable  pageable){
		
		
		Evento evento = new Evento();
		evento.setUsuario(new Usuario(usuarioLogado));
		evento.setNomeEvento(nomeEvento);

		ExampleMatcher exampleMatcher = ExampleMatcher
				.matchingAll().withMatcher("usuario", GenericPropertyMatcher.of(StringMatcher.CONTAINING , false))
				.withMatcher("nomeEvento", GenericPropertyMatcher.of(StringMatcher.CONTAINING , false).startsWith().ignoreCase()); 
		Example<Evento> example = Example.of(evento, exampleMatcher);
		
		
		return findAll(example, pageable);
		
	}

	
	public default Page<Evento> todosEventosPaginadosPorUsuarioLogado(Long usuarioLogado , Pageable pageable) {

		Evento evento = new Evento();
		evento.setUsuario(new Usuario(usuarioLogado));

		
		ExampleMatcher exampleMatcher = ExampleMatcher
				.matchingAny().withMatcher("usuario_id", GenericPropertyMatcher
				.of(StringMatcher.CONTAINING , false).contains()); 
		
		Example<Evento> example = Example.of(evento, exampleMatcher);
					
				
		return findAll(example, pageable);
	}

}
