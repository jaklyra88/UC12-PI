package br.com.LinkSystem.Enums;

public enum TipoResidencia {
	
	CASA("Casa"),
	APARTAMENTO("Apartamento");
	
	private String tipoResidencia;
	
	private TipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

	public String getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

}
