package br.com.pedro.LibraryManager.repository;

import br.com.pedro.LibraryManager.model.Emprestimo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
    @Query(value = "SELECT * FROM emprestimo WHERE email = ?1", nativeQuery = true)
    List<Emprestimo> findAllByUser(String user);
}
