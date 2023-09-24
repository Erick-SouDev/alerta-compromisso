package erick.br.dto;

import org.springframework.stereotype.Component;

@Component("modelmapper")
public class CompromissoDTO {

	public CompromissoDTO(String nomeEvento, String dataEvento, String local, String bairro) {
		this.nomeEvento = nomeEvento;
		this.dataEvento = dataEvento;
		Local = local;
		this.bairro = bairro;
	}

	public CompromissoDTO() {

	}

	private String nomeEvento;

	private String dataEvento;

	private String Local;

	private String bairro;

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
