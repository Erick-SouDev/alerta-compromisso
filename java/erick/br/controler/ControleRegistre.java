package erick.br.controler;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Participante;
import erick.br.repository.RepositoryParticipante;
import jakarta.validation.Valid;

@Controller
public class ControleRegistre {

	@Autowired
	RepositoryParticipante repositoryParticipante;

	@GetMapping(value = { "/" })
	public ModelAndView getRegistre() {

		ModelAndView mAndView = new ModelAndView("registre");
		mAndView.addObject("participante", new Participante());
		return mAndView;
	}

	@GetMapping(value = { "/evento" })
	public ModelAndView getEvento() {

		ModelAndView mAndView = new ModelAndView("views/cadastroevento");
		return mAndView;
	}

	@GetMapping(value = { "/login" })
	public String getLogin() {

		return "login";
	}

	@PostMapping(value = { "/registrar/usuario" })
	public ModelAndView registrarUsuario(@Valid Participante participante, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView("registre");
		// validar usuario
		if (result.hasErrors()) {
			return modelAndView;
		}

		Participante particip = repositoryParticipante.save(participante);

		if (particip.getId() != null) {
			modelAndView.addObject("participante", new Participante());
			modelAndView.addObject("msg", "usuario salvo com sucesso");

		}
		return modelAndView;
	}
}
