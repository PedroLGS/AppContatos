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

import br.com.plgs.AppContatos.dto.PessoaDTO;
import br.com.plgs.AppContatos.model.Pessoa;
import br.com.plgs.AppContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") // http://localhost:8080/api/pessoas
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Operation(summary = "Grava o registro de Pessoa")
	@PostMapping // http://localhost:8080/api/pessoas
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newPessoa);
	}
	
	@Operation(summary = "Busca registro por ID de Pessoa")
	@GetMapping("/{id}") // http://localhost:8080/api/pessoas/1
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Busca registro por ID de uma pessoa para mala direta")
	@GetMapping("/maladireta/{id}") // http://localhost:8080/api/pessoas/maladireta/1
	public ResponseEntity<List<PessoaDTO>> findByIdMalaDireta(@PathVariable Long id) {
		List<PessoaDTO> pessoaDTO = pessoaService.findByIdMalaDireta(id);
		if(pessoaDTO == null) {
			return ResponseEntity.notFound().build();
		}
		if(pessoaDTO.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoaDTO);
	}
	
	@Operation(summary = "Busca todos os registros de Pessoas")
	@GetMapping // http://localhost:8080/api/pessoas
	public ResponseEntity<List<Pessoa>> findAllPessoas() {
		List<Pessoa> pessoas = pessoaService.findAll();
		if(pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		if(pessoas.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Atualiza o registro de pessoa por ID")
	@PutMapping("/{id}") // http://localhost:8080/api/pessoas/1
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		Pessoa updPessoa = pessoaService.update(pessoa, id);
		if(updPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updPessoa);
	}
	
	@Operation(summary = "Exclui o registro de pessoa por ID")
	@DeleteMapping("/{id}") // http://localhost:8080/api/pessoas/1
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
