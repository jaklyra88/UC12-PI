package br.com.LinkSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.LinkSystem.model.Morador;
import br.com.LinkSystem.model.Residencia;
import br.com.LinkSystem.model.Veiculo;

//TRATANDO AS REQUISIÇÕES FEITAS PARA A PÁGINA
@Controller
public class HomeController {
	
	//MÉTODO INDEX PARA INICIAR A SESSÃO DO USUÁRIO 
		@GetMapping("/")
		public ModelAndView index() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/home/index");
			//INSTANCIANDO OS OBJETOS PARA INICIAR A CRIAÇÃO E PESQUISA VIA MODAL
			mv.addObject("morador", new Morador());
			mv.addObject("veiculo", new Veiculo());
			mv.addObject("residencia", new Residencia());
			return mv;
		}
		
	

}
