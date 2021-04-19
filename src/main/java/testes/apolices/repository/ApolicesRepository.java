package testes.apolices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import testes.apolices.model.Apolices;

@Repository
public interface ApolicesRepository extends MongoRepository<Apolices, String>  {

	public Apolices findByNumero(int numero);

	public List<Apolices> findAllByOrderByNumeroDesc();
	
}
