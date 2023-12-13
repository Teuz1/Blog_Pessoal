package com.generation.blogpessoal.controller;


	// PostagemController.java (Camada controller)
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/postagens")
	public class PostagemController {

	    @Autowired
	    private PostagemRepository postagemRepository;

	    // Método de busca específica
	    @GetMapping("/buscar")
	    public List<Postagem> buscarPorTitulo(@RequestParam String titulo) {
	        return postagemRepository.findByTituloContainingIgnoreCase(titulo);
	    }

	    // Métodos CRUD básicos
	    @GetMapping
	    public List<Postagem> listarTodas() {
	        return postagemRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Postagem buscarPorId(@PathVariable Long id) {
	        return postagemRepository.findById(id).orElse(null);
	    }

	    @PostMapping
	    public Postagem criarPostagem(@RequestBody Postagem postagem) {
	        return postagemRepository.save(postagem);
	    }

	    @PutMapping("/{id}")
	    public Postagem atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagemAtualizada) {
	        postagemAtualizada.setId(id);
	        return postagemRepository.save(postagemAtualizada);
	    }

	    @DeleteMapping("/{id}")
	    public void deletarPostagem(@PathVariable Long id) {
	        postagemRepository.deleteById(id);
	    }
	}

	

