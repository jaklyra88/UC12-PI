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

import br.com.LinkSystem.dao.MoradorDao;
import br.com.LinkSystem.model.Morador;


@Controller
public class MoradorController {
	
	@Autowired
	private MoradorDao moradorRepositorio;
	
	//CHAMANDO O FORMULÁRIO DE MORADOR AO SOLICITAR A INCLUSÃO DE UM NOVO MORADOR
	@GetMapping("/inserirMoradores")
	public ModelAndView InsertMorador(Morador morador) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Morador/formMorador");
		mv.addObject("morador", new Morador());
		return mv;
		
	}
	
	
	//ACESSANDO O FILTRO DE MORADORES - STATUS NO SISTEMA
	@GetMapping("filtroMoradores")
	public ModelAndView filtroMorad(Morador morador) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Morador/filtroMoradores");
		return mv;
	}
	
	//INSERINDO DADOS DO MORADOR NO FORMULÁRIO E SALVANDO NO BANCO DE DADOS - VERIFICANDO ANTES SE HÁ ERROS NO PREENCHIMENTO DO FORMULÁRIO
	@PostMapping("InsertMorador")
	public ModelAndView inserirMorador(@Valid Morador morador, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {//VERIFICANDO SE SÁ ERROS E VOLTANDO AO FORMA PARA CORREÇÃO - MANTENDO O UUSÁRIO NA VIEW 
			mv.setViewName("Morador/formMorador");
			mv.addObject("morador");
		}else {//NÃO HAVENDO ERROS ELE SALVA NO BANCO DE DADOS
			mv.setViewName("redirect:/moradores-adicionados");
			moradorRepositorio.save(morador);
		}
		
		return mv;
	}
	
	//ACESSANDO A PAGINA DE ULTIMOS MORADORES CADASTRADOS
	@GetMapping("moradores-adicionados")
	public ModelAndView listagemMoradores() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Morador/listMoradores");
		mv.addObject("moradoresList", moradorRepositorio.findAll());//RESPONSÁVEL POR PEGAR TODOS OS MORADORES DO BANCO DE DADOS
		return mv;
	}

	//ALTERANDO DADOS DO MORADOR PELO ID 
	@GetMapping("/alterarMorador/{id}")
	public ModelAndView alterarMorad(@PathVariable ("id")Integer id) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Morador/alterarMorador");
		Morador morador = moradorRepositorio.getOne(id);
		mv.addObject("morador", morador);
		return mv;
	}
	
	//ALTERANDO MORADOR ATRAVÉS DO FORMMORADOR - EM MORADORES-ADICIONADOS
	@PostMapping("/alterarMorador")
	public ModelAndView alterarMorad(Morador morador) {
		ModelAndView mv = new ModelAndView();
		moradorRepositorio.save(morador);
		mv.setViewName("redirect:/moradores-adicionados");
		return mv;
	}
	
	//EXCLUINDO MORADOR ATRAVÉS DO FORMMORADOR - EM MORADORES-ADICIONADOS
	@GetMapping("/excluirMorador/{id}")
	public String excluirMorador(@PathVariable("id")Integer id) {
		moradorRepositorio.deleteById(id);
		return "redirect:/moradores-adicionados";
	}
	
	//BUSCAR DE MORADORES ATIVOS NO SISTEMA ATRAVÉS DO FILTRO DE MORADORES
	@GetMapping("filtro-moradores")
	public ModelAndView filtroMoradores() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Morador/filtroMoradores");
		return mv;
		
	}
	
	//LISTA DE MORADORES LIBERADOS NO SISTEMA
		@GetMapping("moradores-liberados")
		public ModelAndView listaMoradoresLiberados() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Morador/moradores-liberados");
			mv.addObject("moradoresLiberados", moradorRepositorio.findByStatusLiberado());//RESPONSÁVEL POR PEGAR OS MORADORES LIBERADOS DO BANCO DE DADOS
			return mv;
		}
	
		
		
	//LISTA DE MORADORES BLOQUEADOS NO SISTEMA
		@GetMapping("moradores-bloqueados")
		public ModelAndView listaMoradoresBloqueados() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Morador/moradores-bloqueados");
			mv.addObject("moradoresBloqueados", moradorRepositorio.findByStatusBloqueado());//RESPONSÁVEL POR PEGAR OS MORADORES LIBERADOS DO BANCO DE DADOS
			return mv;
		}
				
	//LISTA DE MORADORES PENDENTES NO SISTEMA
	@GetMapping("moradores-pendentes")
	public ModelAndView listaMoradoresPendentes() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Morador/moradores-pendentes");
			mv.addObject("moradoresPendentes", moradorRepositorio.findByStatusPendente());//RESPONSÁVEL POR PEGAR OS MORADORES LIBERADOS DO BANCO DE DADOS
			return mv;
		}
		
	//LISTA DE MORADORES CANCELADOS NO SISTEMA
	@GetMapping("moradores-cancelados")
	public ModelAndView listaMoradoresCancelados() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Morador/moradores-cancelados");
			mv.addObject("moradoresCancelados", moradorRepositorio.findByStatusCancelado());//RESPONSÁVEL POR PEGAR OS MORADORES LIBERADOS DO BANCO DE DADOS
			return mv;
		}
				
				
	//PESQUISA DE MORADOR NO PAINEL INDEX - BUSCANDO OBJETO MORADOR
	@PostMapping("pesquisar-morador")
	public ModelAndView pesquisarMorador(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		List<Morador> listaMoradores;//RECEBENDO LISTA DE MORADORES PELO DAO
		if(nome == null || nome.trim().isEmpty()) {
			listaMoradores = moradorRepositorio.findAll();// SE A PESQUISA ESTIVER EM BRANCO RETORNA TODOS OS MORADORES
		}else {
			listaMoradores = moradorRepositorio.findByNomeContainingIgnoreCase(nome);
		}
		
			mv.addObject("ListaDeMoradores", listaMoradores);
			mv.setViewName("Morador/pesquisaMorador-resultado");
			return mv;
	}
	
}
