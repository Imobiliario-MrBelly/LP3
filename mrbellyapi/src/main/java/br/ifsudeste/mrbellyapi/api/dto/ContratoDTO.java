package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
	private Long id;

	 private Imovel imovel;
	 private Locatario locatario;
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;
	private double valor;

	public static ContratoDTO create(Contrato contrato) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(contrato, ContratoDTO.class);
	}
}
