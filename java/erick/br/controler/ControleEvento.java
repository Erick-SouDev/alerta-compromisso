package erick.br.controler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeExpansionListener;

import org.springframework.beans.factory.annotation.Autowired;
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
import jakarta.websocket.server.PathParam;

@Controller
public class ControleEvento {

	@Autowired
	private RepositoryEvento repositoryEvento;
	
	@GetMapping(value = { "/agendar" })
	public ModelAndView getEventoPage( HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("views/agendar");
		modelAndView.addObject("evento", new Evento());
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		modelAndView.addObject("listaEventos", repositoryEvento.findAllEventosUsuarioLogado(usuario));

		return modelAndView;
	}

	@PostMapping(value = { "/agendar/evento" })
	public ModelAndView agendarEvento(@Valid Evento evento, BindingResult result, HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		if (result.hasErrors()) {
			modelAndView.setViewName("views/agendar");
			modelAndView.addObject("listaEventos", repositoryEvento.findAllEventosUsuarioLogado(usuario));

			return modelAndView;
		}

		evento.setUsuario(usuario);
		Evento event = repositoryEvento.save(evento);

		modelAndView.addObject("msg", "Evento Agendado Com Sucesso");
		modelAndView.addObject("listaEventos", repositoryEvento.findAllEventosUsuarioLogado(usuario));
		modelAndView.addObject("evento", new Evento());
		modelAndView.addObject("evento", event);
		modelAndView.setViewName("views/agendar");
		return modelAndView;

	}
	
	
	

	/*@GetMapping(value = { "/eventos/{id}/editar" })
	public ModelAndView editarEvento(@PathParam(value = "id") String id , HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("views/agendar");
		System.out.println(id);
		modelAndView.addObject("evento", new Evento());
		return modelAndView;

	}*/

}

 
