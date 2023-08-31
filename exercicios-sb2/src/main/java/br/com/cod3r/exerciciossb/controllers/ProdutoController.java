package br.com.cod3r.exerciciossb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@PostMapping
	public ResponseEntity<?> criarProduto(Produto produto){
		Optional<Produto> existeProduto  = produtoRepository.findByNome(produto.getNome());
		if(existeProduto.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto com esse nome já existente no banco de dados.");
		}
		Produto novoProduto = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
	
	@GetMapping
	public List<Produto> obterTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/{pagina}/{tamanho}")
	public Page<Produto> obterProdutosPaginada(@PathVariable int pagina, @PathVariable int tamanho) {
		if(tamanho > 10) tamanho = 10;
		Pageable page = PageRequest.of(pagina, 3);
		return produtoRepository.findAll(page);
	}
	
	@GetMapping(path = "/{nome}")
	public Iterable<Produto> obterProdutosNome(@PathVariable String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	@PutMapping
	public ResponseEntity<?> alterarProduto(Produto produto){
		Optional<Produto> existeProduto = produtoRepository.findByNome(produto.getNome());
		if(existeProduto.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe esse nome no banco de dados, altere para outro.");
		} 
		Produto alterarProduto = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.OK).body(alterarProduto);
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable int id){
		try {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Produto com o ID " + id + " deletado com sucesso.");
		} catch(EmptyResultDataAccessException e){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe produto com esse ID");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o produto");
		}
	}
	
}


