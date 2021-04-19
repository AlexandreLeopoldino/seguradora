package testes.clientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Data;

@Data
@Document(collection = "clientes")
public class Clientes {

	 @Id
	 private String id;
	 
	 @CPF
	 @Indexed(unique = true)
	 private String cpf;
	
	 @Size(min = 3, max = 50)
	 private String	 nome;
	
	 @Size(min = 3, max = 100)
	 private String	cidade;
	 
	 @Size(min = 2, max = 2)
	 private String	uf;

}
