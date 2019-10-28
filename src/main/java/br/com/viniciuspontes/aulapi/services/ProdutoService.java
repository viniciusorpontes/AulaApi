package br.com.viniciuspontes.aulapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.viniciuspontes.aulapi.domain.Produto;
import br.com.viniciuspontes.aulapi.repositories.ProdutoRepository;
import br.com.viniciuspontes.aulapi.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Page<Produto> pesquisar(String nome, Pageable pageable) {
		return produtoRepository.findByNomeContaining(nome, pageable);
	}

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + 
				" Tipo: " + Produto.class.getName()
				));
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return produtoRepository.save(obj);
	}
	
	public Produto update(Produto obj) {
		find(obj.getId());
		return produtoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		produtoRepository.deleteById(id);
	}
}
