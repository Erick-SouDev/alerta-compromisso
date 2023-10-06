package erick.br.dto;

import org.springframework.stereotype.Component;

import erick.br.model.Compromisso;

@Component("modelmapper")
public class CompromissoDTO {

	public CompromissoDTO(Compromisso compromisso) {
		super();
		this.nomeEvento = compromisso.getNomeCompromisso();
		this.dataEvento = compromisso.getDataCompromisso().toLocaleString();
		this.horaEvento = compromisso.getHoraCompromisso().toLocaleString();
		this.local = compromisso.getInderecoCompromisso().getNomeLocal();

	}

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

	public String getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public CompromissoDTO() {

	}

	private String nomeEvento;

	private String dataEvento;

	private String horaEvento;

	private String local;

	private String bairro;

}
