package testes.apolices.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import testes.clientes.model.Clientes;


@Data
@Document(collection = "apolices")
public class Apolices {

	@Id
	private String id;
    @Indexed(unique = true)
	private int numero;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate  dataVigenciaInicio;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate  dataVigenciaFim;
    @NotNull
    private String placa;
    @NotNull
    private double valor;
    @DBRef
	private Clientes clientes;
	
}
