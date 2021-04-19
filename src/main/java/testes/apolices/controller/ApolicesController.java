package testes.apolices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import testes.apolices.model.Apolices;
import testes.apolices.model.ApolicesDTO;
import testes.apolices.service.ApolicesService;

@RestController
@RequestMapping("apolices")
public class ApolicesController {

	@Autowired
    private  ApolicesService apolicesService;

	@PostMapping
	public ResponseEntity<Apolices> criarApolice(@Valid @RequestBody Apolices clientes) {
		return ResponseEntity.status(HttpStatus.CREATED).body(apolicesService.create(clientes));
	}

	@GetMapping()
	public ResponseEntity<List<Apolices>> listarTodasApolices() {
		return ResponseEntity.ok(apolicesService.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Apolices> buscarApolicePorId(@PathVariable(name = "id") String id) {
		return  ResponseEntity.ok(apolicesService.getById(id)) ;
	}
	
	@GetMapping("{numero}/buscarApolicePorNumero")
	public ResponseEntity<ApolicesDTO> buscarAplicePorNumero(@PathVariable(name = "numero") int numero) {
		return  ResponseEntity.ok(apolicesService.buscarApolicePorNumero(numero)) ;
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void AtualizarApolice(@Valid @RequestBody Apolices clientes) {
		apolicesService.update(clientes);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerApolicePorId(@PathVariable String id) {
		apolicesService.delete(id);
	}
	
}
