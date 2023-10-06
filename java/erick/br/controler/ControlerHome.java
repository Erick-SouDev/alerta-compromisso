package erick.br.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.dto.CompromissoDTO;
import erick.br.model.Compromisso;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryCompromisso;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ControlerHome {

	@Autowired
	private RepositoryCompromisso repositoryCompromisso;
	@Autowired
	private static ModelMapper modelMapper;

	@GetMapping(value = "/home")
	public ModelAndView getHome(HttpServletRequest request, ModelAndView modelAndView) {
		modelAndView.setViewName("views/home");
		Usuario usuarioLogadoNaSessao = (Usuario) request.getSession().getAttribute("usuario");


		List<CompromissoDTO> compromissos = repositoryCompromisso
				.findAllCompromissoPorUsuarioLogado(usuarioLogadoNaSessao).stream()
				.map(comproDto -> modelMapper.map(comproDto, CompromissoDTO.class)).toList();
			
		
		compromissos.forEach(c->{
			System.out.println(c);
		});

		return modelAndView;

	}

}
