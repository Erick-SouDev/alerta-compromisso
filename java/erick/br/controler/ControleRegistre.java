package erick.br.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControleRegistre {

	@GetMapping(value = {"/"})
	public String getRegistre() {
		return "registre";
	}
}
