package erick.br.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Compromisso;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryCompromisso;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ControlerCompromisso {

	@Autowired
	private RepositoryCompromisso repositoryCompromisso;

	@GetMapping(value = { "/compromisso" })
	public ModelAndView evento(HttpServletRequest req, ModelAndView modelAndView) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Compromisso> paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(),
				PageRequest.of(0, 5));
		modelAndView.setViewName("views/agendar");

		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("compromisso", new Compromisso());

		return modelAndView;
	}

	@PostMapping(value = { "/agendar/compromisso" })
	public ModelAndView agendarCompromisso(@ModelAttribute(value = "compromisso") @Valid Compromisso compromisso,
			BindingResult result, HttpServletRequest req, ModelAndView modelAndView) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		modelAndView.setViewName("views/agendar");
		
		
		Page<Compromisso> paginas = null;
		if (result.hasErrors()) {
			paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(),
					PageRequest.of(0, 5));
			modelAndView.addObject("paginas", paginas);
			return modelAndView;

		}
		String msg = null;

		if (compromisso.getId() == null) {
			msg = "SEU COMPROMISSO FOI SALVO  COM SUCESSO";
		} else {
			msg = "SEU COMPROMISSO FOI ATUALISADO COM SUCESSO";
		}
		modelAndView.addObject("compromisso", new Compromisso());
		compromisso.setUsuario(usuario);
		Compromisso comprom = repositoryCompromisso.save(compromisso);

		modelAndView.addObject("msg", msg);
		modelAndView.addObject("compromisso", comprom);
		paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(),PageRequest.of(0, 5));
		modelAndView.addObject("paginas", paginas);
		return modelAndView;

	}

	@GetMapping(value = { "/proxima/pagina" })
	public ModelAndView eventoPaginacao(@PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable,
			HttpServletRequest req, ModelAndView modelAndView) {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Compromisso> paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(),
				pageable);
		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("compromisso", new Compromisso());
		modelAndView.setViewName("views/agendar");
		return modelAndView;
	}

	@SuppressWarnings("unused")
	@PostMapping(value = { "/pesquisar/compromisso" })
	public ModelAndView pesquisarCompromisso(@RequestParam(value = "buscarCompromisso") String buscarCompromisso,
			ModelAndView modelAndView, @PageableDefault(size = 5) org.springframework.data.domain.Pageable pageable, HttpServletRequest req) {
		 modelAndView.addObject("compromisso", new Compromisso());


		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Page<Compromisso> paginas = null;

		if (buscarCompromisso != null && !buscarCompromisso.isEmpty()) {
			paginas = repositoryCompromisso.pesquisarCompromissoPaginadosPorUsuarioLogado(usuario.getId(),
					buscarCompromisso, pageable);
		} else {
			paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(), pageable);
		}

		
		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("buscarCompromisso", buscarCompromisso);
		modelAndView.setViewName("views/agendar");
		return modelAndView;

	}

	@GetMapping(value = { "/editar/{idCompromisso}" })
	public ModelAndView editarCompromisso(@PathVariable(value = "idCompromisso") Long idcompromisso,
			ModelAndView modelAndView, HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		modelAndView.setViewName("views/agendar");
		modelAndView.addObject("compromisso", new Compromisso());


		Page<Compromisso> paginas = repositoryCompromisso.todosCompromissoPaginadosPorUsuarioLogado(usuario.getId(),
				PageRequest.of(0, 5));

		Optional<Compromisso> compromisso = repositoryCompromisso.findById(idcompromisso);
		System.out.println(compromisso);
		modelAndView.addObject("paginas", paginas);
		modelAndView.addObject("compromisso", compromisso);
		return modelAndView;
	}

}
