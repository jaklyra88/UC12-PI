package br.com.LinkSystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import br.com.LinkSystem.dao.ResidenciaDao;
import br.com.LinkSystem.model.Residencia;

@Controller
public class ResidenciaController {
	
	@Autowired
	public ResidenciaDao residenciaRepositorio;
	

	@GetMapping("/inserirResidencias")
	public ModelAndView insertResidencia(Residencia residencia) {
		ModelAndView mv = new ModelAndView();
			mv.setViewName("Residencia/formResidencia");
			mv.addObject("residencia", new Residencia());
			return mv;
	}

	
	//INSERINDO DADOS DA RESIDENCIA
	@PostMapping("insertResidencia")
	public ModelAndView inserirResidencia(@Valid Residencia residencia, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("Residencia/formResidencia");
			mv.addObject("residencia");
		}else {
			mv.setViewName("redirect:/residencias-adicionadas");
			residenciaRepositorio.save(residencia);
		}
		
		return mv;
	}
	

	
	
	
	//ACESSANDO A PAGINA DE ULTIMAS RESIDENCIAS CADASTRADAS
	@GetMapping("residencias-adicionadas")
	public ModelAndView listagemResidencias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Residencia/listResidencias");
		mv.addObject("residenciasList", residenciaRepositorio.findAll());
		return mv;
				
	}
		
	
	
	@GetMapping("/alterarResidencia/{id}")
	public ModelAndView alterarResidencia(@PathVariable ("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Residencia/alterarResidencia");
		Residencia residencia  = residenciaRepositorio.getOne(id);
		mv.addObject("residencia",residencia);
		return mv;
				
		
	}
	
	@PostMapping("/alterarResidencia")
	public ModelAndView alterarResidencia(Residencia residencia) {
		ModelAndView mv = new ModelAndView();
		residenciaRepositorio.save(residencia);
		mv.setViewName("redirect:/residencias-adicionadas");
		return mv;
	}
	
	@GetMapping("excluirResidencia/{id}")
	public String excluirResidencia(@PathVariable("id") Integer id) {
		residenciaRepositorio.deleteById(id);
		return "redirect:/residencias-adicionadas";
	}
	
	//PESQUISA DE RESIDENCIA NO PAINEL INDEX - BUSCANDO OBJETO RESIDENCIA
		@PostMapping("pesquisar-residencia")
		public ModelAndView pesquisarResidencia(@RequestParam(required = false) Integer numero) {
			ModelAndView mv = new ModelAndView();
			List<Residencia> listaResidencias;//RECEBENDO LISTA DE RESIDENCIAS PELO DAO
			if(numero == null) {
				listaResidencias = residenciaRepositorio.findAll();// SE A PESQUISA ESTIVER EM BRANCO RETORNA TODOS OS MORADORES
			}else {
				listaResidencias = residenciaRepositorio.findByNumero(numero);
			}
			
				mv.addObject("ListaDeResidencias", listaResidencias);
				mv.setViewName("Residencia/pesquisaResidencia-resultado");
				return mv;
		}
		
	}



