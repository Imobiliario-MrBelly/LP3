package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.PessoaDTO;
import br.ifsudeste.mrbellyapi.model.entity.Pessoa;
import br.ifsudeste.mrbellyapi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public List<PessoaDTO> getPessoas(){
        List<PessoaDTO> list= repository.findAll().stream().map(PessoaDTO::create).collect(Collectors.toList());
        return list;
    }

    public PessoaDTO getPessoaById(Long id){
        Optional<Pessoa> pessoa = repository.findById(id);
        return pessoa.map(PessoaDTO::create).orElseThrow(()->new RuntimeException("Pessoa nao encontrado"));
    }
}
