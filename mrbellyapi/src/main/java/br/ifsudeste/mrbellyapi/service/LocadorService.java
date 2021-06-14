package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.repository.LocadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocadorService {
    private LocadorRepository repository;

    public LocadorService(LocadorRepository repository){
        this.repository = repository;
    }

    public List<Locador> getLocadores(){
        return repository.findAll();
    }

    public Optional<Locador> getLocadorById(Long id){
        return repository.findById(id);
    }
}