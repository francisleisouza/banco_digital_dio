package one.digitalinnovation.banco_digital.repositories;

public interface ContaRepositoryImpl {
	
	public void depositar(Long id, Double valor);	
	public void sacar(Long id, Double valor);
	public void transferir( Long id, Double valor, Long idContaDestino);
	public void imprimiExtrato();
	

}
