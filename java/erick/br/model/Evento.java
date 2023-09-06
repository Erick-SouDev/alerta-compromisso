package erick.br.model;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;
import org.springframework.format.annotation.DateTimeFormat;

import erick.br.enums.StatusEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_evento")
	private String nomeEvento;

	@Column(name = "data_evento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataEvento;

	@ForeignKey(name = "partipante_fk")
	@Column(name = "participante_id")
	private Participante participanate;

	@Embedded
	private LocalizacaoEvento localizacaoEvento;

	private StatusEvent statusEvent;

	public StatusEvent getStatusEvent() {
		return statusEvent;
	}

	public void setStatusEvent(StatusEvent statusEvent) {
		this.statusEvent = statusEvent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Participante getParticipanate() {
		return participanate;
	}

	public void setParticipanate(Participante participanate) {
		this.participanate = participanate;
	}

	public LocalizacaoEvento getLocalizacaoEvento() {
		return localizacaoEvento;
	}

	public void setLocalizacaoEvento(LocalizacaoEvento localizacaoEvento) {
		this.localizacaoEvento = localizacaoEvento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nomeEvento=" + nomeEvento + ", dataEvento=" + dataEvento + ", participanate="
				+ participanate + ", localizacaoEvento=" + localizacaoEvento + "]";
	}

}
