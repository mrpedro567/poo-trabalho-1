package br.com.pedro.LibraryManager.repository;

import br.com.pedro.LibraryManager.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}
