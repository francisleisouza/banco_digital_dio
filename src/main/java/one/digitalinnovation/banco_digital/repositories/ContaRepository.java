package one.digitalinnovation.banco_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.banco_digital.entities.Conta;

public interface ContaRepository  extends JpaRepository<Conta, Long>{
	
	/*public void depositar(Double valor);
	public void sacar(Double valor);
	//public void transferir(Double valor, Conta contaDestno, TipoContaEnum tipoContaEnum);
	public void imprimiExtrato();*/
	
}
