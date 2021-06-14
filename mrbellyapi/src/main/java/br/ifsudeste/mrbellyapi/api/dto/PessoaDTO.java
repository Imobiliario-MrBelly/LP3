package br.ifsudeste.mrbellyapi.api.dto;


import br.ifsudeste.mrbellyapi.model.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private Long id;

    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String sexo;
   // private Date dataCadastro;
    private String telefone;

   public static PessoaDTO create (Pessoa pessoa){
ModelMapper modelMapper = new ModelMapper();
return modelMapper.map(pessoa, PessoaDTO.class);
   }
}
