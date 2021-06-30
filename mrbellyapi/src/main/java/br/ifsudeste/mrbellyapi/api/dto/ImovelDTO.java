package br.ifsudeste.mrbellyapi.api.dto;

import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDTO {
	
	private Long id;
	private double area;
	private String descricao;
	private double condominio;
	private double iptu;
	private int garagem;
	private Long idLocador;
	private Long idEndereco;

	public static ImovelDTO create(Imovel imovel) {
		ModelMapper modelMapper = new ModelMapper();
		ImovelDTO dto = modelMapper.map(imovel, ImovelDTO.class);
		assert dto.getIdLocador().equals(imovel.getLocador().getId());
		assert dto.getIdEndereco().equals(imovel.getEndereco().getId());
		return dto;
	}
}
