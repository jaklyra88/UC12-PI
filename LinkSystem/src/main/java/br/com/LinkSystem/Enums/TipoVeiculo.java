package br.com.LinkSystem.Enums;

public enum TipoVeiculo {
	
	CARRO("Carro"),
	MOTO("Moto"),
	CAMINHAO("Caminhão");
	
	private String tipoVeiculo;
	
	private TipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	
}
