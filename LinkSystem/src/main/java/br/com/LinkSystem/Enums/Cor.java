package br.com.LinkSystem.Enums;

public enum Cor {
	
	VERMELHO("Vermelho"),
	VERDE("Verde"),
	AZUL("Azul"),
	BRANCO("Branco"),
	PRATA("Prata"),
	CINZA("Cinza"),
	AMARELO("Amarelo"),
	OUTRO("Outro");
	
	
	private String cor;
	
	private Cor(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	

}
