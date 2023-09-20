package erick.br.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import erick.br.enums.EventoStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@NotBlank( message ="nome do evento e obrigatorio")
	private String nomeEvento;

	@FutureOrPresent(message = "informe a data ")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE  ,pattern = "yyyy-MM-dd"  )
	private Date dataEvento;
	
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(iso = ISO.TIME , pattern = "HH:mm"  )
	private Date horaEvento;
    
	@ManyToOne()
	private Usuario usuario;

	@Embedded
	@Valid
	private InderecoEvento inderecoEvento;
	
	@Enumerated(EnumType.STRING)
	private EventoStatus eventoStatus ;

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

	public Date getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public InderecoEvento getInderecoEvento() {
		return inderecoEvento;
	}

	public void setInderecoEvento(InderecoEvento inderecoEvento) {
		this.inderecoEvento = inderecoEvento;
	}

	public EventoStatus getEventoStatus() {
		return eventoStatus;
	}

	public void setEventoStatus(EventoStatus eventoStatus) {
		this.eventoStatus = eventoStatus;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nomeEvento=" + nomeEvento + ", dataEvento=" + dataEvento + ", horaEvento="
				+ horaEvento + ", usuario=" + usuario + ", inderecoEvento=" + inderecoEvento + ", eventoStatus="
				+ eventoStatus + "]";
	}

	public Evento(Long id, @NotBlank(message = "nome do evento e obrigatorio") String nomeEvento,
			@FutureOrPresent(message = "informe a data ") Date dataEvento,
			@FutureOrPresent(message = "informe a hora ") Date horaEvento, Usuario usuario,
			@Valid InderecoEvento inderecoEvento, EventoStatus eventoStatus) {
		super();
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.dataEvento = dataEvento;
		this.horaEvento = horaEvento;
		this.usuario = usuario;
		this.inderecoEvento = inderecoEvento;
		this.eventoStatus = eventoStatus;
	}

	public Evento() {
		super();
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

	
	
	



}
