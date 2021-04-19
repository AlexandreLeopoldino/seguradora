package testes.clientes.controller;

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

import testes.clientes.Service.ClientesService;
import testes.clientes.model.Clientes;

@RestController
@RequestMapping("clientes")
public class ClientesController {

	@Autowired
    private  ClientesService clientesService;

	@PostMapping()
	public ResponseEntity<Clientes> criarCliente(@Valid @RequestBody Clientes clientes) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.create(clientes));
	}

	@GetMapping()
	public ResponseEntity<List<Clientes>> listarTodosClientes() {
		return ResponseEntity.ok(clientesService.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Clientes> buscarClientePorId(@PathVariable(name = "id") String id) {
		return  ResponseEntity.ok(clientesService.getById(id)) ;
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarCliente(@Valid @RequestBody Clientes clientes) {
		clientesService.update(clientes);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerClientePorId(@PathVariable String id) {
		clientesService.delete(id);
	}
	
	
	
	
	
}
