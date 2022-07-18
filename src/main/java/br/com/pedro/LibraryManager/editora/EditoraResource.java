package br.com.pedro.LibraryManager.editora;

import java.net.URI; 
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class EditoraResource {
	@Autowired
	private EditoraRepository editoraRepository;
	
	@GetMapping("/editora/all")
	public List<Editora> buscarTodasEditoras(){
		return editoraRepository.findAll();
	}
	
	@GetMapping("/editora/{id}")
	public Editora buscarEditoraById(@PathVariable Long id){
		try {
			Editora editora = editoraRepository.getReferenceById(id);
			return editora;
		}
		catch(EntityNotFoundException e) {
			return null;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/editora/{id}")
	public void deletarEditora(@PathVariable Long id) {
		editoraRepository.deleteById(id);
	}
	
	@PostMapping("/editora")
	public ResponseEntity<Object> criarEditora(@RequestBody Editora editoraInput) {
		Editora savedEditora = editoraRepository.save(editoraInput);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEditora.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/editora/{id}")
	ResponseEntity<Object> updateEditora(@RequestBody Editora editoraInput, @PathVariable Long id){
		Optional<Editora> editora = editoraRepository.findById(id);
		
		if(!editora.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		editoraInput.setId(id);
		editoraRepository.save(editoraInput);
		
		return ResponseEntity.noContent().build();
	}
}
