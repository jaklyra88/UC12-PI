package br.com.LinkSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.LinkSystem.Enums.Acesso;
import br.com.LinkSystem.Enums.TipoResidencia;


@Entity
public class Residencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idResidencia")
	private Integer idResidencia;
	
	@Column(name = "tipoResidencia")
	@NotNull(message = "O tipo de residência deve ser selecionado")
	@Enumerated(EnumType.STRING)
	private TipoResidencia tipoResidencia;
	
	@Column(name = "bloco")
	@NotNull(message = "O bloco deve ser preenchido")
	private String bloco;
	
	@Column(name = "numero")
	@NotNull(message = "O número deve ser preenchido")
	private Integer numero;

	public Integer getIdResidencia() {
		return idResidencia;
	}

	public void setIdResidencia(Integer idResidencia) {
		this.idResidencia = idResidencia;
	}

	public TipoResidencia getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(TipoResidencia tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	
	
}
