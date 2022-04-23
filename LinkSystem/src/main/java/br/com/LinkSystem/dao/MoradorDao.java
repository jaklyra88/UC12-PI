package br.com.LinkSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.LinkSystem.model.Morador;


public interface MoradorDao extends JpaRepository<Morador, Integer>{
	
	
	//CHAMANDO OS MORADORES DE ACORDO COM O STATUS E ENVIANDO O RESI=ULTADO PARA O FILTROMORADORES
	@Query("SELECT j FROM Morador j WHERE j.acesso = 'LIBERADO' ")
	public List<Morador> findByStatusLiberado();
	
	@Query("SELECT k FROM Morador k WHERE k.acesso = 'BLOQUEADO' ")
	public List<Morador> findByStatusBloqueado();
	
	@Query("SELECT l FROM Morador l WHERE l.acesso = 'CANCELADO' ")
	public List<Morador> findByStatusCancelado();
	
	@Query("SELECT m FROM Morador  m WHERE m.acesso = 'PENDENTE' ")
	public List<Morador> findByStatusPendente();
	
	//PESQUISANDO MORADOR PELO NOME
	public List<Morador> findByNomeContainingIgnoreCase(String nome);
	
}
