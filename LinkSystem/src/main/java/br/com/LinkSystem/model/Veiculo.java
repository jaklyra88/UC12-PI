package br.com.LinkSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import br.com.LinkSystem.Enums.Cor;
import br.com.LinkSystem.Enums.Marca;
import br.com.LinkSystem.Enums.Modelo;
import br.com.LinkSystem.Enums.TipoVeiculo;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idveiculo")
	public Integer idVeiculo;
	
	@Column(name = "placa")
	@NotBlank(message = "A placa deve ser informada.")
	public String placa;
	
	@Column(name = "tipoVeiculo")
	@NotNull(message = "O tipo de veículo deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	public TipoVeiculo tipoVeiculo;
	
	@Column(name = "modelo")
	@NotNull(message = "O modelo do veículo deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	public Modelo modelo;
	
	@Column(name = "marca")
	@NotNull(message = "A marca do veículo deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	public Marca marca;
	
	@Column(name = "cor")
	@NotNull(message = "A cor do veículo deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	public Cor cor;
	
	
	@NotNull(message = "O código do morador deve ser preenchido.")
	@ManyToOne
	@JoinColumn(nullable = false)
	private Morador morador;
	
	
	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	
	
	
		
	//MODELOS
	//@OneToOne
	//@JoinColumn (nullable=false, unique=true)
	//private Cliente cliente;

	//@ManyToOne
	//@JoinColumn (nullable = false)
	//private Tecnico tecnico;

}
