package br.ifsudeste.mrbellyapi.api.dto;


import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocatarioDTO {
    private Long id;

    //private Pessoa pessoa;
    //private Login login;

   public static LocatarioDTO create (Locatario locatario){
ModelMapper modelMapper = new ModelMapper();
return modelMapper.map(locatario, LocatarioDTO.class);
   }
}