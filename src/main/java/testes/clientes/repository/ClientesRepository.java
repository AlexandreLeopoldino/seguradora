package testes.clientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import testes.clientes.model.Clientes;

@Repository
public interface ClientesRepository extends MongoRepository<Clientes, String  >  {


}
