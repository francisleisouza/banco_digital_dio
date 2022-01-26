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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import one.digitalinnovation.banco_digital.entities.Conta;
import one.digitalinnovation.banco_digital.services.ContaService;



@RestController
@RequestMapping("/contas")
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

	
	@PutMapping(value = "/depositar/{id}")
	public ResponseEntity<Conta> depositar(@PathVariable Long id, Double valor, @RequestBody Conta obj) {
		obj = contaService.deposito(id, valor);		
		return ResponseEntity.ok().body(obj);

	}
	
	@PutMapping(value = "/sacar/{id}")
	public ResponseEntity<Conta> sacar(@PathVariable Long id, Double valor, @RequestBody Conta obj) {
		obj = contaService.saque(id, valor);		
		return ResponseEntity.ok().body(obj);

	}
	
	@PutMapping(value = "/transferir/{id}")
	public ResponseEntity<Conta> transferir(@PathVariable Long id, Double valor, Long idContaDestino, @RequestBody Conta obj) {
		obj = contaService.transferenciaEntreContas(id, valor, idContaDestino);		
		return ResponseEntity.ok().body(obj);

	}


}
