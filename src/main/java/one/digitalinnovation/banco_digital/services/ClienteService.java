package one.digitalinnovation.banco_digital.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import one.digitalinnovation.banco_digital.entities.Cliente;
import one.digitalinnovation.banco_digital.repositories.ClienteRepository;
import one.digitalinnovation.banco_digital.resources.exceptions.ResourceNotFoundException;
import one.digitalinnovation.banco_digital.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> findlAll() {
		return clienteRepository.findAll();
	};

	public Cliente findById(Long id) {

		Optional<Cliente> obj = clienteRepository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado no cliente! Id: " + id + ", tipo: " + Cliente.class.getName());
		}
		return obj.get();
	}

	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente cliente = clienteRepository.getById(id);
			updateData(cliente, obj);
			return clienteRepository.save(cliente);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Cliente cliente, Cliente obj) {
		cliente.setNome(obj.getNome());
	}

}
