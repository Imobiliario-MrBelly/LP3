package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
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

	public static PessoaDTO create(Pessoa pessoa) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
}
