package br.ifsudeste.mrbellyapi.api.dto;


import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.entity.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocadorDTO {
    private Long id;
    private String nome;

    private Endereco endereco;
    private Login login;

   public static LocadorDTO create (Locador locador){
ModelMapper modelMapper = new ModelMapper();
return modelMapper.map(locador, LocadorDTO.class);
   }
}
