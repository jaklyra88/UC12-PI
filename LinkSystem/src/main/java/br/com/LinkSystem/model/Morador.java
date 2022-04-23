package br.com.LinkSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.LinkSystem.Enums.Acesso;
import br.com.LinkSystem.Enums.TipoResidencia;

@Entity
public class Morador {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMorador")
	private Integer idMorador;
	
	@Column(name = "nome")
	@NotBlank(message = "O nome deve ser preenchido")
	@Size(min = 12, max= 80, message = "Informe o nome completo")
	private String nome;
	
	@Column( name = "rg")
	@NotBlank(message = "O RG tem que ser preenchido")
	@Size(min = 12, max= 12,message = "Mínimo de 12 caracteres")
	private String rg;
	
	@Column(name = "cpf")
	@NotBlank(message = "O CPF tem que ser preenchido")
	@Size(min = 12, max= 12, message = "Mínimo de 12 caracteres")
	private String cpf;
	
	@Column(name = "email")
	@NotBlank(message = "O email deve ser preenchido.")
	private String email;
	
	@Column(name = "telefone")
	@NotBlank(message = "O telefone deve ser informado.")
	private String telefone;
	
	@Column(name = "ramal")
	private String ramal;
	
	@Column(name = "celular")
	@NotBlank(message = "O número do celular deve ser informado.")
	private String celular;
	
	@Column(name = "acesso")
	@NotNull(message = "O tipo de acesso deve ser selecionado.")
	@Enumerated(EnumType.STRING)
	private Acesso acesso;
	
	
	@NotNull(message = "O código da residência deve ser informado")
	@ManyToOne
	@JoinColumn (nullable = false)
	private Residencia residencia;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdMorador() {
		return idMorador;
	}

	public void setIdMorador(Integer idMorador) {
		this.idMorador = idMorador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}
	
	
	
	//verificar sobre os dependentes do Arthur
	//@OneToOne
	//@JoinColumn (nullable=false, unique=true)
	//private Cliente cliente;

	//@ManyToOne
	//@JoinColumn (nullable = false)
	//private Tecnico tecnico;

}
