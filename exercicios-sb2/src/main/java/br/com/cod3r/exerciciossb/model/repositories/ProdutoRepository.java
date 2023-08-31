package br.com.cod3r.exerciciossb.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	Optional<Produto> findByNome(String nome);
}
 