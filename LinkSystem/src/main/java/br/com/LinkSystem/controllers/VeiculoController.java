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

import br.com.LinkSystem.dao.VeiculoDao;
import br.com.LinkSystem.model.Veiculo;

@Controller
public class VeiculoController {
	
	@Autowired
	public VeiculoDao veiculoRepositorio;
	
	@GetMapping("/inserirVeiculos")
	public ModelAndView insertVeiculo(Veiculo veiculo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Veiculo/formVeiculo");
		mv.addObject("veiculo", new Veiculo () );
		return mv;
				
	}
	
	//INSERIR CADASTRO DE VEÍCULOS
	@PostMapping("insertVeiculo")
	public ModelAndView inserirVeiculo(@Valid Veiculo veiculo, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("Veiculo/formVeiculo");
			mv.addObject("veiculo");
		}else {
		mv.setViewName("redirect:/veiculos-adicionados");
		veiculoRepositorio.save(veiculo);
		}
		return mv;
				
	}
	
	//ACESSANDO A PAGINA DE ULTIMOS VEICULOS CADASTRADOS
	@GetMapping("veiculos-adicionados")
	public ModelAndView listagemVeiculos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Veiculo/listVeiculos");
		mv.addObject("veiculosList", veiculoRepositorio.findAll());
		return mv;
	}
	
	
	@GetMapping("/alterarVeiculo/{id}")
	public ModelAndView alterarVeiculo(@PathVariable("id") Integer id) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Veiculo/alterarVeiculo");
		Veiculo veiculo = veiculoRepositorio.getOne(id);
		mv.addObject("veiculo" , veiculo);
		return mv;
	}
	
	@PostMapping("/alterarVeiculo")
	public ModelAndView alterarVeiculo(Veiculo veiculo) {
		ModelAndView mv = new ModelAndView();
		veiculoRepositorio.save(veiculo);
		mv.setViewName("redirect:/veiculos-adicionados");
		return mv;
	}
	
	@GetMapping("/excluirVeiculo/{id}")
	public String excluirVeiculo(@PathVariable ("id") Integer id) {
		veiculoRepositorio.deleteById(id);
		return "redirect:/veiculos-adicionados";
	}
	
	
	
	
	
	//PESQUISA DE VEÍCULO NO PAINEL INDEX - BUSCANDO OBJETO ALUNO 
		@PostMapping("pesquisar-veiculo")
		public ModelAndView pesquisarVeiculo(@RequestParam(required = false) String placa) {
			ModelAndView mv = new ModelAndView();
			List<Veiculo> listaVeiculos;//RECEBENDO LISTA DE VEICULOS DE MORADOR PELO DAO
			if(placa == null || placa.trim().isEmpty()) {
				listaVeiculos = veiculoRepositorio.findAll();// SE A PESQUISA ESTIVER EM BRANCO RETORNA TODOS OS MORADORES
			}else {
				listaVeiculos = veiculoRepositorio.findByPlacaContainingIgnoreCase(placa);
			}
			
				mv.addObject("ListaDeVeiculos", listaVeiculos);
				mv.setViewName("Veiculo/pesquisaVeiculo-resultado");
				return mv;
		}
		
	}

	

