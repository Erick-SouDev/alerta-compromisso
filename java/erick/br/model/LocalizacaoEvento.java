package erick.br.model;

import java.io.Serializable;

import javax.swing.SwingConstants;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class LocalizacaoEvento {

	
	
	private String cidade;
	private String rua;
	private String numeroLocal;
	
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumeroLocal() {
		return numeroLocal;
	}
	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

	
	
	
}
