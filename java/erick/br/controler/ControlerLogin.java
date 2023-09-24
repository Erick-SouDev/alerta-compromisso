package erick.br.controler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.dto.CompromissoDTO;
import erick.br.model.Usuario;
import erick.br.repository.RepositoryCompromisso;
import erick.br.repository.RepositoryUsuario;
import erick.br.services.ServicesDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControlerLogin {

	@Autowired
	private RepositoryUsuario repositoryUsuario;
	

	@GetMapping(value = { "/" })
	public String getLogin() {
		return "login";
	}

	@PostMapping(value = "/login")
	public ModelAndView autenticarUsuario(String email, String senha, HttpSession session, ModelAndView modelAndView) {
		Usuario usuario = repositoryUsuario.verificarAutenticacao(email, senha);
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

	@GetMapping(value = { "/home" })
	public String voltar() {
		
		return "views/home";
	}
}
