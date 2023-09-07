package erick.br.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Participante;
import erick.br.repository.RepositoryParticipante;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControlerPaginaLogin {

	@Autowired
	RepositoryParticipante repositoryParticipante;

	@GetMapping(value = { "/login" })
	public String getLogin() {

		return "login";
	}

	@PostMapping(value = "/autenticar")
	public ModelAndView autenticarUsuario(String email, String senha, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Participante partici = repositoryParticipante.verificarAutenticacao(email, senha);

		if (partici == null) {
			modelAndView.addObject("erro", "Usuario invalido ");
			modelAndView.setViewName("login");

		} else {
			session.setAttribute("participante", partici);
			modelAndView.setViewName("views/home");

		}

		return modelAndView;

	}
}
