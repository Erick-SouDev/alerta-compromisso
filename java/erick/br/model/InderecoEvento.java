package erick.br.model;

import java.io.Serializable;

import javax.swing.SwingConstants;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;


@Embeddable
public class 	InderecoEvento {

	@NotBlank(message = "Informe o nome da cidade")
	private String cidade;
	@NotBlank(message = "Informe o nome do bairro ")
	private String bairro;
	@NotBlank(message = "Informe o nome da rua ")
	private String rua;
	@NotBlank(message = "Informe o numero exp: nº xxx")
	private String numero;
	@NotBlank(message = "Informe o local do evento ")
	private String nomeLocal;
	
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public String getNomeLocal() {
		return nomeLocal;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "InderecoEvento [cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero
				+ ", nomeLocal=" + nomeLocal + "]";
	}
	

	
	
}
