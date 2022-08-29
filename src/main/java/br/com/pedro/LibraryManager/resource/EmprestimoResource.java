package br.com.pedro.LibraryManager.resource;

import br.com.pedro.LibraryManager.model.Emprestimo;
import br.com.pedro.LibraryManager.model.Livro;
import br.com.pedro.LibraryManager.model.LivroId;
import br.com.pedro.LibraryManager.model.Usuario;
import br.com.pedro.LibraryManager.model.dto.EmprestimoDTO;
import br.com.pedro.LibraryManager.repository.EmprestimoRepository;
import br.com.pedro.LibraryManager.repository.LivroRepository;
import br.com.pedro.LibraryManager.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoResource {
    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public EmprestimoResource(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    @GetMapping("/all")
    public List<Emprestimo> findAll(@RequestParam String email){
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(email);

        if(!usuarioOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        else{
            Iterable<Emprestimo> emprestimoIterable = this.emprestimoRepository.findAllByUser(email);
            return StreamSupport.stream(emprestimoIterable.spliterator(), false).collect(Collectors.toList());
        }
    }

    @PutMapping(value = "/devolver/{id}", produces = "application/json")
    public Emprestimo devolverEmprestimo(@PathVariable Long id){
        Optional<Emprestimo> emprestimoOptional = this.emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            Emprestimo emprestimo = emprestimoOptional.get();
            emprestimo.setDataConclusao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

            return this.emprestimoRepository.save(emprestimo);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo nao encontrado");
        }
    }

    @PostMapping
    public List<Emprestimo> realizarEmprestimo(@RequestBody List<EmprestimoDTO> emprestimos){
        List<Emprestimo> emprestimoList = new ArrayList<Emprestimo>();
        for(EmprestimoDTO emprestimo: emprestimos){
            Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(emprestimo.getUsuario());
            Optional<Livro> livroOptional = this.livroRepository.findById(new LivroId(emprestimo.getTitulo(), emprestimo.getEdicao()));

            if(usuarioOptional.isPresent() && livroOptional.isPresent()){
                emprestimoList.add(new Emprestimo(emprestimo.getDataLocacao(), emprestimo.getDataDevolucao(), null, emprestimo.getMulta(), livroOptional.get(), usuarioOptional.get()));
            }
        }

        Iterable<Emprestimo> emprestimoIterable = this.emprestimoRepository.saveAll(emprestimoList);
        return StreamSupport.stream(emprestimoIterable.spliterator(), false).collect(Collectors.toList());
    }


}
