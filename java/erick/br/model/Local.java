package erick.br.model;

import java.io.Serializable;

import javax.swing.SwingConstants;

import jakarta.persistence.Embeddable;

@Embeddable
public class Local  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String regial;
	private String nomeRua;
	private String numeroLocal;
	public String getRegial() {
		return regial;
	}
	public void setRegial(String regial) {
		this.regial = regial;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	public String getNumeroLocal() {
		return numeroLocal;
	}
	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}
	
	
}
