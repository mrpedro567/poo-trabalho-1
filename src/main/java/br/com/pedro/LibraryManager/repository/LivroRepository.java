package br.com.pedro.LibraryManager.repository;

import br.com.pedro.LibraryManager.model.Livro;
import br.com.pedro.LibraryManager.model.LivroId;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, LivroId> {
}
