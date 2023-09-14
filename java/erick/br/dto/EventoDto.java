package erick.br.dto;

import java.util.Date;

import erick.br.model.Evento;

public class EventoDto {

	public EventoDto(Evento evento) {

		this.nomeEvento = evento.getNomeEvento();
		this.bairro = evento.getInderecoEvento().getBairro();
		this.Local = evento.getInderecoEvento().getNomeLocal();
		this.dataEvento = evento.getDataEvento();
	}

	public EventoDto() {

	}

	private String nomeEvento;

	private Date dataEvento;

	private String Local;

	private String bairro;

	
	
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
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
