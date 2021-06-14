package br.ifsudeste.mrbellyapi.api.dto;


import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    private Long id;

    //private Imovel imovel;
    //private Locatario locatario;
//    private Date dataInicio;
//    private Date dataFim;
    private double valor;

   public static  ContratoDTO create (Contrato contrato){
ModelMapper modelMapper = new ModelMapper();
return modelMapper.map(contrato,ContratoDTO.class);
   }
}
