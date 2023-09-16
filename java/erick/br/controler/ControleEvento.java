package erick.br.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Evento;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryEvento;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ControleEvento {

	@Autowired
	private RepositoryEvento repositoryEvento;

	@GetMapping(value = { "/agendar/**" })
	public ModelAndView getEventoPage(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("views/agendar");
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		modelAndView.addObject("evento", new Evento());

		List<Evento> paginasEventos = repositoryEvento.findAllEventosUsuarioLogado(usuario);
		
		PageImpl<Evento> pageImpl = new PageImpl<>(paginasEventos, PageRequest.of(0, 5), paginasEventos.size());
		
		modelAndView.addObject("paginas", pageImpl);

		return modelAndView;
	}

	@PostMapping(value = { "/agendar/evento" })
	public ModelAndView agendarEvento(@Valid Evento evento, BindingResult result, HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		if (result.hasErrors()) {
			modelAndView.setViewName("views/agendar");
			return modelAndView;
		}

		evento.setUsuario(usuario);
		Evento event = repositoryEvento.save(evento);

		modelAndView.addObject("msg", "Evento Agendado Com Sucesso");
		modelAndView.addObject("evento", new Evento());
		modelAndView.addObject("evento", event);
		modelAndView.setViewName("views/agendar");
		return modelAndView;

	}

	/*
	 * @GetMapping(value = { "/eventos/{id}/editar" }) public ModelAndView
	 * editarEvento(@PathParam(value = "id") String id , HttpServletRequest req) {
	 * ModelAndView modelAndView = new ModelAndView("views/agendar");
	 * System.out.println(id); modelAndView.addObject("evento", new Evento());
	 * return modelAndView;
	 * 
	 * }
	 */

}
