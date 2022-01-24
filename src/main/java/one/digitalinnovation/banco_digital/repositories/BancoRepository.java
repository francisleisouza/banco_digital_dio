package one.digitalinnovation.banco_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.banco_digital.entities.Banco;

public interface BancoRepository  extends JpaRepository<Banco, Long>{

}
