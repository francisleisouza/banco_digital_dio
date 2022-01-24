package one.digitalinnovation.banco_digital.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import one.digitalinnovation.banco_digital.entities.enums.TipoContaEnum;


@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer numeroConta;
	
	@Enumerated(EnumType.STRING)
	private TipoContaEnum tipoContaEnum;
	
	@NotNull
	private Double saldoInicial;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;	
	

	@ManyToOne
	@JoinColumn(name = "agencia_id")
	private Agencia agencia;

	
	public Conta() {
		super();
	}


	public Conta(Long id, Integer numeroConta, TipoContaEnum tipoContaEnum, Double saldoInicial) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.tipoContaEnum = tipoContaEnum;
		this.saldoInicial = saldoInicial;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}


	public TipoContaEnum getTipoContaEnum() {
		return tipoContaEnum;
	}


	public void setTipoContaEnum(TipoContaEnum tipoContaEnum) {
		this.tipoContaEnum = tipoContaEnum;
	}


	public Double getSaldoInicial() {
		return saldoInicial;
	}


	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", tipoContaEnum=" + tipoContaEnum + ", saldoInicial="
				+ saldoInicial + "]";
	}
	
	

}
