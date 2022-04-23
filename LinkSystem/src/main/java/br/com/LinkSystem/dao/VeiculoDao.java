package br.com.LinkSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LinkSystem.model.Veiculo;

public interface VeiculoDao extends JpaRepository<Veiculo, Integer> {
	
	//PESQUISANDO VEÍCULO DE MORADOR PELA PLACA
		public List<Veiculo> findByPlacaContainingIgnoreCase(String placa);

}
