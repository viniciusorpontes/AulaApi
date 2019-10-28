package br.com.viniciuspontes.aulapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciuspontes.aulapi.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	public Page<Categoria> findByNomeContaining(String nome, Pageable pageable);
}
