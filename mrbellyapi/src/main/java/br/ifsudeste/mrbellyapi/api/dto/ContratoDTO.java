package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Contrato;
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
public class ContratoDTO {

	private Long id;
	private Long idImovel;
	private Long idLocatario;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	
	private double valor;

	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private String sexo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String telefone;

	private String rua;
	private String numero;
	private String cep;
	private String cidade;
	private String uf;

	public static ContratoDTO create(Contrato contrato) {
		ModelMapper modelMapper = new ModelMapper();
		ContratoDTO dto = modelMapper.map(contrato, ContratoDTO.class);

		dto.cep=contrato.getFiador().getEndereco().getCep();
		dto.cidade=contrato.getFiador().getEndereco().getCidade();
		dto.numero=contrato.getFiador().getEndereco().getNumero();
		dto.rua=contrato.getFiador().getEndereco().getRua();
		dto.uf=contrato.getFiador().getEndereco().getUf();

		dto.telefone=contrato.getFiador().getTelefone();
		dto.dataNascimento=contrato.getFiador().getDataNascimento();
		dto.nome=contrato.getFiador().getNome();
		dto.sobrenome=contrato.getFiador().getSobrenome();
		dto.rg=contrato.getFiador().getRg();
		dto.cpf=contrato.getFiador().getCpf();
		dto.sexo=contrato.getFiador().getSexo();

		assert dto.getIdImovel().equals(contrato.getImovel().getId());
		assert dto.getIdLocatario().equals(contrato.getLocatario().getId());

		return dto;
	}
}
