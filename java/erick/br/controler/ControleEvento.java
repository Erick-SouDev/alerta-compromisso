package erick.br.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Evento;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryEvento;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class ControleEvento {

	@Autowired
	private RepositoryEvento repositoryEvento;

	@GetMapping(value = { "/evento" })
	public ModelAndView evento(HttpServletRequest req, ModelAndView modelAndView) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Evento> paginas = repositoryEvento.todosEventosPaginadosPorUsuarioLogado(usuario.getId(), PageRequest.of(0, 5));

		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("evento", new Evento());
		modelAndView.setViewName("views/agendar");
		return modelAndView;
	}

	@PostMapping(value = { "/evento/agendar" })
	public ModelAndView agendarEvento(@Valid Evento evento, BindingResult result, HttpServletRequest req,
			ModelAndView modelAndView) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		Page<Evento> paginas = null;

		modelAndView.setViewName("views/agendar");

		if (result.hasErrors()) {
			paginas = repositoryEvento.todosEventosPaginadosPorUsuarioLogado(usuario.getId(), PageRequest.of(0, 5));
			modelAndView.addObject("paginas", paginas);
			return modelAndView;

		} else {
			evento.setUsuario(usuario);
			Evento event = repositoryEvento.save(evento);
			paginas = repositoryEvento.todosEventosPaginadosPorUsuarioLogado(usuario.getId(), PageRequest.of(0, 5));
			modelAndView.addObject("paginas", paginas);
			modelAndView.addObject("msg", "Seu evento foi agendado");
			modelAndView.addObject("evento", event);
			modelAndView.addObject("evento", new Evento());
			return modelAndView;
		}

	}

	@GetMapping(value = { "/proxima/pagina" })
	public ModelAndView eventoPaginacao(@PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable,
			HttpServletRequest req, ModelAndView modelAndView) {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Evento> paginas = repositoryEvento.todosEventosPaginadosPorUsuarioLogado(usuario.getId(), pageable);
		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("evento", new Evento());
		modelAndView.setViewName("views/agendar");
		return modelAndView;
	}

	@SuppressWarnings("unused")
	@PostMapping(value = { "/pesquisar" })
	public ModelAndView pesquisarEvento(@RequestParam(value = "buscarEvento") String buscarEvento,
			ModelAndView modelAndView, @PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable,
			HttpServletRequest req) {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Evento> paginas = null;
		
		if (buscarEvento != null ||  (buscarEvento == null && !buscarEvento.isEmpty())) {
			paginas = repositoryEvento.pesquisarEventosPaginadosPorUsuarioLogado(usuario.getId(), buscarEvento, pageable);
		}else {
			paginas = repositoryEvento.todosEventosPaginadosPorUsuarioLogado(usuario.getId(), pageable);
		}

		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("buscarEvento", buscarEvento);
		modelAndView.addObject("evento", new Evento());
		modelAndView.setViewName("views/agendar");
		return modelAndView;

	}

}
