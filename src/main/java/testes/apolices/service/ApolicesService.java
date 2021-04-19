package testes.apolices.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testes.apolices.model.Apolices;
import testes.apolices.model.ApolicesDTO;
import testes.apolices.repository.ApolicesRepository;


@Service
public class ApolicesService {
	
	@Autowired
	private  ApolicesRepository apolicesRepository;
	
	
	public Apolices create(Apolices apolice){
		List<Apolices> listApolices = apolicesRepository.findAllByOrderByNumeroDesc();
		int numero = listApolices.size()>0?listApolices.get(0).getNumero()+1:1;
		apolice.setNumero(numero);
		return apolicesRepository.insert(apolice);
	}
	
	public List<Apolices> getAll(){
		return (List<Apolices>) apolicesRepository.findAll();
	}
	
	public Apolices getById(String id){
		Apolices apolice = apolicesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
		return apolice;
	}
	
	public ApolicesDTO buscarApolicePorNumero(int numero){
		Apolices apolice = apolicesRepository.findByNumero(numero);
		if(apolice != null) {
			long dias = apolice.getDataVigenciaInicio().until(apolice.getDataVigenciaFim(), ChronoUnit.DAYS);
			Boolean apoliceVencida = dias<0 ;
			long diasVencer = dias>0? dias:0;
			long diasVencido = dias<0? dias:0;
			ApolicesDTO apoliceDto = ApolicesDTO.builder().apolice(apolice).apoliceVencida(apoliceVencida).diasVencer(diasVencer).diasVencido(diasVencido).build();
			return apoliceDto;
		}
		else {
			throw  new IllegalArgumentException();
		}
		
	}
	

	public void update(Apolices apolices){
		apolicesRepository.save(apolices);
	}
	

	public void delete(String id){
		apolicesRepository.deleteById(id);
	}
	

}
