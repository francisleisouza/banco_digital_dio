package one.digitalinnovation.banco_digital.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import one.digitalinnovation.banco_digital.entities.Agencia;
import one.digitalinnovation.banco_digital.services.AgenciaService;



@RestController
@RequestMapping("/agencia")
public class AgenciaResouce {
	
	
	@Autowired
	AgenciaService agenciaService;

	@GetMapping()
	public ResponseEntity<List<Agencia>> findAll() {
		List<Agencia> lista = agenciaService.findlAll();
		return ResponseEntity.ok().body(lista);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Agencia> findById(@PathVariable Long id) {

		Agencia obj = agenciaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/new")
	public ResponseEntity<Agencia> insert(@RequestBody Agencia obj) {
		obj = agenciaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		agenciaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Agencia> update(@PathVariable Long id, @RequestBody Agencia obj) {
		obj = agenciaService.update(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

}
