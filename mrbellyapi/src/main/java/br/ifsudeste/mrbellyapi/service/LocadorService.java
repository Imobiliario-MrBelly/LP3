package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.LocadorDTO;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.repository.LocadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocadorService {
    private LocadorRepository repository;

    public LocadorService(LocadorRepository repository){
        this.repository = repository;
    }

    public List<LocadorDTO> getLocadores(){
        List<LocadorDTO> list= repository.findAll().stream().map(LocadorDTO::create).collect(Collectors.toList());
        return list;
    }

    public LocadorDTO getLocadorById(Long id){
        Optional<Locador> locador = repository.findById(id);
        return locador.map(LocadorDTO::create).orElseThrow(()->new RuntimeException("Locador nao encontrado"));
    }
}
