package erick.br.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import erick.br.dto.CompromissoDTO;
import erick.br.model.Compromisso;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryCompromisso;

@Service
@Component
public class ServicesDTO implements Serializable {
	@Autowired
	private static ModelMapper mapperModelMapper;
	@Autowired
	private RepositoryCompromisso repositoryCompromisso;

	@SuppressWarnings("unchecked")
	public List<CompromissoDTO> convertEventListDTO(Usuario usuarioLogado) {

		return this.repositoryCompromisso.findAllCompromissoPorUsuarioLogado(usuarioLogado).stream()
				.map(evento -> mapperModelMapper.map(evento, CompromissoDTO.class)).collect(Collectors.toList());

	}
}
