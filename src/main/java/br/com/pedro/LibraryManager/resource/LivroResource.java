package br.com.pedro.LibraryManager.resource;

import br.com.pedro.LibraryManager.model.Livro;
import br.com.pedro.LibraryManager.model.LivroId;
import br.com.pedro.LibraryManager.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/livro")
public class LivroResource {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroResource(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/all")
    public List<Livro> findAll(){
        Iterable<Livro> result = this.livroRepository.findAll();
        List<Livro> livros = StreamSupport.stream(result.spliterator(), false).collect(Collectors.toList());

        return livros;
    }

    @GetMapping
    public Livro findById(@RequestParam(required = true) String titulo,
                                    @RequestParam(required = true) String edicao){
        LivroId id = new LivroId(titulo, edicao);
        return (this.livroRepository.findById(id).get());
    }

    @PostMapping
    public List<Livro> insert(@RequestBody List<Livro> livros){
        Iterable<Livro> response = this.livroRepository.saveAll(livros);
        return StreamSupport.stream(response.spliterator(), false).collect(Collectors.toList());
    }


}
