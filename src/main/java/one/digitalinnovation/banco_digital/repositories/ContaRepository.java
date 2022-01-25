package one.digitalinnovation.banco_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.banco_digital.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	
}
