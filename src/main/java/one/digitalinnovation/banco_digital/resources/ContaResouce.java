package one.digitalinnovation.banco_digital.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import one.digitalinnovation.banco_digital.entities.Conta;
import one.digitalinnovation.banco_digital.services.ContaService;



@RestController
@RequestMapping("/conta")
public class ContaResouce {
	
	
	@Autowired
	ContaService contaService;

	@GetMapping()
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> lista = contaService.findlAll();
		return ResponseEntity.ok().body(lista);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Long id) {
		Conta obj = contaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping("/new")
	public ResponseEntity<Conta> insert(@RequestBody Conta obj) {
		obj = contaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		contaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta obj) {
//		obj = contaService.update(id, obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
//
//	}


}
