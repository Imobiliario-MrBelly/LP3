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

    //private Endereco endereco;
    private double area;
    private String descricao;
    private double condominio;
    private double iptu;
    private int garagem;
    //private Locador locador;

   public static ImovelDTO create (Imovel imovel){
ModelMapper modelMapper = new ModelMapper();
return modelMapper.map(imovel, ImovelDTO.class);
   }
}
