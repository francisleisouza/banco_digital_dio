package one.digitalinnovation.banco_digital.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import one.digitalinnovation.banco_digital.entities.Conta;
import one.digitalinnovation.banco_digital.repositories.ContaRepository;
import one.digitalinnovation.banco_digital.resources.exceptions.ResourceNotFoundException;
import one.digitalinnovation.banco_digital.services.exceptions.ObjectNotFoundException;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public List<Conta> findlAll() {
		return contaRepository.findAll();
	};

	public Conta findById(Long id) {

		Optional<Conta> obj = contaRepository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado no conta! Id: " + id + ", tipo: " + Conta.class.getName());
		}
		return obj.get();
	}

	public Conta insert(Conta obj) {
		return contaRepository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			contaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Conta update(Long id, Conta obj) {
		try {
			Conta conta = contaRepository.getById(id);
			updateData(conta, obj);
			return contaRepository.save(conta);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Conta conta, Conta obj) {
		conta.setCliente(obj.getCliente());
	}	

}
