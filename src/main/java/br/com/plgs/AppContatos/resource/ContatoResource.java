package br.com.plgs.AppContatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plgs.AppContatos.model.Contato;
import br.com.plgs.AppContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos") // http://localhost:8080/api/contatos
public class ContatoResource {
	
	@Autowired
	private ContatoService contatoService;
	
	@Operation(summary = "Grava o registro de Contato para uma Pessoa")
	@PostMapping // http://localhost:8080/api/contatos
	public ResponseEntity<Contato> save(@RequestBody Contato contato) {
		Contato newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Busca registro por ID de Contato")
	@GetMapping("/{id}") // http://localhost:8080/api/contatos/1
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id) {
		Optional<Contato> findContato = contatoService.findById(id);
		if(findContato.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Busca todos os registros de contatos de uma pessoa")
	@GetMapping("/pessoa/{idPessoa}") // http://localhost:8080/api/contatos/pessoa/1
	public ResponseEntity<List<Contato>> findAllByPessoa(@PathVariable Long idPessoa) {
		List<Contato> contatos = contatoService.findByPessoaId(idPessoa);
		if(contatos == null) {
			return ResponseEntity.notFound().build();
		}
		if(contatos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contatos);

	}
	
	@Operation(summary = "Atualiza o registro de contato por ID")
	@PutMapping("/{id}") // http://localhost:8080/api/contatos/1
	public ResponseEntity<Contato> update(@RequestBody Contato contato, @PathVariable Long id) {
		Contato updContato = contatoService.update(contato, id);
		if(updContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updContato);
	}
	
	@Operation(summary = "Exclui o registro de contato por ID")
	@DeleteMapping("/{id}") // http://localhost:8080/api/contatos/1
	public ResponseEntity<?> delete(@PathVariable Long id) {
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
