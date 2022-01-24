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

import one.digitalinnovation.banco_digital.entities.Banco;
import one.digitalinnovation.banco_digital.services.BancoService;



@RestController
@RequestMapping("/banco")
public class BancoResouce {
	
	
	@Autowired
	BancoService bancoService;

	@GetMapping()
	public ResponseEntity<List<Banco>> findAll() {
		List<Banco> lista = bancoService.findlAll();
		return ResponseEntity.ok().body(lista);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Banco> findById(@PathVariable Long id) {

		Banco obj = bancoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Banco> insert(@RequestBody Banco obj) {
		obj = bancoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		bancoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Banco> update(@PathVariable Long id, @RequestBody Banco obj) {
		obj = bancoService.update(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

}
