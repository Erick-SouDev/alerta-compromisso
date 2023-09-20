package erick.br.controler;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Usuario;
import erick.br.repository.RepositoryUsuario;
import jakarta.validation.Valid;

@Controller
public class ControleRegistre {

	@Autowired
	RepositoryUsuario repositoryUsuario;

	@GetMapping(value = { "/registrar" })
	public ModelAndView getRegistre(ModelAndView modelAndView) {

		modelAndView.setViewName("views/registre");

		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}

	@PostMapping(value = { "/registrar/usuario" })
	public ModelAndView registrarUsuario(@Valid Usuario usuario, BindingResult result, ModelAndView modelAndView) {

		modelAndView.setViewName("views/registre");

		try {

			if (result.hasErrors()) {
				return modelAndView;
			}

			Usuario user = repositoryUsuario.save(usuario);
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("msg", "usuario salvo com sucesso");

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			modelAndView.addObject("msg", "Email ou Senha Ja Existe ");
		}
		return modelAndView;

	}
}
