package com.generation.blogpessoal.repository;

	// PostagemRepository.java (Camada repository)
	import org.springframework.data.jpa.repository.JpaRepository;
	import java.util.List;

	public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	    // Método de busca específica
	    List<Postagem> findByTituloContainingIgnoreCase(String titulo);
	}


