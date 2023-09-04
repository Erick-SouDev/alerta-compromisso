package erick.br.model;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import erick.br.enums.StatusEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nomeEvento;

	@Embedded
	private Local Local;

	@ForeignKey(name = "fk_id_usuario ")
	@Column(name = "id_usuario")
	private Usuario usuario;

	@DateTimeFormat(pattern = "yyyy-M-dd", style = "pt-br", iso = ISO.DATE_TIME.DATE)
	@Temporal(TemporalType.DATE)
	private Date dataEvento;

	@Enumerated(EnumType.STRING)
	private StatusEvent statusEvent;



	public Evento() {
		super();
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

	public Local getLocal() {
		return Local;
	}

	public void setLocal(Local local) {
		Local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public StatusEvent getStatusEvent() {
		return statusEvent;
	}

	public void setStatusEvent(StatusEvent statusEvent) {
		this.statusEvent = statusEvent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Date getDataEvento() {
		return dataEvento;
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

}
