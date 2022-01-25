package one.digitalinnovation.banco_digital.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import one.digitalinnovation.banco_digital.entities.Agencia;
import one.digitalinnovation.banco_digital.repositories.AgenciaRepository;
import one.digitalinnovation.banco_digital.resources.exceptions.ResourceNotFoundException;
import one.digitalinnovation.banco_digital.services.exceptions.ObjectNotFoundException;

@Service
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepository;

	public List<Agencia> findlAll() {
		return agenciaRepository.findAll();
	};

	public Agencia findById(Long id) {

		Optional<Agencia> obj = agenciaRepository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado no agencia! Id: " + id + ", tipo: " + Agencia.class.getName());
		}
		return obj.get();
	}

	public Agencia insert(Agencia obj) {
		return agenciaRepository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			agenciaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Agencia update(Long id, Agencia obj) {
		try {
			Agencia agencia = agenciaRepository.getById(id);
			updateData(agencia, obj);
			return agenciaRepository.save(agencia);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Agencia agencia, Agencia obj) {
		agencia.setNome(obj.getNome());
	}

}
