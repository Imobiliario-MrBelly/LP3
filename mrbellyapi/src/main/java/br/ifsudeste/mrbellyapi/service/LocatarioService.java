package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import br.ifsudeste.mrbellyapi.model.repository.LocatarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocatarioService {
    private LocatarioRepository repository;

    public LocatarioService(LocatarioRepository repository){
        this.repository = repository;
    }

    public List<Locatario> getLocatarios(){
        return repository.findAll();
    }

    public Optional<Locatario> getLocatarioById(Long id){
        return repository.findById(id);
    }
}
