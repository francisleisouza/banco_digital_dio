package one.digitalinnovation.banco_digital.repositories;

import one.digitalinnovation.banco_digital.entities.Conta;

public interface ContaRepositoryImpl {
	
	public void depositar(double valor);	
	public void sacar(double valor);
	public void transferir( Conta contaDestino, Double valor);
	public void imprimiExtrato();
	

}
