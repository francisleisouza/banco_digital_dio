package one.digitalinnovation.banco_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.banco_digital.entities.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
