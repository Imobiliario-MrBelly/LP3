package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Fiador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiadorDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private String sexo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String telefone;
	private Long idEndereco;

	public static FiadorDTO create(Fiador fiador) {
		ModelMapper modelMapper = new ModelMapper();
		FiadorDTO dto = modelMapper.map(fiador, FiadorDTO.class);
		assert dto.getIdEndereco().equals(fiador.getEndereco().getId());
		return dto;
	}
}
