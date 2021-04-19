package testes.apolices.model;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ApolicesDTO {
   
	
	private Apolices apolice;
	
	private Boolean apoliceVencida;
	
	private long diasVencer;
	
	private long diasVencido;
	
}
