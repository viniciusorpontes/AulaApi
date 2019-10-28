package br.com.viniciuspontes.aulapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.viniciuspontes.aulapi.domain.Pessoa;
import br.com.viniciuspontes.aulapi.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public Page<Pessoa> pesquisar(@RequestParam(required = false, 
	       defaultValue = "") String nomepessoa, Pageable pageable) {
		return pessoaService.pesquisar(nomepessoa, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> find(@PathVariable Integer id) {
		Pessoa obj = pessoaService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Pessoa obj) {
		obj = pessoaService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdpessoa()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Pessoa obj,
									@PathVariable Integer id) {
		obj = pessoaService.update(obj, id);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}