package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Locatario;
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
public class LocatarioDTO {
	
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

	public static LocatarioDTO create(Locatario locatario) {
		ModelMapper modelMapper = new ModelMapper();
		LocatarioDTO dto = modelMapper.map(locatario, LocatarioDTO.class);
		assert dto.getIdLogin().equals(locatario.getLogin().getId());
		return dto;
	}
}
