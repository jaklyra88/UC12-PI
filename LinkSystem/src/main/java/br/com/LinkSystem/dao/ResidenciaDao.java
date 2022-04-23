package br.com.LinkSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LinkSystem.model.Morador;
import br.com.LinkSystem.model.Residencia;

public interface ResidenciaDao extends JpaRepository<Residencia, Integer> {
	
	//PESQUISANDO RESIDENCIA PELO NÚMERO
		public List<Residencia> findByNumero(Integer numero);

}
