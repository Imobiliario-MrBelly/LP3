package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.EnderecoDTO;
import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository){
        this.repository = repository;
    }

    public List<EnderecoDTO> getEnderecos(){
        List<EnderecoDTO> list= repository.findAll().stream().map(EnderecoDTO::create).collect(Collectors.toList());
        return list;
    }

    public EnderecoDTO getEnderecoById(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        return endereco.map(EnderecoDTO::create).orElseThrow(()->new RuntimeException("endereco nao encontrado"));
    }
}
