package testes.clientes.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testes.clientes.model.Clientes;
import testes.clientes.repository.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private  ClientesRepository clientesRepository;
	
	
	public Clientes create(Clientes cliente){
		Clientes clientes =clientesRepository.insert(cliente);
		return clientes;
	}
	
	public List<Clientes> getAll(){
		return (List<Clientes>) clientesRepository.findAll();
	}
	
	public Clientes getById(String id){
		Clientes cliente = clientesRepository.findById(id).get();
		return cliente;
	}
	
	public void update(Clientes cliente){
		 clientesRepository.save(cliente);
	}
	

	public void delete(String id){
		 clientesRepository.deleteById(id);
	}
	
	
	
}
