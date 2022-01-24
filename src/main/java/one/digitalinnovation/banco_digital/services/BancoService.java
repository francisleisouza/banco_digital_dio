package one.digitalinnovation.banco_digital.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import one.digitalinnovation.banco_digital.entities.Banco;
import one.digitalinnovation.banco_digital.repositories.BancoRepository;
import one.digitalinnovation.banco_digital.resources.exceptions.ResourceNotFoundException;
import one.digitalinnovation.banco_digital.services.exceptions.ObjectNotFoundException;

@Service
public class BancoService {

	@Autowired
	BancoRepository bancoRepository;

	public List<Banco> findlAll() {
		return bancoRepository.findAll();
	};

	public Banco findById(Long id) {

		Optional<Banco> obj = bancoRepository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado no banco! Id: " + id + ", tipo: " + Banco.class.getName());
		}
		return obj.get();
	}

	public Banco insert(Banco obj) {
		return bancoRepository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			bancoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Banco update(Long id, Banco obj) {
		try {
			Banco categoria = bancoRepository.getById(id);
			updateData(categoria, obj);
			return bancoRepository.save(categoria);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Banco banco, Banco obj) {
		banco.setNomeBanco(obj.getNomeBanco());
	}

}
