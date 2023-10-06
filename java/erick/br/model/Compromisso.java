package erick.br.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import erick.br.enums.CompromissoStatus;
import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Compromisso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@NotBlank( message ="nome do evento e obrigatorio")
	private String nomeCompromisso;

	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd"   )
	private Date dataCompromisso;
	
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat( pattern = "HH:mm"  )
	private Date horaCompromisso;
    
	@ManyToOne( fetch = FetchType.EAGER  , optional = false  )
	private Usuario usuario;

	@Embedded
	@Valid
	private InderecoCompromisso inderecoCompromisso;
	
	@Enumerated(EnumType.STRING)
	private CompromissoStatus compromissoStatus ;

	public Compromisso(Long id) {
		super();
		this.id = id;
	}



	public Compromisso() {
		super();
	}

	@Override
	public String toString() {
		return "Compromisso [id=" + id + ", nomeCompromisso=" + nomeCompromisso + ", dataCompromisso=" + dataCompromisso
				+ ", horaCompromisso=" + horaCompromisso + ", usuario=" + usuario + ", inderecoCompromisso="
				+ inderecoCompromisso + ", compromissoStatus=" + compromissoStatus + "]";
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
		Compromisso other = (Compromisso) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompromisso() {
		return nomeCompromisso;
	}

	public void setNomeCompromisso(String nomeCompromisso) {
		this.nomeCompromisso = nomeCompromisso;
	}

	public Date getDataCompromisso() {
		return dataCompromisso;
	}

	public void setDataCompromisso(Date dataCompromisso) {
		this.dataCompromisso = dataCompromisso;
	}

	public Date getHoraCompromisso() {
		return horaCompromisso;
	}

	public void setHoraCompromisso(Date horaCompromisso) {
		this.horaCompromisso = horaCompromisso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public InderecoCompromisso getInderecoCompromisso() {
		return inderecoCompromisso;
	}

	public void setInderecoCompromisso(InderecoCompromisso inderecoCompromisso) {
		this.inderecoCompromisso = inderecoCompromisso;
	}

	public CompromissoStatus getCompromissoStatus() {
		return compromissoStatus;
	}

	public void setCompromissoStatus(CompromissoStatus compromissoStatus) {
		this.compromissoStatus = compromissoStatus;
	}

	
	
	



}
