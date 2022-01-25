package one.digitalinnovation.banco_digital.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_agencia")
public class Agencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull	
	private Integer numeroAgencia;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "banco_id")
	private Banco banco;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas = new ArrayList<>();


	public Agencia() {
		
	}


	public Agencia(Long id, Integer numeroAgencia, String nome, Banco banco) {
		super();
		this.id = id;
		this.numeroAgencia = numeroAgencia;
		this.nome = nome;
		this.banco = banco;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}


	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}	
	
	@JsonIgnore
	public List<Conta> getContas() {
		return contas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Agencia [id=" + id + ", numeroAgencia=" + numeroAgencia + ", nome=" + nome + "]";
	}
	
}
