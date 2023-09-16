package erick.br.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Usuario;
import erick.br.repository.RepositoryUsuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControlerLogin {

	@Autowired
	RepositoryUsuario repositoryParticipante;

	@GetMapping(value = { "/login" })
	public String getLogin() {

		return "login";
	}

	@GetMapping(value = { "/home" })
	public String voltar() {

		return "views/home";
	}

	@PostMapping(value = "/autenticar")
	public ModelAndView autenticarUsuario(String email, String senha, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = repositoryParticipante.verificarAutenticacao(email, senha);
		if (usuario == null) {
			modelAndView.addObject("erro", "Usuario invalido ");
			modelAndView.setViewName("login");

		} else {
			session.setAttribute("usuario", usuario);
			modelAndView.setViewName("views/home");

		}

		return modelAndView;

	}

	@GetMapping(value = { "/logout" })
	public String logout(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		session.invalidate();
		return "/login";

	}
}
