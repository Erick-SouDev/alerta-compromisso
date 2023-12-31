package erick.br.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Usuario implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "nome obrigatorio")
	private String nome;
	@NotBlank(message = "e-mail obrigatorio")
	private String email;

	@NotBlank(message = "senha obrigatorio")
	private String senha;

	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.REFRESH , fetch = FetchType.EAGER )
	private List<Compromisso> compromissos = new ArrayList<>();
	
	public List<Compromisso> getCompromissos() {
		return compromissos;
	}
	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

}
