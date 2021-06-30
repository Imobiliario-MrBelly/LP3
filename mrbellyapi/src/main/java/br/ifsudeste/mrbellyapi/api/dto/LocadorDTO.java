package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Locador;
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
public class LocadorDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private char sexo;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private String telefone;
	private Long idLogin;
	private Long idEndereco;

	public static LocadorDTO create(Locador locador) {
		ModelMapper modelMapper = new ModelMapper();
		LocadorDTO dto = modelMapper.map(locador, LocadorDTO.class);
		assert dto.getIdLogin().equals(locador.getLogin().getId());
		assert dto.getIdEndereco().equals(locador.getEndereco().getId());
		return dto;
	}
}
