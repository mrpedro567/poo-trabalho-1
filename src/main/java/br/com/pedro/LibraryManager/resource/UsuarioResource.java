package br.com.pedro.LibraryManager.resource;

import br.com.pedro.LibraryManager.model.Usuario;
import br.com.pedro.LibraryManager.model.dto.LoginDTO;
import br.com.pedro.LibraryManager.model.dto.UsuarioDTO;
import br.com.pedro.LibraryManager.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioResource {
    private final UsuarioRepository usuarioRespository;

    public UsuarioResource(UsuarioRepository usuarioRespository) {
        this.usuarioRespository = usuarioRespository;
    }


    @GetMapping("/{email}")
    public Usuario findById(@PathParam("email") String email){
        Optional<Usuario> response = this.usuarioRespository.findById(email);

        if(response.isPresent()){
            return response.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PutMapping("/redefinir-senha")
    public Usuario updateSenha(@RequestBody LoginDTO body){
        Optional<Usuario> response = this.usuarioRespository.findById(body.getEmail());

        if(response.isPresent()){
            Usuario usuario = response.get();

            usuario.setSenha(body.getSenha().trim());
            return this.usuarioRespository.save(usuario);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PostMapping("/login")
    public Usuario autenticar(@RequestBody LoginDTO login){
        Optional<Usuario> response = this.usuarioRespository.findById(login.getEmail());

        if(response.isPresent()){
            Usuario usuario = response.get();

            if(login.getSenha().trim().equals(usuario.getSenha())){
                return usuario;
            }
            else{
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PostMapping("/create")
    public Usuario create(@RequestBody UsuarioDTO usuario){
        Optional <Usuario> response = this.usuarioRespository.findById(usuario.getEmail());

        if(response.isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User already exists");
        }
        else{
            Usuario newUser = new Usuario();

            newUser.setEmail(usuario.getEmail());
            newUser.setNascimento(LocalDate.parse(usuario.getNascimento(), DateTimeFormatter.ISO_LOCAL_DATE));
            newUser.setNome(usuario.getNome());
            newUser.setSenha(usuario.getSenha());
            newUser.setCidade(usuario.getCidade());
            newUser.setNumero(usuario.getNumero());
            newUser.setRua(usuario.getRua());

            return this.usuarioRespository.save(newUser);
        }
    }
}
