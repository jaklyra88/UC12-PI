package br.com.LinkSystem.Enums;

public enum Acesso {
	
	LIBERADO("LIBERADO"),
	BLOQUEADO("BLOQUEADO"),
	CANCELADO("CANCELADO"),
	PENDENTE("PENDENTE");
	
	private String acesso;
	
	private Acesso(String acesso) {
		this.acesso = acesso;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

}
